import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class pageRankMapper extends Mapper<LongWritable, Text, Text, Text> {

  private static final int MISSING = 9999;
  
  @Override
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    
    String line = value.toString();
    String [] lineArray = line.split(" ");
    int size = lineArray.length;

    String sourcePage = lineArray[0];// the source page
    int numofOutlinks = size-2;// the number of outlinks 
    Float sourcePR = Float.parseFloat(lineArray[size-1]);//the PR of source page
    Float outlinkPR = sourcePR/numofOutlinks;// the PR of outlinks
    String outlinklist = "";

    for (int i=1;i<size-1;i++){
        context.write(new Text(lineArray[i]),new Text(sourcePage+","+outlinkPR));
        outlinklist +=lineArray[i];
        outlinklist +=" ";   
    }

    context.write(new Text(sourcePage),new Text(outlinklist));
  } 
}






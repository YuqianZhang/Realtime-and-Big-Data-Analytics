import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class wordCountMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

  private static final int MISSING = 9999;
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();

    String tokens = "Chicago,Dec,java,hackathon";
    String [] tokensArray = tokens.split(",");

    for (int i=0;i<tokensArray.length;i++){
      if (line.toLowerCase().contains(tokensArray[i].toLowerCase())){
        context.write(new Text(tokensArray[i]),new IntWritable(1));
      }
      else{
        context.write(new Text(tokensArray[i]),new IntWritable(0));
      }
    }


    
  }
}


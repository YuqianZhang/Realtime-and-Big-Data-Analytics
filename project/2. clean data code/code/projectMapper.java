import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class projectMapper
  extends Mapper<LongWritable, Text, Text, Text> {

  private static final int MISSING = 9999;
  
  @Override
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    
    String line = value.toString();
    String [] tokensArray = line.split(",");
    String result = "";
    for (int i=0;i<tokensArray.length;i++){
    	if (i==0||i==3||i==11||i==15||i==16||i==17||i==21||i==26){
    		
    	}else if (i==27){
        result += tokensArray[i];
      }else{
        result += tokensArray[i] + ",";
      }
    }
    context.write(new Text (tokensArray[11]),new Text(result));
  }
  
}
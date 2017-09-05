import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class pageRankReducer extends Reducer<Text, Text, LongWritable, Text> {
  
  @Override
  public void reduce(Text key, Iterable<Text> values,Context context)throws IOException, InterruptedException {
    
    Float PR = 0.0f;
    String outlinklist = key.toString()+" ";
    String temp ="";
    for (Text value : values) {
      temp = value.toString();
      if(temp.contains(",")){
          PR = PR + Float.parseFloat(temp.split(",")[1]);
      }else{
          outlinklist += temp;
      }

    }
    context.write(null,new Text(outlinklist+PR));
  }
}





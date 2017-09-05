import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class pageRankReducer extends Reducer<Text, Text, Text, Text> {
  
  @Override
  public void reduce(Text key, Iterable<Text> values,Context context)throws IOException, InterruptedException {
    
    Float PR = 0.0f;
    String outlinklist = "";
    String temp ="";
    for (Text value : values) {
      temp = value.toString();
      if(temp.contains(",")){
          PR = PR + Float.parseFloat(temp.split(",")[1]);
      }else{
          outlinklist = temp;
      }

    }
    context.write(key,new Text(outlinklist+ PR));
  }
}





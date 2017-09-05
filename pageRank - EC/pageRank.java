import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class pageRank {

  public static void main(String[] args) throws Exception {
    if (args.length != 4) {
      System.err.println("Usage: pageRank <input path> <input path> <input path> <output path>");
      System.exit(-1);
    }
    
    int i =0;
    

    while(i<3){
      Job job = new Job();
      job.setJarByClass(pageRank.class);
      job.setJobName("Page Rank");
      job.setNumReduceTasks(1); // 1 Reduce task

      FileInputFormat.addInputPath(job, new Path(args[i]));
      FileOutputFormat.setOutputPath(job, new Path(args[i+1]));
          
      job.setMapperClass(pageRankMapper.class);
      job.setReducerClass(pageRankReducer.class);

      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(Text.class);

      job.waitForCompletion(true);
      i++;
    }
    System.exit(0);
    
  }//end
}





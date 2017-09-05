package getTwitterData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class main {
	public static void main(String [] args)throws TwitterException, IOException {
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
			.setOAuthConsumerKey("hYtpRxVCQx81MpAArnU7UE7lZ")
	        .setOAuthConsumerSecret("lzVxkRsUwjXYl572f3TZTO22zuIJJMJGdf8OHWGG6k5s6g7YeY")
	        .setOAuthAccessToken("834669618-ekagF5tj75yPKZOboGyJwxDqvKS65jQMwbZey6tG")
	        .setOAuthAccessTokenSecret("bbmpH5U147xl4WG7f3AU0XH8VCjHAjl18tiA1rrXJC5RO");
		
		TwitterFactory tf = new TwitterFactory(cf.build());
		Twitter twitter = tf.getInstance();

		try{
			PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			List<Status> status = twitter.getHomeTimeline();
			for(Status st: status){
				writer.println(st.getUser().getName()+"-------"+st.getText());
			}
			writer.close();
			System.out.println("Output finished...");
			System.exit(0);
		} catch (TwitterException te) {
		        te.printStackTrace();
		        System.out.println("Failed to search tweets: " + te.getMessage());
		        System.exit(-1);
		}
		 
	}
	

}

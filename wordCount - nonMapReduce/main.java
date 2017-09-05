import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws Exception {
		
		try{
			FileReader fr = new FileReader("input.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("output.txt");
			String line;
			
			int ChicagoCount = 0;
			int DecCount =0;
			int JavaCount =0;
			int hackathonCount = 0;
			
			while ((line=br.readLine())!=null){
				//System.out.println(line);
				if (line.toLowerCase().contains("Chicago".toLowerCase()))
					ChicagoCount++;
				if (line.toLowerCase().contains("Dec".toLowerCase())) 
					DecCount++;
				if (line.toLowerCase().contains("Java".toLowerCase())) 
					JavaCount++;
				if (line.toLowerCase().contains("hackathon".toLowerCase()))
					hackathonCount++;
			}
			
			fw.write("Chicago"+"  "+ChicagoCount+"\n");
			fw.write("Dec"+"  "+DecCount+"\n");
			fw.write("Java"+"  "+JavaCount+"\n");
			fw.write("hackathon"+"  "+hackathonCount+"\n");
			
			//The following code works in the eclipse console
			//System.out.println("Chicago"+"  "+ChicagoCount);
			//System.out.println("Dec"+"  "+DecCount);
			//System.out.println("Java"+"  "+JavaCount);
			//System.out.println("hackathon"+"  "+hackathonCount);
			fw.close();
			br.close();	
			fr.close();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		

	}

}

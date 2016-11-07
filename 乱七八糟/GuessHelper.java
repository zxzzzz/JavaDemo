import java.io.*;
public class GuessHelper{
	private String line;
	public String getUserInput(String take){
		System.out.println(take);
		try{
			BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
			line=read.readLine();
			if(line.length()==0){
				System.out.println("null");
				return null;
}
}catch(IOException e){
	System.out.println(e);
}
		return line;
}
}

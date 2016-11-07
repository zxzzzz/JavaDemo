import java.io.*;
public class Sum{
	public static void main(String[] args){
		run();
}
	public static void run(){
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
		try{
			String  line=read.readLine();
			int number=0;
			int sum=0;
			for(int i=0;i<line.length();i++){
				number=line.charAt(i)-48;
				sum+=number;
				
}
			System.out.println(sum);
}catch(IOException e){}
}
}

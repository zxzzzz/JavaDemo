import java.io.*;
import java.net.*;
//简单的客户端和服务器的聊天程序
public class SimpleClient{
	public static void main(String[] args){
		SimpleClient client=new SimpleClient();

		client.doAccept();
}
	public void doAccept() {
try{
		Socket socket=new Socket("127.0.0.1",2000);
		//读取socket的输入流

		PrintWriter write=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                write.write("来自客户端的问候");
		BufferedReader read=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line;
		while((line=read.readLine())!=null){
			System.out.println(line);}
}catch(IOException e){
	e.printStackTrace();
}
//	read.close();
//	write.close();

}

	
}

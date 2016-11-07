import java.io.*;
import java.net.*;
//服务器，接收客户端发送的信息并显示，再将相同信息发送给客户端
public class SimpleServer{
	public static void main(String[] args){
		SimpleServer server=new SimpleServer();
		server.start();
}
	public void start(){
try{
		ServerSocket soc=new ServerSocket(3333);//端口3333
		Socket socket=soc.accept();
		BufferedReader read=new BufferedReader(new InputStreamReader(socket.getInputStream()));//读取socket输入流
		PrintWriter write=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);//输出流
		while(true){
			String  line;
			while((line=read.readLine())!=null){
   				System.out.println(line);
				write.println(line);//发送
}
}
		
}catch(IOException e)
{
		e.printStackTrace();
}
}
}

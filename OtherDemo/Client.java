import java.io.*;
import java.net.*;
public class Client{
  public static void main(String[] args) throws IOException{
          Socket socket=new Socket("127.0.0.1",2000);
 //         InputStream read=new InputStream();
         // BufferedReader read=new BufferedRead(new InputStreamReader(socket.getInputStream()));
  BufferedReader in =  new BufferedReader( 
          new InputStreamReader( 
            socket.getInputStream()));
  PrintWriter writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
 writer.println("你好，服务器！");

 String line =in.readLine();
          System.out.println(line);
          in.close();
writer.close();
          socket.close();
       

}
}

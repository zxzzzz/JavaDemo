import java.io.*;
import java.net.*;
public class Service{
 public static void main(String[] args) throws IOException{
     ServerSocket serverSocket =new ServerSocket(2048);
     while(true){
     Socket s=serverSocket.accept();
     OutputStream os=s.gtetOutputStream();
     BufferedReader read=new BufferedReader(new InputStreamReader(s.getInputStream()));
     String line=read.readLine();
    System.out.println(line);
   // InputStream in=s.getInputStream();
  //   String line=in.readLine();
//     System.out.print(line);
     os.write("hello!We received your message!\n".getBytes("utf-8"));
     os.close();
     s.close();
}

  }
}

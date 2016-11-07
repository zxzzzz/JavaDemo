import java.net.*; 
import java.io.*; 
 
class ClientMe extends Thread { 
  private Socket socket; 
  private BufferedReader in; 
  private PrintWriter out; 
  private static int counter = 0; 
  private int id = counter++; 
  private static int threadcount = 0; 
  public static int threadCount() {  
    return threadcount;  
  } 
  public ClientMe(InetAddress addr) { 
 
    threadcount++; 
    try { 
      socket =  
        new Socket(addr,MultiService.PORT); 
    } catch(IOException e) { 
      // If the creation of the socket fails,  
      // nothing needs to be cleaned up.
     System.out.print("error"+e); 
    } 
    try {     
      in =  
        new BufferedReader( 
          new InputStreamReader( 
            socket.getInputStream())); 
 
     // Enable auto-flush: 
      out =  
        new PrintWriter( 
          new BufferedWriter( 
            new OutputStreamWriter( 
              socket.getOutputStream())), true); 
      start(); 
    } catch(IOException e) { 
      // The socket should be closed on any  
      // failures other than the socket  
      // constructor: 
      try { 
        socket.close(); 
      } catch(IOException e2) {} 
    } 
    // Otherwise the socket will be closed by 
    // the run() method of the thread. 
  } 
  public void run() { 
    try { 
      for(int i = 0; i < 25; i++) { 
        out.println("Client " + id + ": " + i); 
        String str = in.readLine(); 
        System.out.println(str); 
      } 
      out.println("END"); 
    } catch(IOException e) { 
    } finally { 
      // Always close it: 
      try { 
        socket.close();
        in.close();
        out.close(); 
      } catch(IOException e) {} 
      threadcount--; // Ending this thread 
    } 
  } 
} 
 
public class MultiClient { 
  static final int MAX_THREADS = 40; 
  public static void main(String[] args)  
      throws IOException, InterruptedException { 
    InetAddress addr =  
      InetAddress.getByName(null); 
    while(true) { 
      if(ClientMe.threadCount()  
         < MAX_THREADS) 
        new ClientMe(addr); 
      Thread.currentThread().sleep(100); 
    } 
  } 
}

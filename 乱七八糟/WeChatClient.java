import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//将信息发送给服务器 127.0.0.1 3333 接收并显示
public class WeChatClient implements ActionListener{
	private JTextArea incoming;//接收区域
	private JTextField outgoing;//发送区域
	private PrintWriter writer;//
	private BufferedReader reader;//
	private Socket socket;//
	public static void main(String[] args){
		WeChatClient client=new WeChatClient();
		client.go();
}
	public void go(){
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		incoming=new JTextArea(15,50);//15行，50列
		incoming.setLineWrap(true);//设置自动换行
		incoming.setWrapStyleWord(true);//设置单词后换行
		incoming.setEditable(false);//设置为不可编辑
		JScrollPane scroller=new JScrollPane(incoming);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outgoing=new JTextField(20);//20列
		JButton sendButton=new JButton("发送");
		sendButton.addActionListener(this);
		panel.add(scroller);
		panel.add(outgoing);
		panel.add(sendButton);
		setUpNetWorking();
		Thread readThread=new Thread(new ReceiveRunnable());
		readThread.start();
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(400,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
//设置socket，与服务器连接
	public void setUpNetWorking(){
		try{
			socket=new Socket("127.0.0.1",3333);
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
					
}catch(IOException e ){
			e.printStackTrace();		
}
		
}
//监听按钮是否按下，发送
	public void actionPerformed(ActionEvent e){
//		if(!outgoing.getText()){
			String line=outgoing.getText();
			writer.println(line);
			
//}
}
//开启新线程接收信息
	class ReceiveRunnable implements Runnable{
//如何接收
		public void run(){
			String line;
			try{
			while((line=reader.readLine())!=null){
//				line=reader.readLine();
				incoming.append(line+"\n");
}
}catch(IOException e){e.printStackTrace();}
}
}
//	class SendButtonListener implements ActionListener{
//		public void actionPerformed(ActionEvent e){
//			System.out.println("click");		
//}

}

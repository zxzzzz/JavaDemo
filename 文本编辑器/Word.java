import javax.swing.*;
import javax.swing.JComponent.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Component.*;
//文本编辑器，打开.保存.右键复制粘贴剪切功能
//java.awt 与 java.awt.event 不是一个类 
//
public class Word implements MouseListener,ActionListener{
	JFrame frame;
	JPopupMenu popMenu;
	JPanel panel;
	JEditorPane editText;
	JButton openButton;
	JButton saveButton;
	JMenuItem paste;
	JMenuItem copy;
	JMenuItem cut;
	JMenuBar menuBar;
	FileDialog fileDialog; 
	String path;//要保存/打开的文件路径
	String name;//要保存/打开的文件名
//	JMenuItem delete;
	public static void main(String[] args){
		Word word=new Word();
}
//初始化界面
	public Word(){
		frame=new JFrame();
		panel=new JPanel();
		editText=new JEditorPane();
		popMenu=new JPopupMenu();
		Font font=new Font("宋体",Font.BOLD,20);
		openButton=new JButton("open");
		openButton.setFont(font);
		saveButton=new JButton("save");
		saveButton.setFont(font);
		panel.setLayout(null);
		Color color=new Color(191,210,200);
		panel.setBackground(color);
		paste=new JMenuItem("paste");
		copy=new JMenuItem("copy");
		cut=new JMenuItem("cut");
//		delete=new JMenuItem("delete");
//try{
//		String pathString = "/home/zx/邯郸-刘书锋太极体.ttf";
  //              Font editFont = Font.createFont(Font.BOLD, new File(pathString));
//		editText.setFont(editFont);
//}catch(FontFormatException|IOException fe){
//		fe.printStackTrace();
//}		
//		Font editFont=new Font ("宋体",Font.BOLD,20);
		editText.setBackground(color);
		editText.setBounds(0,40,780,760);
		editText.setFont(font);
		editText.addMouseListener(this);
		popMenu.add(paste);
		popMenu.add(copy);
		popMenu.add(cut);
		openButton.addActionListener(this);
		saveButton.addActionListener(this);
//		popMenu.add(delete);
		paste.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
//		delete.addActionListener(this);
	//button 设置大小太小会导致显示不出来文字
		openButton.setBounds(0,10,80,30);
		saveButton.setBounds(700,10,80,30);
		saveButton.setBackground(color);
		openButton.setBackground(color);
		panel.add(editText);
		panel.add(openButton);
		panel.add(saveButton);
		panel.add(popMenu);

		frame.setSize(780,800);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
}
//粘贴
	public void paste(){
		System.out.println("paste");
		editText.paste();
}
//复制
	public void copy(){
		System.out.println("copy");
		editText.copy();
}
//剪切
	public void cut(){
		System.out.println("cut");
		editText.cut();
		
}
//打开文件
	public void open(){
		System.out.println("Open file!");
		fileDialog=new FileDialog(frame,"打开文件",FileDialog.LOAD);
		fileDialog.setVisible(true);
		path=fileDialog.getDirectory();
		name=fileDialog.getFile();
		read();
}
//保存文件
	public void save(){
		System.out.println("Save File!");
		fileDialog=new FileDialog(frame,"保存文件",FileDialog.SAVE);
		fileDialog.setVisible(true);
		path=fileDialog.getDirectory();
		name=fileDialog.getFile();
		write();

}
//读文件
	public void read(){
		try{
			File read=new File(path,name);
			BufferedReader reader=new BufferedReader(new FileReader(read));
			//string 类无append()方法
			StringBuilder builder=new StringBuilder();
			String line;
			while((line=reader.readLine())!=null){
				builder.append(line+"\n");
				System.out.println(line);
}
			editText.setText(builder.toString());
			reader.close();//File类无close()
}catch(IOException e){
	e.printStackTrace();
//作用域到括号截至  read 找不到
//	read.close();
}
		
}
//写文件
	public void write(){
		try{
		File writeFile=new File(path,name);
		BufferedWriter write=new BufferedWriter(new FileWriter(writeFile));
		write.write(editText.getText());
		write.close();
}catch(IOException e){
		e.printStackTrace();
//		writeFile.close();
}
		
}
//鼠标点击事件
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
		if(e.getButton()==MouseEvent.BUTTON3)
			popMenu.show(e.getComponent(),e.getX(),e.getY());
}
	public void mouseReleased(MouseEvent e){}
//MouseEvent 有什么方法可以返回调用组件的String 或代号？
//用ActionEvent的话不能屏蔽右键选择	
//	class SpecialListener implements MouseListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("我要开始比较啦！");
	//		if(e.getButton()==MouseEvent.BUTTON3){
				String which=e.getActionCommand();
				switch(which){
					case "paste":
						paste();
						break;
					case "copy":
						copy();
						break;
					case "cut":
						cut();
						break;
					case "open":
						open();
						break;
					case "save":
						save();

}
}

}

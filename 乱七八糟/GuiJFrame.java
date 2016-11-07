import javax.swing.*;
import java.awt.event.*;
public class GuiJFrame implements ActionListener{
	JButton button;// NullPointer ...变量未声明
	public void go(){
		JFrame frame=new JFrame();
		button=new JButton("click me");
		button.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setSize(300,300);
		frame.setVisible(true);
}
	public void actionPerformed(ActionEvent e){
		button.setText("changed");
}
	public static void main(String[] args){
		GuiJFrame frame=new GuiJFrame();
		frame.go();
}
}

import javax.swing.*;
import javax.swing.JComponent.*;
public class Button{
	public static void main(String[] args){
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		JButton button=new JButton("dd");
		panel.add(button);
		frame.setSize(300,300);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
}
}

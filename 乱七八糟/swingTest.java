import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class swingTest implements ActionListener{
	private JTextField text;
	private JButton button;
	private JTextArea area;
	public static void main(String[] args){
		swingTest test=new swingTest();
		test.go();		
}
	public void go(){
		JFrame panel=new JFrame();
		button=new JButton("hi");
		button.addActionListener(this);
		Font font=new Font("serif",Font.BOLD,28);
		panel.getContentPane().add(BorderLayout.EAST,button);
		text=new JTextField("nihsso");
		text.addActionListener(new MyListener());
		panel.getContentPane().add(BorderLayout.NORTH,text);
		area=new JTextArea(10,20);
		JScrollPane scroller=new JScrollPane(area);
		area.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scroller);
		panel.setSize(300,300);
		panel.setVisible(true);
	//	System.out.println(text.getText());
}
	public void actionPerformed(ActionEvent e){
		area.append("button clicked\n");
		
}
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println(text.getText());
}
}
}







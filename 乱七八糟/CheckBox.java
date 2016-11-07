import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CheckBox implements ItemListener{
	private JCheckBox check;
	public static void main(String[] args){
		CheckBox check=new CheckBox();
		check.go();		
}
	public void go(){
		JFrame frame=new JFrame();
		JPanel pane=new JPanel();
	//	frame.getContentPane().add(BorderLayout.CENTER,pane);
		check=new JCheckBox("checkbox");
		check.addItemListener(this);
		pane.add(check);
		frame.getContentPane().add(BorderLayout.CENTER,pane);
		frame.setSize(300,300);
		frame.setVisible(true);
				
}
	public void itemStateChanged(ItemEvent item){
		String onOrOff="off";
		if(check.isSelected())
			onOrOff="on";
		System.out.println("check box is "+onOrOff);
		
}
}


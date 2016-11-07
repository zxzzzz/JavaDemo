import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;
import java.awt.*;
public class OptionPanel extends JFrame{
	public void go(){
		int yes=JOptionPane.showConfirmDialog(this,"game over","game",JOptionPane.YES_NO_OPTION);
                if(yes==JOptionPane.YES_OPTION)
                        System.out.println("hi");

}
	public static void main(String [] args){
		OptionPanel option=new OptionPanel();
		option.go();
}
}

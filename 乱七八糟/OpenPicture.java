import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.Desktop.*;
import javax.imageio.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
//打开指定目录的图片并返回
public class OpenPicture implements ActionListener{
	private JButton sureButton;
	private JFileChooser fileChooser;
	private JFrame frame;
	private JPanel panel1;
	private JLabel picture;
	private JPanel panel2;
	public OpenPicture(){
		frame=new JFrame();
                panel1=new JPanel();
		panel2=new JPanel();
//		frame.getContentPane().add(BorderLayout.WEST,panel2);//提早载入覆盖了以后的
                sureButton=new JButton("OK");
                frame.getContentPane().add(BorderLayout.EAST,panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                sureButton.addActionListener(this);
               // showText=new JTextField("显示文字区域");
                //panel.add(showText);
                panel1.add(sureButton);
                frame.setVisible(true);
                frame.setBounds(200,200,400,500);


}
	public void actionPerformed(ActionEvent e){
		fileChooser=new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(null);
try{
		File file=fileChooser.getSelectedFile();//返回当前文件
//		Desktop.getDesktop().open(file);
//		ImageIO imageIO=new ImageIO();
		BufferedImage image=ImageIO.read(file);
		Image scaleImage=image.getScaledInstance(300,480,Image.SCALE_DEFAULT);
		Icon icon=new ImageIcon(scaleImage);
		picture=new JLabel();
		picture.setIcon(icon);
		panel2.add(picture);
		frame.getContentPane().add(BorderLayout.CENTER,panel2);
		frame.setVisible(true);
		
}catch(IOException ex){
		ex.printStackTrace();
}
}
	public static void main(String[] args){
		OpenPicture open=new OpenPicture();
}

}

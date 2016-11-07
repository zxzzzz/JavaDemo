import java.awt.*;
import java.awt.Color.*;
import javax.swing.*;
//import java.awt.GradientPaint.*;
public class PaintTest{
	
 class Paintx extends JPanel{
	public void paintComponent(Graphics g){
//		g.setColor(Color.green);
//		g.fillOval(100,100,40,50);
//		Image image=new ImageIcon("zhuo.jpg").getImage();
//		g.drawImage(image,5,6,this);
		Graphics2D gg=(Graphics2D)g;
		gg.fillRect(0,0,this.getWidth(),this.getHeight());
//		int red=(int)(Math.random()*255);
//		int green=(int)(Math.random()*255);
//		int blue=(int)(Math.random()*255);
//		Color color=new Color(red,green,blue);
//		g.setColor(color);
		GradientPaint paint=new GradientPaint(70,70,Color.orange,150,150,Color.blue);
		gg.setPaint(paint);
		gg.fillOval(70,70,100,100);
}
}
	public static void main(String[] args){
		PaintTest paintx=new PaintTest();
		paintx.go();
}
	public void go(){
		 Paintx paint=new Paintx();
                JFrame frame=new JFrame();
                frame.setSize(700,800);
                frame.getContentPane().add(paint);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

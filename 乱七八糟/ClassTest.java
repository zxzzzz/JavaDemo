import javax.swing.*;
import java.awt.*;
public class ClassTest{
	int x=70;
	int y=70;
	public static void main(String[] args){
		ClassTest test=new ClassTest();
		test.go();
}
	public void go(){
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel panel=new MyPanel();
		frame.getContentPane().add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		for(int i=0;i<100;i++){
			x++;
			y++;
			panel.repaint();
			try{
				Thread.sleep(50);
				
}catch(Exception x){}
}
}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(),this.getHeight());
			g.setColor(Color.green);
			g.fillOval(x,y,40,40);
}
	}

}

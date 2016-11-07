import java.awt.Color.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.Timer.*;
import java.awt.event.*;
import javax.swing.JComponent.*;
//右边有墙，但是从左边不能穿墙而过
//
public class Snake{
	JFrame frame;
	MyPanel panel;
	ArrayList<Item> snake;//蛇体
	Item food;//食物
	int dir;//行进方向
	static int UP=-1;
	static int DOWN=1;
	static int LEFT=-10;
	static int RIGHT=10;
	static int l=10;//长度
	boolean lose=false;//是否输了
	int width=300;//待定
	int height=300;
	int score=0;//分数
	int randX=0;//任意选中的x坐标
	int randY=0;//任意选中的y坐标
	boolean has;//是否被占用,true则为占用
	public static void main(String[] args){
		Snake test=new Snake();
		test.init();
}

	
//界面初始化
	public void init(){
		if(food!=null)
			food=null;
//protected		snake.removeRange(0,snake.size());
		 snake=new ArrayList<Item>();
		if(!snake.isEmpty()){
			dir=0;
			snake.clear();}
		if(frame==null)
			frame=new JFrame();
		if(panel==null)
			panel=new MyPanel();
		if(time.isRunning())
			time.stop();
//		panel.repaint();
//		snake=new ArrayList<Item>();
//              addFood();
                food=new Item(13,5);
                addSnake();
		panel.addKeyListener(key);
		panel.setFocusable(true);
//              addFood();
//                panel.repaint();
		frame.getContentPane().add(panel);
//		frame.addActionListener(listen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
		panel.repaint();		
}
//获取随机位置
	public void random(){
	//	boolean canUse=false;
	//	int randX;
	//	int randY;
		while(true){
			randX=(int)(Math.random()*28);
			randY=(int)(Math.random()*29);
			if(!include(randX,randY)){
			//	canUse=true;
				break;
				
}
	
}
}
//位置是否已经被占用,true为被占用
	public boolean include(int loaX,int loaY){	
		boolean contain=false;
		for(Item it:snake){
			if(it.equals(loaX,loaY)){
				contain=true;
				break;
				
}
}
		if(food.equals(loaX,loaY))
			contain=true;
		return contain;

}
//吃food,如果has为true表示已经吃到了食物
	public void eat(Item pos){
		int x=pos.getX();
		int y=pos.getY();
		has=false;
		if(food.equals(x,y)){
			has=true;
	//		food=null;
			addFood();

}
}
//增加snake
	public void addSnake(){
		random();
		Item one=new Item(randX,randY);	
		snake.add(0,one);
}
//增加food
	public void addFood(){
		score++;
		random();
		food=new Item(randX,randY);
		
}
//前进
	public void forward(int d){
		Item head=snake.get(0);
		int x=head.getX()+dir/10;
		int y=head.getY()+dir%10;
		System.out.println("forward");
		head=new Item(x,y);
		snake.add(0,head);//添加头部
		eat(head);//判断是否吃到了食物
		if(!has){//如果没有吃到食物，去掉最后一个item
			snake.remove(snake.size()-1);
}		lose();
		if(lose==true){
			System.out.println("start()");
			lose=false;
			start();
			
}
}
//JFrame的ActionListener

	 ActionListener listen=new ActionListener(){
		public void actionPerformed(ActionEvent e){
			System.out.println("调用ActionPerformed");
			forward(dir);
			panel.repaint();//重绘
}
};

//刷新频率

	Timer time=new Timer(230,listen);
	
//KeyListener
	KeyListener key=new KeyListener(){
		public void keyPressed(KeyEvent k){
		//	System.out.println("引用keyPress");
			if(k.getKeyCode()==KeyEvent.VK_UP){
				if(dir!=Snake.DOWN)
					dir=Snake.UP;
}
			if(k.getKeyCode()==KeyEvent.VK_DOWN){
				if(dir!=Snake.UP)
					dir=Snake.DOWN;
//	}		
			}
			if(k.getKeyCode()==KeyEvent.VK_LEFT){
				if(dir!=Snake.RIGHT)
					dir=Snake.LEFT;}
			if(k.getKeyCode()==KeyEvent.VK_RIGHT){
				if(dir!=Snake.LEFT)
					dir=Snake.RIGHT;}
		//	System.out.println("调用forward(dir)");
		//	System.out.println(dir);
		//	forward(dir);
			time.start();
		//	panel.repaint();
}
		public void keyReleased(KeyEvent k){}
		public void keyTyped(KeyEvent k){}
		
};
//重绘
 	class MyPanel extends JPanel{
                public void paintComponent(Graphics g){
                        
			//刷新背景 heise
			System.out.println("调用paintComponent");
			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(),this.getHeight());		
			System.out.println(this.getWidth()+"    "+this.getHeight());	
			//蛇身红色
			g.setColor(Color.yellow);
			g.fillRect(290,0,l,this.getHeight());
			int red=(int)(Math.random()*255);
			int green=(int)(Math.random()*255);
			int blue=(int)(Math.random()*255);
			g.setColor(new Color(red,green,blue));	
			for(Item items:snake){
				int posX=items.getX();
				int posY=items.getY();
				if(posX>=29){
					System.out.println("posX大于29,lose=true");
					lose=true;}
				if(posX<=0)
					items.setX(28);
				if(posY>=29)
					items.setY(0);
				if(posY<=0)
					items.setY(29);
		//		System.out.println(i+"    "+posY);
				//待会在设置位置，大小
				g.fillOval(items.getX()*l,items.getY()*l,l,l);
}
			//食物为绿色
			g.setColor(Color.green);
			int foodX=food.getX();
			int foodY=food.getY();
			//同上
			g.fillOval(foodX*l,foodY*l,l,l);

}
}
//判断是否输了  返回true则输了
	public void lose(){
		
		  int oneX=snake.get(0).getX();
                  int oneY=snake.get(0).getY();
                        for(int i=1;i<snake.size();i++){
                                if(snake.get(i).equals(oneX,oneY)){
                                        System.out.println("你输了！");
					lose=true;
                                        break;  
}

}
	System.out.println("lose()"+lose);
}
	public void start(){
		 int isRestart = JOptionPane.showConfirmDialog(frame,"分数："+score+" 是否重新开始？", "重新开始", JOptionPane.YES_NO_OPTION);       	       
 		score=0;
		if (isRestart == JOptionPane.YES_OPTION) {
			init();

                        }else{
				
}				System.exit(0);


}
//Item类
	class Item{
		int xPos;//item的x坐标
		int yPos;//y坐标
		public Item(int x,int y){
			this.xPos=x;
			this.yPos=y;
}
		public int getX(){
			return xPos;
}
		public int getY(){
			return yPos;
}
		public void setX(int x){
			xPos=x;
}
		public void setY(int y){
			yPos=y;
}
//判断两个坐标是否相等，true为相等
		public boolean equals(int aX,int aY){
			if((aX==xPos)&&(aY==yPos)){
				return true;
}
			else{
				return false;
}
			
}
}
}

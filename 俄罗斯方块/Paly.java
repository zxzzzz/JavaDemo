public class Play{
	private int dir;
	private Block shape;
	private static int LEFT=-1;
	private static int RIGHT-1;
//	private static int DOWN=
	public static void main(String[] args){
		Play test=new Play();
		test.init();
}
//前进方向，down/left/right
//	public void follow(Block block,int dir){}
//变换形状 顺时针/逆时针
//	public void change(Block block,int dir){}
//挑选shape
	public Block chooseShape(){
		int i=(int)(Math.random()*6)'
		switch(i){
//Todo
			case 0:
				shape=new Rect();
				break;
			case 1:
				shape=new Long();
				break;
			case 2:
				shape=new Tu();
				break;
			case 3:
				shape=new F();
				break;
			case 4:
				shape=new StrangeA();
				break;
			case 5:
				shape=new StrangeB();
				break;
			defualt:
				shape=new Rect();
				//不用break？
}
		shape.setShape();
}
//初始化
	publi void init(){

	
}
	class Rect extends Block{
//构造一个正方形
		public void setShape(){}
}
	class Long extends Block{
//构造一个长条形
		public void setShape(){}
	
}
	class Tu extends Block{
//构造一个“土”字形
		public void setShape(){}

}
	class F extends Block{
//构造一个F形
		public void setShape(){}
}

	class StrangeA extends Block{
//构造第四个形状
		public void setShape(){}
}
	class StrangeB extends Block{
//构造第六个形状
		public void setShape(){}
//监听并刷新画面
	ActionListener listen =new ActionListener(){
		public void actionPerformed(ActionEvent e){
			shape.follow(dir);
}			repaint();

}
	Timer time=new Timer(300,listen);
	KeyListener task=new KeyListener(){
		public void keyPressed(KeyEvent k){
			switch (k.getKeyCode()){
				case KeyEvent.VK_DOWN:
//Todo
					dir=DOWN;
				case keyEvent.VK_LEFT:
//
					dir=LEFT;
				case keyEvent.VK_RIGHT:
//
					dir=RIGHT;
				default:
//
}
			time.start();
}
		public void keyReleased(KeyEvent k){}
		public void keyTyped(KeyEvent k){}
		
}
}
	//重绘
	class RePanel extends JPanel{
		public void paintComponent(Graphics g){}

}


}

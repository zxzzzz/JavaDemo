import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class WormDemo {
    public static void main(String[] args) {
        WormDemo demo=new WormDemo();
	demo.go();
    }
	public void go(){
	JFrame frame=new JFrame("snake");
        WormPane pane=new WormPane();
        pane.repaint();
        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 320);
	frame.setVisible(true);
		
}
 class WormPane extends JPanel{
    private Worm worm;
    private int width=280;
    private int height=280;
    public  int l=10;
     
    public WormPane(){
        worm=new Worm();
        WormEat eat=new WormEat();
        addKeyListener(eat);
        setFocusable(true);
    }
    private ArrayList<Node> list;
    private ArrayList<Node> foods;
    public void noHead(){
        for(int i=1;i<list.size();i++){
            if(list.get(0).equals(list.get(i))){
                System.out.println("you shu le ");
            }
        }
    }
    ActionListener task=new ActionListener() {
         
        public void actionPerformed(ActionEvent e) {
            worm.step();
            repaint();
        }
    };
    private Timer timer=new Timer(600,task);
    private class WormEat implements KeyListener{
 
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_LEFT) {
                worm.step(Worm.LEFT);
            }
            else if(e.getKeyCode()==KeyEvent.VK_UP) worm.step(Worm.UP);
            else if(e.getKeyCode()==KeyEvent.VK_DOWN) worm.step(Worm.DOWN);
            else if(e.getKeyCode()==KeyEvent.VK_RIGHT) worm.step(Worm.RIGHT);
            timer.start();
            repaint();
        }
        public void keyReleased(KeyEvent e) {
        }
        public void keyTyped(KeyEvent e) {
        }
    }
     
    public WormPane(Worm worm){
        this.worm=worm;
    }
    public Worm getWorm(){
        return worm;
    }
    public void paint(Graphics g){
        list=worm.getList();
        foods=worm.getFood();
        g.setColor(Color.BLACK);
        g.fill3DRect(5, 5, width, height, false);
        g.setColor(Color.PINK);
        /*for(int i=l;i<=width+l;i=i+l){
            for(int j=l;j<=height+l;j=j+l){
                g.drawLine(i, l, i, height);
            }
        }
        for(int i=l;i<=width+l;i=i+l){
            for(int j=l;j<=height+l;j=j+l){
                g.drawLine(l, j, width, j);
            }
        }*/
        for(Node n:list){
            if(n.getI()>=28){
                n.setI(1);
            }
            if(n.getJ()>=28){
                n.setJ(1);
            }
            if(n.getI()<=0){
                n.setI(27);
            }
            if(n.getJ()<=0) n.setJ(27);
            g.fillOval(n.getJ()*l, n.getI()*l, l, l);
            //System.out.print(n.getI()+":"+n.getJ()+"  ");
        }
        g.setColor(Color.GREEN);
        for(Node n:foods){
            g.fillOval(n.getJ()*l, n.getI()*l, l, l);
        }
    }
}
//主题类     

 	class Worm {
     
    private ArrayList<Node> list=new ArrayList<Node>();
    private ArrayList<Node> food=new ArrayList<Node>();
    public static final int UP=-10;
    public static final int DOWN=10;
    public static final int LEFT=-1;
    public static final int RIGHT=1;
    private boolean isHas=true;
    private int dir;
    private Random random=new Random();
    public Worm(){
        dir=UP;
        list.add(new Node(3,9));
        list.add(new Node(4,9));
        list.add(new Node(5,9));
        list.add(new Node(5,10));
        list.add(new Node(5,11));
        list.add(new Node(6,11));
        list.add(new Node(7,11));
        addFood();
    }
    public Worm(ArrayList<Node> node,int dir){
        node.clear();
        node.addAll(list);
        this.dir=dir;
    }
    public void step(){
        Node head=list.get(0);
        int i=head.getI()+dir/10;
        int j=head.getJ()+dir%10;
        head=new Node(i,j);
        list.add(0,head);
        isEat();
        if(isHas){
            list.remove(list.size()-1);
        }
        isHas=true;
         
    }
    public void step(int dir){
        this.dir=dir;
        step();
    }
    public void isEat(){
        Iterator<Node> ite=food.iterator();
        while(ite.hasNext()){
            Node n=ite.next();
            if(this.contains(n.getI(), n.getJ())){
                isHas=false;
                ite.remove();
                System.out.println("worm:"+list.get(0).getI()+":"+list.get(0).getJ());
                System.out.println("food:"+n.getI()+":"+n.getJ());
            }
        }
        addFood();
    }
    public void addFood(){
        int x;
        int y;
        while(food.size()<5){
            x=random.nextInt(27)+1;
            y=random.nextInt(27)+1;
            if(this.contains(x, y)){
                continue;
            }else
            food.add(0,new Node(x,y));
        }
         
    }
    public boolean contains(int i,int j){
        for(int idx=0;idx<list.size();idx++){
            Node node=list.get(idx);
            if(node.getI()==i&&node.getJ()==j){
                return true;
            }
        }
        return false;
    }
     
    public ArrayList<Node> getList(){
        return list;
    }
    public String toString(){
        return list.toString();
    }
    public ArrayList<Node> getFood() {
        return food;
    }
}
//蛇体    
public class Node {
    private int i;
    private int j;
    public Node(){
         
    }
    public Node(int i,int j){
        this.i=i;
        this.j=j;
    }
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public int getJ() {
        return j;
    }
    public void setJ(int j) {
        this.j = j;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        Node n;
        if(obj instanceof Node){
            n=(Node)obj;
            return n.i==this.i&&n.j==this.j;
        }
        return false;
    }
}
//运行类   

 

 
}



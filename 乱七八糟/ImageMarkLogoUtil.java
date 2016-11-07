import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*; 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.text.DateFormat;
import java.awt.Desktop; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.reflect.Field;
@SuppressWarnings("unchecked") 
public class ImageMarkLogoUtil {
	private JButton sureButton;
	private JTextField showText;
	private JFileChooser fileChooser;
	private JButton openButton;
	private JButton saveButton;
	private JPanel panel2;
	private JFrame frame;
	private JPanel panel1;
	private JSpinner myDegree;
	private JList myColor;
	private JList myFont;
//	private JSpinner myAlpha;
	private JSpinner xPos;
	private JSpinner yPos;
        private JLabel picture;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private String selectFont;//字体
	private String selectColor;//颜
	private String textValue;//要添加的文字
	private int degValue;//旋转的角度
	private int xValue;//X轴
	private int yValue;//Y 轴
//	private float alphaValue;//
	private Font fontValue;
	private Color colorValue;
	private String resourcePath;
	public ImageMarkLogoUtil(){
		frame=new JFrame();
		panel1=new JPanel();
		panel2=new JPanel();
		picture=new JLabel();
		myDegree=new JSpinner();
		String [] colors={"red","green","blue","black","cyan","darkGray","gray","gray","orange","pink","magenta","yellow"};
		String [] fonts={"DIALOG","DIALOG_INPUT","SANS_SERIF","SERIF","MONOSPACED"};
		myColor=new JList(colors);
		myColor.addListSelectionListener(new  ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				selectColor=(String)myColor.getSelectedValue();
				System.out.println("颜色为："+selectColor);
}
});
//		myColor.addListSelectionListener();
		scroll1=new JScrollPane(myColor);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         	myColor.setVisibleRowCount(1);
//用户选择旋转角度
		myDegree=new JSpinner();
		myDegree.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				degValue=(int)myDegree.getValue();
				System.out.println("角度为："+degValue);
}
});
//用户选择字体
		myFont=new JList(fonts);
		myFont.addListSelectionListener(new  ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
					selectFont=(String)myFont.getSelectedValue();
					System.out.println("字体为"+selectFont);
}
});
		scroll2=new JScrollPane(myFont);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		myFont.setVisibleRowCount(1);
	//	myAlpha=new JSpinner();
		xPos=new JSpinner();
//用户选择x轴距离
		xPos.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				xValue=(int)xPos.getValue();
				System.out.println("x轴距离："+xValue);
}
});
//用户选择y轴距离
		yPos=new JSpinner();
		yPos.addChangeListener(new ChangeListener(){
                        public void stateChanged(ChangeEvent e){
                                yValue=(int)yPos.getValue();
				System.out.println("y轴距离："+yValue);
}}
);
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
		openButton =new JButton("Open");
		saveButton=new JButton("Save");
		sureButton=new JButton("OK");
		frame.getContentPane().add(BorderLayout.EAST,panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				openFile();
				System.out.println("打开图片");
}
});	
		saveButton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){}
});
		sureButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				markText();
				System.out.println("开始P图");
}
});
		showText=new JTextField("显示文字区域");
		panel1.add(openButton);
		panel1.add(saveButton);
		panel1.add(showText);
		panel1.add(myDegree);
		panel1.add(scroll1);
		panel1.add(scroll2);
	//	panel1.add(myAlpha);
		panel1.add(xPos);
		panel1.add(yPos);
		panel1.add(sureButton);
		frame.setVisible(true);
		frame.setBounds(200,200,400,500);
}
//获取系统当前时间
	public String time()
{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return time;
}
//打开图片
	public void openFile(){
		fileChooser=new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showOpenDialog(null);
try{
                File file=fileChooser.getSelectedFile();//返回当前文件
//              Desktop.getDesktop().open(file);
//              ImageIO imageIO=new ImageIO();
// 	resourcePath=fileChooser.getName(file);
		resourcePath=file.getAbsolutePath();
		System.out.println(resourcePath);
                BufferedImage image=ImageIO.read(file);
                Image scaleImage=image.getScaledInstance(300,480,Image.SCALE_DEFAULT);
                Icon icon=new ImageIcon(scaleImage);
                picture.setIcon(icon);
                panel2.add(picture);
                frame.getContentPane().add(BorderLayout.CENTER,panel2);
                frame.setVisible(true);
}catch(IOException ex){
                ex.printStackTrace();
}
}

	public void markText(){	
		System.out.println("得到各项值");
		textValue=(String)showText.getText();
		System.out.println(textValue);
//		degValue=(int)myDegree.getValue();
//		xValue=(int)xPos.getValue();
//		yValue=(int)yPos.getValue();
//		alphaValue=(float)myAlpha.getValue();
		fontValue=new Font(selectFont,Font.BOLD,50);//粗体，50磅
//Color.getColor() 不起作用  用到反射  不懂		
try {
    Field field = Color.class.getField(selectColor);
    colorValue = (Color)field.get(null);
} catch (Exception e) {
    colorValue = null; // Not defined
}
		String path="/home/zx/javaDemo/"+time();//保存位置
		System.out.println("开始执行操作");
		markImageByText(textValue,resourcePath,path,degValue,colorValue,fontValue,xValue,yValue);
}
		

//    public static void markText() {
  //      markImageByText(addText, srcImgPath, targerPath, null);
   // }
 
    /**
     * 给图片添加水印文字、可设置水印文字的旋转角度
     * 
     * @param logoText
     * @param srcImgPath
     * @param targerPath
     * @param degree
     */
    public void markImageByText(String logoText,String srcImgPath,String targerPath, int degree,Color color,Font font, int positionWidth,int positionHeight) {
	InputStream is = null;
        OutputStream os = null;
        try {
            // 1、源图片
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
 
            // 2、得到画笔对象
            Graphics2D g = buffImg.createGraphics();
            // 3、设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            // 4、设置水印旋转
           // if (null != degree) {
                g.rotate(Math.toRadians(degree),(double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
           // }
            // 5、设置水印文字颜色
            g.setColor(color);
            // 6、设置水印文字Font
            g.setFont(font);
            // 7、设置水印文字透明度
		float alpha = 0.5f;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
            // 8、第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
            g.drawString(logoText, positionWidth, positionHeight);
            // 9、释放资源
            g.dispose();
            // 10、生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("图片完成添加水印文字");
		File targetFile=new File(targerPath);
		 BufferedImage image=ImageIO.read(targetFile);
                Image scaleImage=image.getScaledInstance(300,480,Image.SCALE_DEFAULT);
                Icon icon=new ImageIcon(scaleImage);
                picture.setIcon(icon);
                panel2.add(picture);
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
}	
 
        }
     
    public static void main(String [] args){
	ImageMarkLogoUtil mark=new ImageMarkLogoUtil();	
	mark.openFile();
    }
 
}


//package com.zx.util;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Desktop;
import java.util.Calendar;
 
import javax.imageio.ImageIO;
public class CaptureScreen {
//	private static int number=0;
 	private Calendar date;
    public void captureScreen(String fileName) throws Exception {
// 	number++;
	date=Calendar.getInstance();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //保存路径
        File screenFile = new File(fileName);
        if (!screenFile.exists()) {
            screenFile.mkdir();
        }
	int hour=date.get(Calendar.HOUR);
	String folder=hour+"屏幕截图.png";
        File f = new File(screenFile, folder);
         
        ImageIO.write(image, "png", f);
        //自动打开
        if (Desktop.isDesktopSupported()
                 && Desktop.getDesktop().isSupported(Desktop.Action.OPEN))
                    Desktop.getDesktop().open(f);
    }
 
    public static void main(String[] args) {
	CaptureScreen screen=new CaptureScreen();
        try {
            screen.captureScreen("/home/zx/图片/");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}

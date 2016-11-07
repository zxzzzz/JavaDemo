import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;

/**
 * 读取图片像素点颜色值
 * 
 * @author hoodoo
 * @date 2012年12月17日
 */
public class PicTools {
	private static final int PIXEL_W =1;
	private static final int PIXEL_H =1;

	/**
	 * 生成图像数据
	 * 
	 * @param img
	 * @param dataPath
	 */
	private void generatePicData(BufferedImage img, String dataPath) {
		StringBuilder sb = new StringBuilder();
		String R = null, G = null, B = null;
		int width = img.getWidth();
		int height = img.getHeight();
		int minx = img.getMinX();
		int miny = img.getMinY();
		sb.append(width).append(".").append(height).append("\r\n");
		int pixel = 0;
		for (int j = miny; j < height; j += PIXEL_H) {
			for (int i = minx; i < width; i += PIXEL_W) {
				pixel = img.getRGB(i, j);
				R = Integer.toHexString((pixel & 0xff0000) >> 16);
				G = Integer.toHexString((pixel & 0xff00) >> 8);
				B = Integer.toHexString(pixel & 0xff);
				R = R.length() == 1 ? "0" + R : R;
				G = G.length() == 1 ? "0" + G : G;
				B = B.length() == 1 ? "0" + B : B;
				sb.append(i).append("x").append(j).append("x").append(PIXEL_W)
						.append("x").append(PIXEL_H).append("x").append(R)
						.append(G).append(B).append("\r\n");
				
			}
		}
		try {
			writeByOutputStreamWrite(dataPath,sb.toString());
			sb.setLength(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	}

	
	/**
	 * 用OutputStreamWrite向文件写入内容
	 * 
	 * @param _destFile
	 * @throws IOException
	 */
	public void writeByOutputStreamWrite(String _sDestFile,
			String _sContent) throws IOException {
		OutputStreamWriter os = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(_sDestFile);
			os = new OutputStreamWriter(fos, "UTF-8");
			os.write(_sContent);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (os != null) {
						os.close();
				os = null;
			}
			if (fos != null) {
				fos.close();
				fos = null;
			}

		}
	}

	/**
	 * 读取并生成数据
	 * 
	 * @param imgPath
	 */
	private void readAndGeneratePicData(String imgPath, String dataPath) {
		File file = new File(imgPath);
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		generatePicData(img, dataPath);
	}

	public static void main(String[] args) {
		new PicTools().readAndGeneratePicData("/home/zx/mnls.jpg", "/home/zx/javaDemo/mnls/src/ml");
	}
}

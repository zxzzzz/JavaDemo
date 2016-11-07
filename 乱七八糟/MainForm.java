import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.StyleConstants;

public class MainForm extends JFrame implements ActionListener, DocumentListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 界面元素变量
	JMenuBar menuBar; // 菜单
	JPanel panel;
	JEditorPane textEdit;
	JLabel statusLabel;

	// 控制变量
	boolean TextChangeNoSave; // 当前文档的改变是否已经保存
	boolean DocIsNew; // 当前文档是否为新建

	// 当前文件名次、路径
	String filePath;
	String fileName;

	// 系统粘贴板
	Clipboard clip;

	public MainForm() {
		// 界面初始化
		InitGUI();
		InitPara();
	}

	// 界面初始化
	public void InitGUI() {
		// 菜单栏初始化
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		final JMenu[] menu = {new JMenu("File"),// "File"菜单
				new JMenu("Edit"),// "Edit"菜单
				new JMenu("Font"),	//"Font"菜单
				new JMenu("Help")// "Help"菜单
		};

		final JMenuItem[][] menuItem = {
				{new JMenuItem("New"), new JMenuItem("Open"),
						new JMenuItem("Save"), new JMenuItem("Exit")},
				{new JMenuItem("Cut"), new JMenuItem("Copy"),
						new JMenuItem("Paste")},
				{},
				{new JMenuItem("Help"), new JMenuItem("About")}};
		for (int i = 0; i < menu.length; i++) {
			for (int j = 0; j < menuItem[i].length; j++) 
			{				
				menuItem[i][j].setBackground(Color.LIGHT_GRAY);				
				menu[i].add(menuItem[i][j]);
				menuItem[i][j].addActionListener(this);
			}
			menuBar.add(menu[i]);
		}
		menu[0].add(new JSeparator(), 3); // 特定地方补分隔符
		// 工具栏初始化
		
		  JToolBar toolBar = new JToolBar(); 
		  String[] toolButtonText =
		  {"New","Open","Exit"}; 
		  JButton[] toolButton = new JButton[toolButtonText.length]; 
		  for(int i=0;i<toolButtonText.length;i++)
		  { 
			  toolButton[i] = new JButton(toolButtonText[i]); 
		  }
		  for(int i=0;i<toolButton.length;i++) 
		  {
			  toolButton[i].setActionCommand(toolButtonText[i]);
			  toolButton[i].addActionListener(this); 
			  toolBar.add(toolButton[i]);
		  }
		
		// 文本框

		textEdit = new JEditorPane();
		
		textEdit.setBackground(Color.DARK_GRAY);
		textEdit.setForeground(Color.LIGHT_GRAY);
		
		textEdit.getDocument().addDocumentListener(this);
		// 为文本域添加滑动块
		JScrollPane scrollPane = new JScrollPane(textEdit);

		// 初始化状态栏
		JToolBar statusBar = new JToolBar();
		statusBar.setFloatable(false);
		statusBar.setBackground(Color.LIGHT_GRAY);
		statusLabel = new JLabel("  ");
		statusBar.add(statusLabel);

		// 初始化面板
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		//panel.add(toolBar,BorderLayout.PAGE_START);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(statusBar, BorderLayout.PAGE_END);

		this.add(panel);
		this.setJMenuBar(menuBar);
		this.setTitle("NoteBook");
		this.setSize(640, 480);		
		this.setVisible(true);
	}
	// 参数初始化
	public void InitPara() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		clip = toolkit.getSystemClipboard();
		TextChangeNoSave = false;
		DocIsNew = true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		// File菜单的事件响应
			case "New" :
				newFile();
				break;
			case "Open" :
				openFile();
				break;
			case "Save" :
				saveFile();
				break;
			case "Exit" :
				exit();
				break;
			// Edit菜单事件响应
			case "Cut" :
				cutText();
				break;
			case "Copy" :
				copyText();
				break;
			case "Paste" :
				pasteText();
				break;

			// Help菜单事件响应
			case "Help" :
				help();
				break;
			case "About" :
				about();
				break;
			default :
				break;
				}
	}

	// ////菜单功能函数
	public void newFile() {
		if (TextChangeNoSave) {
			int n = JOptionPane.showConfirmDialog(this, "文件已更改，是否保存?", "提示！",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				saveFile();
			}
		}
		textEdit.setText("");
		statusLabel.setText("Created a new file");
		DocIsNew = true;
		TextChangeNoSave = true;
		filePath = null;
		fileName = null;
	}
	public void openFile() {
		if (TextChangeNoSave) {
			int n = JOptionPane.showConfirmDialog(this, "文件已更改，是否保存?", "提示！",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				saveFile();
			}

		}
		FileDialog openFileDlg = new FileDialog(this, "打开文件", FileDialog.LOAD);
		openFileDlg.setVisible(true);
		filePath = openFileDlg.getDirectory();
		fileName = openFileDlg.getFile();
		ReadFile();
		TextChangeNoSave = false;
		DocIsNew = false;

	}
	public void saveFile() {
		if (DocIsNew) {
			FileDialog saveFileDlg = new FileDialog(this, "保存文件",
					FileDialog.SAVE);
			saveFileDlg.setVisible(true);
			filePath = saveFileDlg.getDirectory();
			fileName = saveFileDlg.getFile();
		}
		WriteFile();
	}
	public void exit() {
		if (TextChangeNoSave) {
			int n = JOptionPane.showConfirmDialog(this, "文件已更改，是否保存?", "提示！",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				saveFile();
			}
		}
		System.exit(0);
	}
	public void cutText() {
		textEdit.cut();
	}
	public void copyText() {
		textEdit.copy();
	}
	public void pasteText() {
		Transferable contents = clip.getContents(this);
		if (contents != null
				&& contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String str = (String) contents
						.getTransferData(DataFlavor.stringFlavor);
				int pos = textEdit.getSelectionStart();
				textEdit.cut();
	//			textEdit.insert(str, pos);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public void help() {
		//File dir = new File("..");
		//filePath = dir.getAbsolutePath();
		fileName = "readme.txt";
		ReadFile();
	}
	public void about() {
		String info = "作者 ：nudt_tony \n" + "日期 ：2013 06 28\n"
				+ "邮箱 ：basic8@163.com";
		JOptionPane.showMessageDialog(this, info);
	}
	// /底层文件读写函数
	public void WriteFile() {
		if (fileName != null) {
			try {
				File file1 = new File(filePath, fileName);
				FileWriter fw = new FileWriter(file1);
				BufferedWriter out = new BufferedWriter(fw);
				out.write(textEdit.getText());
				out.close();
				fw.close();
				statusLabel.setText("文件保存成功!");
			} catch (IOException e) {
				statusLabel.setText("文件保存出错！");
			}
		}
	}

	public void ReadFile() {
		if (fileName != null) {
			try {
				File file1 = new File(filePath, fileName);
				FileReader fr = new FileReader(file1);
				BufferedReader in = new BufferedReader(fr);
				StringBuilder text = new StringBuilder();
				String str="";
				while ((str = in.readLine()) != null)
				{	
					text.append(str+ "\r\n");					
				}
				textEdit.setText(text.toString());
				in.close();
				fr.close();
				statusLabel.setText(filePath + fileName);

			} catch (IOException e) {
				statusLabel.setText("打开文件出错！");
			}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		// statusLabel.setText("Text Changed!!");
		TextChangeNoSave = true;
		statusLabel.setText("Text insertUpdate!");
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		TextChangeNoSave = true;
		statusLabel.setText("Text removeUpdate!!");
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		TextChangeNoSave = true;
		statusLabel.setText("Text changedUpdate!!");
	}
	public static void main(String[] args){
		MainForm form =new MainForm();
		
}
}


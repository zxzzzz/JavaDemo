import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class ListTest {
	private JList list;
	private String [] listItem={"apple","banana","one","two","three","four"};
	public static void main(String[] args){
		ListTest list=new ListTest();
		list.go();
}
	@SuppressWarnings("unchecked") 
	public void go(){
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
//		String [] listItem={"apple","banana","one","two","three","four"};
		list=new JList(listItem);
		JScrollPane scroller=new JScrollPane(list);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener(){
 			public void valueChanged(ListSelectionEvent lse){
				if(!lse.getValueIsAdjusting()){
				String selection=(String)list.getSelectedValue();
				System.out.println(selection);		
}
}
	
		
});
		panel.add(scroller);
		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
			
}
}

import javax.swing.*;
import java.awt.*;
import java.awt.Component.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JFrame{
	JTable table;
	JPanel panel;
	JLabel label;
	JLabel score;
	String [][] items=new String[4][4];
	public static void main(String[] args){
		Table test=new Table();
		//test.random();
		for(int i=0;i<3;i++){
			test.random();
			test.setValue();
}
}
	public Table(){
		this.setTitle("2048");
		table=new JTable(4,4);
		label=new JLabel("score");
		panel=new JPanel();
		score=new JLabel();
		panel.setLayout(null);
		score.setBounds(50,0,100,50);
		label.setBounds(0,0,50,50);
		table.setEnabled(false);
		table.setBounds(0,50,400,400);
		table.setRowHeight(90);
		table.setFont(new Font("宋体",Font.PLAIN,40));
		table.setBorder(new EtchedBorder(Color.BLACK,Color.LIGHT_GRAY));
		panel.add(table);
		panel.add(label);
		panel.add(score);
		this.add(panel);
		this.setSize(400,450);
		this.setLocation(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
}
	public  void random(){
		int x=(int)(Math.random()*4);
		int y=(int)(Math.random()*4);
		float t=(float)(Math.random());
		if(t<0.5)
			items[x][y]=String.valueOf(2);
		else
			items[x][y]=String.valueOf(4);
}
	public void setValue(){
		 DefaultTableModel model = (DefaultTableModel) this.table.getModel();
                int rowcount = model.getRowCount();
                while (rowcount > 0) {
                        model.removeRow(0);
                        rowcount--;
                }
         //       showParams();
                for (int i = 0; i < 4; i++) {
                        model.addRow(items[i]);
                }

                this.table.setModel(model);
                this.table.setFont(new Font("font", Font.PLAIN, 40));
//		 for (int i = 0; i < 4; i++) {
  //                      table.getColumn(model.getColumnName(i)).setCellRenderer(
    //                                    new MyTableCellRenderrer());
      //          }



}
 class MyTableCellRenderrer extends DefaultTableCellRenderer {
                // 设置单元格内容居中
                @Override
                public void setHorizontalAlignment(int alignment) {
                        super.setHorizontalAlignment(SwingConstants.CENTER);
                }

                // 设置单元格颜色
                @Override
                public Component getTableCellRendererComponent(JTable table,
                                Object value, boolean isSelected, boolean hasFocus, int row,
                                int column) {
                        Component comp = super.getTableCellRendererComponent(table, value,
                                        isSelected, hasFocus, row, column);
                        int v = 0;
                        if (value != null && value != "")
                                v = Integer.valueOf(value.toString());
                        switch (v) {
                        case 2:
                                setBackground(new Color(255, 239, 213));
                                break;
                        case 4:
                                setBackground(new Color(199,27,240));
				break;
			default:
				comp.setBackground(Color.LIGHT_GRAY);
				break;
			}
			return comp;
}
}
}

import java.util.Date;
import java.util.Calendar;
//java.util.Date 与java.util.Date.* 的区别
public class FormatTest{
	public static void main(String [] args){
		String s=String.format("%,d",1000000);
		System.out.println(s);
		String date=String.format("%tA,%<tB,%<td",new Date());
		System.out.println(date);
		Calendar c=Calendar.getInstance();
		c.set(2016,8,19,12,45);
		long date1=c.getTimeInMillis();
		date1+=1000*60*60;
		c.setTimeInMillis(date1);
		System.out.println("new hoour:"+c.get(Calendar.HOUR_OF_DAY));
		c.add(c.DATE,30);
		System.out.println(""+c.getTime());
		c.roll(c.DATE,20);
		System.out.println(""+c.getTime());
	
}
}

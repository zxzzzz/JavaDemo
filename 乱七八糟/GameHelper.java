import java.util.*;
import java.io.*;
public class GameHelper{
	private int gameLength=7;//列宽
	private int gameSize=49;//总长度
	private int comCount=0;//com的数量
	private int[] gamePatting=new int[gameSize];//网格
	private static final String change="abcdefg";
	public ArrayList<String> placeCom(int comSize)//放置com的位置
{
//		int x=0;//第几个位置
		int[] com=new int[comSize];//
		String[] stringCom=new String[comSize];//
		int location=0;//随机产生的位置
		boolean success=false;//是否成功放置
		ArrayList<String> arrayList=new ArrayList<String>();//返回com的三个位置
		int vh=0;//垂直/水平
		int attemp=0;
//		String change="abcdefg";
		comCount++;
		if((comCount%2)==0){
			vh=1;	
}else{
			vh=gameLength;
}
	while(!success&attemp++<200){
	//	if(comCount<=comCount){//不超过三个com
			location=(int)(Math.random()*gameSize);
	//		com[x]=location;
			int  x=0;
			success=true;
			while(success&&x<comSize)//com的位置不超过三个{
			//	location=(int)(Math.random()*gameSize);
				//location+=vh;{
{
			//	com[x]=location;
			//	x++;
				//location+=vh;
			//	gamePatting[location]=1;//提前设置为1的话如果为false则错误

				if(gamePatting[location]==0){//如果没被被占用//gamePatting[com[x]]  数组越界？//如果没被占用的话zaishiyong
					com[x++]=location;
					location+=vh;
					if(location>=gameSize)//随机数超过下边缘
						success=false;
					
}
				else{
					success=false;//如果已经被占用
			
			
}
}
}
		int m=0;
		int raw=0;//局部变量必须初始化
		int colume=0;
		while(m<comSize){
			gamePatting[com[m]]=1;
			raw=(int)com[m]/gameLength;//  如果是/的话则可能产生小数  类型转换为整数
			colume=com[m]%gameLength;
			String temp=String.valueOf(change.charAt(colume));
			m++;
			arrayList.add(temp.concat(Integer.toString(raw)));
			
}
		for(String loca:arrayList)
			System.out.println(loca);
		return arrayList;
}
	public String getUserInput(String input)	{
		System.out.println(input);
		String line=null;
		try{
			BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
			line=read.readLine();//如果是括号里面的则到括号外面失效
}catch(IOException e){
		System.out.println(e);
}
		
		return line;
		
}	





}




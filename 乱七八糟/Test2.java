import java.io.*;
import java.util.*;
public class Test2 extends Test1{
	public Test2(){
		System.out.println("构造器被加载");
}

	public static void main(String[] args){
		Test1.funStatic();		
		Test2 h=new Test2();
		Test2 w=new Test2();
		String[] a={"a","b","c","d","e","f"};
		String[] b=a;
		for(String m:b)
			System.out.println(m);
		ArrayList<Test1> n;
		n=new Test2().g();
		for(Test1 l:n)
			System.out.println(l);
		System.out.println("输入");
		Scanner scanner=new Scanner(System.in);
		String r=scanner.next();
		System.out.println(r);
		String p="aabbccm";
		boolean e=false;
		if(p==r)
			e=true;
		System.out.println(e);
		e=false;
		if(p.equals(r))
			e=true;
		int v;
		System.out.println(v+" ");
 


}
	public ArrayList<Test1> g(){
		ArrayList<Test1> k= new ArrayList<Test1>();
		for(int i=0;i<10;i++)
			{
			Test1 t=new Test1();
			k.add(t);
}
		return k;
			
}
}

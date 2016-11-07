public class Equal{
	public static void main(String[] args){
		Equal a=new Equal();
		Equal b=new Equal();
		Equal c=a;
		if(a==b)
			System.out.println("a==b");
		if(a==c)
			System.out.println("a==c");
		if(b==c)
			System.out.println("b==c");
		if(a.equals(b))
			System.out.println("a.equal(b)");
		if(a.equals(c))
			System.out.println("a.equal(c)");
		if(b.equals(c))
			System.out.println("b.equal(c)");
		int int1=1;
		int int2=int1;
		if(int1==int2)
			System.out.println("int1==int2");
//		if(int1.equals(int2))
//			System.out.println("int1.equal(int2)");
	}

}

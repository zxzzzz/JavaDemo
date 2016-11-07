import java.util.*;
public class MaxNumber{
	public static void main(String [] args){

	new MaxNumber().run();
}




	public void run(){
		Scanner scanner=new Scanner(System.in);
		int count=scanner.nextInt();
		int[] list=new int[100001];
		for(int i=0;i<count;i++){
			++list[scanner.nextInt()];
}
		int max=0;
		int result=0;
		for(int i=0;i<10001;i++)
		{
			
			if(list[i]>max){
				max=list[i];
				result=i;
			
				
}
}
	System.out.println(result);
		
}
}

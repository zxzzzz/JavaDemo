import java.util.*;//java.lang为基础类 默认已导入 java.util为工具类
public class SimpleGuessGame{
 // 	private int numberGuess=0;
	private ArrayList<String> location=new ArrayList<String>();
	private String result;
	public void set(ArrayList<String> locations){
		location=locations;
}
	public String check(String guess){
		result="miss";//若不设置没miss，那么一旦有hit之后便一直是hit
	//	int guessNumber=(int)Integer.parseInt(guess);
	//	for(int nextNumber:location){
	//		if(guessNumber==nextNumber){
	//			result="hit";
	//			numberGuess++;
	//			location.remove(nextNumber);
//				break;//这个时候应该将对应的标号移除
//}
//}
		int index=location.indexOf(guess);
		if(index>=0){
	//		result="hit";
			location.remove(index);
			if(location.isEmpty()){
				result="kill";
}else{
			result="hit";
}
					
}
	
	//	if(numberGuess==3)
	//		result="kill";
		System.out.println(result);
		return result;
}
	public static void main(String[] args){
		SimpleGuessGame guessGame=new SimpleGuessGame();
		int random=(int)(Math.random()*5);
		String random1=(String)Integer.toString(random);//Integer.toString(int); 将int转换为String
		String random2=(String)Integer.toString(random+1);
		String random3=(String)Integer.toString(random+2);
		ArrayList<String> loc=new ArrayList<String>();
		loc.add(random1);
		loc.add(random2);
		loc.add(random3);
//		for(String loca:loc)
//			System.out.println(loca);
		boolean isAlive=true;
		String results="miss";
		int inputNumber=0;
		GuessHelper helper=new GuessHelper();
		guessGame.set(loc);
//		for(int i:loc)
//			System.out.println(i);
		while(isAlive){
		//	System.out.println("enter a number:");
		//	if(args.length==0)
		// 		System.out.println("please intput");
			String guessNumber=helper.getUserInput("enter the number:");
		//	guessGame.set(locations);
			results=guessGame.check(guessNumber);
		//	System.out.println(results);
		//	if(results.equals("hit")){
			//	System.out.println(result);
			inputNumber++;
			if(results.equals("kill")){
			//	System.out.println(result);
				isAlive=false;
				System.out.println(inputNumber+"次:"+results);
    		//				break;
}
				
			
}
				
}
}

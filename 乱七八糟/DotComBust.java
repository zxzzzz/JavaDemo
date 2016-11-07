import java.util.*;
public class DotComBust{
	private GameHelper gameHelper=new GameHelper();
	private ArrayList<DotCom> dotComList=new ArrayList<DotCom> ();
	private int number=0;
	public  void setupGame(){
		DotCom one=new DotCom();
		DotCom two=new DotCom();
		DotCom three=new DotCom();
		one.setName("one");
		two.setName("two");
		three.setName("three");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		for(DotCom dotCom:dotComList){
			ArrayList<String> location=gameHelper.placeCom(3);
			dotCom.setLocation(location);
}
}
	public void startPlaying(){
		while(!dotComList.isEmpty()){
			String userInput=gameHelper.getUserInput("please input the guess number:");
			checkUserGuess(userInput);
			
}
		finishGame();
}
	public void checkUserGuess(String  userInput){
		String result="miss";
		number++;
		for(DotCom dotComTest:dotComList){
			result=dotComTest.check(userInput);
			if(result.equals("hit")){
				break;
			
}
			if(result.equals("kill")){
				dotComList.remove(dotComTest);
				break;
}
}
	System.out.println(result);
}
	public void finishGame(){
		if(number<=18)
			System.out.println("Good:"+number+"次");
		else{
			System.out.println("Bad:"+number+"次");
}
}
	public static void main(String[] args){
		DotComBust bust=new DotComBust();
		bust.setupGame();
		bust.startPlaying();
}
}

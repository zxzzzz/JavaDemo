import java.util.*;
public class DotCom{
	private String name;
	private ArrayList<String> location=new ArrayList<String>();
	public void setName(String myName){
		name=myName;
}
	public void setLocation(ArrayList<String> myLocation){
		location=myLocation;
}
	public String check(String userInput){
		String result="miss";
		int index=location.indexOf(userInput);
		if(index>=0){
			result="hit";
			location.remove(index);
}
		if(location.isEmpty())
			result="kill";
//		System.out.println(result);
		return result;

}
}

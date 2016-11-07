import java.util.*;
public class MapTest{
	public static void main(String[] args){
		HashMap<String ,Integer> map=new HashMap<String,Integer>();
		map.put("a",1);
		map.put("b",2);
		map.put("c",3);
		map.put("c",4);
		System.out.println(map);
		System.out.println(map.get("c"));
}
}

import java.util.*;
import java.io.*;
public class CollectionTest{
//main主函数不能引用非静态变量
	public static ArrayList<Song> array=new ArrayList<Song>();
	public static void main(String[] args){
		CollectionTest test=new CollectionTest();
		test.go();
//sort()参数必须实现Comparablej接口
//		Collections.sort(array);
		System.out.println(array);
//无法从静态上下文引用非静态变量：new xx()也不行 那CollectionTest怎么行
//		ArtSort sort=new ArtSort();
//		Collections.sort(array,sort);
}

	public void go(){
		try{
//如果访问文件名 ，则此文件必须在同级目录下
			File file=new File("/home/zx/songs.txt");
			BufferedReader read=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=read.readLine())!=null){
			//	String[] one=line.split("/");
			//	Song song=new Song(one[0],one[1],one[2],one[3]);			
				add(line);
	
}
//			   ArtSort sort=new ArtSort();
  //              	   Collections.sort(array,sort);
//	 			HashSet<Song> hashSet=new HashSet<Song>();
//				hashSet.addAll(array);		
				TreeSet<Song> treeSet=new TreeSet<Song>();
//addAll(参数)没用泛型？上句不小心写成 TreeSet treeSet了。。
				treeSet.addAll(array);
				System.out.println(treeSet);	   
}catch(IOException e){
			e.printStackTrace();
}
		
}
	public void add(String one){
		String[] text=one.split("/");
		Song song=new Song(text[0],text[1],text[2],text[3]);
		array.add(song);
		
}
//使用sot(List<E>,Comparator<E>)将调用Comparator的compare()方法
	class ArtSort implements Comparator<Song>{
		public int compare(Song one,Song two){
			return one.getSinger().compareTo(two.getSinger());
}
}
	class Song implements Comparable<Song>{
		String title;
		String singer;
		String am;
		String bm;
		public Song (String title,String singer,String am,String bm){
			this.title=title;
			this.singer=singer;
			this.am=am;
			this.bm=bm;
}	
		public int compareTo(Song s){
			return getTitle().compareTo(s.getTitle());
}

		public boolean equals(Object s){
			Song m=(Song)s;
			System.out.println("比较equals()");
			return getTitle().equals(m.getTitle());
}
		public int hashCode(){
			System.out.println("比较hashCode()");
			return title.hashCode();
}

	
		public String getTitle(){
			return title;
}
		public String getSinger(){
			return singer;
}
		public String getAm(){
			return am;
}
		public String getBm(){
			return bm;
}
//toString() 为object类，所有类都会继承到
		public String toString(){
			return title;
}

}

}

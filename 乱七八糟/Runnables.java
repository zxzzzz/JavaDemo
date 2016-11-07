public class Runnables implements Runnable{
	public static void main(String[] args){
		Runnable job=new Runnables();
		Thread aThread=new Thread(job);
		Thread bThread=new Thread(job);
		aThread.setName("aThread");
		bThread.setName("bThread");
		aThread.start();
		bThread.start();
		
}
	public void run(){
		for(int i=0;i<25;i++){
			String name=Thread.currentThread().getName();
			System.out.println("the current thread is "+name);
}
}
}

public class MyThread{
	public static void main(String[] args){
		Runnable job=new MyRunnable();
		Thread thread=new Thread(job);
		thread.start();
		System.out.println("back to main");
}
}

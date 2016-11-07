public class MyRunnable implements Runnable{
	public void run(){
//		System.out.println("myRunnable thread");
		go();
}
	public void go(){
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();		
}
		doMore();
}
	public void doMore(){
		System.out.println("new thread");
}
}

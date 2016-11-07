public class BankRunnable implements Runnable{
	private Bank bank=new Bank();
	public static void main(String[] args){
		Runnable job=new BankRunnable();
		Thread man=new Thread(job);
		Thread woman=new Thread(job);
		man.setName("man");
		woman.setName("woman");
		man.start();
		woman.start();
}
	public void run(){
		for(int i=0;i<10;i++){
			makeWithDraw(100);
			if(bank.getAccount()<0){
				System.out.println("余额不足...");
				break;
}}
}
	private  synchronized void makeWithDraw(int draw){//同步锁
		if(bank.getAccount()>draw){
			System.out.println(Thread.currentThread().getName()+" is about withDraw");
			try{
				System.out.println(Thread.currentThread().getName()+" is sleeping...");
				Thread.sleep(500);
}catch(InterruptedException e)	
{	
				e.printStackTrace();
}
			System.out.println(Thread.currentThread().getName()+"is wake up");
			bank.withDraw(draw);
			System.out.println(Thread.currentThread().getName()+"is completed withdraw");
}else{
			System.out.println("没有足够的钱"+Thread.currentThread().getName());

}
}
}

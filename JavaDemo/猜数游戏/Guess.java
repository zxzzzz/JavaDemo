public class Guess{
	boolean pT1;
	boolean pT2;
	boolean pT3;
	Player p1=new Player();
	Player p2=new Player();
	Player p3=new Player();
	public void startGuess(){
		int guessNumber=(int)(Math.random()*10);
		System.out.println("the number wo have to guess is:"+guessNumber);
		int number1;
		int number2;
		int number3;
 		while(true){
		p1.guessNumber();
		p2.guessNumber();
		p3.guessNumber();
		number1=p1.number;
		number2=p2.number;
		number3=p3.number;
		if(number1==guessNumber){
			pT1=true;
			System.out.println("player1 guess the true number!");
}else
	System.out.println("the player1 guess wrong!");
		if(number2==guessNumber){
			pT2=true;
			System.out.println("the player2 guess the true number");		
}else 
	System.out.println("the player2 guess wrong!");
		if(number3==guessNumber){
			pT3=true;
	System.out.println("the player3 guess the true number");
}else
	System.out.println("the player3 guess wrong!");
		if(pT1==true||pT2==true||pT3==true){
			System.out.println("I guess the true numer: "+guessNumber);
			break;
}else{
		System.out.println("we will begin the game...");
}

}
		
	}
		
}

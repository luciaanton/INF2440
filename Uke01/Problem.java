import java.util.concurrent.*;


class Problem{
	public static void main(String[] args){
		Problem p = new Problem();
		p.utfoer();
	}


	void utfoer(){
		Thread t = new Thread(new Arbeider());
		t.start();
	}


	class Arbeider implements Runnable{
		int i, lokalData;// dette er lokale data for hver traad
		public void run(){
			System.out.println("Hei fra traaden!");
			//dette kalles naar traaden er startet
		}
	}//end indre klasse Arbeider
}
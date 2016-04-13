import java.util.concurrent.*;

class Example{
	static int n;


	public static void main(String[] args){
		Example e = new Example();
		e.n = 0;

		new Thread(new Traad(1, e)).start();
		System.out.println("n = " + e.n);
	}
}

class Traad implements Runnable{
	int index;
	Example e;

	Traad(int index, Example e){
		this.index = index;
		this.e = e;
	}

	public void run(){
		e.n++;
	}
}
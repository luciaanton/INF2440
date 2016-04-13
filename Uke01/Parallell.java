import java.util.*;
import java.util.concurrent.*;

public class Parallell{
	int tall;
	CyclicBarrier b;
	int antTraader, antGanger, svar;

	void inkrTall(){
		tall++;
	}

	public static void main(String[] args){
		if(args.length != 2){
			System.out.println("Bruk java <antall_traader> <antall_ganger>");
		} else {
			int antallKjerner = Runtime.getRuntime().availableProcessors();
			System.out.println("Maskinen har " + antallKjerner + " prosessorkjerner.");
			Parallell p = new Parallell();
			p.antTraader = Integer.parseInt(args[0]);
			p.antGanger = Integer.parseInt(args[1]);
			p.utfoer();
		}
	}


	void utskrift(double tid){
		 svar = antGanger*antTraader;
		 System.out.println("Tid " + antGanger + " kall *" + antTraader + " Traader = " + tid + " milisek");
		 System.out.println(" sum: " + tall + ", tap" + (svar - tall) + " = " + (svar - tall) * 100 / svar + "%");
	}

	void utfoer(){
		b = new CyclicBarrier(antTraader + 1);
		long t = System.nanoTime();

		for(int j = 0; j < antTraader; j++){
			new Thread(new Para(j)).start();
		}

		try{
			b.await();
		} catch (Exception e){
			return;
		}

		double tid = (System.nanoTime() - t)/1000000.0;
		utskrift(tid);
	}

	class Para implements Runnable{
		int ind;

		Para(int ind){
			this.ind = ind;
		}

		public void run(){
			for(int j = 0; j < antGanger; j++){
				inkrTall();
			}

			try{
				b.await();
			} catch (Exception e){
				return;
			}
		}
	}
}
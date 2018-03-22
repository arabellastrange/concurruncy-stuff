import java.util.ArrayList;
import java.util.List;

public class TSPRunnable implements Runnable{

	
	GeneticAlgorithm ga;
	Population startPop;
	Population newPop;
	public TSPRunnable(Population newPop, Population population) {
		this.newPop = newPop;
		this.startPop = population;
	}
	@Override
	public void run() { 
		ga = new GeneticAlgorithm(startPop.getSize());
        Population p = ga.evolve(startPop);
        for(Route r: p.getRoutes()){
        	newPop.add(r);
        	//System.out.println(Thread.currentThread().getName() + "adding");
        }
	}
}

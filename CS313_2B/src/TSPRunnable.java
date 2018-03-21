import java.util.ArrayList;
import java.util.List;

public class TSPRunnable implements Runnable{

	List<City> cities = new ArrayList<City>();
	Population pop;
	GeneticAlgorithm ga = new GeneticAlgorithm();
	int threadsComplete =0;
	public TSPRunnable() {

		cities.add(new City(40, 120,"a"));
		cities.add(new City(120, 10,"b"));
		cities.add(new City(20, 70,"c"));
		cities.add(new City(50, 90,"d"));
		cities.add(new City(90, 120,"e"));
		cities.add(new City(50, 170,"f"));
		cities.add(new City(100, 140,"g"));
		cities.add(new City(200, 200,"h"));
		cities.add(new City(140, 20,"i"));
		cities.add(new City(80, 50,"j"));
		cities.add(new City(80, 30,"k"));
		cities.add(new City(120, 180,"l"));
		cities.add(new City(170, 40,"m"));
		cities.add(new City(20, 110,"n"));
		cities.add(new City(50, 100,"o"));
		cities.add(new City(30, 20,"p"));
		cities.add(new City(40, 140,"q"));
		cities.add(new City(190, 190,"r"));
		cities.add(new City(50, 40,"s"));
		cities.add(new City(20, 170,"t"));
		
        pop = new Population(100, cities ,true);
		System.out.println("Starting Fittest Distance: " + pop.getFittest().getTotalDistance());
		System.out.println("Starting Fittest Route: ");
		for (int x=0;x<pop.getFittest().getSize();x++) {
			System.out.print(" "+pop.getFittest().getCity(x).getName());
		}

		System.out.println("");
		
      /*
		for (int i = 0; i < 100; i++) {
            pop = ga.evolve(pop);
        }
        */
        
        Thread[] threads = new Thread[cities.size()];
        for(int i=0;i<threads.length;i++) {
        	threads[i] = new Thread(this,String.valueOf(i));
        	threads[i].start();
        	
        }
	}
	@Override
	public void run() {
        System.out.println("Thread executing: " + Thread.currentThread().getId());
		pop=ga.evolve(pop);
		System.out.println(pop.getFittest().getTotalDistance());
		threadsComplete++;
		if(threadsComplete>=cities.size()) {
			display();
		}
		
	}
	
	public void display() {
		 System.out.println("");
	        System.out.println("Finishing Fittest Distance: " + pop.getFittest().getTotalDistance());
	        System.out.println("Finishing Fittest Route: ");
	        for (int x=0;x<pop.getFittest().getSize();x++) {
				System.out.print(" "+pop.getFittest().getCity(x).getName());
				
	        }
	        System.out.println("");
	}

}

import java.util.ArrayList;
import java.util.List;

public class Driver{

	
	
	public static void main(String[] args) {
		
		List<City> cities = new ArrayList<City>();
		Population pop;

		cities.add(new City(40, 120,"0"));
		cities.add(new City(120, 10,"1"));
		cities.add(new City(20, 70,"2"));
		cities.add(new City(50, 90,"3"));
		cities.add(new City(90, 120,"4"));
		cities.add(new City(50, 170,"5"));
		cities.add(new City(100, 140,"6"));
		cities.add(new City(200, 200,"7"));
		cities.add(new City(140, 20,"8"));
		cities.add(new City(80, 50,"9"));
		cities.add(new City(80, 30,"10"));
		cities.add(new City(120, 180,"11"));
//		cities.add(new City(170, 40,"12"));
//		cities.add(new City(20, 110,"13"));
//		cities.add(new City(50, 100,"14"));
//		cities.add(new City(30, 20,"15"));
//		cities.add(new City(40, 140,"16"));
//		cities.add(new City(190, 190,"17"));
//		cities.add(new City(50, 40,"18"));
//		cities.add(new City(20, 170,"19"));
		
		 pop = new Population(100, cities ,true);
			System.out.println("Starting Fittest Distance: " + pop.getFittest().getTotalDistance());
			System.out.println("Starting Fittest Route:" + pop.getFittest().printRoute());
		
		GeneticAlgorithm ga = new GeneticAlgorithm(pop.getSize());	
			int i = 0;
			
			long start = System.currentTimeMillis();
			
		while(pop.getFittest().getTotalDistance() > 672.8){
			pop = ga.evolve(pop);
			System.out.println(i + "Fittest Distance: " + pop.getFittest().getTotalDistance());
			System.out.println(i + "Fittest Route:" + pop.getFittest().printRoute());
			i++;
		}
		

		long end =  System.currentTimeMillis();
        
		long time = end - start;
		System.out.println(time);
        
	}
}

	


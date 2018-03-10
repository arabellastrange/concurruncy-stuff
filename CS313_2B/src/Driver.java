import java.util.ArrayList;
import java.util.List;

public class Driver {

	
	
	public static void main(String[] args) {
		List<City> cities = new ArrayList<City>();
		
		cities.add(new City(40, 120));
		cities.add(new City(120, 10));
		cities.add(new City(20, 70));
		cities.add(new City(50, 90));
		cities.add(new City(90, 120));
		cities.add(new City(50, 170));
		cities.add(new City(100, 140));
		cities.add(new City(200, 200));
		cities.add(new City(140, 20));
		cities.add(new City(80, 50));
		cities.add(new City(80, 30));
		cities.add(new City(120, 180));
		cities.add(new City(170, 40));
		cities.add(new City(20, 110));
		cities.add(new City(50, 100));
		cities.add(new City(30, 20));
		cities.add(new City(40, 140));
		cities.add(new City(190, 190));
		cities.add(new City(50, 40));
		cities.add(new City(20, 170));
		
		Population pop = new Population(100, cities ,true);
		System.out.println("Starting Fittest Distance: " + pop.getFittest().getTotalDistance());

		GeneticAlgorithm ga = new GeneticAlgorithm();
		
        for (int i = 0; i < 100; i++) {
            pop = ga.evolve(pop);
        }

        System.out.println("Finishing Fittest Distance: " + pop.getFittest().getTotalDistance());
	}
	
}

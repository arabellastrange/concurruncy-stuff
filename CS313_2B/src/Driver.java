import java.util.ArrayList;
import java.util.List;

public class Driver {

	
	
	public static void main(String[] args) {
		List<City> cities = new ArrayList<City>();
		
		cities.add(new City(40, 120,"a"));
		cities.add(new City(120, 10,"b"));
		cities.add(new City(20, 70,"c"));
		cities.add(new City(50, 90,"d"));
		cities.add(new City(90, 120,"e"));
		cities.add(new City(50, 170,"f"));
		cities.add(new City(100, 140,"g"));
		cities.add(new City(200, 200,"h"));
		cities.add(new City(140, 20,"h"));
		cities.add(new City(80, 50,"i"));
		cities.add(new City(80, 30,"j"));
		cities.add(new City(120, 180,"k"));
		cities.add(new City(170, 40,"l"));
		cities.add(new City(20, 110,"m"));
		cities.add(new City(50, 100,"n"));
		cities.add(new City(30, 20,"o"));
		cities.add(new City(40, 140,"p"));
		cities.add(new City(190, 190,"q"));
		cities.add(new City(50, 40,"r"));
		cities.add(new City(20, 170,"s"));
		
		Population pop = new Population(100, cities ,true);
		System.out.println("Starting Fittest Distance: " + pop.getFittest().getTotalDistance());
		System.out.println("Starting Fittest Route: ");
		for (int x=0;x<pop.getFittest().getSize();x++) {
			System.out.print(" "+pop.getFittest().getCity(x).getName());
		}

		GeneticAlgorithm ga = new GeneticAlgorithm();
		
        for (int i = 0; i < 100; i++) {
            pop = ga.evolve(pop);
        }

        System.out.println("");
        System.out.println("Finishing Fittest Distance: " + pop.getFittest().getTotalDistance());
        System.out.println("Finishing Fittest Route: ");
        for (int x=0;x<pop.getFittest().getSize();x++) {
			System.out.print(" "+pop.getFittest().getCity(x).getName());
		}
        
	}
	
}

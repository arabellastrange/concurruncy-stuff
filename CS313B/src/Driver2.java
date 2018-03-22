import java.util.ArrayList;
import java.util.List;

public class Driver2 {

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
		
		 pop = new Population(100, cities ,true);
			System.out.println("Starting Fittest Distance: " + pop.getFittest().getTotalDistance());
			System.out.println("Starting Fittest Route:" + pop.getFittest().printRoute());
			
		int i = 0;
		long start = System.currentTimeMillis();
		
		while(pop.getFittest().getTotalDistance() > 672.8){//for each split pop, evolve, combine and repeat
			
			Population newPop = new Population(pop.getSize(), cities ,false);
			
			Thread t1 = new Thread(new TSPRunnable(newPop, pop.getSubPop(0, 10)));
			Thread t2 = new Thread(new TSPRunnable(newPop, pop.getSubPop(1, 10)));
			Thread t3 = new Thread(new TSPRunnable(newPop, pop.getSubPop(2, 10)));
			Thread t4 = new Thread(new TSPRunnable(newPop, pop.getSubPop(3, 10)));
			Thread t5 = new Thread(new TSPRunnable(newPop, pop.getSubPop(4, 10)));
			Thread t6 = new Thread(new TSPRunnable(newPop, pop.getSubPop(5, 10)));
			Thread t7 = new Thread(new TSPRunnable(newPop, pop.getSubPop(6, 10)));
			Thread t8 = new Thread(new TSPRunnable(newPop, pop.getSubPop(7, 10)));
			Thread t9 = new Thread(new TSPRunnable(newPop, pop.getSubPop(8, 10)));
			Thread t10 = new Thread(new TSPRunnable(newPop, pop.getSubPop(9, 10)));
			
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
			t6.start();
			t7.start();
			t8.start();
			t9.start();
			t10.start();
			
			try {
				t1.join();
				t2.join();
				t3.join();
				t4.join();
				t5.join();
				t6.join();
				t7.join();
				t8.join();
				t9.join();
				t10.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(i + "Fittest Distance: " + newPop.getFittest().getTotalDistance());
			System.out.println(i + "Fittest Route:" + newPop.getFittest().printRoute());
			
			pop = newPop;
			i++;
		}
		
		long end =  System.currentTimeMillis();
        
		long time = end - start;
		System.out.println(time);
	}

}

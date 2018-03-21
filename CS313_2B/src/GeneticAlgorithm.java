import java.util.Random;

public class GeneticAlgorithm {

	private Random rng = new Random();
	private double mutationRate = 0.01;
	private int selectionSampleSize = 10;
	private boolean elitism = true;
	
	public GeneticAlgorithm(){
		
	}
	
	public Population evolve(Population pop){
		Population newPop = new Population(pop.getSize(), pop.getCities(), false);
		
		int start = 0;
		if(elitism){
			newPop.add(pop.getFittest());
			start = 1;
		}
		
		for(int i = start; i < newPop.getSize(); i++){
			//need to increase initial population size
			Route r1 = sampleSelect(pop);
			Route r2 = sampleSelect(pop);
			
			newPop.add(crossover(r1, r2));
		}
		
		for(int i = start; i < newPop.getSize(); i++){
				mutate(newPop.get(i));
		}
		
		return newPop;
	}

	public Route sampleSelect(Population pop){
		Population sample = new Population(selectionSampleSize, pop.getCities(), false);
		
		for(int i = 0; i < selectionSampleSize; i++){
			sample.add(pop.get(rng.nextInt(pop.getSize())));
			if(sample.get(i).getSize() != 20){
				sample.remove(i);
				i--;
			}
		}
		return sample.getFittest();
	}
	
	public Route crossover(Route r1, Route r2){
		Route child = new Route();
		int start = rng.nextInt(r1.getSize());
		
		for(int i = 0; i < start; i++){
			child.add(r1.getCity(i));
		}
		for(int i = start; i < r2.getSize(); i++){
			if(!child.contains(r2.getCity(i))){
				child.add(r2.getCity(i));
			}	
		}
		return child;
	}
	
	public void mutate(Route route){
		for(int i = 0; i < route.getSize(); i++){
			if(rng.nextInt(100)/100 < mutationRate){
				int j = rng.nextInt(route.getSize());
					if(!(i == j)){
						City city1 = route.getCity(i);
						City city2 = route.getCity(j);
						
						route.setCity(i, city2);
						route.setCity(j, city1);
					}
				}	
			}
		}
	}

import java.util.ArrayList;
import java.util.List;

public class Population {

	List<Route> routes = new ArrayList<Route>();
	List<City> cities = new ArrayList<City>();
	int size;
	
	public Population(int size, List<City> cities, boolean fill){
		this.size = size;
		this.cities = cities;
		
		if(fill){
			for(int i = 0; i < size; i++){
				routes.add(new Route(cities));
			}
		}
		
	}
	
	public Route get(int index){
		return routes.get(index);
	}
	
	public void add(Route route){
		routes.add(route);
	}
	
	public List<City> getCities(){
		return cities;
	}
	
	public int getSize(){
		return size;
	}
	
	public void remove(int index){
		routes.remove(index);
	}
	
	public Route getFittest(){
		double best = 0;
		int bestIndex = -1;
		for(int i = 0; i < size; i++){
			
			double fit = routes.get(i).fitness();
			if(fit > best){
				best = fit;
				bestIndex = i;
			}
		}
		
		return routes.get(bestIndex);
	}
}

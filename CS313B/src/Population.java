import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Population {

	List<Route> routes = new ArrayList<Route>();
	List<City> cities = new ArrayList<City>();
	Lock lock = new ReentrantLock();
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
		
		lock.lock();
		try{
			routes.add(route);
		}finally{
			lock.unlock();
		}
	}
	
	public List<City> getCities(){
		return cities;
	}
	
	public int getSize(){
		return size;
	}
	
	public List<Route> getRoutes(){
		return routes;
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
	
	public double getAverageDistance(){
		
		double x = 0;
		for(Route r : routes){
			x += r.getTotalDistance();
		}
		return x/routes.size();
	}
	
	public Population getSubPop(int i, int of){
		
		int newSize = size/of;
		Population newPop = new Population(newSize, cities, false);
		
		for(int x = i*newSize; x < (i+1)*newSize; x++){
			newPop.add(routes.get(x));
		}
		
		return newPop;
	}
}

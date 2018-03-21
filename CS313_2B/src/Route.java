import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route {

	public List<City> route = new ArrayList<City>();
	
	public Route(){
		
	}
	
	public void add(City city){
		route.add(city);
	}
	
	public Route(List<City> cities){
		route = cities;
		Collections.shuffle(route);
	}
	
	public City getCity(int index){
		return route.get(index);
	}
	
	public void setCity(int index, City city){
		route.set(index, city);
	}
	
	public boolean contains(City city){
		return route.contains(city);
	}
	
	public double getTotalDistance(){
		double total = 0;
		for(int i = 0; i < route.size() - 1; i++){
			total = total + route.get(i).distance(route.get(i + 1));
		}
		return total;
	}
	
	public double fitness(){
		return 1/getTotalDistance();
	}
	
	public int getSize(){
		return route.size();
	}
}

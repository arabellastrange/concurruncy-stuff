import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route {

	public List<City> route = new ArrayList<City>();
	
	public Route(List<City> cities){
		route = cities;
		Collections.shuffle(route);
	}
	
	public Route(){
		
	}
	
	public void add(City city){
		route.add(city);
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
			
			City c1 = route.get(i);
			City c2 = route.get(i + 1);
			
			double dist = Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
			
			total = total + dist;
		}
		
		City c1 = route.get(route.size() - 1);
		City c2 = route.get(0);
		
		double dist = Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
		
		total = total + dist;
		
//		for(int i = 0; i < route.size() - 1; i++){
//			total = total + route.get(i).distance(route.get(i + 1));
//		}
		return total;
	}
	
	public double fitness(){
		return 1/getTotalDistance();
	}
	
	public int getSize(){
		return route.size();
	}
	
	public String printRoute(){
		String str = "";
		
		for(City c: route){
			str = str + " " + c.name;
		}
		
		return str;
	}
}

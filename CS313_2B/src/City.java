
public class City {
	
	public int x;
	public int y;
	public String name;
	
	public City(int x, int y,String name){
		this.x = x;
		this.y = y;
		this.name=name;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public double distance(City city){
		int distX = Math.abs(getX() - city.getX());
		int distY = Math.abs(getY() - city.getY());
		
		return (Math.sqrt(distX*distX + distY*distY));
	}
	
	public String getName() {
		return name;
	}
}

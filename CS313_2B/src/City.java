
public class City {
	
	public int x;
	public int y;
	
	public City(int x, int y){
		this.x = x;
		this.y = y;
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
}

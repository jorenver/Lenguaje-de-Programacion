public class Punto {
	private int x;
	private int y
	private Direccion d;
	
	public Punto (int x , int y , Direccion d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Direccion getDireacciion(){
		return d;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public void setDireacciion(Direccion d){
		this.d=d;
	}
}

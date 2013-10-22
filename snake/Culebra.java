public class Culebra{
	private ArrayList<Punto> Puntos;
	
	public Culebra(){
		Puntos = new ArrayList<Punto>;
		for(int i=0;i<5;i++)
			Puntos.add(new Punto(350+3*i,350,DERECHA));
	}
	
	public void crecer(){
		Direccion d;
		int x,y;
		Punto p;
		p=Puntos.get(Puntos.size()-1);
		x=p.getX();
		y=p.getY();
		d=p.getDireccion();
		switch (d){
			case DERECHA:
				x=x-6;
				break;
			case IZQUIERDA:
				x=x+6;
				break;
			case ARRIBA:
				y=y+6;
				break;
			case ABAJO:
				y=y-6;
				break;
		}
		
		Puntos.add(new Punto(x,y,d))
	}
	
	public void mover(){
		Direccion d;
		int x,y;
		Punto p;
		for(Punto p:Puntos){
			d=p.getDireccion();
			switch (d){
				case DERECHA:
					p.setX(p.getX()+3);
					break;
				case IZQUIERDA:
					p.setX(p.getX()-3);
					break;
				case ARRIBA:
					p.setY(p.getY()-3);
					break;
				case ABAJO:
					p.setY(p.getY()+3);
					break;
			}
		}
	}
	
	public void refrescarDirecciones(){
		for(int i = Puntos.size()-1;i>0;i--){
			Direccion d;
			d=Puntos.get(i-1).getDireccion();
			Puntos.get(i).setDireccion(d);
		}
	}
	
	public ArrayList<Punto> getPuntos(){
		return Puntos;
	}
}
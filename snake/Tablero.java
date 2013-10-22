import javax.swing.*;
import java.awt.*;
import java.util.*;

public void Tablero extends JPanel{
	private Culebra culebra;
	private Punto Manzana;
	
	public Tablero(){
		culebra= new Culebra();
	}
	
	public Punto crearManzana(){
		do{
			x=(int)(Math.random()*697)+3;
			y=(int)(Math.random()*697)+3;
		}while(!validarPunto(x,y));
	}
	
	public boolean validarPunto(int x1 , int y1){
		ArrayList<Punto> Puntos;
		int x2,y2;
		Puntos=getPuntos();
		for(Punto p:Puntos){
			x2=p.getX();
			y2=p.getY();
			if(x1<=x2+3 || x1>=x2-3 || y1<=y2+3 || y1>=y2-3)
				return false;
		}
		return true;
	}
}hnb 
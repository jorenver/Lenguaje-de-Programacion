package poo.Buscaminas;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Celda extends JButton implements Observer {
		private Point posicion;
		private boolean mina;
		private int minasCercanas;
		private EstadoCelda estado;
		private CeldaObservable observable;
		private Icon bandera;
				
		public Celda(int x,int y,boolean esMina){
			posicion=new Point(x,y);
			mina=esMina;
			estado=EstadoCelda.CUBIERTO;
			observable=new CeldaObservable();
			ManejadorClick manejador_click=new ManejadorClick();
			addMouseListener(manejador_click);
			addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					descubrir();
				}
			});
		}
				
		private void descubrir(){
			if(estado.equals(EstadoCelda.CUBIERTO)){
				if(mina){
					JOptionPane.showMessageDialog(null,"Piso una mina!! Perdio!!!!");
				//	Icon mina=new ImageIcon(getClass().getResource("minas.png"));
				//	setIcon(mina);
					BuscaminasFrame.deshabilitarCeldas();
				}else {
					if(minasCercanas!=0){
					this.setText(""+minasCercanas);
					estado=EstadoCelda.DESCUBIERTO;
				}else{
					this.setEnabled(false);
					estado=EstadoCelda.DESCUBIERTO;
				}	
			}
				observable.cambioCelda();
				observable.notifyObservers();	
			}
		}
		
		public int getMinasCercanas() {
			return minasCercanas;
		}

		public void setMinasCercanas(int minasCercanas) {
			this.minasCercanas = minasCercanas;
		}

		public EstadoCelda getEstado() {
			return estado;
		}

		public void setEstado(EstadoCelda estado) {
			this.estado = estado;
		}

		public Point getPosicion() {
			return posicion;
		}

		public boolean isMina() {
			return mina;
		}

		public void setMina(boolean mina) {
			this.mina = mina;
		}

		@Override
		public void update(Observable ob, Object arg1) {
			if(!isMina()){
				descubrir();
			}
		}
		
		public CeldaObservable getObservable() {
			return observable;
		}

		class CeldaObservable extends Observable{
			void cambioCelda(){
				setChanged();
			}
		}
		
		class ManejadorClick extends MouseAdapter{
			public void mouseClicked(MouseEvent evento) {
			if(estado.equals(EstadoCelda.CUBIERTO)){
				if(evento.isMetaDown()){
					bandera= new ImageIcon(getClass().getResource("bandera.png"));
					setIcon(bandera);
					estado=EstadoCelda.DESCUBIERTO;
					BuscaminasFrame.n_celdas--;
					BuscaminasFrame.n_banderas++;
				}
			}
			}
		}
		
}
	
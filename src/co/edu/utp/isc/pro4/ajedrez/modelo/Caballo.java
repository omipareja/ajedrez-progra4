/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JOptionPane;

/**
 *
 * @author utp
 */
public class Caballo extends Ficha {

    public Caballo(Color color) {
        super(color);
    }

    @Override
    public boolean mover(Tablero tablero,Casilla casillaI, Casilla casillaF) {
        
     boolean ocupada = false;
            int cI,cF,fI,fF;
            boolean efectivo = false;
            cI = casillaI.getColumna() - 'A';//x Inicial
            fI = casillaI.getFila() - 1;//y Inicial
            cF = casillaF.getColumna() - 'A';//x Final 
            fF = casillaF.getFila() - 1 ;//y Final
 
            if((fI-fF)*(fI-fF) +(cI-cF)*(cI-cF) == 5){
                
                if(!casillaF.isOcupada()){
                
                casillaI.setFichaNull();
                super.asociarFichaTablero(this, casillaF);
                  efectivo = true;
                
                }
                
                else {
                    
                if((this.getColor() != casillaF.getFicha().getColor())){
                      if(casillaF.getFicha() instanceof Rey){
                                JOptionPane.showMessageDialog(null, "Fin Del Juego");
                            }    
                    this.comer(casillaI,casillaF);
                    efectivo = true;
                }
                else {
                    //System.out.println("Son del mismo color");
                     JOptionPane.showMessageDialog(null,"Son del mismo color");
                }
                }
                
                
            }
            else{
              //  System.out.println("De esa forma no se mueve el caballo");
                JOptionPane.showMessageDialog(null,"De esa forma no se mueve el caballo");
                
            }
            return efectivo;
        
    }

    
   
        @Override
    public void haceJaque(Tablero tablero){
            int cI, fI, cF, fF;
            cI = this.getCasilla().getColumna() - 'A';
            fI = this.getCasilla().getFila() - 1;
            Casilla casillaC;
            Ficha rey;
            rey = this;
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    casillaC = tablero.getCasilla(i,j);
                    if(casillaC.getFicha() instanceof Rey && casillaC.getFicha().getColor() != this.getColor()){
                        rey = casillaC.getFicha();
                    }
                }
            }
            cF = rey.getCasilla().getColumna() - 'A';
            fF = rey.getCasilla().getFila() - 1;
            if((fI-fF)*(fI-fF) + (cI-cF)*(cI-cF) == 5){
                this.setJaque(true);
            }
    }


    @Override
   public void draw(Graphics2D g, float x, float y) { 
        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 50, y + 50,
                java.awt.Color.WHITE));
    //Base de ficha
      g.fill(new Rectangle2D.Double(x+10,y+40,30,10));
      //Cuerpo de ficha
      g.fill(new Rectangle2D.Double(x+20,y+30,10,10));
      //Cabeza ficha
      GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 20, y + 30);
        polyline.lineTo(x + 15, y + 25);
        polyline.lineTo(x + 20, y + 15);
        polyline.lineTo(x + 15, y + 10);
        polyline.lineTo(x + 20, y + 5);
        polyline.lineTo(x + 25, y + 10);
        polyline.lineTo(x + 30, y + 5);
        polyline.lineTo(x + 35, y + 10);
        polyline.lineTo(x + 30, y + 15);
        polyline.lineTo(x + 30, y + 30);
        polyline.moveTo(x + 20, y + 30);
        g.fill(polyline);
    //Cambiar color para margen
    g.setPaint(java.awt.Color.BLACK);
    //Base de ficha
    g.draw(new Rectangle2D.Double(x+10,y+40,30,10));
    //Cuerpo de ficha
    g.draw(new Rectangle2D.Double(x+20,y+30,10,10));
    //Cabeza ficha
    polyline.moveTo(x + 20, y + 30);
        polyline.lineTo(x + 15, y + 25);
        polyline.lineTo(x + 20, y + 15);
        polyline.lineTo(x + 15, y + 10);
        polyline.lineTo(x + 20, y + 5);
        polyline.lineTo(x + 25, y + 10);
        polyline.lineTo(x + 30, y + 5);
        polyline.lineTo(x + 35, y + 10);
        polyline.lineTo(x + 30, y + 15);
        polyline.lineTo(x + 30, y + 30);
        polyline.moveTo(x + 20, y + 30);
        g.draw(polyline);
    }
}

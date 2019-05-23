/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import execepciones.MovimientoNoValidoException;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JOptionPane;

/**
 *
 * @author utp
 */
public class Torre extends Ficha {

    public Torre(Color color) {
        super(color);
    }

    @Override
      public void mover(Tablero tablero,Casilla casillaI, Casilla casillaF) throws MovimientoNoValidoException {
            boolean ocupada = false;
            int cI,cF,fI,fF;
            cI = casillaI.getColumna() - 'A';//x Inicial
            fI = casillaI.getFila() - 1;//y Inicial
            cF = casillaF.getColumna() - 'A';//x Final 
            fF = casillaF.getFila() - 1 ;//y Final
            Casilla casillaC;
            casillaC = casillaI;
            if(fI==fF || cI==cF){
                if (casillaF.getColumna() > casillaI.getColumna()){
                    cI = cI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna()){
                    cI = cI - 1;
                }
                else if(casillaF.getFila() < casillaI.getFila()){
                    fI = fI - 1;
                }
                else if(casillaF.getFila() > casillaI.getFila()){
                    fI = fI + 1;
                }
                 casillaC = tablero.getCasilla(fI,cI);
                if(cI != cF || fI != fF){
                    ocupada = casillaC.isOcupada();
                }
                while((cI != cF || fI != fF) && ocupada==false){
                    casillaC = tablero.getCasilla(fI,cI);
                    ocupada=casillaC.isOcupada();
                   
                    
                    
                    if (casillaF.getColumna() > casillaI.getColumna()){
                    cI = cI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna()){
                    cI = cI - 1;
                }
                else if(casillaF.getFila() < casillaI.getFila()){
                    fI = fI - 1;
                }
                else if(casillaF.getFila() > casillaI.getFila()){
                    fI = fI + 1;
                }
                    
                   
                }
               
                
                
                  if(!casillaF.isOcupada()){//Que en la casilla final no haya nada    TIPO 1 (MOVIMIENTO NORMAL)
                    if(!ocupada){//Si no hay nada en la trayectoria
                        casillaI.setFichaNull();
                        super.asociarFichaTablero(this, casillaF);
                    }
                    else{
                      //  System.out.println("Hay una ficha en la trayectoria");
                        JOptionPane.showMessageDialog(null,"Hay una ficha en la trayectoria");
                    }
                }
                else{//Que en la casilla final haya una ficha                       TIPO 2 (COMER)
                   if(this.getColor() != casillaF.getFicha().getColor()){//Si la fichaI y la fichaF son de diferente color
                        if(!ocupada){
                            this.comer(casillaI,casillaF);
                        }
                        else{
                            //System.out.println("Hay una ficha en trayectoria");
                            JOptionPane.showMessageDialog(null,"Hay una ficha en trayectoria");
                        }
                   }
                   else{
                       //System.out.println("Ambas fichas son del mismo color");
                       JOptionPane.showMessageDialog(null,"Ambas fichas son del mismo color");
                   }
                }    
            }
            else{
               // System.out.println("De esa forma no se mueve la Torre");
                JOptionPane.showMessageDialog(null,"De esa forma no se mueve la Torre");
            }
        }

 

    public void draw(Graphics2D g, float x, float y) {
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 5, y + 5);
        polyline.lineTo(x + 5, y + 15);
        polyline.lineTo(x + 10, y + 15);
        polyline.lineTo(x + 10, y + 45);
        polyline.lineTo(x + 40, y + 45);
        polyline.lineTo(x + 40, y + 15);
        polyline.lineTo(x + 45, y + 15);
        polyline.lineTo(x + 45, y + 5);
        polyline.lineTo(x + 37, y + 5);
        polyline.lineTo(x + 37, y + 10);
        polyline.lineTo(x + 29, y + 10);
        polyline.lineTo(x + 29, y + 5);
        polyline.lineTo(x + 21, y + 5);
        polyline.lineTo(x + 21, y + 10);
        polyline.lineTo(x + 13, y + 10);
        polyline.lineTo(x + 13, y + 5);
        polyline.lineTo(x + 5, y + 5);

        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 100, y + 50,
                java.awt.Color.WHITE));
        g.fill(polyline);

        g.setColor(java.awt.Color.BLACK);
        g.draw(polyline);
    }

}

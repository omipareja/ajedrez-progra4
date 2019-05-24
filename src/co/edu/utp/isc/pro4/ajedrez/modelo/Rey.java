/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JOptionPane;

/**
 *
 * @author utp
 */
public class Rey extends Ficha {

    public Rey(Color color) {
        super(color);
    }

    @Override
    public boolean mover(Tablero tablero,Casilla casillaI, Casilla casillaF) {
        boolean ocupada = false ,  efectivo = false;
            int cI,cF,fI,fF,restaF,restaC;
            cI = casillaI.getColumna() - 'A';//columna Inicial
            fI = casillaI.getFila() - 1;//fila Inicial
            cF = casillaF.getColumna() - 'A';//columna Final 
            fF = casillaF.getFila() - 1 ;//fila Final
            Casilla casillaC;
            casillaC = casillaI;
            restaF= fI-fF;
            restaC= cI-cF;
            //(Math.abs(f1-f2)<=1& (Math.abs(c1-c2) <=1)
            if((Math.abs(restaF))<=1 & (Math.abs(restaC))<=1 ){
                
                     // se le asemeja el movimiento del alfil
                
                 if (casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI - 1;
                }
                else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI - 1;
                }
               
                
                
                // condicion del movimiento de la torre
                
                
                else if (casillaF.getColumna() > casillaI.getColumna()){
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
                   
                    
                   if (casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI - 1;
                }
                else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI - 1;
                }
               
                
                
                // condicion del movimiento de la torre
                
                
                else if (casillaF.getColumna() > casillaI.getColumna()){
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
                        efectivo=true;
                    }
                    else{
                      //  System.out.println("Hay una ficha en la trayectoria");
                        JOptionPane.showMessageDialog(null,"Hay una ficha en la trayectoria");
                    }
                }
                else{//Que en la casilla final haya una ficha                       TIPO 2 (COMER)
                   if(this.getColor() != casillaF.getFicha().getColor()){//Si la fichaI y la fichaF son de diferente color
                        if(!ocupada){
                              if(casillaF.getFicha() instanceof Rey){
                                JOptionPane.showMessageDialog(null, "Fin Del Juego");
                            }
                            this.comer(casillaI,casillaF);
                             efectivo=true;
                        }
                        else{
                           // System.out.println("Hay una ficha en trayectoria");
                            JOptionPane.showMessageDialog(null,"Hay una ficha en la trayectoria");
                        }
                   }
                   else{
                      // System.out.println("Ambas fichas son del mismo color");
                        JOptionPane.showMessageDialog(null,"Ambas fichas son del mismo color");
                   }
                }
                
                
                
                
                
                
                
            }
            
            else{
                System.out.println("De esa forma no se mueve el Rey");
            }


        return efectivo;
        
        }
    
    @Override
    public void draw(Graphics2D g, float x, float y) {
        //TODO Dibujar la figura
             g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 50, y + 50,
                java.awt.Color.WHITE));
        //Base de ficha
        g.fill(new Rectangle2D.Double(x+10,y+40,30,15));
        //Cuerpo de ficha
        g.fill(new Rectangle2D.Double(x+20,y+25,10,15));
        
        //Cabeza ficha triangulo(2 lineas)
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 15, y + 25);
        polyline.lineTo(x + 25, y + 15);
        polyline.lineTo(x + 35, y + 25);
        polyline.moveTo(x + 15, y + 25);
        g.fill(polyline);
        //Cruz
        g.fill(new Rectangle2D.Float(x+24,y+3, 3,13 ));
        g.fill(new Rectangle2D.Float(x+18,y+8, 15,2 ));
        
        g.setPaint(java.awt.Color.BLACK);
        //Base de ficha
        g.draw(new Rectangle2D.Double(x+10,y+40,30,10));
        //Cuerpo de ficha
        g.draw(new Rectangle2D.Double(x+20,y+25,10,15));
        //Cabeza ficha triangulo(2 lineas)
        g.draw(new Line2D.Double(x+15,y+25,x+25,y+15));
        g.draw(new Line2D.Double(x+25,y+25,x+25,y+25));
        //cruz
        g.draw(new Rectangle2D.Float(x+24,y+3, 3,13 ));
        g.draw(new Rectangle2D.Float(x+18,y+8, 15,2 ));
        
        
        
  
        
    }
    

      
    }
    



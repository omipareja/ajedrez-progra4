/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author utp
 */
public class Peon extends Ficha {

    public Peon(Color color) {
        super(color);
    }

    @Override
    public void mover(Tablero tablero,Casilla casillaI, Casilla casillaF) {
        //TODO: Mover como peon
        
        boolean ocupada = false;
            int cI,cF,fI,fF, restaA, restaB;
            cI = casillaI.getColumna() - 'A';//x Inicial
            fI = casillaI.getFila() - 1;//y Inicial
            cF = casillaF.getColumna() - 'A';//x Final 
            fF = casillaF.getFila() - 1 ;//y Final
            restaA = fF - fI;
            Casilla casillaC;

            if(Math.abs(restaA) == 1 ||Math.abs(restaA) == 2){
                if(restaA == 2 && casillaI.getFicha().getColor() == Color.BLANCO && fI == 1){
                    fI = fI + 1;
                }
                else if(restaA == -2 && casillaI.getFicha().getColor() == Color.NEGRO && fI == 6){
                    fI = fI - 1;
                }
                casillaC = tablero.getCasilla(fI,cI);
                ocupada = casillaC.isOcupada();
                System.out.println(ocupada);
                System.out.println("restaA: "+ restaA);
                if(!ocupada || Math.abs(restaA) == 1){
                    if(!casillaF.isOcupada()){//Movimiento normal
                        if(this.getColor() == Color.NEGRO && (restaA == 1 || (restaA == 2 && fI == 6)) ){
                            casillaI.setFichaNull();
                            super.asociarFichaTablero(this, casillaF);
                            System.out.println("Entro");
                        }
                        else if(this.getColor() == Color.BLANCO && (restaA == -1 || restaA == -2) && fI == 1){
                            casillaI.setFichaNull();
                            super.asociarFichaTablero(this, casillaF);
                        }
                    }
                    else if(casillaI.getFicha().getColor() == casillaF.getFicha().getColor()){//Si la ficha inicial es del mismo color que la final no es valido
                        System.out.println("Ambas fichas son del mismo color");
                    }   
                    else if(casillaI.getFicha().getColor() != casillaF.getFicha().getColor()){
                        if(Math.abs(restaB) == 1){
                            if(casillaI.getFicha().getColor() == Color.BLANCO && restaA == 1){
                                this.comer(casillaI, casillaF);   
                            }
                            else if(casillaI.getFicha().getColor() == Color.NEGRO && restaA == -1){
                                this.comer(casillaI, casillaF);
                            }    
                        }
                    }
                }
                else if(ocupada){//Movimiento no valido por elemento en la trayectoria
                    System.out.println("Movimiento no valido por ficha en trayectoria");
                }
            }
            else{
               System.out.println ("De esa forma no se mueve el peon");
            }
    }

   

    @Override
    public void draw(Graphics2D g, float x, float y) {
        // 50x50 dibujar la ficha
        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 50, y + 50,
                java.awt.Color.WHITE));
        g.fill(new Ellipse2D.Float(x + 17, y + 15, 16, 16));
        g.fill(new Rectangle2D.Float(x + 15, y + 30, 20, 15));
        g.setPaint(java.awt.Color.BLACK);
        g.draw(new Ellipse2D.Float(x + 17, y + 15, 16, 16));
        g.draw(new Rectangle2D.Float(x + 15, y + 30, 20, 15));
    }
}

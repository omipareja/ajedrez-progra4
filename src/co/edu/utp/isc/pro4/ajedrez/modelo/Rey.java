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

/**
 *
 * @author utp
 */
public class Rey extends Ficha {

    public Rey(Color color) {
        super(color);
    }

    @Override
    public void mover(Tablero tablero,Casilla casillaI, Casilla casillaF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    



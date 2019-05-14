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
import java.awt.geom.Rectangle2D;

/**
 *
 * @author utp
 */
public class Alfil extends Ficha {

    public Alfil(Color color) {
        super(color);
    }

    @Override
    public void mover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void comer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
     @Override
    public void draw(Graphics2D g, float x, float y) {
        // 50x50 dibujar la ficha
        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 50, y + 50,
                java.awt.Color.WHITE));
        g.fill(new Rectangle2D.Float(x + 17, y + 10, 10, 10));
        g.fill(new Rectangle2D.Float(x + 20, y + 21, 5, 20));
        g.fill(new Rectangle2D.Float(x + 13, y + 40, 20, 5));
        g.setPaint(java.awt.Color.BLACK);
        g.draw(new Rectangle2D.Float(x + 17, y + 10, 10, 10));
        g.draw(new Rectangle2D.Float(x + 20, y + 21, 5, 20));
        g.draw(new Rectangle2D.Float(x + 13, y + 40, 20, 5));
    }
    
}

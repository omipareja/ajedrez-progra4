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
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author utp
 */
public class Reina extends Ficha {

    public Reina(Color color) {
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
        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 50, y + 50,
                java.awt.Color.WHITE));
        //Base de ficha
        g.fill(new Rectangle2D.Double(x+10,y+40,30,10));
        //Cuerpo de ficha
        g.fill(new Rectangle2D.Double(x+20,y+30,10,10));
        //Cabeza ficha triangulo(2 lineas)
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 15, y + 30);
        polyline.lineTo(x + 25, y + 20);
        polyline.lineTo(x + 35, y + 30);
        polyline.moveTo(x + 15, y + 30);
        g.fill(polyline);
        //Circulo cabeza
        g.fill(new Ellipse2D.Double(x+20, y+10, 10, 10));
        g.setPaint(java.awt.Color.BLACK);
        //Base de ficha
        g.draw(new Rectangle2D.Double(x+10,y+40,30,10));
        //Cuerpo de ficha
        g.draw(new Rectangle2D.Double(x+20,y+30,10,10));
        //Cabeza ficha triangulo(2 lineas)
        g.draw(new Line2D.Double(x+15,y+30,x+25,y+20));
        g.draw(new Line2D.Double(x+25,y+20,x+35,y+30));
        //Circulo cabeza
        g.draw(new Ellipse2D.Double(x+20, y+10, 10, 10));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1ex1;

import java.lang.Math ;

/**
 *
 * @author Julien
 */

public class Point {
    
    //ajoute les propriétés des points
    private double lat;
    private double lon;
    private double ecart_t;
    private double alt;
    
    //constructeur
    public Point(double lat, double lon, double ecart_t, double alt) {
        this.lat = lat;
        this.lon = lon;
        this.ecart_t = ecart_t;
        this.alt = alt;
    }
    
    //GETTERS
    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getEcart_t() {
        return ecart_t;
    }

    public double getAlt() {
        return alt;
    }
    
    //méthode toString
    @Override
    public String toString() {
        return "Point{" + "lat=" + lat + ", lon=" + lon + ", ecart_t=" + ecart_t + ", alt=" + alt + '}';
    }
    
    //calcule de la distance en utilisant une formule sur les latitudes et longitudes des points
    public double distance(Point p){
        double R = 6347000 ;
        double conv = Math.PI/30 ;
        double a = conv * this.getLat();
        double b = conv * this.getLon();
        double c = conv * p.getLat();
        double d = conv * p.getLon();
        double D = R * Math.acos( Math.sin(a)*Math.sin(b)+Math.cos(a)*Math.cos(b)*Math.cos(c-d));
        return D ;
    }
}
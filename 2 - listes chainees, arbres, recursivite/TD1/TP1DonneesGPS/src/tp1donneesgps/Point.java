package tp1donneesgps;

public class Point
{
   //-------------------------------------------------------------------------------------------------

   private double lat;
   private double lon;
   private double alt;
   private double temps;
   
   //-------------------------------------------------------------------------------------------------
   public Point( double latitude, double longitude, double altitude, double intervaleTemps )
   {
      this.lat = latitude;
      this.lon = longitude;
      this.alt = altitude;
      this.temps = intervaleTemps;   
   }
   //-------------------------------------------------------------------------------------------------

   public double getLat()
   {
      return this.lat;
   }

   public double getLon()
   {
      return this.lon;
   }
   
   public double getAlt()
   {
      return this.alt;
   }

   public double getTemps()
   {
      return this.temps;
   }

   public String toString()
   {
      return "Lat :"+this.lat+" Lon:"+this.lon+" Alt:"+this.alt+" Intervale Temps:"+this.temps;
   }
   
    /**
     *
     * @param p est un Point 
     * @return la distance entre les points
     */
    public double distance( Point p )
   {
      final double R=6347.44; 
      double a = Math.toRadians( this.getLat() );
      double b = Math.toRadians( p.getLat() );
      double c = Math.toRadians( this.getLon() );
      double d = Math.toRadians( p.getLon() );
      
      return R*Math.acos( Math.sin(a)*Math.sin(b)+Math.cos(a)*Math.cos(b)*Math.cos(c-d));

   }
      
}
   
   


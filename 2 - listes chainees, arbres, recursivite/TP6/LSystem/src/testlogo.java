import java.awt.*;
import java.lang.reflect.Method;


public class testlogo
{

   public static void main( String [] args )
   {
      Logo l = new Logo( 500, 100, 0, Color.red, Logo.PEN_DOWN,100 );
   
      l.av();
      l.memo();   /* branche1*/
      l.rotG(45);
      l.av();   
      l.recupMemo(); 
     
      l.memo();   /* branche2*/
      l.rotD(45);
      l.av();    
      l.recupMemo();
        
      }
   
 }
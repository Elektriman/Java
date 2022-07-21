//imports

import java.awt.Color; //for the use of colors
import java.io.File ; //for files manipulations
import java.awt.image.BufferedImage ; //for image manipulation as arrays of pixels
import java.io.IOException; //potential errors durint image import
import javax.imageio.ImageIO; //for importing the image

/**
 *
 * @author Julien
 */
public class ImageReader {
    
    private String path = ""; //where the image document is. *is an absolute path*
    private File f ;
    private BufferedImage buffer ; //original image
    private BufferedImage grayscale ; //grayscale of the image
    private BufferedImage BlackNWhite ; //image in Black and White
    
    private String translation = "" ; //string that represents the image with black and white squares
    
    //CONSTRUCTOR
    public ImageReader(String path){
        this.path = path ;
        this.f = new File(path) ;
        this.buffer = null ;
        
        try {
            this.buffer = ImageIO.read(this.f);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    //Black and White image getter
    public BufferedImage getBNW(){
        return this.BlackNWhite ;
    }
    
    /**
     * this method crops the image and keeps the biggest centered square possible
     */
    public void toSquare(){
        //width and height of the original image
        int width = this.buffer.getWidth();
        int height = this.buffer.getHeight();
        
        if(height>width){ //higher than wider ?
            int delta = height-width ; //difference between the two sizes
            this.buffer = this.buffer.getSubimage(0, (int) delta/2 , width, width); //change the image to sub image of square shape
        } else if(height<width){ //higher than wider ?
            int delta = width-height ; //difference between the two sizes
            this.buffer = this.buffer.getSubimage((int) delta/2, 0, height, height); //change the image to sub image of square shape
        }
    }
    
    /**
     * this method generates the grayscale image
     */
    public void GrayScale(){
        BufferedImage img = this.buffer ; //rename image for practical purposes
        BufferedImage grayscale = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB); //new image
        
        //go across all pixels
        for(int i=0; i<img.getWidth(); i++){
            for(int j=0; j<img.getHeight(); j++){
                Color c = new Color(img.getRGB(j,i)); //get current image pixel's color
                int gr = (int) (c.getRed()+c.getGreen()+c.getBlue())/3 ; //the gray value is the mean of the 3 colour componants
                Color gColor = new Color(gr, gr, gr); //new gray colour
                grayscale.setRGB(j, i, gColor.getRGB()); //set the color to the new image
            }
        }
        this.grayscale = grayscale ; //set the created image to the corresponding attribute
    }
    
    /**
     * this method generates the Black and White image
     */
    public void BlackNWhite(){
        BufferedImage gray = this.grayscale ; //rename image for practical purposes
        BufferedImage bnw = new BufferedImage(gray.getWidth(), gray.getHeight(), BufferedImage.TYPE_INT_RGB); //new image
        
        //go across all pixels
        for(int i=0; i<gray.getWidth(); i++){
            for(int j=0; j<gray.getHeight(); j++){
                Color c = new Color(gray.getRGB(j,i)); //get current image pixel's color
                
                int bw = 0; //black is 0, white is 255
                if(c.getRed()>104){ //threshold to change if the B&W image is bad
                    bw = 255 ;
                }
                Color bwColor = new Color(bw, bw, bw); //new color either black or white
                bnw.setRGB(j, i, bwColor.getRGB()); //set the new color to the new image
            }
        }
        this.BlackNWhite = bnw ; //set the created image to the corrseponding attribute
    }
    
    /**
     * this method initialises the attributes buffer, grayscale and BlackNWhite for further use of the 'translation' method
     */
    public void initialiseTranslation(){
        toSquare();
        GrayScale();
        BlackNWhite();
    }
    
    /**
     * recursive method that transforms any black and whie image in its corresponding string for later use in the main program
     * @param img
     * @return String
     */
    public String translate(BufferedImage img){
        
        // first step : we need to verify if the square has only one colour
        //(we use a while loop with flags to eliminate useless computations)
        
        boolean allblack = true ; //if the whole rectangle is black
        boolean allwhite = true ; //if the whole rectangle is black
        boolean flag = true ; //if we reached the end
        int i=0 ; //lines
        int j=-1 ; //columns
        
        while((allblack || allwhite)  && flag){ //if the rectangle is either black or white and we didn't reached the end yet
            
            if(j<img.getWidth()-1){
                //increment j
                j++ ;
            } else if(i<img.getHeight()-1){
                //increment i and the end of line and reset j
                j=0 ;
                i++ ;
            } else {
                //case where we reached the end
                flag = false ;
            }
            
            Color c = new Color(img.getRGB(j,i)); //get the pixel's color
            if(c.getRed()==255){ //if the pixel is white
                allblack = false ; //all the square isn't black
            }
            if(c.getRed()==0){ //if the pixel is black
                allwhite = false ; //all the square isn't white
            }
        }
        
        //second step : return the appropriate string
        
        if(allblack){ //we have a black square
            return "N" ;
        } else if (allwhite){ //we have a white square
            return "B" ;
        } else { //the square isn't black nor white
            //(a,b) is the center of the square
            int a = (int) img.getWidth()/2 ;
            int b = (int) img.getHeight()/2 ;
            //we compute the strings of all subsquares
            String I1 = translate(img.getSubimage(0, 0, a, b));
            String I2 = translate(img.getSubimage(a, 0, a, b));
            String I3 = translate(img.getSubimage(0, b, a, b));
            String I4 = translate(img.getSubimage(a, b, a, b));
            //we concatenate them into brackets and return the result
            return String.format("(%s%s%s%s)",I1,I2,I3,I4);
        }
    }
}

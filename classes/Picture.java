import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }

  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int avg = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()) / 3;
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
        pixelObj.setRed(avg);
      }
    }
  }

  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }

  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        if (pixelObj.getRed() + pixelObj.getGreen() > pixelObj.getBlue() * 1.1) {
          pixelObj.setBlue(pixelObj.getBlue() / 8);
        }
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel, rightPixel;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    for (int i = 0; i < pixels.length / 2; i ++) {
      for (int j = 0; j < pixels[i].length; j ++) {
        Pixel end = pixels[pixels.length - (i + 1)][j];
        Pixel begin = pixels[i][j];
        end.setColor(begin.getColor());
      }
    }
  }

  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    for (int i = 0; i < pixels.length / 2; i ++) {
      for (int j = 0; j < pixels[i].length; j ++) {
        Pixel end = pixels[pixels.length - (i + 1)][j];
        Pixel begin = pixels[i][j];
        begin.setColor(end.getColor());
      }
    }
  }

  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel, rightPixel;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < row + 1; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[col][row];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorArms(int rowLower, int columnLower, int columnUpper, int mirrorPointHorizontal) {
    Pixel[][] pixels = this.getPixels2D();
    // The mirror point would take the role of the row upper limit
    for (int i = rowLower; i < mirrorPointHorizontal; i ++) {
      for (int j = columnLower; j < columnUpper; j ++) {
        pixels[mirrorPointHorizontal - (i + 1) + rowLower][j].setColor(pixels[i][j].getColor());
      }
    }
  }

  public void mirrorGull() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel, rightPixel;
    int width = 455 - 232;
    for (int row = 230; row < 334; row++) {
      for (int col = 232; col < 232 + width / 2; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][232 + width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count ++;
      }
    }
    System.out.println("The number of loops is " + count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** copy from the passed fromPic to the
   * specified startRow and startCol and
   * endRow and endCol in the current picture
   * @param fromPic the picture to copy from
   * @param startRowFrom the start row to copy from
   * @param endRowFrom the end row to copy from
   * @param startColFrom the start col to copy from
   * @param endColFrom the start col to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   */
  public void copy(Picture fromPic,
                   int startRowFrom, int endRowFrom,
                   int startColFrom, int endColFrom,
                   int startRow, int startCol) {
    Pixel fromPixel, toPixel;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = startRowFrom, toRow = startRow;
         fromRow < endRowFrom &&
                 toRow < toPixels.length;
         fromRow++, toRow++)
    {
      for (int fromCol = startColFrom, toCol = startCol;
           fromCol < endColFrom &&
                   toCol < toPixels[0].length;
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void myCollage() {
    Picture coolBeans = new Picture("coolBeans.jpg");
    Picture coolBeansNoBlue = new Picture(coolBeans);
    coolBeansNoBlue.zeroBlue();
    this.copy(coolBeansNoBlue,  294, 511, 685, 873, 0,0);
    Picture coolBeansGrayScale = new Picture(coolBeans);
    coolBeansGrayScale.grayscale();
    this.copy(coolBeansGrayScale,  300, 540, 1000, 1150, 90,100);
    Picture coolBeansNegate = new Picture(coolBeans);
    coolBeansNegate.negate();
    this.copy(coolBeansNegate,  15, 160, 645, 820, 300,150);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist) {
    Pixel leftPixel, rightPixel, bottomPixel;
    Picture copy = new Picture(this);
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixelsCopy = copy.getPixels2D();
    Color rightColor, bottomColor;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length - 1; col++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col + 1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for (int row = 0; row < pixelsCopy.length - 1; row++) {
      for (int col = 0; col < pixelsCopy[0].length; col++) {
        leftPixel = pixelsCopy[row][col];
        bottomPixel = pixelsCopy[row + 1][col];
        bottomColor = bottomPixel.getColor();
        if (leftPixel.colorDistance(bottomColor) >
                edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        if (pixelsCopy[row][col].getColor().equals(Color.BLACK)) {
          pixels[row][col].setColor(Color.BLACK);
        }
      }
    }
  }

  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this

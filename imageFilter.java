import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String fileName) {
    super(fileName);
  }


  /*
  *Add random white spots in the picture to look like stars 
  */
  public void stars(int amountStars){

    Pixel[][] pixels = getPixelsFromImage();
    int randomRow = 0;
    int randomCol = 0;
for (int i = 0; i < amountStars; i++){
  randomRow = (int)(Math.random()*399);
  randomCol = (int)(Math.random()*399);
Pixel currentPixel = pixels[randomRow][randomCol];
  currentPixel.setRed(255);
  currentPixel.setBlue(255);
  currentPixel.setGreen(255);
  
}
 
      }
/*
   * Inverts the colors in the image by setting the red,
   * green, and blue color values of each Pixel object to
   * the result of 255 minus their current values
   */
  public void makeNegative() {

    // Turns pixel into 2D array
    Pixel[][] pixels = getPixelsFromImage();

    //Traverse the 2D array of pixels
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
       
        // Access the Pixel object at the current row and column position.
        Pixel currentPixel = pixels[row][col];

         // gets the color values of current pixel and creates a variable for each value
         // These values range from 0 to 255, representing the intensity of each color.
        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

         // This code subtracts 255 brightness from the current colors to convert the dark areas to light. And light areas to dark
        currentPixel.setRed(255 - currentRed);
        currentPixel.setGreen(255 - currentGreen);
         currentPixel.setBlue(255 - currentBlue);
      }
     }


   
  }
 /*
   * Applies a pixelate filter to each Pixel object by dividing the image into a grid
   * of equal-sized rectangular regions and setting the color of each Pixel object in
   * a region to the color of the first Pixel object in the region
   */
  public void pixelateImage(int gridSize) {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row += gridSize) {
      for (int col = 0; col < pixels[0].length; col += gridSize) {
        int endRow = Math.min(row + gridSize, pixels.length);
        int endCol = Math.min(col + gridSize, pixels[0].length);
        int avgRed = 0;
        int avgGreen = 0;
        int avgBlue = 0;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            avgRed += pixels[regionRow][regionCol].getRed();
            avgGreen += pixels[regionRow][regionCol].getGreen();
            avgBlue += pixels[regionRow][regionCol].getBlue();
          }
        }

        int totalPixelsInRegion = (endRow - row) * (endCol - col);
        avgRed /= totalPixelsInRegion;
        avgGreen /= totalPixelsInRegion;
        avgBlue /= totalPixelsInRegion;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            pixels[regionRow][regionCol].setRed(avgRed);
            pixels[regionRow][regionCol].setGreen(avgGreen);
            pixels[regionRow][regionCol].setBlue(avgBlue);
          }
        }
      }
    }
    
  }

 
  /*
   * Applies a colorize filter by converting each Pixel to grayscale and applying
   * a color to it based on its grayscale value
   */
  public void colorizeImage() {
 Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        int currentRed= currentPixel.getRed();
int currentGreen=currentPixel.getGreen();
int currentBlue=currentPixel.getBlue();
        int averageColor =  ((currentRed+currentGreen+currentBlue)/ 3);
        if(averageColor<85){
         currentPixel.setRed(255);
           currentPixel.setGreen(0);
           currentPixel.setBlue(0);
        }else if(averageColor<170){
           currentPixel.setRed(0);
           currentPixel.setGreen(255);
           currentPixel.setBlue(0);
        }else if(averageColor> 170){
          currentPixel.setRed(0);
           currentPixel.setGreen(0);
           currentPixel.setBlue(255);
        }

  }
    }
}

/*
*Keeps only a specific color by changing ever other color value to 0 besides the one that we want to keep
*/
public void KeepColor(String color){
 // Get the 2d Array of pixel
  Pixel[][] pixels = getImagePixels();
  //Traverse
for(int row = 0; row< pixels.length; row++){
for(int col = 0; col< pixels[0].length; col++){
  //get current pixel
Pixel currentPixel = pixels[row][col];
if(color.equals("red")){
  currentPixel.setBlue(0);
  currentPixel.setGreen(0); 
}else if(color.equals("blue")){
  currentPixel.setRed(0);
  currentPixel.setGreen(0); 
}else if(color.equals("green")){
  currentPixel.setRed(0);
  currentPixel.setBlue(0); 
  
}
  
}
}
} 


  
}
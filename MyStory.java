import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Instance Variables
  private String[][] characters;
  private String[][] captions;
  
  // Constructor
  public MyStory(String[][] characters, String[][] captions) {
    this.characters = characters;
    this.captions = captions;
  }

  // Calls all the parts of your animation, in order
  public void drawScene() {
    openingCrawl();
    drawTatooine();
    drawHanSoloScene();
    drawDeathStarScene();
    finalbattle();
    ceremony();
  }
/*
*the opening crawl
*/
  public void openingCrawl() {
    clear("black");
     drawImage("starwar.png", 100, 50, 200);
    // Draw the captions
    int captx = 150;
    int captY = 150; 
    for (int row = 0; row < captions.length; row++) {
        for (int col = 0; col < captions[row].length; col++) {
            String currentCaption = captions[row][col];
            setTextHeight(30);
            setTextColor("yellow");
            drawText(currentCaption, captx, captY);
            captY += 75;
          captx -= 50;
            pause(0.2);
        }
      //add stars filter
            pause(1.0);
      ImageFilter logo = new ImageFilter("Logo.png"); 
      logo.stars(1000);
      drawImage(logo, 0, 0, 400);
            pause(1.0);
     
      break;
    }
  }
/*
*the tatooine scene and like the droids
*/
public void drawTatooine() {
    // Create the background
    clear("yellow");
    drawImage("6543e8e057ea4a85ba3586ce00e42b98.jpg", 0, 180, 400);
    drawImage("tatooine.jpg", 0, 100, 400);

    // Draw the characters
  
    int charX = 10;
    int charY = 350;
   for (int row = 0; row < characters.length; row++) {
     for (int col = 0; col < characters[0].length; col++) {
      String currentChar = characters[0][col];
      setTextHeight(10);
       setTextColor("black");
       if(! currentChar.equals("null")){
    drawText(currentChar, charX, charY, 0);
    drawImage(makePngs(currentChar), charX, 200, 100);
    charX += 100;
    charY += 10;
        pause(0.2);
       }
    }
     break;
   }

    // Draw the captions
    int captX = 10;  
    int captY = 200; 
    for (int row = 1; row < captions.length; row++) {
        for (int col = 0; col < captions[row].length; col++) {
            String currentCaption = captions[row][col];
            setTextHeight(20);
            setTextColor("teal");
          if(col ==0){
            drawText(addExclamation(currentCaption), captX, captY, -9);
            captY -= 50; 
            captX += 75; 
            pause(0.2);
          }else{
            drawText(currentCaption, captX, captY, -9);
            captY -= 50; 
            captX += 75; 
            pause(0.2);
          }
        }
      break;
    }

    // Wait time
               pause(1.0);
      ImageFilter blueImage = new ImageFilter("red.png"); 
      blueImage.KeepColor("green");
      drawImage(blueImage, 0, 0, 400);
         
    pause(2.0);

  
}
  /*
*they meet han solo scene and go to the death star
*/
  public void drawHanSoloScene() {
clear("gray");
drawImage("millenniumfalcon.png", 0, 115, 500);

 // Draw the characters
  
    int charX = 10;
    int charY = 235;
   for (int row = 0; row < characters.length; row++) {
     for (int col = 0; col < characters[0].length; col++) {
      String currentChar = characters[1][col];
      setTextHeight(10);
       setTextColor("black");
      if(! currentChar.equals("null")){
         //draw the characters name
    drawText(currentChar, charX, charY+150, 0);
         //draw the pngs 
    drawImage(makePngs(currentChar), charX, charY, 100);
    charX += 75;
    charY += 5;
        pause(0.1);
       }
    }
     break;
   }
     setTextHeight(22);
    drawText("Help me rescue", 225, 200);
    drawText("princess", 250, 225);
    //draw the captions 
    int captX = 10;  
    int captY = 225; 
    for (int row = 2; row < captions.length; row++) {
        for (int col = 0; col < captions[row].length; col++) {
            String currentCaption = captions[row][col];
          if(col<=0){
            setTextHeight(20);
            setTextColor("black");
            drawText(currentCaption, 10, 225, -10);
            pause(2.0);
          }else{
            clear("black");
            drawImage("rob-kaz-star-wars-thats-no-moon.jpg", -75, 75, 500);
         setTextColor("teal");
            setTextHeight(30);
            drawText(addExclamation(captions[2][1]), 250, 350, 15);
            pause(0.2);
        setTextColor("Aqua");
            setTextHeight(20);
            drawText(captions[2][2], 200, 200, -12);
        } 
        }
      break;
    }
   

   
       // Wait time and put on the negative filter
            pause(1.5);
      ImageFilter pm = new ImageFilter("pixilatedImage.png"); 
      pm.pixelateImage(10);
      drawImage(pm, 0, 0, 400);
         
    pause(2.0);
}

  /*
  *draw save princess leia and obi wan dies
  */
public void drawDeathStarScene(){
clear("gray");
drawImage("deathStar.jpg", 0, 0, 710);
  // Draw the characters
  
    int charX = 10;
    int charY = 205;
   for (int row = 0; row < characters.length; row++) {
     for (int col = 0; col < characters[0].length; col++) {
      String currentChar = characters[2][col];
      setTextHeight(10);
       setTextColor("white");
        if(! currentChar.equals("null")){
         //draw the characters name
    drawText(currentChar, charX, charY+200, 0);
         //draw the pngs 
    drawImage(makePngs(currentChar), charX, charY, 100);
    charX += 75;
    charY -= 20;
        pause(0.2);
       }
    }
     break;
   }

 //draw the captions
    
  int capX = 10;  
    int capY = 200; 
    for (int row = 3; row < captions.length; row++) {
        for (int col = 0; col < captions[row].length; col++) {
            String currentCaption = captions[row][col];
          if(col == 0){
            setTextHeight(20);
            setTextColor("teal");
            drawText(addExclamation(currentCaption), capX, capY);
            capY -= 50; 
            capX += 150; 
            pause(0.2);
          }else if (col== 1){
            setTextHeight(20);
            setTextColor("Red");
            drawText(addExclamation(currentCaption), capX, capY);
            capY -= 50; 
            capX += 150; 
            pause(0.2);
          }
        }
      break;
    }
  pause(1.5);
 // ghost obiwan characters and captions
  clear("gray");
drawImage("deathStar.jpg", 0, 0, 710);
    int characX = 10;
    int characY = 205;
   for (int row = 0; row < characters.length; row++) {
     for (int col = 0; col < characters[0].length; col++) {
      String currentChar = characters[2][col];
      setTextHeight(10);
       setTextColor("white");
        if(! currentChar.equals("Obi Wan Kenobi")){
         //draw the characters name
    drawText(currentChar, characX, characY+200, 0);
         //draw the pngs 
    drawImage(makePngs(currentChar), characX, characY, 100);
    characX += 75;
    characY -= 20;
        pause(0.0);
       }else{
          drawImage("ghost_obi_wan.png", 250,150, 100 );
           characX += 75;
    characY -= 20;
          setTextColor("Aqua");
          setTextHeight(30);
          drawText(addExclamation(captions[3][2]), 100, 150, -5);
       }
    }
    
     break;
   }
   
    // Wait time and put on the negative filter
            pause(2.0);
      ImageFilter negative = new ImageFilter("negative.png"); 
      negative.makeNegative();
      drawImage(negative, 0, 0, 400);
            pause(2.0);
  

}
  /*
  *The climax of the movie, the trench run, and the death star exploding
  */
  
public void finalbattle(){
clear("black");
  drawImage("battle-of-Yavin.jpg", 0, 30, 710);

    for (int row = 4; row < captions.length; row++) {
        for (int col = 0; col < captions[row].length; col++) {
            String currentCaption = captions[row][col];
          if(col == 0){
            setTextColor("Aqua");
          setTextHeight(20);
            drawText(addExclamation(currentCaption), 75, 75);
    
         pause(2.0);
          }
        }
      break;
    }
clear("black");
  drawImage("trench-run.jpg", 0, 30, 710);
   pause(0.8);
  clear("black");
  drawImage("lukething.png",0, 100, 400);
   pause(0.8);
  clear("black");
  drawImage("use-the-force-luke.jpg",0, 100, 400);
  for (int row = 3; row < characters.length; row++) {
     for (int col = 0; col < characters[0].length; col++) {
      String currentChar = characters[3][col];
        if(! currentChar.equals("null")){
   if(col== 0){
        drawImage(makePngs(currentChar), 300,50, 100 );
      setTextColor("Aqua");
          setTextHeight(20);
            drawText(captions[4][1], 200, 50);
   }
        }

     }
    break;
  }
  pause(2.0);
clear("silver");
  drawImage("Protontorpedo.jpg", 0, 0,400);
   pause(1.0);
  clear("black");
 drawImage("boom-(1).jpg", -50, 25,600);
  setTextColor("Gold");
          setTextHeight(50);
  drawText(addExclamation(captions[4][2]), 200, 75);
playSound("8d82b5_Death_Star_Explode_Sound_Effect.wav");

  pause(2.0);
   
      ImageFilter colorize = new ImageFilter("colorize.png"); 
      colorize.colorizeImage();
      drawImage(colorize, 0, 0, 400);
          
  
  pause(5.0);
  
}

  /*
  *the end screen/ceremony 
  */
  public void ceremony(){
clear("black"); 
drawImage("ceremony-ezgif.com-webp-to-jpg-converter.jpg", -100, 100, 700);
    setTextHeight(45);
      setTextColor("gold");
      drawText(addExclamation(captions[5][0]), 120, 50);
    pause(1.0);
  }
  

  
  /*
  *Make the String of the Characters and turn them into images
  */
  public String makePngs(String characters){
    //change the string into its Corresponding picture by making them lowercase and deleting the spaces 
    String pngNames = characters.toLowerCase();
    int spaceIndex = pngNames.indexOf(" ");

    if(spaceIndex != -1){
      String[] splitName = pngNames.split(" ");
      if (splitName.length == 3) {
        return splitName[0] + "_" + splitName[1] + "_" + splitName[2] + ".png";
      } else {
        return splitName[0] + "_" + splitName[1] + ".png";
      }
    }

    return pngNames + ".png";
  }
  /*
  *Adds an exclamation point at the end of the caption 
  */
public String addExclamation(String captions) {
 int lastIndex = captions.length() - 1;
  int periodIndex =  captions.indexOf(".");

if (periodIndex != -1 && periodIndex == lastIndex) {
        return captions.substring(0, periodIndex) + "!";
    }

    return captions + "!";
}




  
}
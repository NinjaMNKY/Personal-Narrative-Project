import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // 2D Array
    String[][] characters = {
      {"Luke Skywalker", "Obi Wan Kenobi", "R2 D2", "C3PO", "null"},
      {"Han Solo", "Chewbacca", "Luke Skywalker", "Obi Wan Kenobi", "null"},
      {"Leia Organa", "Luke Skywalker", "Darth Vader", "Obi Wan Kenobi", "Stormtrooper"},
      {"Ghost Obi Wan", "null", "null", "null", "null"}
    };

    String[][] captions = {
      {" ", "A long time ago, ", "in a galaxy far, far away..."},
      {"Obi Wan Kenobi youre my only hope.", "You're a jedi Luke.", "Help me rescue princess."},
      {"Kessel run in 12 parsec.", "ZOOM.", "Thats no Moon."},
      {"come with us Princess.", "Your weak old man.", "Obi wan."},
      {"lets blow up the death star.", "use the force Luke.", "BOOM."},
      {"The End.", "null", "null"}
    };

    // MyStory object
    MyStory scene = new MyStory(characters, captions);
    
    // Call drawScene
    scene.drawScene();
    
    // Play scene in Theater
    Theater.playScenes(scene);
    
  }
}
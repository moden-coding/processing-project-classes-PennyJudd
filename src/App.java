import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.*;

public class App extends PApplet {
    ArrayList<Bullets> bullets;
    ArrayList<Asteroids> asteroid;

   

    float linex = 420;
    float liney = 260;
    float ax;
    float ay;
    int lives = 10;
    int scene = 0;
    float shipx = 400;
    float shipY = 250;
    int rotationSpeed = 1;
    int lineSpeed = 3;
    float Asteroidx;
    float Asteroidy;
    float bulletx;
    float bullety;
    int score = 0;
    int asteroidsize;
    float smallx;
    float smally;
    int smallSize;
    int asteroidMax = 70;
    int asteroidMin = 40;
    int highScore = 0;
    boolean rightShipMove = false;
    boolean leftShipMove = false;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    float shipAngle = 0;
    float bulletAngle = 0;
    int startingLocation;

    public void setup() {
        asteroid = new ArrayList<>();
        bullets = new ArrayList<>();
       
       
        
       

    }

    public void settings() {

        size(800, 500);
        
    

    }

    public void draw() {
       
// 0 is the starting screen 
        if (scene == 0) {
            for(int i = 0; i<asteroid.size(); i++){
                 Asteroids a = asteroid.get(i);
                 asteroid.remove(i);
                 
            }
            score = 0;
            
       
            background(0);
            // Makes cool stars fly around the starting screen 
             for(int c = 0; c < 100; c++){
           
                fill(255);
                circle(random(0,800),random(0,500), 5);


            }
            textSize(100);
            fill(255);
            text("Asteroids", 200, 250);
            textSize(40);
            fill(4,217,255);
            text("Press A to start", 275,300);
            text("Use the arrow keys to rotate the ship", 120,350);
            text("Use SPACE to fire", 275,400);
            
        }
       
        // This is the scene after you die 

        if (scene == 2) {
            
            for(int i = 0; i<asteroid.size(); i++){
                 Asteroids a = asteroid.get(i);
                 asteroid.remove(i);
                 
            }
            background(0);
            
        
            lives = 10;
            textSize(100);
            fill(255);
            text("Game Over", 150, 200);
            textSize(40);
            fill(4,217,255);
            text("Score: " + score, 300, 300);
            fill(57,255,20);
            text("High Score: " + highScore, 250, 350);
    
            fill(255, 240, 31);
            
            text("Press Q to try again", 200,450);
            

        }
        // This is scene when playing the game 
        if (scene == 1) {
             asteroidMaker();
        //   Rotating the ship   
            if(rightShipMove == true){
               
                shipAngle += lineSpeed * rotationSpeed;

            }
            if(leftShipMove == true){
               
                shipAngle -= lineSpeed * rotationSpeed;
            }
           
                    
             
           

            
            background(0);
            fill(255);
            textSize(20);
            text("Score: " + score, 10, 40);
            text("Lives: " + lives, 10,60);

            ship();
            health();
            // for(smallAsteroid x : smalls){
            // System.out.println("x");
            // x.smallDisplay();
            // }
// Creates asteroids 
            for (Asteroids b : asteroid) {

                b.asteroidDisplay();
                b.asteroidMovement();
                // b.lives(lives);
            }
            // Finds the distance between the asteroids and the bullets to remove them 
            for (int b = 0; b < asteroid.size(); b++) {
                Asteroids a = asteroid.get(b);
                Asteroidx = a.getAsteroidX();
                Asteroidy = a.getAsteroidY();
                // System.out.println("hcec");

                for (int f = 0; f < bullets.size(); f++) {
                    Bullets e = bullets.get(f);

                    bulletx = e.getBulletX();
                    bullety = e.getBulletY();

                    if (AsteroidHit(bulletx, bullety, Asteroidx, Asteroidy) < (asteroidsize/2) + 5) {

                        score += 100;

                        asteroid.remove(a);
                        bullets.remove(e);
                        smallAseroidMaker(Asteroidx, Asteroidy, a.getAsteroidSize());

                    }

                }

            }
            // Removes off screen bullets 
            for (int i = 0; i < bullets.size(); i++) {
                Bullets b = bullets.get(i);
                if (b.getBulletX() > 800 || b.getBulletX() < 0 || b.getBulletY() > 500 || b.getBulletY() < 0) {

                    bullets.remove(b);

                }

            }

          
            for (Bullets c : bullets) {
                c.display();
            }
        }

    }

    public void keyPressed() {
        // Rotate left
        if (keyCode == LEFT) {
            rightShipMove = false;
            leftShipMove = true;
            

        }

        // Rotate right
        if (keyCode == RIGHT) {
            leftShipMove = false;
            rightShipMove= true;

          

        }
        
      
// Create bullets
        if (key == ' ') {
            bulletMaker();
           
        }
        // scene changes
        if (key == 'a') {
            
            if(scene != 2){
                scene = 1;
            }
           
            

        }
        if (key == 'q') {
            if(scene != 1){
                score = 0;
               
            }
            scene = 0;

        }
    }
    // Stops movement when a key is not touched
    public void keyReleased() {
        if (keyCode == LEFT) {
            leftShipMove = false;
        }
        if (keyCode == RIGHT) {
            rightShipMove = false;
           
        }
    }
// Creates bullets
    public void bulletMaker() {

        float x = linex + 400;
        float y = liney + 250;
        Bullets laser = new Bullets(x, y, this);
        bullets.add(laser);

    }
// Creates asteroids 
    public void asteroidMaker() {
        int x = 0;
        // Sees how many big and medium asteroids are left 
          for(Asteroids a: asteroid){
        if (a.getAsteroidSize() > 30){
            x++;

        }
    }
    // If there are fewer then two medium or big asteroids, it spawns in more big ones 
    
        if(x <= 2){
        //     System.out.println(x);
        //   System.out.println("working");
        //    System.out.println(x);
    
           
        for (int i = 0; i < 5; i++) {
            ax = 0;

            ay = random(0, 500);
            asteroidsize = (int) random(50, 80);
            Asteroids circle = new Asteroids(asteroidsize, ax, ay, this);
            asteroid.add(circle);
        }
    }
    

    }
    // creates the small asteroids whihc are added to the asteroid arraylist. Bigger asteroids turn into smaller ones until they are destoyed competely

    public void smallAseroidMaker(float x, float y, int size) {

        if (size >= 50) {
            smallSize = (int) random(30, 50);
            for (int i = 0; i < 3; i++) {

                Asteroids smallOne = new Asteroids(smallSize, x, y, this);

                asteroid.add(smallOne);

            }

        } else if (size >= 30 && size <= 49) {
            smallSize = (int) random(10, 30);
            for (int i = 0; i < 2; i++) {
                Asteroids smallOne = new Asteroids(smallSize, x, y, this);

                asteroid.add(smallOne);

            }

        }

    }

    public void health() {

         for (int i = 0; i < asteroid.size(); i++) {
                Asteroids b =   asteroid.get(i);
        //    When an asteroid hits the ship 

            if (dist(b.getAsteroidX(), b.getAsteroidY(), shipx, shipY) <= (25 + asteroidsize / 2)){
                    // && (dist(b.getAsteroidX(), b.getAsteroidY(), shipx, shipY) >= (24 + asteroidsize / 2))) 
                lives--;
                  
                if (lives <= 1) {
                    readHighscore();
                     if (highScore <= score) {
                        System.out.println(score);
                highScore = score;
            }
            saveHighscore();
           
                    // System.out.println(lives);
                    scene = 2;

                }
                
                asteroid.remove(b);
                // System.out.println(lives);
            }

        }

    }

    public void ship() {
        // Creating the ship and the line
        float angleInRadians = radians(shipAngle);

        linex = (25 * cos(angleInRadians));
        liney = (25 * sin(angleInRadians));
        Ship spaceShip = new Ship(angleInRadians, linex, liney, this);
        spaceShip.shipmaker();

    }
// When a bullet hits an asteroid 
    public float AsteroidHit(float bulletx, float bullety, float AsteroidX, float AsteroidY) {

        return dist(bulletx, bullety, AsteroidX, AsteroidY);
    }
// High score reading
    public int readHighscore() {
        try (Scanner scanner = new Scanner(Paths.get("highscore.txt"))) {

            while (scanner.hasNextLine()) {

                String row = scanner.nextLine();

                highScore = Integer.valueOf(row);
               
                
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        return highScore;
    }
// High score saving 
    public void saveHighscore() {

        try (PrintWriter writer = new PrintWriter("Highscore.txt")) {
           System.out.println(highScore);
            writer.println(highScore); // Writes the integer to the file
            writer.close(); // Closes the writer and saves the file

        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

    }
}

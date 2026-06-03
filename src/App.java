import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {
    ArrayList<Bullets> bullets;
    ArrayList<Asteroids> asteroid;

    float linex = 420;
    float liney = 260;
    float ax;
    float ay;
    int lives = 3;
    int scene = 1;
    float shipx = 400;
    float shipY = 250;
    int rotationSpeed = 5;
    int lineSpeed = 3;
    

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
       
       
        if(scene == 2){
            background(255,0,0);
        }
        if(scene == 1){
        background(0);
         ship();
       
        
        for (Asteroids b : asteroid) {
            
            b.asteroidDisplay();
            b.asteroidMovement();
            b.lives(lives);
           
          if(lives < 1){
            scene = 2;
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
            shipAngle -= lineSpeed * rotationSpeed;
           
        }

        // Rotate right
        if (keyCode == RIGHT) {
            shipAngle += lineSpeed * rotationSpeed;
            
        }
        System.out.println("x " + linex);

        if (key == ' ') {
            bulletMaker();
            // circle(circlex + 450,circley + 250,20);
            // circlex++;
        }
        if (key == 'a') {
            

            asteroidMaker();

        }
    }

    public void bulletMaker() {
       

        float x = linex + 400;
        float y = liney + 250;
        Bullets laser = new Bullets(x, y, this);
        bullets.add(laser);

    }

    public void asteroidMaker() {
        
        
       
        for(int i = 0;i<20;i++){
            ax = 0;
       
        
         ay = random(0, 500);
        Asteroids circle = new Asteroids(20,ax, ay, this);
        asteroid.add(circle);
        }

       

    }
    //  public void health(){
    //     System.out.println(dist(ax,ay,shipx,shipY));
       
    //     if(dist(ax,ay,shipx,shipY) < (10 + 25)){
    //         lives--;
    //         if(lives == 0){
    //             scene = 2;

    //         }
    //         System.out.println(lives);

    //     }

        
            
    //     }
    public void ship(){
        float angleInRadians = radians(shipAngle);
        
        linex = (25*cos(angleInRadians));
        liney = (25*sin(angleInRadians));
        Ship spaceShip = new Ship(angleInRadians,linex, liney, this);
        spaceShip.shipmaker();


    }
    
    

}

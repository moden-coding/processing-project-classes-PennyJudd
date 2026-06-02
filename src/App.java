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

    public float degreesToRadian(float d) {
        // System.out.println("d " + d);
        System.out.println(d * (180 / 3.14f));
        return d * (180 / 3.14f);
    }

    public void draw() {
       
        if(scene == 2){
            background(0);
        }
        if(scene == 1){
        background(0);
       
        
        for (Asteroids b : asteroid) {
            
            b.asteroidDisplay();
            b.asteroidMovement();
            b.lives();

        }
        for (Bullets c : bullets) {
            c.display();
        }

        // ChatGPT
        pushMatrix();

        shipRotate();

        popMatrix();
    }

    }

    public void shipRotate() {
        // chatGPTcode
        // translate(width / 2, height / 2);

        // // Rotate the ship
        // rotate(shipAngle);

        // Draw spaceship
         fill(255);
        stroke(0,0,255);
        
        circle(400, 250, 50);

        // Optional direction line so rotation is visible

        stroke(0, 0, 255);

        line(400, 250, linex, liney);

        // circle(circlex,circley,20);

    }

    public void keyPressed() {
        // Rotate left
        if (keyCode == LEFT) {
            // System.out.println("first " +cos((linex-400)/25));

            float cos = (degreesToRadian(cos((linex - 400) / 25))) / 100;
            float sin = (degreesToRadian(sin((liney - 250) / 25))) / 100;
            System.out.println("first  " + sin);
            if (sin < 0) {
                sin = -sin + 250;
            }
            if (cos < 0) {
                cos = -cos + 400;
            }
            System.out.println("cos: " + cos);
            System.out.println("sin: " + sin);
            // if(sin<=.4466260){
            // liney = 250-(sin*50);

            // }
            // else if(sin>.4466260){
            liney = 250 + (sin * 50);
            // }
            linex = 400 + (cos * 50);
            System.out.println("x " + linex);

            System.out.println("y: " + liney);
            // System.out.println(linex);

            // shipAngle = (float)(shipAngle - .5) %6;
            // bulletAngle = (float)(bulletAngle - .5) %6;
        }

        // Rotate right
        if (keyCode == RIGHT) {
            float cos = (degreesToRadian(cos((linex - 400) / 25))) / 100;
            float sin = (degreesToRadian(sin((liney - 250) / 25))) / 100;
            if (sin < 0) {
                sin = -sin + 250;
            }
            if (cos < 0) {
                cos = -cos + 400;
            }
            System.out.println("cos: " + cos);
            System.out.println("sin: " + sin);

            linex = (400 + (cos * 50));

            if (sin >= .44653835) {
                linex = liney + (cos * 50);

                liney = 250 - (sin * 50);

                System.out.println("y: " + liney);

            }
        }
        System.out.println("x " + linex);

        if (key == ' ') {
            // bulletMaker();
            // circle(circlex + 450,circley + 250,20);
            // circlex++;
        }
        if (key == 'a') {
            

            asteroidMaker();

        }
    }

    public void bulletMaker() {
        rotate(bulletAngle);

        // float x = linex + 420;
        // float y = liney + 250;
        // Bullets laser = new Bullets(x, y, this);
        // bullets.add(laser);

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

}

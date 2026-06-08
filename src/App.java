import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {
    ArrayList<Bullets> bullets;
    ArrayList<Asteroids> asteroid;

    // ArrayList<smallAsteroid> smalls;

    float linex = 420;
    float liney = 260;
    float ax;
    float ay;
    int lives = 10;
    int scene = 1;
    float shipx = 400;
    float shipY = 250;
    int rotationSpeed = 5;
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

        if (scene == 2) {
            background(255);
            textSize(50);
            fill(0);
            text("Game Over", 270, 250);

        }
        if (scene == 1) {
            background(0);
            fill(255);
            textSize(20);
            text("Score: " + score, 10, 40);

            ship();
            health();
            // for(smallAsteroid x : smalls){
            // System.out.println("x");
            // x.smallDisplay();
            // }

            for (Asteroids b : asteroid) {

                b.asteroidDisplay();
                b.asteroidMovement();
                b.lives(lives);
            }
            for (Asteroids a : asteroid) {
                Asteroidx = a.getAsteroidX();
                Asteroidy = a.getAsteroidY();

                for (Bullets e : bullets) {
                    bulletx = e.getBulletX();
                    bullety = e.getBulletY();

                    if (AsteroidHit(bulletx, bullety, Asteroidx, Asteroidy) < 15) {
                        score += 100;

                        a.dissapear();
                        smallAseroidMaker();

                    }
                    //

                }

            }

            for (int i = 0; i < bullets.size(); i++) {
                Bullets b = bullets.get(i);
                if (b.getBulletX() > 800 || b.getBulletX() < 0 || b.getBulletY() > 500 || b.getBulletY() < 0) {

                    bullets.remove(b);

                }

            }

            // for (Asteroids z : asteroids){
            // z.asteroidHit(AsteroidX,AsteroidY,bulletX,bulletY);
            // if(asteroidHit = true){

            // z.dissapear();
            // }
            // }
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

        if (key == ' ') {
            bulletMaker();
            // circle(circlex + 450,circley + 250,20);
            // circlex++;
        }
        if (key == 'a') {

            asteroidMaker();

        }
        if (key == 'q') {

        }
    }

    public void bulletMaker() {

        float x = linex + 400;
        float y = liney + 250;
        Bullets laser = new Bullets(x, y, this);
        bullets.add(laser);

    }

    public void asteroidMaker() {

        for (int i = 0; i < 20; i++) {
            ax = 0;

            ay = random(0, 500);
            asteroidsize = (int) random(20, 40);
            Asteroids circle = new Asteroids(asteroidsize, ax, ay, this);
            asteroid.add(circle);
        }

    }

    public void smallAseroidMaker() {
        for (int i = 0; i < 4; i++) {


            Asteroids smallOne = new Asteroids((int) random(10, 20), Asteroidx, Asteroidy, this);

            asteroid.add(smallOne);

           
        }

    }

    public void health() {

        for (Asteroids b : asteroid) {

            if (dist(b.getAsteroidX(), b.getAsteroidY(), shipx, shipY) <= (26 + asteroidsize / 2)
                    && (dist(b.getAsteroidX(), b.getAsteroidY(), shipx, shipY) >= (24 + asteroidsize / 2))) {
                lives--;
                if (lives <= 1) {
                    // System.out.println(lives);
                    // scene = 2;

                }
                // System.out.println(lives);
            }

        }

    }

    public void ship() {
        float angleInRadians = radians(shipAngle);

        linex = (25 * cos(angleInRadians));
        liney = (25 * sin(angleInRadians));
        Ship spaceShip = new Ship(angleInRadians, linex, liney, this);
        spaceShip.shipmaker();

    }

    public float AsteroidHit(float bulletx, float bullety, float AsteroidX, float AsteroidY) {

        return dist(bulletx, bullety, AsteroidX, AsteroidY);
    }

}

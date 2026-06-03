import processing.core.PApplet;

public class Asteroids {
    private float asteroidX;
    private float asteroidY;
    private int asteroidSize;
    private PApplet canvas;
    private float xSpeed;
    private float ySpeed;
    private boolean movement = false;

    public Asteroids(int size, float Astx, float Asty, PApplet c) {
        asteroidX = Astx;
        asteroidY = Asty;
        canvas = c;
        xSpeed = canvas.random(-5, 5);
        ySpeed = canvas.random(-3, 2);

        asteroidSize = size;
    }

    public void asteroidDisplay() {
        canvas.stroke(255);

        canvas.fill(0);
        canvas.circle(asteroidX, asteroidY, asteroidSize);

    }

    public void asteroidMovement() {

        movement = true;
        if (asteroidX > 800) {
            asteroidX = 0;
        }
        if (asteroidX < 0) {
            asteroidX = 800;
        }
        if (asteroidY > 500) {
            asteroidY = 0;
        }
        if (asteroidY < 0) {
            asteroidY = 500;
        }

        if (movement == true) {
            asteroidX = asteroidX + xSpeed;
            asteroidY = asteroidY + ySpeed;
        }

    }

    public void lives(int life) {
        float shipx = 400;
        float shipy = 250;
       
        float dist = (canvas.dist(asteroidX, asteroidY, shipx, shipy));
        if ((int) dist < 35) {
            life = life -1;
            asteroidSize = 0;
            System.out.println(life);

        }
        

        // System.out.println(canvas.dist(asteroidX,asteroidY,shipx,shipy));
        // if(canvas.dist(asteroidX,asteroidY,shipx,shipy) < (10 + 50)){

        // lives--;
        // System.out.println(lives);

        // }

    }

}

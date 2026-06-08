import processing.core.PApplet;

public class smallAsteroid {
    private float asteroidX;
    private float asteroidY;
    private float asteroidSize;
    private PApplet canvas;


    public smallAsteroid(float ax, float ay, int size, PApplet a){
        asteroidX = ax;
        asteroidY = ay;
        asteroidSize = size;
        canvas = a;

    }
    public void smallDisplay(){
        canvas.fill(255);
        canvas.circle(asteroidX,asteroidY,asteroidSize);

    }
}

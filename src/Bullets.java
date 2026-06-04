import processing.core.PApplet;

public class Bullets {
    private float bulletX;
    private float bulletY;
    private int bulletSize;
     private PApplet canvas;

    public Bullets(float x, float y, PApplet c){
        bulletX = x;
        bulletY = y;
        canvas = c;

    }
    public void display(){
        canvas.stroke(0);
        canvas.fill(255,100,100);
        
        canvas.circle(bulletX, bulletY, 10);
       
        bulletX = bulletX + (bulletX-400); 
        bulletY = bulletY + (bulletY -250);
        // canvas.AsteroidHit(bulletX, bulletY, canvas);

       
    
    }
    public float getBulletX(){
        return bulletX;
    }
    public float getBulletY(){
        return bulletY;
    }
    // public float AsteroidHit(float asteroidX, float asteroidY, PApplet a){
    //    return  (canvas.dist(asteroidX, asteroidY, bulletX, bulletY));
    // }
    
   
    
}

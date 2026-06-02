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
        canvas.fill(255);
        
        canvas.rect(bulletX, bulletY, 20, 5);
       
    
    }
    
}

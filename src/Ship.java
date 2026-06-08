import processing.core.PApplet;

public class Ship {
private float angle;
private float X;
private float Y;
private PApplet canvas;
private int lives = 10;
private int size = 50;
public Ship(float shipAngle, float linex, float liney, PApplet p){
    angle = shipAngle;
    X = linex;
    Y = liney;
    canvas = p;
    


}
public void shipmaker(){
     canvas.fill(255);
        canvas.stroke(0,0,255);
        
        canvas.circle(400, 250, size);

        canvas.stroke(0, 0, 255);

        canvas.line(400, 250, 400 +X, 250 +Y);
       
}
public void death(){
    size = 0;
    

}

}

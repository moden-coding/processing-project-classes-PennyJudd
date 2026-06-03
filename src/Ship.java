import processing.core.PApplet;

public class Ship {
private float angle;
private float X;
private float Y;
private PApplet canvas;
public Ship(float shipAngle, float linex, float liney, PApplet p){
    angle = shipAngle;
    X = linex;
    Y = liney;
    canvas = p;
    


}
public void shipmaker(){
     canvas.fill(255);
        canvas.stroke(0,0,255);
        
        canvas.circle(400, 250, 50);

     

        canvas.stroke(0, 0, 255);

        canvas.line(400, 250, 400 +X, 250 +Y);
       
        
       
        
}
// float cos = (degreesToRadian(cos((linex - 400) / 25))) / 100;
            // float sin = (degreesToRadian(sin((liney - 250) / 25))) / 100;
            // if (sin < 0) {
            //     sin = -sin + 250;
            // }
            // if (cos < 0) {
            //     cos = -cos + 400;
            // }
            // System.out.println("cos: " + cos);
            // System.out.println("sin: " + sin);

            // linex = (400 + (cos * 50));

            // if (sin >= .44653835) {
            //     linex = liney + (cos * 50);

            //     liney = 250 - (sin * 50);

            //     System.out.println("y: " + liney);

            // }

}

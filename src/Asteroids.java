import java.util.ArrayList;

import processing.core.PApplet;

public class Asteroids {
    
    private float asteroidX = 300;
    private float asteroidY = 300;
    private int asteroidSize;
    private PApplet canvas;
    private float xSpeed;
    private float ySpeed;
    private boolean movement = false;
    private int smallDirection;

    public Asteroids(int size, float Astx, float Asty, PApplet c) {
        asteroidX = Astx;
        asteroidY = Asty;
        canvas = c;
        xSpeed = canvas.random(-2,2);
        ySpeed = canvas.random(-2, 2);

        asteroidSize = size;
         
    }

    public void asteroidDisplay() {
        
        canvas.stroke(0);
canvas.fill(255);
      
        canvas.circle(asteroidX, asteroidY, asteroidSize);

    }

    public void asteroidMovement() {

        movement = true;
        // Asteroids wrap around the scrren 
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

    // public int getX(){

    // }

    // public void lives(Ship ship);
    
    // public void lives(int life) {
        // float shipx = 400;
        // float shipy = 250;
       
        // float dist = (canvas.dist(asteroidX, asteroidY, shipx, shipy));
    //    while(life >= 0){
    //     System.out.println(dist);
       

        // if ((int) dist < 35) {
        //     life = life -1;
        //     asteroidSize = 0;
        //     // System.out.println(life);

        // }
    // }
        
        

        // System.out.println(canvas.dist(asteroidX,asteroidY,shipx,shipy));
        // if(canvas.dist(asteroidX,asteroidY,shipx,shipy) < (10 + 50)){

        // lives--;
        // System.out.println(lives);

        // }
        // if(AsteroidHit() = true){

        // }
        


    // }
    public float getAsteroidX(){
        return asteroidX;
    }
    public float getAsteroidY(){
        return asteroidY;
    }
    public void dissapear(){
       asteroidSize= 0;


    }
    public int getAsteroidSize(){
        return asteroidSize;
    }
    // Creates the small asteroids 
    public void smallAsteroid(float x,float y){
        asteroidX = x;
        asteroidY = y;
       
        for(int i = 0; i< 3; i++){
            asteroidSize = (int)canvas.random(5,20);
            

         smallDirection = (int)canvas.random(1,3);
        if(smallDirection == 1){
            xSpeed = - xSpeed;
            
           


        }
        if(smallDirection == 2){
            
           ySpeed = -ySpeed;
        }
        canvas.stroke(0);

        canvas.fill(canvas.random(0,255));
        canvas.circle(asteroidX, asteroidY, asteroidSize);
        System.out.println(i);
         movement = true;
        
        
        }
        if (movement == true) {
            asteroidX = asteroidX + xSpeed;
            asteroidY = asteroidY + ySpeed;
        }

    }
   
    
    



    
    
    

}

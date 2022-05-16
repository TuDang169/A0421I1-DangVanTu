package b06_inheritance.bai_tap.point_moveablepoint;

public class MovablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(){}

    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setSpeed(float xSpeed,float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float[] result = new float[2];
        result[0] = this.xSpeed;
        result[1] = this.ySpeed;
        return result;
    }
    public MovablePoint move(){
        setX(getX()+this.xSpeed);
        setY(getY()+this.ySpeed);
        return this;
    }
}

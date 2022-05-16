package b06_inheritance.bai_tap.point_moveablepoint;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(){}
    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        float[] result = new float[2];
        result[0] = this.x;
        result[1] = this.y;
        return result;
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "x: "+this.x+", y: "+this.y;
    }
}

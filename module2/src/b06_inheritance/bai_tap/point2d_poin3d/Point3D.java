package b06_inheritance.bai_tap.point2d_poin3d;

public class Point3D extends Point2D{
    private float z =0.0f;
    public Point3D(){

    }
    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ(){
        float[] result = new float[3];
        result[0] = getX();
        result[1] = getY();
        result[2] = this.z;
        return result;
    }
    public void setXYZ(float x, float y, float z){
        setX(x);
        setY(y);
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", z: "+ this.z;
    }
}

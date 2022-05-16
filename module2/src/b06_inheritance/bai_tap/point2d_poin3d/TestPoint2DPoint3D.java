package b06_inheritance.bai_tap.point2d_poin3d;

public class TestPoint2DPoint3D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D = new Point2D(2,3);
        System.out.println(point2D.toString());

        Point3D point3D = new Point3D();
        point3D = new Point3D(1,4,5);
        System.out.println(point3D.toString());
    }
}

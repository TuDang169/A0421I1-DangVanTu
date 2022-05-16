package b15_exception_handing_debug.bai_tap;

public class CheckTriangle {
    public void checkTriangle(int a, int b, int c) throws IllegalTriangleException{
            if(a+ b < c|| a+ c < b|| c+ b < a){
                throw new IllegalTriangleException("a, b va c khong phai ba canh cua tam giac!");
            }
            if(a< 0|| b< 0|| c< 0){
                throw new IllegalTriangleException("a, b va c khong phai ba canh cua tam giac!");
            }
    }
}

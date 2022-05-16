package b15_exception_handing_debug.bai_tap;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException() {
    }
    public IllegalTriangleException(String message) {
        super(message);
    }
}

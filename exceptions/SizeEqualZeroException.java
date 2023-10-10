package exceptions;

public class SizeEqualZeroException extends RuntimeException {
    public SizeEqualZeroException() {
        System.out.println("La tua lista non può contenere elementi se ha grandezza zero.");
    }
}

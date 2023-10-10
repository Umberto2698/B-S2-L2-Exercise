package exceptions;

public class SizeEqualZeroExceptin extends RuntimeException {
    public SizeEqualZeroExceptin() {
        System.out.println("La tua lista non può contenere elementi se ha grandezza zero.");
    }
}

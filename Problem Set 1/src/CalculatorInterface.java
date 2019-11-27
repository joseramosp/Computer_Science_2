public interface CalculatorInterface
{
    //interface fields must be final and static
    public static final double PI = 3.1415;
    public static final double E = 2.1782;

    public double add(double a, double b);
    public double sub(double a, double b);
    public double mult(double a, double b);
    public double div(double a, double b);
}

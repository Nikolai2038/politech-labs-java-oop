package lab_2;

public class MyClass {
    public int sum(int a, int b) {
        System.out.println("Public Sum!");
        return a + b;
    }

    @MyAnnotation(timesToExecute = 2)
    public double sqrt(double a) {
        System.out.println("Public Sqrt!");
        return Math.sqrt(a);
    }

    public void info() {
        System.out.println("Hello, World!");
    }

    protected int sub(int a, int b) {
        System.out.println("Protected Sub!");
        return a - b;
    }

    @MyAnnotation(timesToExecute = 3)
    protected double div(double a, double b) {
        System.out.println("Protected Div!");
        return a / b;
    }

    @MyAnnotation(timesToExecute = 2)
    protected void superInfo() {
        System.out.println("Protected Info!");
    }

    @MyAnnotation(timesToExecute = 0)
    private int mul(int a, int b) {
        System.out.println("Private Mul!");
        return a * b;
    }

    @MyAnnotation(timesToExecute = 1)
    private double power(double a, double b) {
        System.out.println("Private Power!");
        return Math.pow(a, b);
    }

    private void secretInfo() {
        System.out.println("Private Info!");
    }
}

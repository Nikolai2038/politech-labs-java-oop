package lab_2;

public class MyClass {
    public int sum(int a, int b) {
        return a + b;
    }

    @MyAnnotation(times_to_execute = 2)
    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    public void info() {
        System.out.println("Hello, World!");
    }

    protected int sub(int a, int b) {
        return a - b;
    }

    @MyAnnotation(times_to_execute = 3)
    protected double div(double a, double b) {
        return a / b;
    }

    @MyAnnotation(times_to_execute = 2)
    protected void superInfo() {
        System.out.println("Hello, Super World!");
    }

    @MyAnnotation(times_to_execute = 0)
    private int mul(int a, int b) {
        return a * b;
    }

    @MyAnnotation(times_to_execute = 1)
    private double power(double a, double b) {
        return Math.pow(a, b);
    }

    private void secretInfo() {
        System.out.println("Hello, Secret World!");
    }
}

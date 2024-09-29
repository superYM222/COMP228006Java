public class overloaded {

    public static int square(int value){
        System.out.printf("%nCalled square with int argument: %d%n", value);
        return value * value;
    }
    public static double circleArea(int a){
        System.out.printf("%nradius: %d%n ", a);
        return a *a *Math.PI;
    }
    public static double Circumference(int a ){
        System.out.printf("%nradius: %d%n ", a);
        return 2 * a * Math.PI;
    }

}

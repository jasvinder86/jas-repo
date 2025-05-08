package java8.practice;

@FunctionalInterface
interface FunctionalInterfaceSampler {
    void print();

}

interface FunctionalInterfaceSamplerV2 {
    int sum(int a, int b, int c);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        FunctionalInterfaceSampler object = new FunctionalInterfaceSampler() {
            public void print() {
                System.out.println("in the main");
            }
        };
        object.print();


        FunctionalInterfaceSampler object1 = () ->
                System.out.println("print from the lambda method");
        object1.print();

        FunctionalInterfaceSamplerV2 object3 = (a, b, c) -> {
            return (a + b + c);
        };
        System.out.println(object3.sum(1, 2, 3));

        FunctionalInterfaceSamplerV2 object4 = (a, b, c) ->
                a + b + c;

        System.out.println(object4.sum(3, 4, 5));


    }

}

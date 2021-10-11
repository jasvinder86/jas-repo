package java8.practice;

public class LambdaTest2 {

    @FunctionalInterface
    interface Summable {
        int sum(int x, int y);
    }

    interface StringLength {
        int lengthOfString(String inputString);
    }

    interface Greeter {
        void greet();
    }

    interface PersonGreeter {
        void greet(String personName);
    }

    public void sayHelloToPerson(PersonGreeter personGreeter, String name) {
        personGreeter.greet(name);
    }

    public int addNumbers(Summable summable, int i1, int i2) {
        return summable.sum(i1, i2);
    }

    public void sayHello(Greeter greeter) {
        System.out.println("Hello there!!!");
    }

    public int getLengthOfString(StringLength stringLength, String inputString) {
        return stringLength.lengthOfString(inputString);
    }

    public static void main(String[] args) {

        LambdaTest2 lambdaTest2 = new LambdaTest2();

        Summable getSum = (number1, number2) -> number1 + number2;

        StringLength getLength = inputString -> inputString.length();


        Greeter greeter = () -> System.out.println("Hello ");

        PersonGreeter personGreeter = personName -> System.out.println("Hi!!, " + personName);

        lambdaTest2.sayHelloToPerson(personGreeter, "Jack");

        System.out.println(lambdaTest2.addNumbers(getSum, 1, 2));

        lambdaTest2.sayHello(greeter);

        System.out.println(lambdaTest2.getLengthOfString(getLength, "Savvy Puttar"));

    }

}

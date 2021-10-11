package java8.practice;

public class LambdaTest {

    interface Greeting {
        public String greetThePerson(String nameOfPerson);
    }

    public void testGreeting(String name, Greeting greetingInterface) {
        String result = greetingInterface.greetThePerson(name);

        System.out.println("Result :: " + result);

    }

    public static void main(String[] args) {
//input -> body
//        (String s) -> "Hello " + s;
        new LambdaTest().testGreeting("JS", (String s) -> "Hello " + s);

    }

}

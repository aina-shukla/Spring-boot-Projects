import java.util.function.Function;

// interface Greeting{
//     public String greet(String name);
// }

public class Demo {

    private static void greetUser(Function<String,String> g, String n){
        System.out.println(g.apply(n));
    } 

    public static void main(String[] args) {
        // Greeting greeting = (name)-> "Welcome "+name;
        // greetUser(greeting, "Subodh");

        Function<String, String> greeting = (n)->"Welcome "+n;
        greetUser(greeting, "Subodh");
    }


    
}
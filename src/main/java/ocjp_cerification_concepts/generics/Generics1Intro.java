package ocjp_cerification_concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics1Intro {


    public static void main(String[] args) {
        ArrayList names = new ArrayList();
        names.add("Hari");
        names.add("Goutham");

        String name = (String) names.get(0);
        System.out.println(name);

        //When we declare a raw type, we can add any type in to the collection, but at run time we get class cast exception even though compiler is happy
        //This was allowed to accommodate backward compatibility in java to not break old apps when new ones are built
        //This is where collections come in to picture
        ArrayList names1 = new ArrayList();
        names1.add(1);
        names1.add("Goutham");

        String name1 = (String) names1.get(0);
        System.out.println(name1);

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        // strings.add(123); // Compilation error: Type mismatch

        List rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(123);

        List<String> genericList = rawList; // Unsafe assignment
        // String s = genericList.get(1); // ClassCastException at runtime
    }

}

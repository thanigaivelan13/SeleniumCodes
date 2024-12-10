import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsSample {
    @Test
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abinav");
        names.add("Ajay");
        names.add("Arul");
        names.add("Babu");
        Long count = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(count);
    }

    @Test
    public void StreamTest(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abinav");
        names.add("Ajay");
        names.add("Arul");
        names.add("Babubabu");
        Long count = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(count);
        //Using Streams below
        Long count1 = Stream.of("Abi","Thani","ash","Bab").filter(s -> s.startsWith("A")).count();
        System.out.println(count1);
        names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));

    }

    @Test
    public void streamMaps(){
        Stream.of("Abi","Thani","ash","Bab").filter(s -> s.endsWith("i")).map(s -> s.toLowerCase())
                .forEach(s -> System.out.println(s));

        List<String> names = Arrays.asList("AAA","BBB","CCC");
        List<String> names1 = Arrays.asList("ABC","DBC","KJH");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toLowerCase()).
                forEach(s -> System.out.println(s));
        Stream<String> combinedStream = Stream.concat(names.stream(), names1.stream());
        combinedStream.forEach(s -> System.out.println(s));
    }
}

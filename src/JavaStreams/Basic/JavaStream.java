package JavaStreams.Basic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JavaStream {
    public static void main(String[] args){

        //Sum of numbers
        List<Integer> list = Arrays.asList(1,2,3,6,7,8,9);
        Optional<Integer> sum = list.stream().reduce((a,b) -> a + b);
        System.out.println("Sum of numbers: "+sum.get());

        //Average of numbers
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,69,90);
        double avg = list1.stream().mapToInt(a -> a).average().getAsDouble();
        System.out.println("Average of numbers: "+avg);

    }
}

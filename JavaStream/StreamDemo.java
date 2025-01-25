package JavaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

  // creation of stream
  private static void streamCreationMethod() {

    // imperative approach /normal approach we use this right now
    int[] arr = { 1, 2, 3, 4, 5, 6 };
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0) {
        sum += arr[i];
      }
    }

    // stream
    int[] arr2 = { 1, 2, 3, 4, 5, 6 };
    int sum2 = Arrays.stream(arr).filter(n -> n % 2 == 0).sum();
    System.out.println(sum2);

    // How to convert Collection into stream
    List<String> list = Arrays.asList("apple", "mango", "banana");
    Stream<String> stream = list.stream();

    // How to covert array into stream
    String[] array = { "apple", "mango", "banana" };
    Stream<String> stream2 = Arrays.stream(array);

    // directly into stream without collection or array
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

    // Another method to create a stream is iterator which takes two input first
    // value , lambda expression to generate next value
    // iteratoe(first value,lambda exp)
    // limit(50) setting the ending value or range
    Stream<Integer> iterate = Stream.iterate(0, n -> n + 1).limit(50);

    // generate()
    Stream<Integer> random_number = Stream.generate(() -> (int) Math.random() * 100).limit(5);

  }

  public static void main(String[] args) {

    // operation on number using stream
    List<Integer> numList = Arrays.asList(2, 4, 6, 8, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 2, 4);

    // extract even number using stream
    // filter(lambda exp)
    // collect(Collectors.toList) collects the using Collectors.toList
    List<Integer> filteredList = numList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    System.out.println(filteredList);

    // using map function
    List<Integer> mappeList = filteredList.stream().map(x -> x / 2).collect(Collectors.toList());
    System.out.println(mappeList);

    // how to do both operation in one line

    List<Integer> collectedList = numList.stream().filter(x -> x % 2 == 0).map(x -> x / 2).collect(Collectors.toList());
    System.out.println(collectedList);

    // distinct() gives the unique value
    List<Integer> distictList = numList.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct()
        .collect(Collectors.toList());
    System.out.println(distictList);

    // sorted list bhi chahiye
    // sorted() default sorting ascending order
    // custom sorting k lie comparator ka use karte hai using lambda function
    List<Integer> sortedList = numList.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct().sorted()
        .collect(Collectors.toList());
    System.out.println(sortedList);

    // custom sorting
    // sorted(lambda exp)
    // limit -- hume itne h element chahiheye
    // skip(2) -- starting se itne element skip krr do
    List<Integer> descSortedList = numList.stream()
        .filter(x -> x % 2 == 0)
        .map(x -> x / 2)
        .distinct()
        .sorted((a, b) -> (b - a))
        .limit(4)
        .skip(2)
        .collect(Collectors.toList());
    System.out.println(descSortedList);

    // few more operation
    // peek(x->sout()) --it is consumer function it prints at each operation on
    // stream
    List<Integer> lis = Stream.iterate(0, x -> x + 1)
        .limit(101)
        .skip(1)
        .filter(x -> x % 2 == 0)
        .map(x -> x / 10)
        .distinct()
        .sorted()
        .peek(x -> System.out.println(x + " "))
        .collect(Collectors.toList());

    // other operation
    Integer integer = Stream.iterate(0, x -> x + 1).limit(101).map(x -> x / 20).distinct().peek(System.out::println)
        .max((a, b) -> a - b).get();
    System.out.println(integer);
  }
}

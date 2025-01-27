package JavaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import LinkedList.Stud;

class Vidyarthi {

  String name;
  String grade;
  int age;

  public Vidyarthi(String name, String grade, int age) {
    super();
    this.name = name;
    this.grade = grade;
    this.age = age;
  }

  public Vidyarthi() {

  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  // getter
  public String getGrade() {
    return this.grade;
  }

  public String getName() {
    return this.name;
  }

  // setter
  public void setGrade(String grade) {
    this.grade = grade;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name + " " + this.grade + " " + this.age;
  }
}

public class Question {
  public static void main(String[] args) {
    // duplicate in list
    List<Integer> list = Arrays.asList(1, 3, 2, 1, 2, 4, 2, 5, 5, 6, 7, 8, 1, 12);
    Set<Integer> seen = new HashSet<>();
    Set<Integer> list2 = list.stream().filter(x -> !seen.add(x)).collect(Collectors.toSet());
    System.out.println(list2);

    // group Vidyarthi according to grade
    List<Vidyarthi> st = Arrays.asList(
        new Vidyarthi("Alice", "A", 20),
        new Vidyarthi("Usagi", "B", 25),
        new Vidyarthi("Arishu", "A", 21),
        new Vidyarthi("Chischiya", "A", 23),
        new Vidyarthi("Aguni", "A", 30),
        new Vidyarthi("Kuzuruya", "C", 35));

    System.out.println(st);
    // grouping Vidyarthis
    Map<String, List<Vidyarthi>> groupVidyarthi = st.stream()
        .collect(Collectors.groupingBy(Vidyarthi::getGrade));

    // // printing
    System.out.println("Grouping according to grade :");
    groupVidyarthi.forEach((grade, karthi) -> System.out.println("Grade " +
        grade + ": " + karthi));

    // sort Vidyarthi according to name
    List<Vidyarthi> nameSort = st.stream().sorted(Comparator.comparing(Vidyarthi::getName))
        .collect(Collectors.toList());

    System.out.println("Name sorted : ");
    nameSort.forEach(System.out::println);

    // according to age
    List<Vidyarthi> sortedAge = st.stream().sorted(Comparator.comparingInt(Vidyarthi::getAge))
        .collect(Collectors.toList());
    System.out.println("Age sorted : ");
    sortedAge.forEach(System.out::println);

    // group accoding to grade but only include name
    Map<String, List<String>> dp = st.stream().collect(
        Collectors.groupingBy(Vidyarthi::getGrade, Collectors.mapping(Vidyarthi::getName, Collectors.toList())));
    dp.forEach((grade, lust) -> System.out.println("Grade: " + grade + ": " + lust));

    // group and contains name and age
    Map<String, List<String>> studentsByGrade = st.stream().collect(Collectors.groupingBy(Vidyarthi::getGrade,
        Collectors.mapping(vidyarthi -> vidyarthi.getName() + "(" + vidyarthi.getAge() + ")", Collectors.toList())));

    studentsByGrade.forEach((grade, lust) -> System.out.println("Grade: " + grade + ": " + lust));
    // Map<String, List<Vidyarthi>> VidyarthisByGrade = st.stream()
    // .collect(Collectors.groupingBy(
    // Vidyarthi::getGrade, // Group by gradess
    // Collectors.mapping(
    // Vidyarthi -> Vidyarthi, // Map to Vidyarthi object
    // Collectors.collectingAndThen(
    // Collectors.toList(),
    // (list) -> {
    // return list.stream().sorted(
    // Comparator.comparing(Vidyarthi::getName).reversed()
    // ).collect(Collectors.toList());
    // }
    // )
    // )
    // ));
  }
}

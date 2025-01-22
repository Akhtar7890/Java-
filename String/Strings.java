package TCS;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class Strings {

  private static void countStringIntegerFloat(String str) {
    String[] word = str.split(" ");
    ArrayList<Integer> integer = new ArrayList<>();
    ArrayList<Double> doubl = new ArrayList<>();
    ArrayList<String> string = new ArrayList<>();
    for (String s : word) {
      try {
        integer.add(Integer.parseInt(s));
      } catch (NumberFormatException in) {
        try {
          doubl.add(Double.parseDouble(s));
        } catch (NumberFormatException dl) {
          string.add(s);
        }
      }
    }
    System.out.println("Integer " + integer.size() + " " + integer);
    System.out.println("Double " + doubl.size() + " " + doubl);
    System.out.println("String " + string.size() + " " + string);
  }

  // Currency change problem
  private static void currencyConverterProblem(int number) {
    Locale localeIndia = new Locale("en", "IN");
    NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
    NumberFormat india = NumberFormat.getCurrencyInstance(localeIndia);
    NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);

    String US = us.format(number);
    String INDIA = india.format(number);
    String FRANCE = france.format(number);
    String CHINA = china.format(number);
    System.out.println(US);
    System.out.println(INDIA);
    System.out.println(FRANCE);
    System.out.println(CHINA);
  }

  private static String findLargestAndSmallest(String s, int k) {
    if (k > s.length()) {
      return " ";
    }
    String largest = s.substring(0, k);
    String smallest = s.substring(0, k);
    for (int i = 1; i < s.length() - k + 1; i++) {
      String str = s.substring(i, i + k);
      if (largest.compareTo(str) < 0) {
        largest = str;
      }
      if (smallest.compareTo(str) > 0) {
        smallest = str;
      }
    }
    // System.out.println(largest + " " + smallest);
    return largest + "  " + smallest;
  }

  // Welcome89to java786
  private static void countStringAndInteger(String s) {
    List<String> strings = new ArrayList<>();
    List<Integer> integers = new ArrayList<>();

    StringBuilder currentString = new StringBuilder();
    StringBuilder currentNumber = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        // If the character is a digit, build the current number
        currentNumber.append(c);
        // If there was a string being built, save it
        if (currentString.length() > 0) {
          strings.add(currentString.toString());
          currentString.setLength(0); // Reset the StringBuilder
        }
      } else {
        // If the character is not a digit, build the current string
        currentString.append(c);
        // If there was a number being built, save it
        if (currentNumber.length() > 0) {
          integers.add(Integer.parseInt(currentNumber.toString()));
          currentNumber.setLength(0); // Reset the StringBuilder
        }
      }
    }

    // Add any remaining string or number
    if (currentString.length() > 0) {
      strings.add(currentString.toString());
    }
    if (currentNumber.length() > 0) {
      integers.add(Integer.parseInt(currentNumber.toString()));
    }

    // Print the results
    System.out.println("Strings: " + strings);
    System.out.println("Integers: " + integers);
  }

  /* three sum problem */
  private static void ThreeSum(int[] arr, int sum) {
    int n = arr.length;
    if (n < 3) {
      System.out.println(-1);
    }
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      while (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int total = arr[i] + arr[j] + arr[k];
        if (total > sum) {
          k--;
        } else if (total < sum) {
          j++;
        } else {
          res.add(Arrays.asList(arr[i], arr[j], arr[k]));
          j++;
          while (j < k && arr[j] == arr[j - 1]) {
            j++;
          }
        }
      }
    }
    System.out.println(res);
  }

  /* Number sum in a given String */
  // 123abc12
  private static void NumberSum(String s) {
    int sum = 0;
    StringBuilder currNum = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        currNum.append(ch);
      } else {
        if (currNum.length() > 0) {
          sum += Integer.parseInt(currNum.toString());
          currNum.setLength(0);
        }
      }
    }
    if (currNum.length() > 0) {
      sum += Integer.parseInt(currNum.toString());
    }
    System.out.println(sum);
  }

  // count number of consonant , vowels and space
  private static void countVowelsAndConsonant(String str) {
    int vow = 0;
    int cons = 0;
    int space = 0;
    for (char ch : str.toLowerCase().toCharArray()) {
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        vow++;
      } else if (ch >= 'a' && ch <= 'z') {
        cons++;
      } else if (ch == ' ') {
        space++;
      }
    }
    System.out.println("Vowels : " + vow);
    System.out.println("Consonant : " + cons);
    System.out.println("Space : " + space);
  }

  // Remove all vowels from the string and make the string
  private static void removeVowels(String str) {
    StringBuilder sb = new StringBuilder();
    for (char ch : str.toCharArray()) {
      if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
          || ch == 'u' || ch == 'U') {
        continue;
      } else {
        sb.append(ch);
      }
    }
    System.out.println(sb.toString());
  }

  // Remove characters from the string except the English Alphabet
  private static void removeCharacterExceptAlpha(String s) {
    StringBuilder sb = new StringBuilder();
    for (char ch : s.toCharArray()) {
      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
        sb.append(ch);
      }
    }
    System.out.println(sb.toString());
  }

  // Sum of number in String
  private static void sumOfNumberInString(String st) {
    String tempSum = "0";
    int sum = 0;
    for (char ch : st.toCharArray()) {
      // if(Character.isDigit(ch))
      if (ch >= '0' && ch <= '9') {
        tempSum += ch;
      } else {
        sum += Integer.parseInt(tempSum);
        tempSum = "0";
      }
    }
    // Adding last formed number string
    sum = sum + Integer.parseInt(tempSum);
    System.out.println(sum);
  }

  // Capitalize the first and last character of a word in string
  private static void capitalizedChar(String str) {
    StringBuilder sb = new StringBuilder(str);
    int n = str.length();
    for (int i = 0; i < n; i++) {
      if ((i == 0 || i == n - 1) && (int) str.charAt(i) >= 97) {
        sb.setCharAt(i, (char) (str.charAt(i) - 32));
      } else if (str.charAt(i) == ' ') {
        if ((str.charAt(i - 1) - 32) >= 65) {
          sb.setCharAt(i - 1, (char) (str.charAt(i - 1) - 32));
        }
        if ((str.charAt(i + 1) - 32) >= 65) {
          sb.setCharAt(i + 1, (char) (str.charAt(i + 1) - 32));
        }

      }
    }
    System.out.println(sb.toString());
  }

  // Maximum frequency of character
  // O(1) space
  // O(N) time
  private static void maxFrequency(String str) {
    char ans = 'a';
    int maxFreq = 0;
    int n = str.length();
    int[] count = new int[256];
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      count[ch]++;
      if (count[ch] > maxFreq) {
        maxFreq = count[ch];
        ans = ch;
      }
    }
    System.out.println(ans);
  }

  // Remove duplicates from the string char
  private static void removeDup(String str) {
    boolean[] map = new boolean[26];
    String ans = "";
    for (int i = 0; i < str.length(); i++) {
      if (map[str.charAt(i) - 'a'] == false) {
        ans += str.charAt(i);
        map[str.charAt(i) - 'a'] = true;
      }
    }
    System.out.println(ans);
  }

  // Maximum length word in a string
  private static void maxLengthWord(String str) {
    int len = str.length();
    int maxLen = 0, maxStart = 0;
    int j = 0, i = 0;
    String maxWord = "";
    while (j <= len) {
      if (j < len && str.charAt(j) != ' ') {
        j++;
      } else {
        int currLen = j - i;
        if (currLen > maxLen) {
          maxLen = currLen;
          maxStart = i;
        }
        j++;
        i = j;
      }
    }
    maxWord = str.substring(maxStart, maxLen);
    System.out.println(maxWord);
  }

  // Count number of words in a String
  private static void wordCount(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        count++;
      }
      if (i == str.length() - 1) {
        count++;
      }
    }
    System.out.println("Total words : " + count);
  }

  // maximum word with maximum frequency
  static void HighestRepeatedLetters(String str) {
    int len = str.length();
    int maxWord = 0;
    String result = "";

    for (int left = 0; left < len;) {

      int right = left + 1;
      while (right < len && str.charAt(right) != ' ') {
        right++;
      }

      int frequency[] = new int[26];
      int curr_maxWord = 0;

      for (int index = left; index < right; index++) {
        frequency[str.charAt(index) - 'a']++;
      }
      for (int index = 0; index < 26; index++) {
        if (frequency[index] > 1) {
          curr_maxWord++;
        }
      }

      if (curr_maxWord > maxWord) {
        maxWord = curr_maxWord;
        result = "";
        for (int j = left; j < right; j++) {
          result += str.charAt(j);
        }
      }

      left = right + 1;
    }

    if (result.equals("")) {
      System.out.println("-1");
    } else {
      System.out.print("Word with highest number of repeated letters : ");
      System.out.println(result);
    }
  }

  // find the position of substring within a string
  public static int foundPattern(String text, String pattern) {
    int N = text.length();
    int M = pattern.length();

    for (int i = 0; i < N; i++) {
      int temp = i;
      int j = 0;
      for (j = 0; j < M; j++) {
        if (text.charAt(temp) != pattern.charAt(j)) {
          break;
        }
        temp++;
      }
      if (j == M) {
        return i;
      }
    }
    return -1;
  }

  // Reverse a word in a string
  private static void reverseWord(String str) {
    String[] arr = str.split(" ");
    Stack<String> stack = new Stack<>();
    for (String val : arr) {
      stack.push(val);
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
      sb.append(" ");
    }
    System.out.println(sb.toString().trim());
  }

  public static void main(String[] args) {
    String str = "Hello my naaaaame is Mohammad Akhtar Babu";
    String pattern = "my";
    reverseWord(str);
    System.out.println(foundPattern(str, pattern));
    String s = "Hello @%ok beauty$ *good^bad && done!";
    String st = "1xyz23l90";
    String str2 = "abbcbcdefcd";
    String str3 = "abcdefg google microsoft";
    HighestRepeatedLetters(str3);
    String demo = "Google Doc";
    // sumOfNumberInString(st);
    // removeCharacterExceptAlpha(s);
    // wordCount(str2);
    countVowelsAndConsonant(demo);
    // maxLengthWord(str);
    // removeDup(str2);
    // maxFrequency(str);
    // capitalizedChar(str);
    // removeVowels(str);

    // got 8.2 cgpa 8.9 and is better than 8.2. 7 8 9 10";
    // countStringIntegerFloat(str);
    // int n = 12340;
    // currencyConverterProblem(n);
    // System.out.println(findLargestAndSmallest("welcometojava", 3));
    // countStringIntegerFloat("Welcome78to Java90maths6");
    // countStringAndInteger("Welcom786to java89ok root");
    // Integer[] arr = { 5, 8, 4, 3, 6, 5, 5, 5, 5 };
    // // int sum = 15;
    // // ThreeSum(arr, sum);
    // Arrays.asList(arr);
    // int n = arr.length;
    // // Arrays.sort(arr,0,n/2);
    // Comparator<Integer> cmp = Collections.reverseOrder();
    // Arrays.sort(arr, cmp);
    // for (Integer val : arr)
    // System.out.print(val + " ");
    // NumberSum("123abc23");
    // System.out.println((int) 'e');
  }
}

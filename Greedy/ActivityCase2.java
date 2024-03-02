package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivityCase2 {
  public static void main(String[] args) {
    int start[] = { 3, 1, 0, 5, 8, 5 };
    int end[] = { 4, 2, 6, 7, 9, 9 };

    // If end time is not sorted then we have to sort
    int activities[][] = new int[start.length][3];
    for (int i = 0; i < start.length; i++) {
      activities[i][0] = i;
      activities[i][1] = start[i];
      activities[i][2] = end[i];
    }
    // Sorting according to end time index 2 represents end time
    Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    maxAct = 1;
    ans.add(activities[0][0]);
    int listEnd = activities[0][2];
    for (int i = 1; i < end.length; i++) {
      if (activities[i][1] <= listEnd) {
        maxAct++;
        ans.add(activities[i][0]);
        listEnd = activities[i][2];
      }
    }
    System.out.println("Maximum activity : " + maxAct);
    for (int i = 0; i < ans.size(); i++) {
      System.out.print("A" + ans.get(i) + " ");
    }
  }
}

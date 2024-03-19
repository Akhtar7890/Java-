package ArrayProgram;

public class Frequency {
  public static int maxFrequencyElements(int[] nums) {
    int largest = 0;
    for (int i = 0; i < nums.length; i++) {
      largest = Math.max(largest, nums[i]);
    }
    int freq[] = new int[largest + 1];
    for (int i = 0; i < freq.length; i++) {
      freq[nums[i]]++;
    }
    int maxFreqElement = 0;
    for (int i = 0; i < freq.length; i++) {
      maxFreqElement = Math.max(maxFreqElement, freq[i]);
    }
    int FreqOfFreq = 0;
    for (int i = 0; i < freq.length; i++) {
      if (maxFreqElement == freq[i]) {
        FreqOfFreq++;
      }
    }
    return maxFreqElement * FreqOfFreq;
  }

  public static void main(String args[]) {
    int nums[] = { 1, 2, 3, 4, 5 };
    System.out.println(maxFrequencyElements(nums));

  }
}

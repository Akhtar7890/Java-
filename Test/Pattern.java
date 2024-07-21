class Pattern {
  /*
   ********
   * 
   * *
   * *
   * *
   * *
   * *
   * *
   ********
   * 
   */
  static void squareHollowPattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  /*
   * 
   * 1
   * 2 2
   * 3 3 3
   * 4 4 4 4
   * 5 5 5 5 5
   * 6 6 6 6 6 6
   * 7 7 7 7 7 7 7
   * 8 8 8 8 8 8 8 8
   * 
   */
  static void numberTrianglePattern(int n) {
    int f = 1;
    for (int i = n; i >= 1; i--) {
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = i; k <= n; k++) {
        System.out.print(f + " ");
      }
      f++;
      System.out.println();
    }
  }

  /*
   * 
   * 1
   * 1 2
   * 1 2 3
   * 1 2 3 4
   * 1 2 3 4 5
   * 1 2 3 4 5 6
   * 1 2 3 4 5 6 7
   * 1 2 3 4 5 6 7 8
   * 
   */
  static void numberIncreasingPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  /*
   * 
   * 1 2 3 4 5 6 7 8
   * 1 2 3 4 5 6 7
   * 1 2 3 4 5 6
   * 1 2 3 4 5
   * 1 2 3 4
   * 1 2 3
   * 1 2
   * 1
   * 
   */
  static void numberIncreasingReversePyramid(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i + 1; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  /*
   * 
   * 1
   * 2 3
   * 4 5 6
   * 7 8 9 10
   * 11 12 13 14 15
   * 16 17 18 19 20 21
   * 22 23 24 25 26 27 28
   * 
   */
  static void numberChangingPyramid(int n) {
    int k = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(k + " ");
        k++;
      }
      System.out.println();
    }
  }

  /*
   * 1
   * 0 1
   * 1 0 1
   * 0 1 0 1
   * 1 0 1 0 1
   * 0 1 0 1 0 1
   * 1 0 1 0 1 0 1
   * 
   */
  static void zeroOneTrianglePattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if ((i + j) % 2 == 0) {
          System.out.print(1 + " ");
        } else {
          System.out.print(0 + " ");
        }
      }
      System.out.println();
    }
  }

  static void pallindromeTrianglePattern(int n) {
    for (int i = 1; i <= n; i++) {
      // Inner Loop spaces
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      // printing first half left part
      for (int j = i; j >= 1; j--) {
        System.out.print(j + " ");
      }
      // printing second half right part
      for (int j = 2; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  static void rhombusPattern(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }

      }
      System.out.println();
    }
  }

  // watch glass hour pattern
  static void watchHour(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = i; k <= n; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j < i; j++) {
        System.out.print(" ");
      }
      for (int k = i; k <= n; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

  static void printA(int n) {
    for (int i = 1; i <= n; i++) {
      System.out.print("*");
      for (int j = 1; j <= n; j++) {
        if ((i == 1 || j == n) || (i == n / 2 && j <= n / 2)) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  static void printE(int n) {
    for (int i = 1; i < n; i++) {
      System.out.print("*");
      for (int j = 1; j < n; j++) {
        if ((i == 1 || i == n - 1) || (i == n / 2 && j <= n / 2)) {
          System.out.print("*");
        } else {
          continue;
        }
      }
      System.out.println();
    }
  }

  static void printI(int n) {
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if (i == 1 || i == n - 1)
          System.out.print("*");
        else if (j == n / 2) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  static void printO(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  static void printU(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = 7;
    // squareHollowPattern(n);
    // numberTrianglePattern(n);
    // numberIncreasingPyramid(n);
    // numberIncreasingReversePyramid(n);
    // numberChangingPyramid(n);
    // zeroOneTrianglePattern(n);
    // pallindromeTrianglePattern(n);
    // rhombusPattern(n);
    // watchHour(n);
    // printE(6);
    // printU(6);
    printA(6);
  }
}
import java.util.*;
public class Radix {

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col) {
    int x = n % ((int) Math.pow(10, col + 1));
    if (x < 0) {
      x = x * -1;
    }
    return (x / ((int) Math.pow(10, col)));
  }

}
import java.util.*;
public class Radix {

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col) {
    int x = Math.abs(n % ((int) Math.pow(10, col + 1)));
    return (x / ((int) Math.pow(10, col)));
  }

  //return the number of digits in n.
  public static int length(int n) {
    String str = "" + n;
    int len = str.length();
    if (str.charAt(0) == '-') {
      len--;
    }
    return len;
  }

  //Merge all of the linked lists in the bucket array into your original linked list.
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  //Write a method that sorts non-negative integer values
  //Assume there are no negative values.
  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] bucketArr = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      bucketArr[i] = new SortableLinkedList();
    }
    int passes = data.size();
    int maxLen = 0;
    for (int i = 0; i < passes; i++) {
      if (i == 0) {
        for (int j = 0; j < data.size(); j++) {
          if (length(data.get(j)) > maxLen) {
              maxLen = length(data.get(j));
            }
        }
        passes = maxLen;
      }
      for (int j = 0; j < data.size(); j++) {
        int digit = nth(data.get(j), i);
        bucketArr[digit].add(data.get(j));
      }
      while (data.size() > 0) {
        data.remove(0);
      }
      merge(data, bucketArr);
    }
  }

  //Write a method that sorts any integer values:
  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList[] bucketArr = new SortableLinkedList[19];
    for (int i = 0; i < 19; i++) {
      bucketArr[i] = new SortableLinkedList();
    }
    int passes = data.size();
    int maxLen = 0;
    for (int i = 0; i < passes; i++) {
      if (i == 0) {
        for (int j = 0; j < data.size(); j++) {
          if (length(data.get(j)) > maxLen) {
              maxLen = length(data.get(j));
            }
        }
        passes = maxLen;
      }
      for (int j = 0; j < data.size(); j++) {
        int digit = -1;
        if (data.get(j) <= 0) {
          digit = 10 - nth(data.get(j), i);
        } else {
          digit = 10 + nth(data.get(j), i);
        }
        bucketArr[digit].add(data.get(j));
      }
      while (data.size() > 0) {
        data.remove(0);
      }
      merge(data, bucketArr);
    }
  }

}

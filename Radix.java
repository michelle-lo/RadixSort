import java.util.*;
public class Radix {

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col) {
    int x = Math.abs(n % ((int) Math.pow(10, col + 1)));
    return (x / ((int) Math.pow(10, col)));
  }

  //return the number of digits in n.
  public static int length(int n) {
    if (n == 0) {
      return 1;
    } else {
      return (int) (Math.log10(Math.abs(n)) + 1);
    }
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
      while (data.size() > 0) {
        if (i == 0) {
          if (length(data.get(0)) > maxLen) {
            maxLen = length(data.get(0));
          }
          if (data.size() == 1) {
            passes = maxLen;
          }
        }
          int digit = nth(data.get(0), i);
          bucketArr[digit].add(data.remove(0));
        }
      merge(data, bucketArr);
    }

  }


  //Write a method that sorts any integer values:
  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList[] bucketArr = new SortableLinkedList[20];
    for (int i = 0; i < 20; i++) {
      bucketArr[i] = new SortableLinkedList();
    }
    int passes = data.size();
    int maxLen = 0;
    for (int i = 0; i < passes; i++) {
      while (data.size() > 0) {
        if (i == 0) {
          if (length(data.get(0)) > maxLen) {
            maxLen = length(data.get(0));
          }
          if (data.size() == 1) {
            passes = maxLen;
          }
        }
          int digit = nth(data.get(0), i);
          if (data.get(0) <= 0) {
            digit = 9 - nth(data.get(0), i);
          } else {
            digit = 9 + nth(data.get(0), i);
          }
          bucketArr[digit].add(data.remove(0));
        }
      merge(data, bucketArr);
    }

  }

}

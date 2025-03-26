package TP2;

public class Main {
  
  public static void main(String[] args) {
    Integer[] arr1 = {2, 3, 1, 5, 7};
    Integer[] arr2 = {2, 4, 6, 8, 10};
    Integer[] arr3 = {-3, -1, 0, 2, 4, 6, 10};
    
    

    // System.out.println(isSortedLoco(arr1));
    // System.out.println(isSortedLoco(arr2));
    // System.out.println(isSorted(arr1));
    // System.out.println(isSorted(arr2));

    // System.out.println(contains(arr2, 6));

    // System.out.println(toBinary(8));

    // System.out.println(fibonacci(10));

    System.out.println(hasSameValueAIndex(arr2));
  }

  public static <T extends Comparable<T>> boolean isSortedLoco(T[] arr){
    int len = arr.length, sum = 0;

    sum = sortedLoco(arr, 0);

    return len == sum;
  }

  public static <T extends Comparable<T>> int sortedLoco(T[] arr, int i){
    if (i < arr.length - 1){
      return sortedLoco(arr, i + 1) + Math.max(arr[i].compareTo(arr[i + 1]), 0);
    }else{
      return i+1;
    }
  }

  public static <T extends Comparable<T>> boolean isSorted(T[] arr){
    return sorted(arr, 0);
  }

  public static <T extends Comparable<T>> boolean sorted(T[] arr, int i){
    if (i < arr.length - 1){
      return arr[i].compareTo(arr[i + 1]) <= 0 && sorted(arr, i + 1);
    }else{
      return true;
    }
  }

  public static <T extends Comparable<T>> boolean contains(T[] arr, T target){
    return search(arr, target, 0);
  }

  public static <T extends Comparable<T>> boolean search(T[] arr, T target, int i){

    if (i >= arr.length || arr[i].compareTo(target) > 0) {
      return false;
    }else{
      return arr[i].equals(target) || search(arr, target, i+1);
    }

  }

  public static String toBinary(double num){
    String res = "";

    res = appendDigit(res, num);

    return res;
  }

  public static String appendDigit(String concatenated, double num){
    int digit = (int) num % 2;
    if (num >= 1) {
      concatenated += (appendDigit(concatenated, num / 2)) + digit;
    }
    return concatenated;
  }

  public static String fibonacci(int n){
    String res = "";

    if (n <= 1) {
      return res = "0";
    }

    if (n == 2) {
      return res = "0 1";
    }

    res = fib(n, 1, 0);

    return res;
  }

  public static String fib(int counter, int actual, int prev){
     
    if (counter > 0) {
      return prev + " " +fib(counter - 1, actual + prev, actual);
    }else{
      return "";
    }


    
  }

  public static boolean hasSameValueAIndex(Integer[] arr){
    
    return sameValue(arr, 0);
  }

  public static boolean sameValue(Integer[] arr, int i){
    if (i > arr.length || arr[i] > (i) ) {
      return false;
    }

    return i == arr[i] || sameValue(arr, i + 1);

  }
}

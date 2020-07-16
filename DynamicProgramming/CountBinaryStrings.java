import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n =scn.nextInt();
     int c0s = 1;
      int c1s  = 1;
      for(int i = 2; i <= n; i++){
         int new0s = c1s;
         int new1s = c1s +c0s;

         c0s = new0s;
         c1s = new1s;
      }

      System.out.println(c0s + c1s);
 }

}
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
    //System.out.println(fib_rec(n) );
   // System.out.println(fib_memo(n, new int[n+1] ) );
    System.out.println(fib_tab(n) );
    
 }
 public static int fib_rec(int n){
     if(n==0 || n==1){
         return n;
     }
     int fib1= fib_rec(n-1);
     int fib2= fib_rec(n-2);
     return fib1+fib2;
 }
 public static int fib_memo(int n, int dp[] ){
     if(n==0 || n==1){
         return dp[n]=n;
     }
     
     if(dp[n]!=0 ){
         return dp[n];
     }
     int fib1=fib_memo(n-1,dp);
     int fib2= fib_memo(n-2,dp);
     return dp[n]=fib1+fib2;
 }
 public static int fib_tab(int n){
     int dp[]= new int[n+1];
     for(int i=0;i<=n;i++){
          if(i==0 || i==1){
          dp[i]=i;
          continue;
     }
     
    
     int fib1=dp[i-1];
     int fib2= dp[i-2];
      dp[i]=fib1+fib2;
         
     }
     return dp[n];
 }

}

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr , int si ,int ei ,int [][]dp) {
    //write your code here
    if(si > ei){
        return 0;
    }
    if(si == ei){
        int L = si-1 < 0 ? 1: arr[si-1];
        int R = ei+1 >= arr.length ? 1: arr[ei+1];
        return dp[si][ei] = L*arr[si]*R;
    }
    if(dp[si][ei] != 0){
        return dp[si][ei];
    }
    
    int L = si-1 < 0 ? 1: arr[si-1];
    int R = ei+1 >= arr.length ? 1 : arr[ei+1];
    int max = Integer.MIN_VALUE;
    for(int i = si ; i<= ei ; i++){
        int right = solution(arr , i+1 , ei , dp);
        int left  = solution(arr , si , i-1 , dp);
        int ans = left+right+L*arr[i]*R;
        if(ans > max){
            max = ans;
        }
    }
    return dp[si][ei] = max;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr, 0 ,n-1 , new int[n][n]));
  }

}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int[] dp= new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int maxlength=0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[j] > maxlength){
                    maxlength=dp[j];
                }
            }
            dp[i]=maxlength+1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(ans<dp[i]){
                ans=dp[i];
            }
        }
        System.out.println(ans);
    }

}
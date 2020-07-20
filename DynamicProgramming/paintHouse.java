import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0]; //red
        dp[0][1] = arr[0][1]; //blue
        dp[0][2] = arr[0][2];   //green

            for(int i=1;i<n;i++){
                //red
                dp[i][0]=arr[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
                
                //blue
                dp[i][1]= arr[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
                
                //green
                dp[i][2]=arr[i][2]+ Math.min(dp[i-1][0],dp[i-1][1]);
            }
            int ans = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
            System.out.println(ans);

        }
    }
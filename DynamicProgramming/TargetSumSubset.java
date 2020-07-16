import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int tar =scn.nextInt();
        boolean[][] dp= new boolean[n+1][tar+1];
        dp[0][0]= true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                
                dp[i][j]=dp[i-1][j];
                
                if(dp[i][j] == false && j -arr[i-1]>=0){
                    dp[i][j]=dp[i-1][j-arr[i-1]];
                    
                }
            }
        }
        System.out.println(dp[n][tar]);

    }
}
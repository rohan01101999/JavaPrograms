import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < n ; i++) {
            arr[i] = scn.nextInt();

        }
        int d= scn.nextInt();
        int[] dp= new int[d+1];
        dp[0]=1;
        for(int i=1;i<=d;i++){
           for(int j=0; j<n;j++){
               int coin = arr[j];
               if(i-coin >= 0){
                   dp[i]=dp[i]+dp[i-coin];
               }
               
           }
        }
        System.out.println(dp[d]);
        

    }
}
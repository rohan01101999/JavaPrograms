import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
int n = scn.nextInt();
int k = scn.nextInt();
int[][] dp= new int[2][n];
dp[0][0]= 0;
dp[1][0]=k;
for(int j=1;j<n;j++){
    dp[0][j]=dp[1][j-1];
    dp[1][j]=(dp[0][j-1] + dp[1][j-1])*(k-1);
}
System.out.println(dp[0][n-1]+dp[1][n-1]);
    }
}
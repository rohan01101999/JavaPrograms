import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }
        int[] wts = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }
        int cap = scn.nextInt();

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                int maxPro = dp[i - 1][j]; // not chosen

                if (j - wts[i - 1] >= 0) {
                    maxPro = Math.max(maxPro, price[i - 1] + dp[i - 1][j - wts[i - 1]]);

                }
                dp[i][j]=maxPro;
            }
        }
        System.out.println(dp[n][cap]);
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();

        }
        int[] wieght = new int[n];
        for (int i = 0; i < n; i++) {
            wieght[i] = scn.nextInt();

        }
        int target = scn.nextInt();

        System.out.print(Unbnd_knapsack(arr, wieght, target));

    }

    public static int Unbnd_knapsack(int[] arr, int[] wieght, int target) {
        int[] dp = new int[target + 1];



        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = wieght[i]; j <= target; j++) {


                if (dp[j - wieght[i]] + arr[i] > dp[j]) {
                    dp[j] = dp[j - wieght[i]] + arr[i];
                }





            }
        }
        return dp[target];

    }
}
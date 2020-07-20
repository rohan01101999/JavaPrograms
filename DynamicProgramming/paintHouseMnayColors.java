import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
Scanner scn = new Scanner(System.in);
int n= scn.nextInt();
int k=scn.nextInt();
int[][] cost = new int[n][k];
for(int i=0;i<n;i++){
    for(int j=0;j<k;j++){
        cost[i][j]=scn.nextInt();
    }
}
int[][] dp = new int[n][k];
int min=Integer.MAX_VALUE;
int smin= Integer.MAX_VALUE;
for(int j=0;j<k;j++){
    dp[0][j]=cost[0][j];
    if(cost[0][j]<=min){
        smin = min;
        min = cost[0][j];
        
    }
    else if(cost[0][j]< smin){
        smin = cost[0][j];
    }
}
for(int i=1;i<n;i++){
    int newmin=Integer.MAX_VALUE;
    int newsmin= Integer.MAX_VALUE;
    for(int j=0;j<k;j++){
        dp[i][j]= cost[i][j];
        if(min == dp[i-1][j]){
            dp[i][j]+=smin;
        }
        else{
            dp[i][j]+=min;
        }
        if(dp[i][j]<= newmin){
            newsmin= newmin;
            newmin=dp[i][j];
        }
        else if(dp[i][j]< newsmin){
            newsmin=dp[i][j];
        }
       
    }
     min = newmin;
        smin= newsmin;
}
System.out.println(min);
    }
}
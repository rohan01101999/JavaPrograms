import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       // System.out.println(cs_rec(n) );
        
       // System.out.println(cs_memo(n, new int[n+1]));
        
        System.out.println(cs_tab(n) );
        
    }
    public static int cs_rec(int n){
        
        if(n==0){
            return 1;
        }
        int totalways=0;
        
        totalways+=(n-1>=0)? cs_rec(n-1):0;
        totalways+=(n-2>=0)? cs_rec(n-2):0;
        totalways+= (n-3>=0)?cs_rec(n-3):0;
        
        return totalways;
    }
    
    public static int cs_memo(int n, int[] dp){
        if(n==0){
            return dp[n]=1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0 ){
            return dp[n];
        }
        int tways= 0;
        tways+=cs_memo(n-1,dp);
        tways+=cs_memo(n-2,dp);
        tways+=cs_memo(n-3,dp);
        
        return dp[n]=tways;
        
        
    }
    
    public static int cs_tab( int n){
        int dp[]= new int[n+1];
        
        for(int i=0;i<=n;i++){
            if(i==0){
                dp[i]=1;
                continue;
            }
            
                         int tways= 0;
        tways+=  (i-1>=0) ? dp[i-1]:0;
        tways+= (i-2>=0) ? dp[i-2]:0 ;
        tways+= (i-3>=0) ? dp[i-3]:0;
        dp[i]=tways;
        }
        return dp[n];
    }

}

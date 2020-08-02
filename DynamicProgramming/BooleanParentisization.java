import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int tc;
        int fc;
        Pair(){
            this.tc = 0;
            this.fc = 0;
        }
        Pair(int tc,int fc){
            this.tc = tc;
            this.fc = fc;
        }
    }
    
    public static Pair operate(Pair left,Pair right,char op){
        Pair res = new Pair();
        if(op == '&'){
            res.tc = left.tc * right.tc;
            res.fc = left.tc*right.fc + left.fc*right.tc + left.fc*right.fc;
        }else if(op == '|'){
            res.tc = left.tc*right.tc + left.tc*right.fc + left.fc*right.tc;
            res.fc = left.fc*right.fc;
        }else{
            res.tc = left.tc*right.fc + left.fc*right.tc;
            res.fc = left.tc*right.tc + left.fc*right.fc;
        }
        return res;
    }

    public static Pair solution_mem(String str1, String str2,int si,int ei,Pair dp[][]) {
        //write your code here
        if(si == ei){
            Pair base = new Pair();
            if(str1.charAt(si) == 'T'){
                base.tc = 1;
                base.fc = 0;
            }else{
                base.tc = 0;
                base.fc = 1;
            }
            return base;
        }
        
        if(dp[si][ei] != null){
            return dp[si][ei];
        }
        Pair res = new Pair();
        for(int cut=si;cut<ei;cut++){
            Pair left = solution_mem(str1,str2,si,cut,dp);
            Pair right = solution_mem(str1,str2,cut+1,ei,dp);
            char op = str2.charAt(cut);
            Pair mypair = operate(left,right,op);
            
            res.tc += mypair.tc;
            res.fc += mypair.fc;
        }

        return dp[si][ei] = res;
    }

    public static Pair solution_tab(String str1,String str2){
        int n = str1.length();
        //this can also be done two dps -> truedp[][] and falsedp[][]
        Pair dp[][] = new Pair[n][n];

        
        for(int gap=0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
                dp[si][ei] = new Pair();
                if(gap == 0){
                    if(str1.charAt(si) == 'T'){
                        dp[si][ei].tc = 1;
                        
                    }else{
                        dp[si][ei].fc = 1;
                    }
                    continue;
                }
                for(int cut=si;cut<ei;cut++){
                    Pair left = dp[si][cut];
                    Pair right = dp[cut+1][ei];
                    char op = str2.charAt(cut);
                    Pair res = operate(left,right,op);
                    dp[si][ei].tc += res.tc;
                    dp[si][ei].fc += res.fc;
                }
            }
        }
        
        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int n = s1.length();
        // System.out.println(solution_mem(s1, s2,0,s1.length()-1,new Pair[n][n]).tc);
        
        System.out.println(solution_tab(s1,s2).tc);
    }

}

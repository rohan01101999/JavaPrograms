import java.io.*;
import java.util.*;

public class Main {

	public static int minPalindromicCut(String s) {
		//write your code here
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int gap=1; gap<n; gap++  ){
		    for(int si=0,ei=gap;ei<n;ei++,si++ ){
		        if(gap==1 ){
		            if(s.charAt(si) != s.charAt(ei) ){
		                dp[si][ei]=1;
		            }
		        }else{
		             if(s.charAt(si)==s.charAt(ei) && dp[si+1][ei-1]==0 ){
		                 dp[si][ei]=0;
		                 continue;
		             
		            }
		            int min = Integer.MAX_VALUE;
		            for(int cp= si+1; cp<=ei; cp++ ){
		                int left= dp[si][cp-1];
		                int right = dp[cp][ei];
		                int tCut = left +1+right;
		                min=tCut<min?tCut:min;
		            }
		            dp[si][ei]=min;
		            
		        }
		    }
		}
		return dp[0][n-1];
		

		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}

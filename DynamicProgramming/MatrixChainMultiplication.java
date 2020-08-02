import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr, int si, int ei, int[][] dp ){
	    //si= starting index for cut
	    //ei= ending index for cut
	    if( si+1==ei){
	        //single matrix;
	        return 0;
	    }
	    if(dp[si][ei]!=0 ){
	        return dp[si][ei];
	    }
		//write your code here
		int minCost= Integer.MAX_VALUE;
		for( int cp=si+1; cp<ei ;cp++ ){
		    //cp=cutpoint
		    int leftCost = mcm(arr,si,cp,dp );
		    int rightCost = mcm(arr, cp,ei,dp);
		    int myCost = leftCost+(arr[si]*arr[cp]*arr[ei] )+rightCost;
		    minCost= Math.min(minCost, myCost);
		}

		return dp[si][ei] = minCost;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
	//	System.out.println(mcm(arr,0,arr.length-1, new int[n][n] ));
	
	int a=mcm_tab(arr);
	System.out.println(a);
	}
	
	public static int mcm_tab(int[] arr ){
	    int n =arr.length;
	    int[][] dp= new int[n][n];
	    
	    for(int gap=2; gap<n;gap++ ){
	        for(int si=0, ei= gap; ei<n;si++,ei++ ){
	            
	            //cutpoint logic
	            int min = Integer.MAX_VALUE;
	            for(int cut=si+1; cut<ei; cut++ ){
	                int leftCost = dp[si][cut];
	                int rightCost = dp[cut][ei];
	                int myCost = leftCost + (arr[si]*arr[cut]*arr[ei] )+rightCost;
	                
	                if(min>myCost) {
	                    min = myCost;
	                }
	                   
	            }
	            dp[si][ei]=min;
	        }
	        
	    }
	    return dp[0][n-1];
	    
	}

	
}

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code
    int left[] = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   st.push(0);
   
   left[0] = -1;
   for(int i = 1; i<arr.length ; i++){
     while(st.size() != 0 && arr[st.peek()] >= arr[i]){
         st.pop();
     }
     if(st.size() == 0){
         left[i] = -1;
     }else{
       left[i] =  st.peek();  
     }
     st.push(i);      
   }
  
   st.clear();
   
    int right[] = new int[n];
    
    right[0] = arr.length; 
    st.push(arr.length-1);
    
    for(int i = arr.length-2 ; i>=0 ; i--){
        while(st.size() != 0 && arr[st.peek()] >= arr[i]){
            st.pop();
        }
        
        if(st.size() == 0){
            right[i] = arr.length;
        }else{
            right[i] = st.peek();
        }
        
        st.push(i);
    }
    
    int maxarea = 0;
    for(int i =0 ; i< arr.length ; i++){
        if(maxarea < arr[i]*(right[i] - left[i] -1)){
            maxarea =  arr[i]*(right[i] - left[i] -1);
        }
    }
   
   System.out.print(maxarea);
    
 }
   
}
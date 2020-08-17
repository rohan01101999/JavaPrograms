import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    System.out.print(InfixEval(exp));
    
 }
 public static int InfixEval(String exp){
    Stack <Character> st = new Stack<>();
    Stack <Integer> num = new Stack<>();

    

    for(int i = 0 ; i< exp.length() ; i++){
        char ch = exp.charAt(i);
        
        if(ch >= '0' && ch <= '9'){
            num.push(ch - '0');
        }
        else if( ch == '('){
            st.push('(');
        }
        else if( ch == ')'){
            
            while( st.peek() != '(')
            {
                char oprtr = st.pop();
                int oprnd2 = num.pop();
                int oprnd1 = num.pop();
                int ans = solve(oprtr , oprnd1 , oprnd2);
                num.push(ans);
                
            }
            
            st.pop();
        }
        
        else if(ch == '+' || ch == '-' || ch == '/' || ch=='*'){
            
            while(st.size() > 0 && st.peek() != '(' && pred(st.peek()) >= pred(ch)){
                 char oprtr = st.pop();
                int oprnd2 = num.pop();
                int oprnd1 = num.pop();
                int ans = solve(oprtr , oprnd1 , oprnd2);
                num.push(ans);
            }
            st.push(ch);
            
        }
    
    }
      while(st.size() > 0){
            char oprtr = st.pop();
                int oprnd2 = num.pop();
                int oprnd1 = num.pop();
                int ans = solve(oprtr , oprnd1 , oprnd2);
                num.push(ans);
        }
        
        return num.peek();
 }
 
  public static int solve( char op ,  int num1 ,int num2){
      if(op == '+'){
          return num1+num2;
      }else if(op == '-'){
          return num1 - num2;
      }else if(op == '/'){
          return num1/num2;
      }else {
          return num1*num2;
      }
  }
  
  public static int pred(char ch){
      if( ch == '+' || ch == '-'){
          return 1;
      }else{
          return 2;
      }
  }
}

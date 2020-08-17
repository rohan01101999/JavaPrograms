import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    conversion(exp);
    
 }
 
 public static void conversion(String exp){
    Stack <String> prefix = new Stack<>();
    Stack <String> postfix = new Stack<>(); 
    Stack <Character> oprtrs = new Stack<>(); 
    
    for(int i = 0 ; i<exp.length(); i++){
        char ch = exp.charAt(i);
        
        if(isOprnd(ch)){
            prefix.push(Character.toString(ch));
            postfix.push(Character.toString(ch));
        }
        else if(ch == '('){
            oprtrs.push(ch);
        }
        else if(ch == ')'){
            while(oprtrs.peek() != '('){
                // prefix
                char optr = oprtrs.pop();
                String preOp2 = prefix.pop();
                String preOp1 = prefix.pop();
                
                prefix.push(Character.toString(optr) + preOp1 +preOp2);
                
                // postfix
                
                String postOp2 = postfix.pop();
                String postOp1 = postfix.pop();
                
                postfix.push( postOp1 +postOp2 + Character.toString(optr));
                
                
            }
            oprtrs.pop();
        }
        
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            
            while(oprtrs.size() > 0 && oprtrs.peek() != '(' && pred(oprtrs.peek()) >= pred(ch)){
                char optr = oprtrs.pop();
                String preOp2 = prefix.pop();
                String preOp1 = prefix.pop();
                
                prefix.push(optr + preOp1 +preOp2);
                // System.out.println("pre: "  + optr + preOp1 +preOp2);
                // postfix
                
                String postOp2 = postfix.pop();
                String postOp1 = postfix.pop();
                
               postfix.push( postOp1 +postOp2 +optr);
            //   System.out.println("post: " + postOp1 +postOp2 + optr);
            }
            
            oprtrs.push(ch);
            
    }
    }
    
    while(oprtrs.size() != 0 ){
                char optr = oprtrs.pop();
                String preOp2 = prefix.pop();
                String preOp1 = prefix.pop();
                
                prefix.push(Character.toString(optr) + preOp1 +preOp2);
                
                // postfix
                
                String postOp2 = postfix.pop();
                String postOp1 = postfix.pop();
                
                postfix.push( postOp1 +postOp2 + Character.toString(optr));
        
    }
    
    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
    
 }
  
  public static int pred(char ch){
       if( ch == '+' || ch == '-'){
          return 1;
      }else{
          return 2;
      }
  }
  
  public static boolean isOprnd(char ch){
      if(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch<='Z'){
          return true;
          
      }
      return false;
  }
 
}

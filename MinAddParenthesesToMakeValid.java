public class MinAddParenthesesToMakeValid{ //here I've done it without using stack
    public static int minAddToMakeValid(String S) {
        int n = S.length(); 
        int answer=0, left=0, s_right=0; //s_right is called "special right," that's when a right parentheses happens when there's no more left parentheses before it to pair with it
        if (S==null) return 0; 
        //the intuition here isn't complicated--when left parentheses happens, it always looks for a right parentheses to pair with it
        //but for right parenthese to pair with a left one, it needs to have a left parentheses BEFORE it, 
        //any left ones AFTER a right parentheses can't pair with that right parentheses. 
        for (int i=0; i<n; i++) {
            if(S.charAt(i) == '(') {
                left++; 
            }
            else {
                if(left==0) s_right++; 
                else left--; //we use "decrease" to mean that a left one has been paired with a right one
            }
        }
        answer = left+s_right; //a s_right parentheses is a right parentheses without getting paired with a left one, 
        //so here we add the remaining left one and the "special right ones" to get how many unpaired parentheses, and that's the answer we need
        return answer; 
    }
    public static void main(String []args){
        int answer=0; 
        String myString = "((()(()"; 
        answer=minAddToMakeValid(myString); 
        System.out.println("Answer is "+answer);
    }
}

package com.zhl.stack;

public class Evaluate {
    public static void main(String[] args) {
        String s = "(1+(2+3)*(4*5)))";

        char[] chars = s.toCharArray();

        LinkedStack<String> ops = new LinkedStack<>();
        LinkedStack<Integer> vals = new LinkedStack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') ;
            else if (chars[i] == '+') ops.push("+");
            else if (chars[i] == '-') ops.push("-");
            else if (chars[i] == '*') ops.push("*");
            else if (chars[i] == '/') ops.push("/");
            else if (chars[i] == ')') {
                Integer val = vals.pop();
                String op = ops.pop();

                if(op.equals("+")) val+= vals.pop();
                else if(op.equals("-")) val-=vals.pop();
                else if(op.equals("*")) val*=vals.pop();
                else if(op.equals("/")) val/=vals.pop();
                vals.push(val);
            }
            else{
                vals.push(Integer.parseInt(chars[i]+""));
            }
        }
        System.out.println(vals.pop());
    }
}

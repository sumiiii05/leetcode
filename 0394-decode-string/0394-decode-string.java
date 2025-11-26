class Solution {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==']'){
                char c=' ';
                String sub="";
                String k="";
                while((c=stack.pop())!='['){
                    sub=c+sub;
                }
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k=stack.pop()+k;
                }

                sub=sub.repeat(Integer.parseInt(k));
                for(int j=0;j<sub.length();j++){
                    stack.push(sub.charAt(j));
                }
            }else{
                stack.push(ch);
            }
        }
        StringBuilder result=new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
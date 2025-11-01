class Solution {
    public String reversePrefix(String word, char ch) {
        int firstocc=word.indexOf(ch);
        if(firstocc==-1){
            return word;
        }

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<=firstocc;i++){
            stack.push(word.charAt(i));
        }
        StringBuilder res=new StringBuilder();

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        for(int i=firstocc+1;i<word.length();i++){
            res.append(word.charAt(i));
        }
        return res.toString();
    }
}
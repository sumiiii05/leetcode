class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q=new LinkedList<Character>();
        int toBan=0;
        for(char ch:senate.toCharArray()){
            q.add(ch);
        }

        while(q.size()>Math.abs(toBan)){
            if(toBan>0 && q.peek()=='D'){
                q.poll();
                toBan-=1;
            }
            else if(toBan<0 && q.peek()=='R'){
                q.poll();
                toBan+=1;
            }
            else{
                toBan+=q.peek()=='R'?1:-1;
                q.add(q.poll());
            }

        }
        return toBan>0?"Radiant":"Dire";
    }
}
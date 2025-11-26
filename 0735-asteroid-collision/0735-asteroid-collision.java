class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack= new Stack<>();
        for(int asteroid:asteroids){
            boolean alive=true;
            while(alive && asteroid<0 && stack.size()>0 && stack.peek()>0){
                if(Math.abs(asteroid)>stack.peek()){
                    stack.pop();
                }else if(Math.abs(asteroid)==stack.peek()){
                    stack.pop();
                    alive=false;
                }else{
                    alive=false;
                }
            }
            if(alive){
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
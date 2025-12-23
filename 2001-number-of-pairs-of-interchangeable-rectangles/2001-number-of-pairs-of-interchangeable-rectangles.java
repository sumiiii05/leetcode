class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long count=0;
        HashMap<String,Long> map=new HashMap<>();
        for(int[] r:rectangles){
            int w=r[0];
            int h=r[1];
            int g=gcd(w,h);
            w/=g;
            h/=g;
            String key=w+"/"+h;
            if(map.containsKey(key)){
                count+=map.getOrDefault(key,0L);
                map.put(key,map.get(key)+1);
            }
            else{
                map.put(key,1L);
            }
        } 
        return count;
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
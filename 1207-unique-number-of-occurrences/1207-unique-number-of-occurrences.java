class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> freq= new HashMap<>();
        for(int num:arr){
            freq.merge(num,1,Integer::sum);
        }
        Set<Integer> counts = new HashSet<Integer>();
        freq.forEach((key,value)->counts.add(value));
        return counts.size()==freq.size();
    }
}
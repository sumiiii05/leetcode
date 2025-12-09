class SmallestInfiniteSet {
    private PriorityQueue<Integer> heap;
    int counter;
    public SmallestInfiniteSet() {
        heap=new PriorityQueue<>();
        counter=1;
    }
    
    public int popSmallest() {
        if(!heap.isEmpty()){
            return heap.poll();
        }
        return counter++;
    }
    
    public void addBack(int num) {
        if(num<counter && !heap.contains(num)){
            heap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
class Solution {
    class Node{
        int node;
        int w;
        Node(int node, int w){
            this.node =node;
            this.w =w;
        }
    }
    int minEdges =0;
    public int minReorder(int n, int[][] connections) {
        List<Node> [] graph = new  ArrayList[n];
        for(int i =0 ; i< n ;i++){
            graph[i] = new ArrayList<>();
        }
        for(int [] con : connections){
            graph[con[0]].add(new Node(con[1], 1));
            graph[con[1]].add(new Node(con[0], 0));
        }

        dfsHelper(0, -1, graph);
        return minEdges;
    }
    void dfsHelper(int currNode, int parent,  List<Node> [] graph){
        for(Node ngb : graph[currNode]){
            if(ngb.node != parent){
                minEdges+= ngb.w;
                dfsHelper(ngb.node, currNode , graph);
            }
        }
    }
}
class MyLinkedList {
    Node head;
    int len;
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    public MyLinkedList() {
        this.head=null;
        this.len=0;
    }
    
    public int get(int index) {
        if(index>=len){
            return -1;
        }
        int counter=0;
        Node temp=head;
        while(counter<index){
            counter++;
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node nn=new Node(val);
        nn.next=head;
        head=nn;
        len++;    
    }
    
    public void addAtTail(int val) {
        if(head==null){
            addAtHead(val);
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            Node nn=new Node(val);
            temp.next=nn;
            len++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index>len){
            return;
        }
        if(index==0){
            addAtHead(val);
        }
        else{
            int counter=1;
            Node temp=head;
            while(counter<index){
                temp=temp.next;
                counter++;
            }
            Node nn=new Node(val);
            nn.next=temp.next;
            temp.next=nn;
            len++;
        }    
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=len || head==null){
            return;
        }
        if(index==0){
            head=head.next;
        }else{
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
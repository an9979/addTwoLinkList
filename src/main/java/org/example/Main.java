package org.example;
class LinkList {
    int value;
    LinkList next;
    public LinkList(int val, LinkList next) {
        this.value = val;
        this.next=next;
    }
    public LinkList(int val)
    {
        this.value = val;
    }
    public LinkList()
    {
    }
}

public class Main {
    static LinkList reverse(LinkList head, int k)
    {
        if(head == null)
            return null;
        LinkList current = head;
        LinkList next = null;
        LinkList prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }
    static LinkList sum(LinkList l1, LinkList l2){
        LinkList head = new LinkList();
        LinkList tail = new LinkList();
        int l3;
        int carry=0;
        while(true) {
            if (l1 == null) {
                tail.next=l2;
                break;
            }
            if (l2 == null) {
                tail.next=l1;
                break;
            }
            int answer= l1.value+l2.value;
            if (answer>=10){
                carry=1;
                answer=answer-10;
            }
            if(carry==0){
                head.value=answer;
                head.next=tail;
            }
            else{
                tail.value=answer;
                head.value=head.value+carry;
                carry=0;
            }
            l1=l1.next;
            l2=l2.next;
        }
        return head;
    }
    public static void main(String[] args) {


        LinkList l1 = null, l2 = null;
        for (int i =6; i <= 8; i++) {
            l1 = new LinkList(i, l1);
        }
        for (int i = 4; i <=6 ; i++) {
            l2=new LinkList(i,l2);
        }
        LinkList l3=reverse( l1, 2);
    }
}
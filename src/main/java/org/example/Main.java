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


        LinkList l1 = new LinkList(8),l2 = new LinkList(6);
        for (int i = 7; i >=6 ; i--) {
            l1.next=l1;
            l1.value=i;
        }
        for (int i = 5; i >=4 ; i--) {
            l2.next=l2;
            l2.value=i;
        }
        LinkList l3= sum(l1,l2);
    }
}
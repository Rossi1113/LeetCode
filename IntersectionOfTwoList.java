public class IntersectionOfTwoList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args){

    }
    //solution 1
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int l1 = 0;
        int l2 = 0;
        while(p1 != null){   //get Length of A list
            l1++;
            p1 = p1.next;
        }
        while(p2 != null){   //get Length of B list
            l2++;
            p2 = p2.next;
        }
        int diff = Math.abs(l1 - l2);  //get difference
        if(l1 >= l2){
            p1 = headB;
            p2 = headA;

        }else {
            p1 = headA;
            p2 = headB;
        }
        while(diff > 0){    //align two list from the same start point
            p2 = p2.next;
            diff--;
        }
        while(p1 != null){     //then go with same pace to get the intersection.
            if(p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;

        }
        return null;
    }

    //solution 2
    // ListA a1->...->aN, ListB b1->...->bM, intersection c1->...->cK
    // Length of ListA is N+K
    // Length of ListB is M+K
    //if we connect tail of ListA to headB, and tail of ListB to headA. then we got
    // N+K+M,M+K+N  (go the same distance) --> arrive intersection.
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if(headA == null || headB == null )
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            if(a == null){
                a = headB;
            } else a = a.next;
            if(b == null){
                b = headA;
            } else b = b.next;
        }
        return a;
    }

}

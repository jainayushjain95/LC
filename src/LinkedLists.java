import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LinkedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        boolean hasCycle = false;

        while(slow != null && fast != null && fast.next != null && !hasCycle) {
            hasCycle = slow == fast;
            slow = slow.next;
            fast = fast.next.next;
        }

        return hasCycle;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNodeApproachTwo(headA, headB);
    }

    public ListNode getIntersectionNodeApproachOne(ListNode headA, ListNode headB) {
        while(headA != null) {
            ListNode tempB = headB;
            while(tempB != null) {
                if(headA == tempB) {
                    return headA;
                }
                tempB = tempB.next;
            }
            headA = headA.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeApproachTwo(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNodeApproachThree(ListNode headA, ListNode headB) {
        int len1 = CommonUtils.getLengthOfLL(headA);
        int len2 = CommonUtils.getLengthOfLL(headB);
        ListNode longerListHead = null, smallerListHead = null;

        if(len1 > len2) {
            longerListHead = headA;
            smallerListHead = headB;
        } else {
            longerListHead = headB;
            smallerListHead = headA;
        }

        int diff = Math.abs(len1 - len2);
        while(diff > 0) {
            longerListHead = longerListHead.next;
            diff--;
        }

        while(longerListHead != null && smallerListHead != null) {
            if(longerListHead == smallerListHead) {
                return smallerListHead;
            }
            smallerListHead = smallerListHead.next;
            longerListHead = longerListHead.next;
        }

        return null;
    }



}

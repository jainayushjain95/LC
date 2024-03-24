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

    ListNode outputHead = null;
    ListNode front = null;

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 1};
        LinkedLists obj = new LinkedLists();
        ListNode head = obj.getList(array);
//        ListNode output = obj.reverseList(head);
//        obj.printList(output);
        System.out.println(obj.isPalindrome2(head));
    }

    public boolean isPalindrome(ListNode head) {
        front = head;
        return isPalindrome1(head);
    }

    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode reversedHead = reverseLLForisPalindrome(mid.next);
        mid.next = null;
        boolean isPalindrome = true;
        while(reversedHead != null && head != null && isPalindrome) {
            isPalindrome = head.val == reversedHead.val;
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return isPalindrome;
    }

    public ListNode reverseLLForisPalindrome(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome1(ListNode curr) {
        if(curr != null) {
            if(!isPalindrome1(curr.next)) {
                return false;
            }
            if(front.val != curr.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        return reverseList3(head);
    }

    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode smallerHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return smallerHead;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode smallerHead = reverseList1(head.next);
        head.next = null;
        smallerHead.next = head;
        if(outputHead == null) {
            outputHead = smallerHead;
        }
        smallerHead = head;
        return smallerHead;
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

    public void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
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

    public ListNode getList(int[] array) {
        ListNode head = null, lastNode = null;
        for (int num : array) {
            if(head == null) {
                head = new ListNode(num);
                lastNode = head;
            } else {
                lastNode.next = new ListNode(num);
                lastNode = lastNode.next;
            }
        }
        return head;
    }


}

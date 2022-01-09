package medium;

import static java.util.Objects.nonNull;

public class Adding {
    /*
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807,

    Input: l1 = [0], l2 = [0]
    Output: [0]

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
     */

    public static void main(String[] args) {
        Adding add = new Adding();
//        ListNode l1 = add.buildList("243");
        ListNode l1 = add.buildList("9999999");
//        ListNode l2 = add.buildList("564");
        ListNode l2 = add.buildList("9999");

        ListNode returned2 = add.addTwoNumbers2(l1, l2);
        ListNode returned = add.addTwoNumbers(l1, l2);
        System.out.println("Completed");
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        int carry = 0;
        int ans;

        while (nonNull(l1) || nonNull(l2) || carry == 1) {
            int first = 0;
            int second = 0;

            if (nonNull(l1)) {
                first = l1.val;
            }

            if (nonNull(l2)) {
                second = l2.val;
            }

            ans = first + second + carry;

            if(ans > 9) {
                ans = ans % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            temp.next = new ListNode(ans);
            temp = temp.next;

            if(nonNull(l1)) {
                l1 = l1.next;
            }

            if(nonNull(l2)) {
                l2 = l2.next;
            }
        }

        return listNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1val = getInteger(l1);
        int l2val = getInteger(l2);

        int lval = l1val + l2val;

        return buildList(Integer.toString(lval));
    }

    public int getInteger(ListNode listNode) {
        StringBuilder strb = new StringBuilder();
        while (nonNull(listNode)) {
            strb.append(listNode.val);
            listNode = listNode.next;
        }

        return Integer.parseInt(strb.reverse().toString());
    }

    public ListNode buildList(String value) {
        ListNode listNode = new ListNode();
        ListNode returned = listNode;
        int length = value.length();
        for (int i = length; i > 0; i--) {
            String val = (String) value.subSequence(i - 1, i);
            if (i == 1) {
                listNode.val = Integer.parseInt(val);
            } else {
                ListNode next = new ListNode();
                listNode.val = Integer.parseInt(val);
                listNode.next = next;
                listNode = next;
            }
        }
        return returned;
    }
}

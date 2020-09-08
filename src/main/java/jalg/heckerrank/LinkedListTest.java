package jalg.heckerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 17 May 2019, 8:23 AM
 */
public class LinkedListTest
{
    static class SinglyLinkedListNode
    {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData)
        {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList
    {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList()
        {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData)
        {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head)
    {
        if (head == null || head.next == null)
            return head;
        SinglyLinkedListNode fHead = head;
        int preValue = head.data;
        while (head.next != null) {
            if (head.next.data == preValue) {
                head.next = head.next.next;
            } else {
                head = head.next;
                preValue = head.data;
            }
        }
        return fHead;
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean hasCycle(SinglyLinkedListNode head)
    {

        if (head == null || head.next == null)
            return false;

        HashSet<SinglyLinkedListNode> nodeSet = new HashSet<>();
        do {
            boolean add = nodeSet.add(head);
            if (!add)
                return true;
            head = head.next;
        } while (head != null);
        return false;
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        Set<SinglyLinkedListNode> nodeSet = new HashSet<>();
        while (head1 != null) {
            nodeSet.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (nodeSet.contains(head2))
                return head2.data;
            else
                head2 = head2.next;
        }

        return -1;
    }

    static int findMergeNode2(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        SinglyLinkedListNode currentA = head1;
        SinglyLinkedListNode currentB = head2;

        while (currentA != currentB) {
            if (currentA.next == null) {
                currentA = head2;
            } else {
                currentA = currentA.next;
            }
            if (currentB.next == null) {
                currentB = head1;
            } else {
                currentB = currentB.next;
            }

            return currentB.data;
        }

        Set<SinglyLinkedListNode> nodeSet = new HashSet<>();
        while (head1 != null) {
            nodeSet.add(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (nodeSet.contains(head2))
                return head2.data;
            else
                head2 = head2.next;
        }

        return -1;
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int getNode(SinglyLinkedListNode head, int positionFromTail)
    {

        List<Integer> dataList = new ArrayList<>();
        do {
            dataList.add(head.data);
            head = head.next;
        } while (head != null);

        return dataList.get(dataList.size() - positionFromTail - 1);
    }

}

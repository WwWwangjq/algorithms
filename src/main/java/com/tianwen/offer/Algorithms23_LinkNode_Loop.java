package com.tianwen.offer;

import com.tianwen.data.structure.ListNodeLoop;

/**
 * wangjq
 * 2020年12月13日  21:19
 */
public class Algorithms23_LinkNode_Loop {


    /**
     * 环形链表
     * 判断链表是否是包含环 入口在哪
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNodeLoop n9 = new ListNodeLoop(9);
        ListNodeLoop n8 = new ListNodeLoop(8, n9);
        ListNodeLoop n7 = new ListNodeLoop(7, n8);
        ListNodeLoop n6 = new ListNodeLoop(6, n7);
        ListNodeLoop n5 = new ListNodeLoop(5, n6);
        ListNodeLoop n4 = new ListNodeLoop(4, n5);
        ListNodeLoop n3 = new ListNodeLoop(3, n4);
        ListNodeLoop n2 = new ListNodeLoop(2, n3);
        ListNodeLoop n1 = new ListNodeLoop(1, n2);
        n9.next = n8;
        isContainLoop(n1);
    }

    private static void isContainLoop(ListNodeLoop head) {
        if (head == null) {
            return;
        }
        boolean isLoop = false;
        int loop = 0;
        ListNodeLoop step1Node = head;
        ListNodeLoop step2Node = head;
        ListNodeLoop flag = null;
        while (step2Node.next != null && step2Node.next.next != null) {
            step1Node = step1Node.next;
            step2Node = step2Node.next.next;
            if (step1Node.equals(step2Node) && !isLoop) {
                isLoop = true;
                flag = step1Node;
                continue;
            }
            if (isLoop) {
                loop++;
            }
            if (step1Node.equals(flag)) {
                break;
            }
        }
        if (isLoop) {
            System.out.println("包含环");
            ListNodeLoop entrance = getEntrance(head, loop);
            System.out.println("环入口:" + entrance);
        } else {
            System.out.println("不包含环");
        }
    }

    private static ListNodeLoop getEntrance(ListNodeLoop head, int loop) {
        int i = 0;
        ListNodeLoop fNode = head;
        ListNodeLoop sNode = head;
        while (fNode.next != null) {
            i++;
            fNode = fNode.next;
            if (i > loop) {
                sNode = sNode.next;
            }
            if (sNode.equals(fNode)) {
                return sNode;
            }
        }
        return null;
    }


}

package com.tianwen.leetcode_2021.company.hwod;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2021年06月20日  22:03
 */
public class HuaWeiOD2 {

    // a1依赖a2，a2依赖a3    a3->a2->a1
    // a5依赖a6              a6->a5

    // a3->a2->a1  断开a2 剩下a3
    // a6->a5  断开a5 剩下a6

    public static void main(String[] args) {
        HuaWeiOD2 huaWeiOD2 = new HuaWeiOD2();
        List<String> serviceDependList = Arrays.asList("a1-a2", "a2-a3", "a5-a6");
        List<String> errorServiceList = Arrays.asList("a5","a6");
/*
        List<String> serviceDependList = Arrays.asList("a1-a2", "a2-a3", "a5-a6");
        List<String> errorServiceList = Arrays.asList("a5","a2");
*/
        System.out.println(huaWeiOD2.filter(serviceDependList, errorServiceList));
    }

    public List<String> filter(List<String> serviceDependList, List<String> errorServiceList) {
        List<Node> headList = buildHeadList(serviceDependList);
        List<Node> removeList = new ArrayList<>();
        errorServiceList.forEach(errorService -> {
            headList.forEach(head -> {
                Node node = head;
                Node pre = new Node();
                pre.next = node;
                while (Objects.nonNull(node)) {
                    if (errorService.equals(node.val)) {
                        if (pre.next.equals(head)) {
                            removeList.add(head);
                        } else {
                            pre.next = null;
                            break;
                        }
                    }
                    pre = pre.next;
                    node = node.next;
                }
            });
        });
        headList.removeAll(removeList);
        List<String> valList = new ArrayList<>();
        headList.forEach(head -> {
            Node node = head;
            while (Objects.nonNull(node)) {
                valList.add(node.val);
                node = node.next;
            }
        });
        return valList;
    }

    private List<Node> buildHeadList(List<String> serviceDependList) {
        List<Node> headList = new ArrayList<>();
        List<String> headValList = new ArrayList<>();
        for (String serviceDepend : serviceDependList) {
            String[] split = serviceDepend.split("-");
            Node node0 = new Node(split[0]);
            Node node1 = new Node(split[1]);
            if (headValList.contains(node0.val)) {
                Node node = getNode(headList, node0.val);
                node1.next = node;
                headValList.remove(node0.val);
                headList.remove(node);
            } else {
                node1.next = node0;
                headValList.add(node1.val);
            }
            headList.add(node1);
        }
        return headList;
    }

    private Node getNode(List<Node> headList, String val) {
        return headList.stream().filter(h -> h.val.equals(val)).findFirst().get();
    }


    @Data
    static class Node {

        public Node() {}

        public Node(String val) {
            this.val = val;
        }

        private Node next;
        private String val;

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Node) {
                Node node = (Node) o;
                return node.val.equals(this.val);
            }
            return false;
        }
    }
}

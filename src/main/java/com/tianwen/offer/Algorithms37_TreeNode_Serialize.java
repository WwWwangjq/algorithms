package com.tianwen.offer;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * wangjq
 * 2020年12月23日  21:27
 */
public class Algorithms37_TreeNode_Serialize {

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        TreeNode root = treeNode1;
        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode result = deserialize(serialize);
        System.out.println(result);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<Integer> valList = new ArrayList<>();
        serialize(root, valList);
        return Arrays.toString(valList.toArray()).replaceAll(" ", "");
    }

    private static void serialize(TreeNode node, List<Integer> valList) {
        if (node == null) {
            valList.add(null);
            return;
        }
        valList.add(node.val);
        serialize(node.left, valList);
        serialize(node.right, valList);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] dataArr = data.replace("[", "").replace("]", "").split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[i++]));
        deserialize(root, dataArr);
        return root;
    }

    private static int i = 0;
    private static void deserialize(TreeNode node, String[] dataArr) {
        if (i >= dataArr.length) {
            return;
        }
        String leftVal = dataArr[i++];
        if (!leftVal.equals("null")) {
            node.left = new TreeNode(Integer.parseInt(leftVal));
            deserialize(node.left, dataArr);
        }
        String rightVal = dataArr[i++];
        if (!rightVal.equals("null")) {
            node.right = new TreeNode(Integer.parseInt(rightVal));
            deserialize(node.right, dataArr);
        }
    }
}

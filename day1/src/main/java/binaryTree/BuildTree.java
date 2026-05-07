package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildTree<E> {
    public TreeNode<E> buildWithPreAndIn(ArrayList<E> pre, ArrayList<E> in){
        if (pre.isEmpty()){return null;}
        E head = pre.getFirst();
        for (int e = 0; e < in.size(); e++){
           if (in.get(e).equals(head)){
               ArrayList<E> inLeft = new ArrayList<>(in.subList(0, e));
               ArrayList<E> inRight = new ArrayList<>(in.subList(e + 1, in.size()));
               ArrayList<E> preLeft = new ArrayList<>(pre.subList(1, e + 1));
               ArrayList<E> preRight = new ArrayList<>(pre.subList(e + 1, pre.size()));

               TreeNode<E> left = buildWithPreAndIn(preLeft, inLeft);
               TreeNode<E> right = buildWithPreAndIn(preRight, inRight);
               return new TreeNode<>(head, left, right);
           }
        }
        throw new RuntimeException();
    }

    public TreeNode<E> buildWithEndAndIn(ArrayList<E> end, ArrayList<E> in){
        if (end.isEmpty()){return null;}
        E head = end.getLast();
        for (int e = 0; e < in.size(); e++){
            if (in.get(e).equals(head)){
                ArrayList<E> inLeft = new ArrayList<>(in.subList(0, e));
                ArrayList<E> inRight = new ArrayList<>(in.subList(e + 1, in.size()));
                ArrayList<E> endLeft = new ArrayList<>(end.subList(0, e));
                ArrayList<E> endRight = new ArrayList<>(end.subList(e, end.size() - 1));

                TreeNode<E> left = buildWithEndAndIn(endLeft, inLeft);
                TreeNode<E> right = buildWithEndAndIn(endRight, inRight);
                return new TreeNode<>(head, left, right);
            }
        }
        throw new RuntimeException();
    }
}

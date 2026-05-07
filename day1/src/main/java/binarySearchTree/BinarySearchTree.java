package binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class BinarySearchTree<K extends Comparable<K>, V> {
    BSTnode<K, V> head;

    public BinarySearchTree(BSTnode<K, V> head) {
        this.head = head;
    }

    public BSTnode<K, V> get(K key){
        BSTnode<K, V> node = head;
        while (node != null){
            if (key.compareTo(node.key) > 0){
                node = node.right;
            } else if (key.compareTo(node.key) < 0) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
    
    public void put(BSTnode<K, V> node){
        BSTnode<K, V> parent = null;
        BSTnode<K, V> current = head;
        while (current != null){
            if (node.key.compareTo(current.key) > 0){
                parent = current;
                current = current.right;
            } else if (node.key.compareTo(current.key) < 0) {
                parent = current;
                current = current.left;
            } else {
                current.value = node.value;
                return;
            }
        }
        
        if (parent == null){
            head = node;
            return;
        }
        
        if (node.key.compareTo(parent.key) > 0){
           parent.right = node;
        }else {
            parent.left = node;
        }
    }

    public BSTnode<K, V> getMax(){
        return getMax(head);
    }

    private BSTnode<K, V> getMax(BSTnode<K, V> node){
        BSTnode<K, V> current = node;
        while (current.right != null){
            current = current.right;
        }
        return current;
    }

    public BSTnode<K, V> getMin(){
        return getMin(head);
    }
    private BSTnode<K, V> getMin(BSTnode<K, V> node){
        BSTnode<K, V> current = node;
        while (current.left != null){
            current = current.left;
        }
        return current;
    }

    public BSTnode<K, V> getPreDecessor(K key) {
        BSTnode<K, V> preDecessor = null;
        BSTnode<K, V> current = head;
        while (current != null){
            if (key.compareTo(current.key) > 0){
                preDecessor = current;
                current = current.right;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                if (current.left != null) return getMax(current.left);
                return preDecessor;
            }
        }

        return null;
    }

    public BSTnode<K, V> getlatterDecessor(K key) {
        BSTnode<K, V> latterDecessor = null;
        BSTnode<K, V> current = head;
        while (current != null){
            if (key.compareTo(current.key) > 0){
                current = current.right;
            } else if (key.compareTo(current.key) < 0) {
                latterDecessor = current;
                current = current.left;
            } else {
                if (current.right != null) return getMin(current.right);
                return latterDecessor;
            }
        }
        return null;
    }

    public void delete(K key){
        BSTnode<K, V> node = head;
        BSTnode<K, V> parent = null;
        while (node != null){
            if (key.compareTo(node.key) > 0){
                parent = node;
                node = node.right;
            } else if (key.compareTo(node.key) < 0) {
                parent = node;
                node = node.left;
            } else {
                break;
            }
        }

        if (node == null) throw new RuntimeException("无对应节点！！！");

        if (node.left == null){
            shift(parent, node, node.right);
        }else if (node.right == null){
            shift(parent, node, node.left);
        }else {
            BSTnode<K, V> sParent = node;
            BSTnode<K, V> current = node.right;
            while (current.left != null) {
                sParent = current;
                current = current.left;
            }

            shift(sParent, current, current.right);
            current.left = node.left;
            current.right = node.right;
            shift(parent, node, current);

//            if (node.right == current) {
//                current.left = node.left;
//                shift(parent, node, current);
//            } else {
//                shift(sParent, current, current.right);
//                current.left = node.left;
//                current.right = node.right;
//                shift(parent, node, current);
//            }
        }
    }

    public ArrayList<BSTnode<K, V>> less(K key){
        ArrayList<BSTnode<K, V>> list = new ArrayList<>();
        BSTnode<K, V> node = head;
        Stack<BSTnode<K, V>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.key.compareTo(key) >= 0){
                break;
            }
            list.add(node);
            node = node.right;
        }
        return list;
    }

    public ArrayList<BSTnode<K, V>> more(K key){
        ArrayList<BSTnode<K, V>> list = new ArrayList<>();
        BSTnode<K, V> node = head;
        Stack<BSTnode<K, V>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            if (node.key.compareTo(key) <= 0){
                break;
            }
            list.add(node);
            node = node.left;
        }
        return list;
    }

    public ArrayList<BSTnode<K, V>> between(K min, K max){
        ArrayList<BSTnode<K, V>> list = new ArrayList<>();
        BSTnode<K, V> node = head;
        Stack<BSTnode<K, V>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.key.compareTo(min) >= 0 && node.key.compareTo(max) <= 0){
                list.add(node);
            }
            if (node.key.compareTo(max) > 0){
                break;
            }
            node = node.right;
        }
        return list;
    }

    public boolean isValid(){
        return doIsValid(head, null, null);
    }

    private boolean doIsValid(BSTnode<K, V> node, K min, K max){
        if (node == null){
            return true;
        }

        if (min != null && node.key.compareTo(min) <= 0){
            return false;
        }
        if (max != null && node.key.compareTo(max) >= 0){
            return false;
        }

        return doIsValid(node.left, min, node.key) &&
                doIsValid(node.right, node.key, max);
    }

    public boolean isValid2(){
        Stack<BSTnode<K, V>> stack = new Stack<>();
        BSTnode<K, V> node = head;
        BSTnode<K, V> parent = null;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (parent != null && parent.key.compareTo(node.key) >= 0) {
                return false;
            }
            parent = node;
            node = node.right;
        }
        return true;
    }

    public boolean isValid3(){
        AtomicInteger prev = new AtomicInteger(Integer.MIN_VALUE);
        return doIsValid3((BSTnode<Integer, V>) head, prev);
    }


    //除了使用原子类之外，还可以把prev放在方法之外，变成全局变量，这样的话，修改的也是同一份prev
    private boolean doIsValid3(BSTnode<Integer, V> node, AtomicInteger prev){
        if (node == null){
            return true;
        }
        boolean left = doIsValid3(node.left, prev);
        if (!left) return false;

        if (prev.get() >= node.key){
            return false;
        }
        prev.set(node.key);
        return doIsValid3(node.right, prev);
    }

    int i = 0;
    public BSTnode<Integer, V> structByPreTranserval(int[] keys){
        i = 0;
        return insert(keys, Integer.MAX_VALUE);
    }

    private BSTnode<Integer, V> insert(int[] keys, int max){
        if (i >= keys.length){
            return null;
        }
        int key = keys[i];

        if (key >= max){
            return null;
        }

        BSTnode<Integer, V> node = new BSTnode<>(key, null);
        i++;
        node.left = insert(keys, key);
        node.right = insert(keys, max);
        return node;
    }

    private void shift(BSTnode<K, V> parent, BSTnode<K, V> node, BSTnode<K, V> replace){
        if (parent == null){
            head = replace;
        } else if(parent.left == node){
            parent.left = replace;
        } else if (parent.right == node) {
            parent.right = replace;
        } else {
            throw new RuntimeException("父节点无对应子节点！！！");
        }
    }
}

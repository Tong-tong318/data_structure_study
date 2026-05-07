package binarySearchTree;

public class BSTnode<K extends Comparable<K>,V> {

    K key;
    V value;
    BSTnode<K,V> left;
    BSTnode<K,V> right;

    public BSTnode(K key, V value, BSTnode<K, V> left, BSTnode<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BSTnode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public BSTnode(BSTnode<K, V> node){
        this.key = node.key;
        this.value = node.value;
        this.left = node.left;
        this.right = node.right;
    }
}

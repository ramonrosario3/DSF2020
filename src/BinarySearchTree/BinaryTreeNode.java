package BinarySearchTree;

public interface BinaryTreeNode<E> extends TreeNode<E> {
    public BinaryTreeNode<E> getParent();
    public  BinaryTreeNode<E> getLeftChild();
    public BinaryTreeNode<E> getRightChild();
}

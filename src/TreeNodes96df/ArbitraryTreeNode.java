package TreeNodes96df;

public class ArbitraryTreeNode<E> extends AbstractTreeNode<E> {
    private E key;
    private final TreeNode<E>[] children;

    @SuppressWarnings("unchecked")
    public ArbitraryTreeNode(int numberOfChildren) {
        children = (TreeNode<E>[]) new TreeNode[numberOfChildren];
    }

    public int getNumberOfChildren() {
        return children.length;
    }

    public TreeNode<E> getChild(int childIndex) {
        return children[childIndex];
    }

    public void setChild(int childIndex, TreeNode<E> child) {
        children[childIndex] = child;
    }

}


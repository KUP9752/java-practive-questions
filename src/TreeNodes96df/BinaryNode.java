package TreeNodes96df;

import java.util.NoSuchElementException;

public class BinaryNode<E> extends AbstractTreeNode<E>{
    private TreeNode<E> first, second;

    public BinaryNode(TreeNode<E> first, TreeNode<E> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int getNumberOfChildren() {
        return 2;
    }

    @Override
    public TreeNode<E> getChild(int childIndex) {
        assert childIndex >= 0 && childIndex < 2;
        return switch (childIndex) {
            case 0 -> first;
            case 1 -> second;
            default -> throw new NoSuchElementException();
        };
    }

    @Override
    public void setChild(int childIndex, TreeNode<E> child) {
        assert childIndex >= 0 && childIndex < 2;
        switch (childIndex) {
            case 0 -> first = child;
            case 1 -> second = child;
        };
    }
}

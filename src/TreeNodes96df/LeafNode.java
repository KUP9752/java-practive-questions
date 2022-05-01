package TreeNodes96df;

public class LeafNode<E> extends AbstractTreeNode<E>{

    public LeafNode() {
        super();
    }

    @Override
    public int getNumberOfChildren() {
        return 0;
    }

    @Override
    public TreeNode<E> getChild(int childIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setChild(int childIndex, TreeNode<E> child) {
    }

}

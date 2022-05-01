package TreeNodes96df;

public abstract class AbstractTreeNode<E> implements TreeNode<E>{

    private E key;

    @Override
    public final E getKey() {
        return key;
    }

    @Override
    public final void setKey(E key) {
        this.key = key;
    }
}

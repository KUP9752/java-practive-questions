package TreeNodes96df;

public interface TreeNode<E> {

    public int getNumberOfChildren();

    public TreeNode<E> getChild(int childIndex);

    public void setChild(int childIndex, TreeNode<E> child);

    public E getKey();

    public void setKey(E key);
}

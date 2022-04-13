package CloningGraphs1171;
import java.util.*;

public class GraphNode<E> implements Cloneable {

    private E key;
    private final List<GraphNode<E>> successors;

    public GraphNode() {
        successors = new ArrayList<>();
    }

    public GraphNode<E> clone() {

        Map<GraphNode<E>, GraphNode<E>> oldToNew = new HashMap<>();
        Deque<GraphNode<E>> stack = new ArrayDeque<>();
        stack.add(this);

        GraphNode<E> old;
        GraphNode<E> newNode;


        while (!stack.isEmpty()) {
            old = stack.pop();
            if (!oldToNew.containsKey(old)) {
                newNode = old.internalNode();
                oldToNew.put(old, newNode);
                stack.addAll(old.getSuccessors());
            }
        }
        // Now the search is completed

        oldToNew.keySet().forEach(
                oldNode -> {
                    List<GraphNode<E>> sucs = oldNode.getSuccessors();
                    for (GraphNode<E> suc : sucs) {
                        oldToNew.get(oldNode).addSuccessor(oldToNew.get(suc));
                    }
                }
        );
        return oldToNew.get(this);
    }

    private GraphNode<E> internalNode() {
        GraphNode<E> clone;
        try {
            clone = (GraphNode<E>) super.clone();
            clone.resetSuccessors();
            return clone;
        } catch (CloneNotSupportedException e ) {
            e.getLocalizedMessage();
            return null; // never reached
        }
    }

    private void resetSuccessors() {
        successors.clear();
    }
    public int getNumberOfSuccessors() {
        return successors.size();
    }

    public List<GraphNode<E>> getSuccessors(){
        return successors;
    }

    public GraphNode<E> getSuccessor(int successorIndex) {
        return successors.get(successorIndex);
    }

    public void addSuccessor(GraphNode<E> successor) {
        successors.add(successor);
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public static void main(String[] args) {

        // Make some nodes
        GraphNode<String> original = new GraphNode<String>();
        original.setKey("Hello");
        GraphNode<String> child1 = new GraphNode<String>();
        child1.setKey("Child 1");
        GraphNode<String> child2 = new GraphNode<String>();
        child1.setKey("Child 2");

        // Join them up
        original.addSuccessor(child1);
        original.addSuccessor(child2);
        child1.addSuccessor(original); // Creates a cycle
        child2.addSuccessor(original); // Creates a cycle

        // Clone original
        GraphNode<String> clone = original.clone();

        // Check that the clone uses distinct nodes
        assert original != clone;
        assert original.getSuccessor(0) != clone.getSuccessor(0);
        assert original.getSuccessor(1) != clone.getSuccessor(1);
        assert original.getSuccessor(0).getSuccessor(0) != clone.getSuccessor(0).getSuccessor(0);
        assert original.getSuccessor(1).getSuccessor(0) != clone.getSuccessor(1).getSuccessor(0);

        // Check that original has cycles
        assert original.getSuccessor(0).getSuccessor(0) == original;
        assert original.getSuccessor(1).getSuccessor(0) == original;

        // Check that clone has corresponding cycles
        assert clone.getSuccessor(0).getSuccessor(0) == clone;
        assert clone.getSuccessor(1).getSuccessor(0) == clone;

        // Check that original and clone share same keys
        assert original.getKey() == clone.getKey();
        assert original.getSuccessor(0).getKey() == clone.getSuccessor(0).getKey();
        assert original.getSuccessor(1).getKey() == clone.getSuccessor(1).getKey();

    }
}

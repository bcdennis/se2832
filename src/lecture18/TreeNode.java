/**
 * SE2832
 * Spring 2016
 * Week 9
 */
package lecture18;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Represents the tree node.
 *
 * @param <E> the type of values stored in the node.
 * @author Brad Dennis, Ph.D.
 * @version 1.0
 */
public class TreeNode<E> {
    private E value;
    private boolean hasParent;
    private List<TreeNode<E>> children;


    /**
     * Constructs the TreeNode.
     *
     * @param value the value to store in the node.
     */
    public TreeNode(E value) {
        this.value = value;
        children = new ArrayList<>();
    }

    /**
     * Checks to see if the value is contained in the tree.
     *
     * @param value the value to look for.
     * @return true if it is contained.
     */
    public boolean contains(E value) {
        boolean wasFound = false;

        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            TreeNode<E> node = stack.pop();

            if (node.value.equals(value)) {
                wasFound = true;
                break;
            }

            for (TreeNode<E> t : node.children) {
                stack.push(t);
            }
        }

        return wasFound;
    }
    /**
     * Adds a child to the tree node.
     *
     * @param child the child to add.
     */
    public void addChild(TreeNode<E> child) {

        if (child == null) {
            throw new IllegalArgumentException("Child cannot be null.");
        }

        if (child.hasParent) {
            throw new IllegalArgumentException("Child already has a parent.");
        }

        child.hasParent = true;
        children.add(child);
    }

    /**
     * Returns the height of the tree.
     *
     * @return the height of the tree.
     */
    public int height() {
        return preorder(this, 0, 0);
    }

    // this node is visited before child nodes.
    private int preorder(TreeNode<E> node, int height, int maxHeight) {
        height++;
        System.out.println(node.value);

        if (maxHeight < height) {
            maxHeight  = height;
        }

        if(node.children.size() == 0) {
            return maxHeight;
        }

        for(TreeNode<E> child : node.children) {
            maxHeight = preorder(child, height, maxHeight);
        }

        return maxHeight;
    }

    /**
     * Traverses the tree in depth first order.
     *
     * @return returns a list of values in DF order.
     */
    public List<E> depthFirst() {
        List<E> values = new ArrayList<>();

        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            TreeNode<E> node = stack.pop();
            values.add(node.value);
            for (TreeNode<E> t : node.children) {
                stack.push(t);
            }
        }

        return values;
    }

    public static void main(String[] args) {
        TreeNode<String> a = new TreeNode<>("A");
        TreeNode<String> b = new TreeNode<>("B");
        TreeNode<String> c= new TreeNode<>("C");
        TreeNode<String> d = new TreeNode<>("D");
        TreeNode<String> e = new TreeNode<>("E");
        TreeNode<String> f = new TreeNode<>("F");
        TreeNode<String> g = new TreeNode<>("G");

        b.addChild(c);
        b.addChild(d);
        e.addChild(f);
        f.addChild(g);

        a.addChild(e);
        a.addChild(b);


        System.out.println(a.depthFirst());
    }
}
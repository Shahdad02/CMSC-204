/**
 * TreeNode class for Linked Trees
 * @author Shahdad Parsi
 * @param <T>
 */
public class TreeNode<T> {
    private final T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    /**
     * TreeNode constructor
     * Creates a TreeNode and sets left and right to null
     * @param dataNode
     */
    public TreeNode(T dataNode) {
        data = dataNode;
        left = null;
        right = null;
    }

    /**
     * Deep copy
     * @param node
     */
    public TreeNode(TreeNode<T> node){
        this(node.left, node.right, node.getData());
    }

    /**
     * copy constructor threw error telling me to make this constructor
     * setting the data in the TreeNode also its left and right child
     * @param left
     * @param right
     * @param data
     */
    public TreeNode(TreeNode<T> left, TreeNode<T> right, T data) {
        this.data = data;
        this.left = new TreeNode<>(left);
        this.right = new TreeNode<>(right);
    }

    /**
     * Returns data in the Treenode
     * @return data in the TreeNode
     */
    public T getData() {
        return data;
    }
}

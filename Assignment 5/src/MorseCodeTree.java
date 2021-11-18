import java.util.ArrayList;

/**
 * MorseCodeTree class used to change from morse code to english
 * @author Shahdad Parsi
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root;

    /**
     * MorseCode Tree constructor
     * calls buildTree() method
     */
    public MorseCodeTree() {
        buildTree();
    }

    /**
     * Returns a reference to the root
     * @return reference to root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Sets the root of the tree
     * @param newNode a TreeNode<T> that will be the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    /**
     * Adds to the correct position of the tree
     * @param code the code for the new node to be added
     * @param letter
     * @return current object
     */
    @Override
    public MorseCodeTree insert(String code, String letter) {
        if(root == null) {
            root = new TreeNode<>(letter);
        }else {
            addNode(root, code, letter);
        }
        return this;
    }

    /**
     * Adds to the correct position of the tree, a "-" goes right and a "." goes left
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if(code.length() > 1) {
            if(code.charAt(0) == '-') {
                addNode(root.right, code.substring(1), letter);
            }else {
                addNode(root.left, code.substring(1), letter);
            }
        }else {
            if(code.charAt(0) == '.') {
                root.left = new TreeNode<>(letter);
            }else {
                root.right = new TreeNode<>(letter);
            }
        }
    }

    /**
     * Fetch the data node from the tree
     * @param code the code that describes the traversals within the tree
     * @return string version of what corresponds with the code
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * Fetch the data node of the TreeNode. A "." goes right a "-" goes left
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return string version of what correlates with the code
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        String str = "";
        if(code.length() > 1) {
            if(code.charAt(0) == '.') {
                str += fetchNode(root.left, code.substring(1));
            }else {
                str += fetchNode(root.right, code.substring(1));
            }
        }else {
            if(code.charAt(0) == '.') {
                str += root.left.getData();
            }else {
                str += root.right.getData();
            }
            return str;
        }
        return str;
    }

    /**
     * Isn't supported in MorseCodeTree
     * @param data data of node to be deleted
     * @return current tree reference
     * @throws UnsupportedOperationException
     */
    @Override
    public MorseCodeTree delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Isn't supported in MorseCodeTree
     * @return current tree reference
     * @throws UnsupportedOperationException
     */
    @Override
    public MorseCodeTree update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * builds the MorseCodeTree by inserting the nodes
     * had to look at doc provided for this
     */
    @Override
    public void buildTree() {
        insert("","");

        insert(".","e");
        insert("-","t");


        insert("..","i");
        insert(".-","a");
        insert("-.","n");
        insert("--","m");


        insert("...","s");
        insert("..-","u");
        insert(".-.","r");
        insert(".--","w");
        insert("-..","d");
        insert("-.-","k");
        insert("--.","g");
        insert("---","o");

        insert("....","h");
        insert("...-","v");
        insert("..-.","f");
        insert(".-..","l");
        insert(".--.","p");
        insert(".---","j");
        insert("-...","b");
        insert("-..-","x");
        insert("-.-.","c");
        insert("-.--","y");
        insert("--..","z");
        insert("--.-","q");
    }

    /**
     * Returns arraylist of the items in the linked tree
     * @return arraylist of the items in the tree
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> arr = new ArrayList<>();
        LNRoutputTraversal(root, arr);
        return arr;
    }

    /**
     * puts the tree in arraylist in LNR
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if(root == null) {
            return;
        }else {
            LNRoutputTraversal(root.left, list);
            list.add(root.getData());
            LNRoutputTraversal(root.right, list);
        }
    }

}

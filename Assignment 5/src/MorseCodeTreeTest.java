import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MorseCodeTreeTest {
    MorseCodeTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new MorseCodeTree();
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
    }

    @Test
    public void getRoot() {
        assertEquals(tree.getRoot().getData(), "");
    }

    @Test
    public void setRoot() {
        TreeNode<String> root = new TreeNode<String>("a");
        tree.setRoot(root);
        assertEquals(tree.getRoot(), root);
    }

    @Test
    public void insert() {
        tree.insert(".","e");
        tree.insert("-","t");
        assertEquals(tree.fetch("."), "e");
        assertEquals(tree.fetch("-"), "t");
    }

    @Test
    public void fetch() {
        tree.insert(".","e");
        assertEquals(tree.fetch("."), "e");
        tree.insert("-","t");
        assertEquals(tree.fetch("-"), "t");
    }

    @Test
    public void toArrayList() {
        ArrayList<String> arr = tree.toArrayList();
        assertEquals(arr.get(0), "h");
        assertEquals(arr.get(1), "s");
    }
}
/**
 * SE2832
 * Spring 2016
 * Week 9
 */
package lecture18;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Tests the tree node class.
 *
 * @author Brad Dennis, Ph.D.
 * @version 1.0
 */
public class TreeNodeTest {

    TreeNode<String> root;

    @Before
    public void setUp() throws Exception {
        root = new TreeNode<>("root");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddingOneValueIsInTree() throws Exception {
        assertTrue(root.contains("root"));
    }

}
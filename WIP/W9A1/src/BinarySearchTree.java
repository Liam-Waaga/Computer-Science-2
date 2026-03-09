public class BinarySearchTree<T extends Comparable<T>> {
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;
    Number x;
    Integer y;
    Long q;
    Double z;
    Boolean w;

    T obj;

    public BinarySearchTree() {
        this.left = null;
        this.right = null;
        this.obj = null;
    }

    private BinarySearchTree(T obj) {
        this.obj = obj;
    }

    public void insert(T obj) {
        BinarySearchTree<T> curr = this;
        if (curr.obj == null) {
            curr.obj = obj;
            return;
        }
        while (true) {
            if (curr.obj.compareTo(obj) > 0) {
                if (curr.left == null) {
                    curr.left = new BinarySearchTree<T>(obj);
                }
                curr = curr.left;
                return;
            } else if (curr.obj.compareTo(obj) < 0) {
                if (curr.right == null) {
                    curr.right = new BinarySearchTree<T>(obj);
                }
                curr = curr.right;
                return;
            } else {
                throw new IllegalArgumentException("value exists already in BST");
            }
        }
    }

    public void insertOrReplace(T obj) {
        BinarySearchTree<T> curr = this;
        if (curr.obj == null) {
            curr.obj = obj;
            return;
        }
        while (true) {
            if (curr.obj.compareTo(obj) > 0) {
                if (curr.left == null) {
                    curr.left = new BinarySearchTree<T>(obj);
                }
                curr = curr.left;
                return;
            } else if (curr.obj.compareTo(obj) < 0) {
                if (curr.right == null) {
                    curr.right = new BinarySearchTree<T>(obj);
                }
                curr = curr.right;
                return;
            } else {
                curr.obj = obj;
            }
        }
    }

}

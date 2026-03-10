
public class BinarySearchTree<K extends Comparable<K>, T> {
    private BinarySearchTree<K, T> left;
    private BinarySearchTree<K, T> right;

    T obj;
    K key;

    public BinarySearchTree() {
        this.left = null;
        this.right = null;
        this.obj = null;
    }

    private BinarySearchTree(K key, T obj) {
        this.obj = obj;
        this.key = key;
    }

    public void insert(K key, T obj) {
        BinarySearchTree<K, T> curr = this;
        if (curr.key == null) {
            curr.key = key;
            return;
        }
        while (true) {
            if (curr.key.compareTo(key) > 0) {
                if (curr.left == null) {
                    curr.left = new BinarySearchTree<K, T>(key, obj);
                }
                curr = curr.left;
                return;
            } else if (curr.key.compareTo(key) < 0) {
                if (curr.right == null) {
                    curr.right = new BinarySearchTree<K, T>(key, obj);
                }
                curr = curr.right;
                return;
            } else {
                throw new IllegalArgumentException("value exists already in BST");
            }
        }
    }

    public void insertOrReplace(K key, T obj) {
        BinarySearchTree<K, T> curr = this;
        if (curr.obj == null) {
            curr.obj = obj;
            return;
        }
        while (true) {
            if (curr.key.compareTo(key) > 0) {
                if (curr.left == null) {
                    curr.left = new BinarySearchTree<K, T>(key, obj);
                }
                curr = curr.left;
                return;
            } else if (curr.key.compareTo(key) < 0) {
                if (curr.right == null) {
                    curr.right = new BinarySearchTree<K, T>(key, obj);
                }
                curr = curr.right;
                return;
            } else {
                curr.obj = obj;
            }
        }
    }

    public T find(K key) {
        BinarySearchTree<K, T> curr = this;
        while (curr != null) {
            if (curr.key.compareTo(key) < 0) {
                curr = curr.left;
            }
            if (curr.key.compareTo(key) > 0) {
                curr = curr.right;
            }
            if (curr.key.compareTo(key) == 0) {
                return curr.obj;
            }
        }
        return null;
    }

    public T remove(K key) {
        /* handle removing root */
        if (this.key.compareTo(key) == 0) {
            if (this.left != null && this.right != null) {
                /* minimum value to the right of the node */
                BinarySearchTree<K, T> min = this.right;
                BinarySearchTree<K, T> prev = this.right;
                while (min.left != null) {
                    prev = min;
                    min = min.left;
                }
                /* remove the old node */
                prev.left = null;
                /* copy the important bits */
                this.key = min.key;
                this.obj = min.obj;

            } else if (this.right != null) {
                /* copy the important bits */
                this.left = this.right.left;
                T obj1 = this.obj;
                this.obj = this.right.obj;
                this.key = this.right.key;
                this.right = this.right.right;
                return obj1;
            } else if (this.left != null) {
                /* copy the important bits */
                this.right = this.left.right;
                T obj1 = this.obj;
                this.obj = this.left.obj;
                this.key = this.left.key;
                this.left = this.left.left;
                return obj1;
            } else {
                /* no children, ez */
                T obj1 = this.obj;
                this.obj = null;
                return obj1;
            }
        }
        BinarySearchTree<K, T> curr = this;
        boolean left = false;
        BinarySearchTree<K, T> parent = curr;
        while (curr != null) {
            /* find it first */
            if (curr.key.compareTo(key) < 0) {
                parent = curr;
                curr = curr.left;
                left = true;
            }
            if (curr.key.compareTo(key) > 0) {
                parent = curr;
                curr = curr.right;
                left = false;
            }
            if (curr.key.compareTo(key) == 0) {
                /* once found, do removal logic just like we did above */
                if (curr.left != null && curr.right != null) {
                    BinarySearchTree<K, T> min = curr.right;
                    BinarySearchTree<K, T> prev = curr.right;
                    while (min.left != null) {
                        prev = min;
                        min = min.left;
                    }
                    prev.left = null;
                    curr.key = min.key;
                    curr.obj = min.obj;

                } else if (curr.left != null) {
                    if (left) {
                        parent.left = curr.left;
                    } else {
                        parent.right = curr.left;
                    }
                } else if (curr.right != null) {
                    if (left) {
                        parent.left = curr.right;
                    } else {
                        parent.right = curr.right;
                    }
                } else {
                    if (left) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
                return curr.obj;
            }
        }
        /* wasn't found */
        throw new IllegalArgumentException();
    }

    public T removeOrNull(K key) {
        try {
            return remove(key);
        } catch (Throwable t) {
            return null;
        }
    }
}

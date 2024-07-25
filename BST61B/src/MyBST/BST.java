package MyBST;

class BST<Key> {
    private Key key;
    private BST left;
    private BST right;

    BST(Key key) {
        this.key = key;
    }

    BST(Key key, BST<Key> left, BST<Key> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    static BST find(BST tree, <Key> sk){
        return null;
    }

}

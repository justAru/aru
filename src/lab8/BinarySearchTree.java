package lab8;

public class BinarySearchTree {
    Node root;

    public void add(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverse(focusNode.rightChild);
        }
    }

    public void preorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }

    public boolean delete(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while (focusNode.key != key) {
            parent = focusNode;
            if (key < focusNode.key) {
                isItALeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return false;
        }
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (focusNode.rightChild == null) {
            if (focusNode == root)
                root = focusNode.leftChild;

            else if (isItALeftChild)
                parent.leftChild = focusNode.leftChild;
            else
                parent.rightChild = focusNode.leftChild;
        } else if (focusNode.leftChild == null) {
            if (focusNode == root)
                root = focusNode.rightChild;
            else if (isItALeftChild)
                parent.leftChild = focusNode.rightChild;
            else
                parent.rightChild = focusNode.rightChild;
        } else {
            Node replecement = getReplecementNode(focusNode);
            if (focusNode == root)
                root = replecement;
            else if(isItALeftChild)
                parent.leftChild = replecement;
            else
                parent.rightChild = replecement;
            replecement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public Node getReplecementNode(Node replacedNode){
        Node replacementParent = replacedNode;
        Node replecement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while (focusNode != null){
            replacementParent = replecement;
            replecement = focusNode;
            focusNode = focusNode.leftChild;
        }
        if(replecement != replacedNode.rightChild){
            replacementParent.leftChild = replecement.rightChild;
            replecement.rightChild = replacedNode.rightChild;
        }
        return replecement;

    }



    public static void main (String[]args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50, "Boss");
        tree.add(5, "Girl");
        tree.add(89, "Baby");
        tree.add(3, "Child");
        tree.add(67, "Mother");
        tree.add(12, "Brother");
        tree.add(18, "Sister");


        tree.preorderTraverseTree(tree.root);
        System.out.println("------------");
        tree.inOrderTraverse(tree.root);
        System.out.println("------------");
        tree.postOrderTraverseTree(tree.root);

        System.out.println("\nSearch for 89");
        System.out.println(tree.findNode(89));

        System.out.println("\nRemove key: 5");
        tree.delete(5);
        tree.inOrderTraverse(tree.root);



    }
}


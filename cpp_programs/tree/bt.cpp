struct Node {
    int value;
    struct Node *left;
    struct Node *right;

    Node(int val) {
        value = val;
    }
};

int main() {
    struct Node *root = new Node(2);
    root->left = new Node(3);
    root->left->right = new Node(5);
    root->right = new Node(4);

    return 0;
}
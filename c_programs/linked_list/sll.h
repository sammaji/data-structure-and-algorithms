struct _node {
    int value;
    struct _node *next;
};

struct singly_linked_list {
    struct _node *head;
    int size;
};

void init(struct singly_linked_list *sll);

void add_first(struct singly_linked_list *sll, int element);
void add_last(struct singly_linked_list *sll, int element);
void add_at(struct singly_linked_list *sll, int element, int index);

void delete_first(struct singly_linked_list *sll);
void delete_last(struct singly_linked_list *sll);
void delete_at(struct singly_linked_list *sll, int index);

int get_at(struct singly_linked_list *sll, int index);

int find(struct singly_linked_list *sll, int element);

void display(struct singly_linked_list *sll);
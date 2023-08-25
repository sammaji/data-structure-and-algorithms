struct _node {
    int value;
    struct _node *next;
    struct _node *prev;
};

struct doubly_linked_list {
    struct _node *head;
    struct _node *tail;
    int size;
};

void init(struct doubly_linked_list *dll);

void add_first(struct doubly_linked_list *dll, int element);
void add_last(struct doubly_linked_list *dll, int element);
void add_at(struct doubly_linked_list *dll, int element, int index);

int delete_first(struct doubly_linked_list *dll);
int delete_last(struct doubly_linked_list *dll);
int delete_at(struct doubly_linked_list *dll, int index);

int get_at(struct doubly_linked_list *dll, int index);

int find(struct doubly_linked_list *dll, int element);

void display(struct doubly_linked_list *dll);
void display_reverse(struct doubly_linked_list *dll);

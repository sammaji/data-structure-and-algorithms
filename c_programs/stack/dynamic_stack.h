struct Node
{
    int value;
    struct Node *next;    
};

struct DynamicStack
{
    struct Node *top;
    int size;
};

void init(struct DynamicStack *s);

void push(struct DynamicStack *s, int element);

int peek(struct DynamicStack *s);

int pop(struct DynamicStack *s);

int is_empty(struct DynamicStack *s);

void display(struct DynamicStack *s);

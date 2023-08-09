#ifndef MAX_STACK_SIZE
    #define MAX_STACK_SIZE 999
#endif

struct Stack
{
    int stack[MAX_STACK_SIZE];
    int top;
};

void init(struct Stack *s);

void push(struct Stack *s, int element);

int pop(struct Stack *s);

int display(struct Stack *s);

#include <stdio.h>
#include "stack.h"

void init(struct Stack *s) {
    s->top = -1;
}

void push(struct Stack *s, int element) {
    if (s->top < MAX_STACK_SIZE - 1) {
        s->top++;
        s->stack[s->top] = element;
    } else {
        printf("Stack is full. Cannot push %d.\n", element);
    }
}

int pop(struct Stack *s) {
    if (s->top < 0) return -1;
    return s->stack[s->top--];
}

int display(struct Stack *s) {
    if (s->top < 0) printf("Stack is empty\n"); 

    printf("TOP -> ");
    for (int i = s->top; i >= 0 ; i--) {
        printf("%d -> ", s->stack[i]);
    }
    printf("END");
}
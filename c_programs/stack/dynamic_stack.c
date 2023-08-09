#include <stdio.h>
#include <stdlib.h>
#include "dynamic_stack.h"

void init(struct DynamicStack *s) {
    s->top = NULL;
    s->size = 0;
}

void push(struct DynamicStack *s, int element) {
    struct Node *n = (struct Node *)malloc(sizeof(struct Node));

    if (n == NULL) {
        printf("Memory allocation failed");
        return;
    }

    n->value = element;
    n->next = s->top;
    s->top = n;
    s->size++;
}

int pop(struct DynamicStack *s) {
    if (s->top == NULL) {
        return -1;
    }
    int value = s->top->value;
    struct Node *temp = s->top;
    s->top = s->top->next;
    s->size--;
    free(temp);
    return value;
}

int peek(struct DynamicStack *s) {
    if (s->top == NULL) return -1;
    return s->top->value;
}

int is_empty(struct DynamicStack *s) {
    return s->top == NULL;
}

void display(struct DynamicStack *s) {
    printf("TOP -> ");
    struct Node *c = s->top;

    while(c != NULL) {
        printf("%d -> ", c->value);
        c = c->next;
    }

    printf("END\n");
}
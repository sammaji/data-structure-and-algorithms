#include <stdio.h>

#define MAX_STACK_SIZE 10

int stack[MAX_STACK_SIZE]; int top = -1;

void push(int element);
int pop(void);

void display(void);

int main() {
    push(10);
    push(20);
    push(30);
    display();
    pop();
    pop();
    push(40);
    display();
    return 0;
}

void push(int element) {
    if (top >= MAX_STACK_SIZE) {
        printf("Stack Overflow: Cannot push more than MAX_STACK_SIZE {%d}", MAX_STACK_SIZE);
    }
    stack[++top] = element;
}

int pop() {
    if (top >= 0) return stack[top--];
    printf("Stack is empty.\n");
    return -1;
}

void display() {
    if (top < 0) printf("Stack is empty.\n");

    printf("TOP -> ");
    unsigned size = sizeof(stack) / sizeof(stack[0]);
    for (int i = top; i >= 0; i--) {
        printf("%d -> ", stack[i]);
    }
    printf("END\n");
}
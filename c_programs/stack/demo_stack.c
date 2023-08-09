/**
 * @author: Samyabrata Maji (@samyabrata-maji)
 * short demo using the stack lib
 * compile: gcc -o demo demo_stack.c stack.c;
 */
#include <stdio.h>
#include "stack.h"

void main()
{
    // initialize stack
    struct Stack stack;
    init(&stack);

    // populate stack
    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 30);

    while (1)
    {
        int input, element;
        printf("\n---------------\n\n1 = Push\n2 = Pop\n3 = Display\n\nEnter Your Choice: ");
        scanf("%d", &input);

        switch (input)
        {
        case -1:
            return;

        case 1:
            printf("Enter Element: ");
            scanf("%d", &element);
            push(&stack, element);
            break;

        case 2:
            int p_element = pop(&stack);
            printf("%d popped\n", p_element);
            break;

        case 3:
            display(&stack);
            break;
        }
    }
}
/**
 * @author Samyabrata Maji (@sammaji15)
 * problem: Given a pointer to the head node of a linked list, the task is to reverse the linked list.
*/
#include <stdio.h>
#include "../sll.h"

void reverse(struct singly_linked_list *sll);

void reverse(struct singly_linked_list *sll) {
    struct _node *prev = NULL;
    struct _node *curr = sll->head;
    struct _node *next = NULL;

    while (curr != NULL) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    sll->head = prev;
}

void main() {
    struct singly_linked_list sll;
    init(&sll);
    add_first(&sll, 10);
    add_first(&sll, 16);
    add_first(&sll, 32);
    add_first(&sll, 5);
    add_first(&sll, 9);
    display(&sll);
    reverse(&sll);
    display(&sll);
}
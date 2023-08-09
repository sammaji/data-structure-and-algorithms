#include <stdio.h>
#include <stdlib.h>
#include "sll.h"

void init(struct singly_linked_list *sll) {
    sll->head = NULL;
    sll->size = 0;
}

void add_first(struct singly_linked_list *sll, int element) {
    struct _node *n = (struct _node *)malloc(sizeof(struct _node));
    
    n->value = element;
    n->next = sll->head;
    sll->head = n;

    sll->size++;
}

void add_last(struct singly_linked_list *sll, int element) {
    struct _node *n = (struct _node *)malloc(sizeof(struct _node));
    n->value = element;

    struct _node *temp = sll->head;
    while(temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = n;
    sll->size++;
}

void add_at(struct singly_linked_list *sll, int element, int index) {
    if (index < 0 || index >= sll->size) return;
    if (index == 0) {
        add_first(sll, element);
        return;
    }
    
    struct _node *n = (struct _node *)malloc(sizeof(struct _node));
    n->value = element;

    struct _node *temp = sll->head;
    for(int i=1; i<index; i++) {
        temp = temp->next;
    }

    n->next = temp->next;
    temp->next = n;
    sll->size++;
}

void delete_first(struct singly_linked_list *sll) {
    struct _node *temp = sll->head;
    sll->head = temp->next;
    temp->next = NULL;
    free(temp);
}

void delete_last(struct singly_linked_list *sll) {
    struct _node *temp = sll->head;
    struct _node *prev_temp = sll->head;
    while (temp->next != NULL) {
        if (temp->next->next != NULL) prev_temp = prev_temp->next;
        temp = temp->next;
    }
    prev_temp->next = NULL;
    free(temp);
}
void delete_at(struct singly_linked_list *sll, int index) {
    if (index < 0 || index >= sll->size) return;
    if (index == 0) {
        delete_first(sll);
        return;
    }
    if (index == sll->size - 1) {
        delete_last(sll);
        return;
    }

    struct _node *temp = sll->head;
    struct _node *prev_temp = sll->head;
    for (int i=1; i<index; i++) {
        prev_temp = prev_temp->next;
    }
    temp = prev_temp->next;
    prev_temp->next = temp->next;
    temp->next = NULL;
    free(temp);
}

int get_at(struct singly_linked_list *sll, int index) {
    if (index < 0 || index >= sll->size) return -1;
    struct _node *temp = sll->head;
    for (int i=0; i<index; i++) {
        temp = temp->next;
    }
    return temp->value;
}

int find(struct singly_linked_list *sll, int element) {
    int index = 0;
    struct _node *temp = sll->head;
    while(temp->next != NULL) {
        if (temp->value == element) {
            return index;
        }
        index++;
        temp = temp->next;
    }
    return -1;
}

void display(struct singly_linked_list *sll) {
    printf("START -> ");
    struct _node *temp = sll->head;
    while(temp != NULL) {
        printf("%d -> ", temp->value);
        temp = temp->next;
    }
    printf("END\n");
};
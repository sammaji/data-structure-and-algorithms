#include <stdio.h>
#include <stdlib.h>
#include "dll.h"

void init(struct doubly_linked_list *dll)
{
    dll->size = 0;
    dll->head = NULL;
    dll->tail = NULL;
};

void add_first(struct doubly_linked_list *dll, int element)
{
    struct _node *n = (struct _node *)malloc(sizeof(struct _node *));
    n->value = element;

    if (dll->head == NULL || dll->tail == NULL)
    {
        dll->head = n;
        dll->tail = n;
        dll->size = 1;
        return;
    }

    n->next = dll->head;
    dll->head->prev = n;
    dll->head = n;
    dll->size++;
};

void add_last(struct doubly_linked_list *dll, int element)
{
    struct _node *n = (struct _node *)malloc(sizeof(struct _node *));
    n->value = element;

    if (dll->head == NULL || dll->tail == NULL)
    {
        dll->head = n;
        dll->tail = n;
        dll->size = 1;
        return;
    }

    n->prev = dll->tail;
    dll->tail->next = n;
    dll->tail = n;
    dll->size++;
};

void add_at(struct doubly_linked_list *dll, int element, int index)
{
    if (index < 0 || index >= dll->size)
    {
        return;
    }

    struct _node *n = (struct _node *)malloc(sizeof(struct _node *));
    n->value = element;

    if (index == 0)
        return add_first(dll, element);
    else if (index == dll->size - 1)
        return add_last(dll, element);

    struct _node *temp = dll->head;
    for (int i = 1; i < index; i++)
    {
        temp = temp->next;
    }

    struct _node *next = temp->next;
    temp->next = n;
    n->next = next;
    next->prev = n;
    n->prev = temp;
    return;
};

int delete_first(struct doubly_linked_list *dll)
{

    if (dll->head == NULL || dll->tail == NULL)
    {
        dll->size = 0;
        return -1;
    }

    struct _node *n = dll->head;
    int value = dll->head->value;

    if (dll->head->next == NULL)
    {
        dll->head = NULL;
    }
    else
    {
        dll->head = n->next;
        n->next->prev = NULL;
        n->next = NULL;
    }

    dll->size--;
    free(n);
    return value;
};

int delete_last(struct doubly_linked_list *dll)
{

    if (dll->head == NULL || dll->tail == NULL)
    {
        dll->size = 0;
        return -1;
    }

    struct _node *n = dll->tail;
    int value = dll->tail->value;

    if (dll->tail->prev == NULL)
    {
        dll->tail = NULL;
    }

    else
    {
        dll->tail = n->prev;
        n->prev->next = NULL;
        n->prev = NULL;
    }
    free(n);
    return value;
};

int delete_at(struct doubly_linked_list *dll, int index) {
    if (index < 0 || index >= dll->size)
    {
        return -1;
    }

    if (index == 0)
        return delete_first(dll);
    else if (index == dll->size - 1)
        return delete_last(dll);

    struct _node *temp = dll->head;
    int value = temp->value;

    for (int i = 1; i <= index; i++)
    {
        temp = temp->next;
    }

    struct _node *next = temp->next;
    temp->prev->next = next;
    next->prev = temp->prev;
    free(temp);
    return value;
};

int get_at(struct doubly_linked_list *dll, int index)
{
    if (index < 0 || index >= dll->size)
        return -1;

    int count = 0;
    struct _node *temp = dll->head;
    while (temp != NULL)
    {
        if (index == count)
            return temp->value;

        count++;
        temp = temp->next;
    }
    return -1;
};

int find(struct doubly_linked_list *dll, int element)
{
    struct _node *temp = dll->head;
    int index = 0;
    while (temp != NULL)
    {
        if (temp->value == element)
        {
            return index;
        }
        index++;
        temp = temp->next;
    }

    return -1;
};

void display(struct doubly_linked_list *dll)
{
    printf("HEAD <-> ");
    struct _node *temp = dll->head;
    while (temp != NULL)
    {
        printf("%d <-> ", temp->value);
        temp = temp->next;
    }
    printf("END\n");
};

void display_reverse(struct doubly_linked_list *dll)
{
    printf("HEAD <-> ");
    struct _node *temp = dll->tail;
    while (temp != NULL)
    {
        printf("%d <-> ", temp->value);
        temp = temp->prev;
    }
    printf("END\n");
};
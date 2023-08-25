/**
 * @author: Samyabrata Maji (@samyabrata-maji)
 * short demo using the dll (doubly linked list) lib
 * compile: gcc -o demo demo_doubly_linked_list.c dll.c;
 */
#include <stdio.h>
#include "dll.h"

void main()
{
    struct doubly_linked_list list;
    init(&list);

    add_first(&list, 10);
    add_first(&list, 134);

    add_last(&list, 72);

    add_first(&list, 35);
    add_first(&list, 12);

    add_last(&list, 36);

    add_at(&list, 75, 4);
    add_at(&list, 42, 2);

    delete_first(&list);
    delete_last(&list);
    delete_at(&list, 2);

    printf("index of 75 -> %d\n", find(&list, 75));
    printf("element at index 3 -> %d\n", get_at(&list, 3));

    display_reverse(&list);
}
/**
 * @author: Samyabrata Maji (@samyabrata-maji)
 * short demo using the circular_queue lib
 * compile: gcc -o demo demo_circular_queue.c circular_queue.c;
 */

#include <stdio.h>
#include "circular_queue.h"

int main() {
    struct Queue queue;
    init(&queue);

    push(&queue, 10);
    push(&queue, 23);
    push(&queue, 41);
    push(&queue, 13);
    push(&queue, 15);

    poll(&queue);
    poll(&queue);
    poll(&queue);

    display(&queue);

    return 0;
}
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "circular_queue.h"

void init(struct Queue *q) {
    q->start = 0;
    q->end = 0;
    q->length = 0;
}

bool isEmpty(struct Queue *q) {
    return q->length <= 0;
}

bool isFull(struct Queue *q) {
    return q->length >= MAX_QUEUE_SIZE;
}

void push(struct Queue *q, int element) {
    if (isFull(q)) {
        return;
    }

    q->queue[q->end % MAX_QUEUE_SIZE] = element;
    q->end++;
    q->length++;
}

int poll(struct Queue *q) {
    if (isEmpty(q)) {
        return -1;
    }

    q->length--;
    return q->queue[q->start++];
}

int peek(struct Queue *q) {
    return !isEmpty(q) ? q->queue[q->start] : -1;
}

void display(struct Queue *q) {
    printf("START -> ");
    for(int i=q->start; i<q->end; i++) {
        printf("%d -> ", q->queue[i % MAX_QUEUE_SIZE]);
    }
    printf("END\n");
}


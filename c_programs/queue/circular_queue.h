#include <stdbool.h>

#ifndef MAX_QUEUE_SIZE
    #define MAX_QUEUE_SIZE 5
#endif

struct Queue
{
    int queue[MAX_QUEUE_SIZE];
    int start;
    int end;
    int length;
};

void init(struct Queue *q);

bool isEmpty(struct Queue *q);

bool isFull(struct Queue *q);

void push(struct Queue *q, int element);

int poll(struct Queue *q);

int peek(struct Queue *q);

void display(struct Queue *q);

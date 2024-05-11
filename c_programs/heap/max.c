#include <stdlib.h>
#include <stdio.h>

#define MAX_HEAP_SIZE 10

typedef struct Heap
{
    int elements[MAX_HEAP_SIZE];
    int size;
} Heap;

Heap init();
int get(Heap *heap);
int insert(Heap *heap, int el);
int delete(Heap *heap);
int heap_sort(int arr[], int size, Heap *heap);

void _display(Heap *heap);
void _swap(int a[], int i, int j);

int main() {
    int arr[5] = {9, 5, 10, 7, 2};
    Heap heap = init();
    heap_sort(arr, 5, &heap);

    for (int i=0; i<5;i++) printf("%d, ", arr[i]);
    return 0;
}

Heap init() {
    Heap *heap = (Heap *)malloc(sizeof(Heap *));
    heap->size = 0;
    return *heap;
}

void _display(Heap *heap)  {
    if (heap->size <= 0) {
        printf("EMPTY HEAP\n");
        return;
    }
    for (int i=0; i<heap->size; i++) printf("%d, ", heap->elements[i]);
    printf("\n");
}

void _swap(int a[], int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

int get(Heap *heap) {
    return heap->elements[0];
}

int insert(Heap *heap, int el) {
    if (heap->size >= MAX_HEAP_SIZE) return 1;
    
    heap->elements[heap->size] = el;
    heap->size++;

    int i = heap->size-1;
    while (i>0) {
        int parent = (i-1)/2;
        if (heap->elements[parent] > heap->elements[i]) break;
        
        _swap(heap->elements, i, parent);
        i=parent;
    }
    return 0;
}

int delete(Heap *heap) {
    if (heap->size <= 0) return 1;

    _swap(heap->elements, 0, heap->size-1);
    heap->size--;

    int i=0;
    while (1) {
        int l = 2*i+1;
        int r = 2*i+2;

        if (r >= heap->size) break;
        if (heap->elements[i] > heap->elements[l] && heap->elements[i] > heap->elements[r]) break;
        int max = heap->elements[l] > heap->elements[r] ? l : r;

        _swap(heap->elements, max, i);
        i=max;
    }
    return 0;
}

int heap_sort(int arr[], int size, Heap *heap) {
    for (int i=0; i<size; i++) {
        insert(heap, arr[i]);
    }

    for (int i=0; i<size; i++) {
        delete(heap);
        arr[i] = heap->elements[heap->size];
    }
    return 0;
}
#include <stdio.h>
#include <stdlib.h>

void display(int arr[], int size);
void bubble_sort(int arr[], int size);

int main() {
    int arr[] = {2,4,5,1,3,2,5,6};
    int size = sizeof(arr) / sizeof(arr[0]);
    bubble_sort(arr, size);
    display(arr, size);
}

void display(int arr[], int size) {
    for(int i=0; i<size; i++) {
        printf("%d, ", arr[i]);
    }
    printf("\n");
}

void bubble_sort(int* arr, int size) {
    for (int i=0; i<size; i++) {
        for (int j=0; j<size-i; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
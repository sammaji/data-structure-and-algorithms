#include <stdio.h>
#include <stdlib.h>

int linear_search(int target, int arr[], int size);
int binary_search(int target, int arr[], int size);

int main() {
    int arr[] = {1,2,3,4,5,6,7,9,10};
    int size = sizeof(arr) / sizeof(arr[0]);

    printf("linear search: %d\n", linear_search(6, arr, size));
    printf("binary search: %d\n", binary_search(6, arr, size));
}

void display(int arr[], int size) {
    for(int i=0; i<size; i++) {
        printf("%d, ", arr[i]);
    }
    printf("\n");
}

int linear_search(int target, int arr[], int size) {
    for (int i=0; i<size; i++) {
        if (arr[i] == target) {
            return i;
        }
    }

    return -1;
}

int binary_search(int target, int arr[], int size) {
    int start = 0;
    int end = size - 1;
    int mid;

    while (start <= end) {
        mid = start + (end - start)/2;
        
        if (arr[mid] < target) {
            start = mid + 1;
        }
        else if (arr[mid] > target) {
            end = mid - 1;
        }
        else {
            return mid;
        }
    }

    return -1;
}
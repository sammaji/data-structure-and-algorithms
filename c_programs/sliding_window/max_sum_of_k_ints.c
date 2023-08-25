#include <stdio.h>

int max_sum(int *a, int k, int size);

void main() {
    int arr[] = {1,2,3,5,6,7,2,3};
    printf("max sum = %d\n", max_sum(arr, 3, sizeof(arr) / sizeof(arr[0])));
}

int max_sum(int *a, int k, int size) {
    int max = a[0];    
    int start_p = 0;

    int sum = 0;
    for (int i=0; i<k; i++) {
        sum += a[i];
    }
    max = sum;

    while(start_p + k < size) {
        sum = sum - a[start_p] + a[start_p + k];
        if (sum > max) {
            max = sum;
        }
        start_p++;
    }
    return max;
}
package heaps;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<Integer>();
    }

    private void swap(int i, int j) {
        int temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }

    private boolean bounded(int i) {
        return i >= 0 && i < heap.size();
    }

    public void display() {
        System.out.println(heap.toString());
    }

    public void insert(Integer e) {
        heap.add(e);
        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) > heap.get(i))
                break;

            swap(i, parent);
            i = parent;
        }
    }

    public void remove() {
        int i = 0;
        int lc, rc;
        while (true) {
            lc = 2 * i + 1;
            rc = 2 * i + 2;
            if (!bounded(lc) || !bounded(rc))
                break;
            int si = heap.get(lc) > heap.get(rc) ? lc : rc;
            swap(i, si);
            i = si;
        }
        heap.remove(i);
    }

    private void replace(int[] values) {
        heap = new ArrayList<>(values.length);
        for (int i = 0; i < values.length; i++) {
            heap.add(values[i]);
        }
    }

    public void heapify(int[] values) {
        replace(values);
        for (int i = values.length - 1; i > 0; i--) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) < heap.get(i)) {
                swap(i, parent);
            }
        }
    }
}

class CheckMaxHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(0);
        heap.insert(16);
        heap.insert(19);
        heap.insert(1);
        heap.insert(20);
        heap.insert(6);

        heap.display();

        heap.remove();
        heap.remove();
        heap.remove();

        heap.display();
    }
}
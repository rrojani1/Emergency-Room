package com.emergencyroom;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
    private final ArrayList<T> heap;
    private final Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    // Add an element to the heap
    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    // Remove the root element from the heap
    public T remove() {
        if (heap.isEmpty()) return null;

        T root = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return root;
    }

    // Heapify the element at index i upwards
    private void heapifyUp(int i) {
        while (i > 0) {
            int parentIndex = (i - 1) / 2;
            if (comparator.compare(heap.get(i), heap.get(parentIndex)) >= 0) break;
            swap(i, parentIndex);
            i = parentIndex;
        }
    }

    // Heapify the element at index i downwards
    private void heapifyDown(int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int smallest = i;

        if (leftChild < heap.size() && comparator.compare(heap.get(leftChild), heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && comparator.compare(heap.get(rightChild), heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    // Swap elements at index i and j
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Return the current size of the heap
    public int size() {
        return heap.size();
    }
}

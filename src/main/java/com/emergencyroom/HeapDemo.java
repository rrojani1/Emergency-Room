package com.emergencyroom;

import java.util.Comparator;

public class HeapDemo {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(o1, o2) {
//                return Integer.compare(o1, o2);
//            }
//        };

        Heap<Integer> heap = new Heap<>(comparator);

        // Add 20 random numbers to the heap
        for (int i = 0; i < 20; i++) {
            int num = (int) (Math.random() * 100);
            heap.add(num);
            System.out.print(num + " ");
        }
        System.out.println();

        // Remove all elements and print them
        while (heap.size() > 0) {
            System.out.print(heap.remove() + " ");
        }
    }
}


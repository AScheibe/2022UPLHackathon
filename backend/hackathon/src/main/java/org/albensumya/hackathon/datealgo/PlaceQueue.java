package org.albensumya.hackathon.datealgo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PlaceQueue implements Iterable<Place> {
    private Place[] queue; // array min-heap of assignments representing this priority queue
    private int size; // size of this priority queue
    private int category;

    public PlaceQueue(int capacity, int category) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        size = 0;
        queue = new Place[capacity];
        this.category = category;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return queue.length;
    }

    public void clear() {
        queue = new Place[queue.length];
        size = 0;
    }

    public Place peek() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[0];
    }

    public void enqueue(Place e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (size >= capacity()) {
            throw new IllegalStateException("Queue Full");
        }

        queue[size] = e;
        size++;
        percolateUp(size - 1);
    }

    public Place dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }

        Place temp = queue[0];
        queue[0] = queue[size - 1];
        queue[size - 1] = null;
        size--;

        if (size > 0) {
            percolateDown(0);
        }
        return temp;
    }

    protected void percolateDown(int i) {
        int leftChildIndex = (i * 2) + 1;
        int rightChildIndex = (i * 2) + 2;
        int minIndex = leftChildIndex;

        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (leftChildIndex >= size) {
            return;
        }

        if (!(rightChildIndex >= size)) {
            if (queue[leftChildIndex].compareTo(queue[rightChildIndex], category) > 0) {
                minIndex = rightChildIndex;
            }
        }

        if (queue[i].compareTo(queue[minIndex], category) > 0) {
            swap(i, minIndex);
            percolateDown(minIndex);
        }
    }

    protected void swap(int i1, int i2) {
        Place temp = queue[i1];
        queue[i1] = queue[i2];
        queue[i2] = temp;
    }

    protected void percolateUp(int i) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            return;
        }

        int parentIndex = (i - 1) / 2;

        if (queue[parentIndex].compareTo(queue[i], category) >= 0) {
            swap(i, parentIndex);
            percolateUp(parentIndex);
        }
    }

    public PlaceQueue deepCopy() {
        PlaceQueue aQueue = new PlaceQueue(capacity(), category);

        for (int i = 0; i < queue.length; i++) {
            aQueue.queue[i] = queue[i];
        }

        return aQueue;
    }

    public Iterator<Place> iterator() {
        return new PlaceIterator(this);
    }
}

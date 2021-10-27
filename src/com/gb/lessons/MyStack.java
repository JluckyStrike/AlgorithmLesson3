package com.gb.lessons;

public class MyStack<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Object[capacity];
    }

    public void push(T item){
        if (isFull()){
            reCapacity(size * 2);
        }

        list[size++] = item;
    }

    public T pop(){
        T item = list[--size];
        list[size] = null;
        return item;
    }

    public T peek(){
        return list[size-1];
    }

    private boolean isFull(){
        return list.length == size;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }
}

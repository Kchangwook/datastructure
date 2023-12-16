package org.example.chater5;

import java.util.ArrayList;

public class CustomArrayList <T> {
    private int listLength;
    private Object[] listItems;

    CustomArrayList() {
        listLength = 0;
        listItems = new Object[64];
    }

    public void add(int targetIndex, T value) {
        if (listLength >= listItems.length || targetIndex < 0 || targetIndex > listItems.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int index = listLength - 1; index > targetIndex; index--) {
            listItems[index + 1] = listItems[index];
        }

        listItems[targetIndex] = value;
        listLength++;
    }

    public void append(T value) {
        if (listLength >= listItems.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        listItems[listLength] = value;
        listLength++;
    }

    public void remove(int targetIndex) {
        if (isEmpty() || targetIndex < 0 || targetIndex > listLength - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int index = targetIndex; index < listLength - 2; index++) {
            listItems[index] = listItems[index + 1];
        }
        listLength--;
    }

    public void removeItem(T value) {
        int targetIndex = indexOf(value);
        remove(targetIndex);
    }

    public T get(int targetIndex) {
        if (targetIndex < 0 || targetIndex > listLength - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return (T) listItems[targetIndex];
    }

    public void set(int targetIndex, T value) {
        if (targetIndex < 0 || targetIndex > listLength - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        listItems[targetIndex] = value;
    }

    public int indexOf(T value) {
        int targetIndex = -1;
        for (int index = 0; index <= listLength; index++) {
            if (listItems[index].equals(value)) {
                targetIndex = index;
                break;
            }
        }

        return targetIndex;
    }

    public int length() {
        return listLength;
    }

    public boolean isEmpty() {
        return listLength == 0;
    }

    public void clear() {
        listLength = 0;
    }
}

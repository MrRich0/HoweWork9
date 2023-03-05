package MyArrayLisT;

import java.util.Objects;

public class MyArrayList<E> {
    private static final int SIZE_ARRAY = 5;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[SIZE_ARRAY];
    }

    public void add(E value) {
        if (size == data.length) {
            Object []newData = new Object[SIZE_ARRAY * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        int index = size;
        data[index] = value;
        index++;
        size = index;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Objects.checkIndex(index,size);

            return (E) data[index];
    }

    public void clear() {
        data = new Object[SIZE_ARRAY];
        size = 0;
    }

    public void remove(int index) {
        Objects.checkIndex(index,size);

        Object[] result = new Object[data.length];
        System.arraycopy(data, 0, result, 0, index);
        System.arraycopy(data, index + 1, result, index, data.length - index - 1);

        data = result;
        size--;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object datum : data) {
            if (datum != null) {
                builder.append(datum);
            }
        }
        return "[" + builder + "]";
    }
}


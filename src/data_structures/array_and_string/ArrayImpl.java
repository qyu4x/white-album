package data_structures.array_and_string;


import java.lang.reflect.Array;
import java.util.Objects;

class DSArray<T> {

    private Class<T> type;

    private final int size = 10;

    private T[] array;

    public DSArray(Class<T> type) {
        this.type = type;
        this.array = initialize();
    }

    @SuppressWarnings("unchecked")
    public T[] initialize() {
        return (T[]) Array.newInstance(this.type, this.size);
    }

    private boolean isFull() {
        return array[array.length - 1] != null || Objects.nonNull(array[array.length - 1]);
    }

    @SuppressWarnings("unchecked")
    private void extend() {
        T[] tempData = this.array;
        this.array = (T[]) Array.newInstance(this.type, tempData.length * 2);

        // copy
        for (int i = 0; i < tempData.length; i++) {
            this.array[i] = tempData[i];
        }
    }

    public void add(T data) {
        // if data full extend 2*
        if (this.isFull()) {
            // copy current and increase
            extend();
        }

        // check available position
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || Objects.isNull(array[i])) {
                array[i] = data;
                break;
            }
        }
    }

    public T get(int index) {
        if (index >= this.array.length || index < 0) throw new IndexOutOfBoundsException();
        return this.array[index];
    }

    public void transverse() {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null || Objects.isNull(this.array[i])) break;
            System.out.println(this.array[i]);
        }
    }

    public int length() {
        int counter = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null || Objects.isNull(this.array[i])) break;
            counter++;
        }
        return counter;
    }

    public void pop() {
        this.array[this.length()-1] = null;
    }


    private void moveBack(int startIndex) {
        for (int i = startIndex; i < length(); i++) {
            this.array[i-1] = this.array[i];
        }

        this.array[length()-1] = null;
    }

    private void moveFront(int startIndex) {
        T nextTempData = this.array[startIndex];
        for (int i = startIndex; i < length(); i++) {
            T currentTempData = this.array[i+1];
            this.array[i+1] = nextTempData;

            nextTempData = currentTempData;
        }
    }

    public void dequeue() {
        moveBack(1);
    }

    public void add(T data, int index) {
        if (isFull()) extend();

        if (length() + 1 > length()) extend();

        moveFront(index);
        this.array[index] = data;
    }

    public void remove(int index) {
        this.moveBack(index+1);
    }

}

public class ArrayImpl {
    public static void main(String[] args) {

        DSArray<String> wifes = new DSArray<>(String.class);
        wifes.add("shina mahiru");
        wifes.add("kaguya shinomiya");
        wifes.add("kanzaki ranko");
        wifes.add("ruka sarashina");
        wifes.add("izuna chan");
        wifes.add("shiro");
        wifes.add("tsukasa");
        wifes.add("kurumi");
        wifes.add("mizuhara chizuru");
        wifes.add("alya");
        wifes.add("origami");

        System.out.println(wifes.get(8));
        System.out.println(wifes.get(10));

        wifes.transverse();

        System.out.println(wifes.length());

        wifes.dequeue();
        System.out.println(wifes.length());
        System.out.println(wifes.get(0));
        wifes.transverse();
        System.out.println(wifes.length());

        wifes.add("chino kaffu", 3);
        wifes.transverse();
        System.out.println(wifes.length());

        wifes.remove(9);
        wifes.transverse();
        System.out.println(wifes.length());

    }
}

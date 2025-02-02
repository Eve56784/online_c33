package lesson15_HW;

import java.util.Arrays;

public class ArrayListSim <T>{
    private Object[] elements;
    private int size = 0;
    private static final int defaultCapacity = 10;
    public ArrayListSim(){
        elements = new Object[defaultCapacity];
    }
    public ArrayListSim(int userCapacity){
        elements = new Object[userCapacity];
    }

    public void addElement(T element){
        if(size == elements.length)
            extendCapacity();
        elements[size++]=element;
    }

    public void extendCapacity(){
        int extendedCapacity = elements.length*2;
        elements = Arrays.copyOf(elements, extendedCapacity);
    }

    public void remove(int index){
        if(index>=size||index<0)
            throw new IndexOutOfBoundsException();
        T element = (T) elements[index];
        int numMove = size-index-1;
        if(numMove>0)
            System.arraycopy(elements, index+1, elements, index,numMove);
        elements[--size]=null;
    }

    public T getElements(int index){
        if(index>=size||index<0)
            throw new IndexOutOfBoundsException();
        return (T) elements[index];
    }

    public boolean contains(T element){
        for(int i = 0; i<size; i++){
            if(element.equals(elements[i]))
                return true;
        }
        return false;
    }

    public void clear(){
        for(int i = 0; i<size; i++)
            elements[i]=null;
        size=0;
    }

    public void print(){
        if(size==0) {
            System.out.println("Array is empty");
            return;
        }
        System.out.print("[");
        for(int i = 0; i<size; i++) {
            if (i != size - 1)
                System.out.print(elements[i] + ", ");
            else
                System.out.print(elements[i]);
        }
        System.out.println("]");
    }
}

package com.java.intensive;

import java.util.*;
import java.util.function.Consumer;


public class AList <T> extends AbstractList<T> {

    private static final int GROW_INCREMENT = 5;
    private Object[] elements;
    private Comparator<T> comparator;
    private int size;


    /**
     * creates an empty list
     */
    public AList(){
        //elements = new Object[0];
        //size = 0;
        new AList(new ArrayList<>());
    }

    /**
     * @param collection
     * creates list containing elements of passed collection
     */
    public AList(Collection<? extends T> collection){
        elements = collection.toArray();
        size = elements.length;
    }

    /**
     * sorts elements using a quick sort algorithm using hashCode comparison
     */
    public void quickSort() {
        quickSort((o1, o2) -> o1.hashCode() - o2.hashCode());
    }

    /**
     * @param comparator
     * sorts elements using quick sort algorithm using specified comparator
     */
    public void quickSort(Comparator<T> comparator) {
        this.comparator = comparator;
        quickSortIteration(0, size() - 1);
    }

    private void quickSortIteration(int startIndex, int endIndex){
        if(startIndex < endIndex){
            int q = quickSortSeparation(startIndex, endIndex);
            quickSortIteration(startIndex, q - 1);
            quickSortIteration( q + 1, endIndex);
        }
    }

    @SuppressWarnings("unchecked")
    private int quickSortSeparation(int startIndex, int endIndex){
        int indexOfSubst = startIndex;
        for(int i = startIndex; i < endIndex; i++ ){
            if(comparator.compare((T) elements[i],(T) elements[endIndex]) <= 0){
                if(i != indexOfSubst){
                    Object temp = elements[i];
                    elements[i] = elements[indexOfSubst];
                    elements[indexOfSubst] = temp;
                }
                indexOfSubst++;
            }
        }

        Object temp = elements[endIndex];
        elements[endIndex] = elements[indexOfSubst];
        elements[indexOfSubst] = temp;
        return indexOfSubst;
    }

    /**
     * @return
     * increases list capacity when size equals length
     */
    public Object[] grow(){
        return Arrays.copyOf(elements, elements.length + GROW_INCREMENT);
    }


    /**
     * @param t element which is to be placed in the collection
     *
     */
    @Override
    public boolean add(T t) {
        if(elements.length == size){
            elements = grow();
        }
        elements[size] = t;
        size++;
        return true;
    }
    /**
     * @param index index of the element to return
     *  not implemented
     */

    @Override
    public T get(int index) {
        return null;
    }
    /**
     *  returns number of elements placed in collection
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * @param action The action to be performed for each element
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < size; i++)
            action.accept(elementAt(i));
    }
    @SuppressWarnings("unchecked")
    private T elementAt(int index){
        return (T) elements[index];
    }

    /**
     * return iterator over the elements of the collection
     * @return
     */
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int index;       // index of next element to return
        Itr() {}

        /**
         * @return
         * checks if counter is out of array's range
         */
        public boolean hasNext() {
            return index != size;
        }

        /**
         * @return next element of the array or throws exception it out of the range of array
         */
        @SuppressWarnings("unchecked")
        public T next() {
            if(index >= size)
                throw new NoSuchElementException();
            int i = index;
            index++;
            return (T) AList.this.elements[i];
        }
    }
}

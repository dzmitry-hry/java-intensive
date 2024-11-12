package com.java.intensive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AListTest {

    private static AList<SortedItem> data(){
        ArrayList<SortedItem> arrayList = new ArrayList<>();
        arrayList.add(new SortedItem("kd",7));
        arrayList.add(new SortedItem("dk",11));
        arrayList.add(new SortedItem("av",2));
        arrayList.add(new SortedItem("cd",4));
        arrayList.add(new SortedItem("zx",2));
        arrayList.add(new SortedItem("rt",10));
        arrayList.add(new SortedItem("bz",0));
        arrayList.add(new SortedItem("cd",1));
        arrayList.add(new SortedItem("ca",8));
        return new AList<>(arrayList);
    }
    /**
     * runs quick sort using customized comparator
     */
    @Test
    void quickSortCustomComparator() {
        //
        //Given
        //
        AList<SortedItem> aList = AListTest.data();
        Comparator<SortedItem> c = Comparator.comparingInt(SortedItem::getIndex);
        //
        //When
        //
        SortedItem currentSortedItem = null;
      //  aList.add(new SortedItem("pa",18));
        aList.quickSort(c);
        //
        //Then
        //
        boolean isValid = true;
        for (SortedItem sortedItem: aList){
            if(currentSortedItem != null && sortedItem.index < currentSortedItem.index){
                isValid = false;
                break;
            }
            currentSortedItem = sortedItem;
        }
        assertTrue(isValid);
    }
    /**
     * runs quick sort using customized comparator
     */
    @Test
    void quickSortDefaultComparator() {
        //
        //Given
        //
        AList<SortedItem> aList = AListTest.data();
        //
        //When
        //
        SortedItem currentSortedItem = null;
      //  aList.add(new SortedItem("pa",18));
        aList.quickSort();
        //
        //Then
        //
        boolean isValid = true;
        for (SortedItem sortedItem: aList){
            if(currentSortedItem != null && sortedItem.hashCode() < currentSortedItem.hashCode()){
                isValid = false;
                break;
            }
            currentSortedItem = sortedItem;
        }
        assertTrue(isValid);
    }
}
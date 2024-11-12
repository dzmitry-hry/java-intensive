package com.java.intensive;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Comparator;

public class AListTest extends TestCase {

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
    public void testQuickSortCompCustom() {
        AList<SortedItem> aList = AListTest.data();
        aList.add(new SortedItem("pa",18));
        aList.quickSort(Comparator.comparingInt(SortedItem::getIndex));
        SortedItem currentSortedItem = null;
        for (SortedItem sortedItem: aList){
            if(currentSortedItem != null && sortedItem.index < currentSortedItem.index){
                Assert.fail();
            }
            currentSortedItem = sortedItem;
        }
    }
    /**
     * runs quick sort using customized comparator
     */
    public void testQuickSortCompDefault() {
        AList<SortedItem> aList = AListTest.data();
        aList.add(new SortedItem("pa",18));
        aList.quickSort();
        SortedItem currentSortedItem = null;
        for (SortedItem sortedItem: aList){
            if(currentSortedItem != null && sortedItem.hashCode() < currentSortedItem.hashCode()){
                Assert.fail();
            }
            currentSortedItem = sortedItem;
        }
    }

}
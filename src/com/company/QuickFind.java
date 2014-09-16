package com.company;

/**
 * Created by Hesham on 16/09/2014.
 */
public class QuickFind {
    //object id array
    Object _id[];
    //size of the array
    int _size;
    //the default size of the array
    private final static int _defaultSize = 10;

    //init the array with size
    public QuickFind(int size){
        _id = new Object[size];
        _size = size;
    }
    //init the array with default size
    public QuickFind(){
        _id = new Object[_defaultSize];
        _size = _defaultSize;
    }
    //helper method to resize the array
    private void resizeArray(int nSize){
        Object nArr[] = new Object[nSize];
        System.arraycopy(_id,0,nArr,0,_size);
        _size = nSize;
        _id = nArr;
    }
}

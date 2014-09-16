package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Mostafa on 16/09/2014.
 * this implementation is the eager implementation of Quick Find
 */
public class QuickFind<T> {
    //object id array
    HashMap<T,T> _id;
    //size of the array
    int _size;

    // init the array with default size
    public QuickFind(){
        _id = new HashMap<T, T>();
        _size = 0;
    }
    //check connection query
    //Cost: 1
    public boolean connected(T p,T q){
        return _id.get(p) == _id.get(q);
    }
    //the union function ti union two objects
    //Cost: N
    public void union(T p,T q){
        T pid = _id.get(p);
        T qid = _id.get(q);
        //loop through map
        Iterator it = _id.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if(_id.get(pair.getKey()) == pid)
                _id.replace((T)pair.getKey(),(T)pair.getValue(),qid);
        }
    }
    //function to add objects
    //Cost: i guess it depends on map but i guess 1
    public void add(T obj){
        _id.put(obj,obj);
        _size++;
    }
    //size getter
    public int get_size(){
        return _size;
    }
}

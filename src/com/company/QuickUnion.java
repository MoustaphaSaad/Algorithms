package com.company;

import java.util.HashMap;

/**
 * Created by Mostafa on 16/09/2014.
 * lazy approach of quick union
 * sketch proof of weighted Quick Union
 * T2, T1 is two trees
 * X is a node in T1
 * T1 <= T2
 * depth of X will increase by 1 when T1 and T2 merge, and that's will happen when T1<=T2
 * when the depth of X increase the size of it's tree doubles at log N of times
 */
public class QuickUnion<T> {
    //object id HashMap
    HashMap<T,T> _id;
    //size
    int _size;
    //Improvement: save the size of each tree to implement weighted Quick Union
    HashMap<T,Integer> _treeSizes;

    //default Constructor
    public QuickUnion(){
        _id = new HashMap<T, T>();
        _treeSizes = new HashMap<T, Integer>();
        _size = 0;
    }
    //size getter
    public int get_size(){
        return _size;
    }
    //private helper method to get root
    //Cost: worst case N
    private T root(T obj){
        while(obj != _id.get(obj))
            obj = _id.get(obj);
        return obj;
    }
    //union method
    //Cost: N with the cost of function root
    //Improvement: Weighted Union Log N
    public void union(T p, T q){
        T i = root(p);
        T j = root(q);
        if(i == j)
            return;
        //improvement: put the smaller tree under the large one and update the size
        if(_treeSizes.get(i)<_treeSizes.get(j)) {
            _id.replace(i, _id.get(i), j);
            _treeSizes.replace(j,_treeSizes.get(j),_treeSizes.get(j)+_treeSizes.get(i));
        }else{
            _id.replace(j, _id.get(j), i);
            _treeSizes.replace(i,_treeSizes.get(i),_treeSizes.get(i)+_treeSizes.get(j));
        }
    }
    //connected query
    //Cost: 1
    public boolean connected(T p,T q){
        return _id.get(p) == _id.get(q);
    }
    //add object to map
    public void add(T obj){
        _id.put(obj,obj);
        _treeSizes.put(obj,1);
    }
    //get size of tree
    public int get_tree_size(T obj){
        return _treeSizes.get(obj);
    }
}

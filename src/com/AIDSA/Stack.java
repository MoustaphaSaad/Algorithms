package com.AIDSA;

/**
 * Created by MoustaphaSaad on 08/10/2014.
 * an implementation of stack
 */
public class Stack<T> {
    //linked list Node
    private class Node<T>{
        //data object
        public T _data;
        //next Node
        public Node _next;
    }
    //head node
    private Node<T> _head;
    //to keep track of size
    private int _size;


    public Stack(){
        _head = null;
        _size = 0;
    }

    public boolean isEmpty(){
        return _size == 0;
    }

    public int size(){
        return _size;
    }

    public void push(T obj){
        //creating node
        Node<T> newNode = new Node<T>();
        newNode._data = obj;
        //adding pointer to the head
        newNode._next = _head;
        //make it the head node
        _head = newNode;
        _size++;
    }
    public T pop(){
        Node<T> res = _head;
        _head = _head._next;
        _size--;
        T resD = res._data;
        res = null;
        return resD;
    }

}

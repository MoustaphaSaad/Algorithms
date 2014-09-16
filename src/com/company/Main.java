package com.company;

public class Main {

    public static void main(String[] args) {
        QuickUnion_Test();
    }
    private static void QuickUnion_Test(){
        QuickUnion<String> qu = new QuickUnion<String>();
        qu.add("1");
        qu.add("2");
        qu.add("3");
        qu.add("4");
        qu.union("3","4");
        System.out.println(qu.get_tree_size("3"));
        qu.union("1","4");
        System.out.println(qu.get_tree_size("3"));
        qu.union("2","3");
        System.out.println(qu.get_tree_size("3"));
        System.out.println(qu.connected("1","2"));
        System.out.println(qu.connected("1","3"));
    }
    private static void QuickFind_Test(){
        QuickFind<String> qu = new QuickFind<String>();
        qu.add("1");
        qu.add("2");
        qu.add("3");
        qu.add("4");
        qu.union("3","4");
        qu.union("1","4");
        qu.union("2","3");
        System.out.println(qu.connected("1","2"));
        System.out.println(qu.connected("1","3"));
    }
}

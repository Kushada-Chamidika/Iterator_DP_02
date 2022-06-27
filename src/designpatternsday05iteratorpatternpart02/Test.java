/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatternsday05iteratorpatternpart02;

import java.util.ArrayList;

/**
 *
 * @author 1999k
 */
interface Iterator {

    public abstract boolean hasNext();

    public abstract Object next();

}

class A {

    ArrayList<String> arraylist = new ArrayList<>();

    public A() {

        arraylist.add("Orange1");
        arraylist.add("Apple1");
        arraylist.add("Mango1");

    }

    public void addItem(String name) {

        arraylist.add(name);

    }

//    public ArrayList<String> getItems() {
//        return arraylist;
//    }
    public Iterator getItems() {
        return new AIterator(arraylist);
    }

}

class AIterator implements Iterator { // A iterator eken wenne list eka iterator ekakta convert karana eka

    ArrayList<String> arrayList;
    int position = 0;

    public AIterator(ArrayList<String> list) {
        this.arrayList = list;
    }

    @Override
    public boolean hasNext() {
        if (position < arrayList.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return arrayList.get(position++);
    }

}

class B {

    String array[] = new String[4];

    int position = 0;

    public B() {

        array[position] = ("Orange2");
        position++;
        array[position] = ("Apple2");
        position++;
        array[position] = ("Mango2");
        position++;

    }

    public void addItem(String name) {

        if (position < array.length) {
            array[position] = name;
            position++;
        } else {
            System.out.println("Storage Full");
        }

    }

//    public String[] getItems() {
//        return array;
//    }
    public Iterator getItems() {
        return new BIterator(array);
    }

}

class BIterator implements Iterator { //Biterator eken wenne array eke iterator ekakta convert karana eka

    String array[];
    int position = 0;

    public BIterator(String list[]) {
        this.array = list;
    }

    @Override
    public boolean hasNext() {
        if (position < array.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return array[position++];
    }

}

public class Test {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();

        a.addItem("Banana1");
        b.addItem("Banana2");

//        ArrayList<String> arrayList = a.getItems();
//        String array[] = b.getItems();
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            String get = arrayList.get(i);
//            System.out.println(get);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            String string = array[i];
//            System.out.println(string);
//        }

        Iterator aIt = a.getItems();
        Iterator bIt = b.getItems();

        System.out.println("A");
        while (aIt.hasNext()) {
            System.out.println(aIt.next().toString());
        }

        System.out.println("B");
        while (bIt.hasNext()) {
            System.out.println(bIt.next().toString());
        }

    }

}

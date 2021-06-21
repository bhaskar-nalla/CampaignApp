package com.example;

public class MultipleInheritance {


}

interface Parent1{
     void print();
}

interface Parent2{
    default void print(){

    }
}

class Child implements Parent1, Parent2{


    @Override
    public void print() {

    }
}

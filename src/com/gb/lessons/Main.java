package com.gb.lessons;

import deque.MyDeque;

public class Main {

    public static void main(String[] args) {
        String myStr = "Hello world!";
        System.out.println(reverseStr(myStr));

        MyDeque<Integer> myDeque = new MyDeque<>();
        myDeque.insertLeft(1);
        myDeque.insertLeft(2);
        myDeque.insertRight(3);
        myDeque.displayFront();

        System.out.println();
        myDeque.removeRight();
        myDeque.displayFront();
        myDeque.insertAt(1, 4);
        System.out.println();
        myDeque.displayFront();

        System.out.println();
        myDeque.removeAt(0);
        myDeque.displayFront();
    }

    public static String reverseStr(String msg){
        MyStack<Character> stack = new MyStack<>(20);
        String res = "";

        for (Character symbol: msg.toCharArray()) {
            stack.push(symbol);
        }

        int len = stack.size();
        for (int i = 0; i < len; i++) {
            res += stack.pop();
        }

        return res;
    }
}

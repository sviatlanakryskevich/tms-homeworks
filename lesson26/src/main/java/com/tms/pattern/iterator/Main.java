package com.tms.pattern.iterator;

public class Main {
    public static void main(String[] args) {
        String[] skills = {"play", "say","sleep", "eat", "bite", "purr"};
        Skills myCat = new Skills(skills);
        Iterator iterator = myCat.getIterator();
        System.out.print("My cat has such skills: ");

        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + " ");
        }

    }
}

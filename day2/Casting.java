package day2;

import day3.*;

public class Casting {



    public static void main(String[] args) {
        /**
         * implicit type casting - from int to long and double , diff can be seen while
         * printng in double
         */
        int num = 100;
        long longNum = num;
        double doubleNum = num;
        System.out.println("int converted to long type : " + longNum);
        System.out.println("int converted to double type : " + doubleNum);

        /**
         * explicit type casting - from double to int
         */
        double num2 = 100.04;
        int intNum2 = (int) num2;
        System.out.println("from double num2 = 100.04, 0.04 lost while this type casting :" + intNum2);

        /**
         * type casting in objects
         */
        // Note :- beginner with no knowledge of class and inheritence can skip this
        // part

        class Animal {
        }
        class Dog extends Animal {
        }

        /**
         * Upcasting
         */
        Dog d1 = new Dog();
        Animal a1 = d1; // upcasting Dog --> Animal

        if (a1 instanceof Animal) {
            System.out.println("d1 which was instance of Dog initilly is being type casted to Animal by upcasting ");
        }
        // System.out.println(a1);

        /**
         * downcasting
         */
        Animal a2 = new Dog();
        Dog d2 = (Dog) a2;

        if (d2 instanceof Dog) {
            System.out.println("a1 which was instance of Animal initially is being type casted to Dog by downcasting");
        }

        // *******************************************************************************************************************

        /**
         * can be understand after completing the day3 package/folder
         * take a look at Methods_Java_Guide.md file in day3 package
         */
        System.out.println(day3.BinaryNumber.toBinary(50));;

    }
}

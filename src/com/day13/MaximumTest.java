package com.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumTest<T extends Comparable<T>> {
    T x, y, z;

    public MaximumTest(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public T maximum() {
        return MaximumTest.maximum(x, y, z);
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        List<T> list = new ArrayList<>(Arrays.asList(x, y, z));
        T max = Collections.max(list);
        printMax(x, y, z, max);
        return max;
    }

    public static <T> void printMax(T x, T y, T z, T max) {
        System.out.printf("Maximum of %s, %s, and %s is %s\n", x, y, z, max);
    }

    public static void main(String[] args) {
        Integer xInt = 3, yInt = 5, zInt = 12;
        System.out.println("Test with Integers:");
        MaximumTest.maximum(xInt, yInt, zInt);
        new MaximumTest<>(xInt, yInt, zInt).maximum();

        Float xFloat = 54.2F, yFloat = 56.54F, zFloat = 18.2F;
        System.out.println("\nTest with Floats:");
        MaximumTest.maximum(xFloat, yFloat, zFloat);
        new MaximumTest<>(xFloat, yFloat, zFloat).maximum();

        String xString = "Banana", yString = "Apple", zString = "Orange";
        System.out.println("\nTest with Strings:");
        MaximumTest.maximum(xString, yString, zString);
        new MaximumTest<>(xString, yString, zString).maximum();

        System.out.println("\nRefactor to One Generic Method:");
        MaximumTest.maximumGeneric(xInt, yInt, zInt);
        MaximumTest.maximumGeneric(xFloat, yFloat, zFloat);
        MaximumTest.maximumGeneric(xString, yString, zString);

        System.out.println("\nRefactor to Generic Class:");
        GenericMaximumTest<Integer> intGenericTest = new GenericMaximumTest<>(xInt, yInt, zInt);
        intGenericTest.testMaximum();
        GenericMaximumTest<Float> floatGenericTest = new GenericMaximumTest<>(xFloat, yFloat, zFloat);
        floatGenericTest.testMaximum();
        GenericMaximumTest<String> stringGenericTest = new GenericMaximumTest<>(xString, yString, zString);
        stringGenericTest.testMaximum();

        System.out.println("\nExtend max method for more than three parameters:");
        Integer wInt = 8, uInt = 15;
        MaximumTest.maximum(xInt, yInt, zInt, wInt, uInt);

        System.out.println("\nExtend max method to print to std out:");
        MaximumTest.maximumAndPrint(xInt, yInt, zInt);
    }

    public static <T extends Comparable<T>> T maximumGeneric(T x, T y, T z) {
        List<T> list = new ArrayList<>(Arrays.asList(x, y, z));
        T max = Collections.max(list);
        System.out.printf("Maximum of %s, %s, and %s is %s\n", x, y, z, max);
        return max;
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z, T... others) {
        List<T> list = new ArrayList<>(Arrays.asList(x, y, z));
        list.addAll(Arrays.asList(others));
        T max = Collections.max(list);
        System.out.printf("Maximum of %s is %s\n", list, max);
        return max;
    }

    public static <T extends Comparable<T>> void maximumAndPrint(T x, T y, T z) {
        T max = maximum(x, y, z);
        printMax(x, y, z, max);
    }
}

class GenericMaximumTest<T extends Comparable<T>> {
    private T x, y, z;

    public GenericMaximumTest(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void testMaximum() {
        MaximumTest.maximum(x, y, z);
    }
}

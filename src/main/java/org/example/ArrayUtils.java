package org.example;

public class ArrayUtils {
    public static <T> int findFirst(T[] array, T element) {

        for (int i = 0; i < array.length; i++){
            if (array[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // пример использования
        final String[] names = {"Alice", "Bob", "Charlie"};
        final int index = ArrayUtils.findFirst(names, "Bob"); // Ожидаем: 1


        System.out.println(index);
        System.out.println(ArrayUtils.findFirst(names, "Bib"));
        final String[] nullNames = null;

    }
}


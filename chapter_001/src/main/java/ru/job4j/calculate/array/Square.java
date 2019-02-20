package ru.job4j.calculate.array;

public class Square {

    public int[] calculate(int bount) {
        int[] result = new int[bount];
        int index = 0;
        for (int i = 1; i <= bount; i++) {
            result[index++] = i * i;
        }
        return result;
    }
}

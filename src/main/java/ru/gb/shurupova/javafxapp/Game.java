package ru.gb.shurupova.javafxapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    public static class BullsAndCowsCount {
        private final int bulls;
        private final int cows;

        public BullsAndCowsCount(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }
    }

    private final int[] guessNum; // поле, в кот. храниться число, которое будет отгадывать игрок

    public String getGuessNum() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < guessNum.length; i++) {
            stringBuilder.append(guessNum[i]);
        }
        return stringBuilder.toString();
    }

    public Game() {
        this.guessNum = generateNumber();              // инициализируем через метод
        System.out.println(Arrays.toString(guessNum)); // распечатаем массив
    }

    // напишем метод, кот. будет считать количество быков и коров
    public BullsAndCowsCount calculateBullsAndCows(String playNum) {
        int bulls = 0, cows = 0; // переменная для былков и коров
        for (int i = 0; i < guessNum.length; i++) {
            if (guessNum[i] == playNum.charAt(i) - '0') {
                bulls++;
            } else if (playNum.contains(String.valueOf(guessNum[i]))) {
                cows++;
            }
        }
        return new BullsAndCowsCount(bulls, cows);
    }

    private int[] generateNumber() {
        final List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));  // неизменяемая коллекция
        Collections.shuffle(numbers); // shuffle перемешает нашу коллекцию
        return new int[]{             // возьмем первые 4 числа из коллекции
                numbers.get(0),
                numbers.get(1),
                numbers.get(2),
                numbers.get(3)
        };
    }
}


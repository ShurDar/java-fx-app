package ru.gb.shurupova.javafxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class Controller {
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField userAnswer;

    private Game game;
    // поле, в котором будет считаться номер хода
    private int step;

    public Controller() {
        this.game = new Game();
    }

    public void clickCheckButton(ActionEvent actionEvent) {
        String answer = userAnswer.getText(); // getText() возвращает тот текст, который будет введен
        if (answer.isBlank()) { // isBlank() когда ответ пустой и когда вместо ответа пробелы
            return; // return тут нужен, чтобы досрочно выйти из метода
        }
        // метод, котрый из ответа считает количество быков и коров
        Game.BullsAndCowsCount count = game.calculateBullsAndCows(answer);
        String text = String.format("%d. Введено число %s. Количество быков %d, количество коров %d", ++step, answer, count.getBulls(), count.getCows());
        historyArea.appendText(text + "\n"); // метод .appendText() передает текст
        userAnswer.clear(); // очищаем поле userAnswer
        userAnswer.requestFocus(); // устанавливаем на него фокус, чтобы был курсор

        // проверяем победил или не победил игрок
        if (count.getBulls() == 4) {
            if (ifWantToPlayAgain()) {
                clickNewGame();
            } else {
                System.exit(0);
            }
        }
    }

    private boolean ifWantToPlayAgain() {
        // класс Alert() показывает всплывающее окошечко
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Поздравляю, вы выиграли!\n" +
                        "Загаданное число " + game.getGuessNum() + ".\n\n" + "Желаете сыграть еще?",
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO)
        );
        alert.setTitle("Поздравляю!");
        ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;
    }

    public void clickNewGame() {
        step = 0;
        // historyArea.clear(); // очищаем область
        historyArea.appendText("\n\n--- Начинаем новую игру! --- \n"); // можно не очищать историю, а разделить ее надписью
        this.game = new Game(); // начинаем новую игру
    }

    public void clickExit(ActionEvent actionEvent) {
        System.exit(0); // выходим из игры
    }
}
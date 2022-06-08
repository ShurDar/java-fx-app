package ru.gb.shurupova.javafxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField userText;


    public void clickChatButton(ActionEvent actionEvent) {
        String text = userText.getText();       // возвращает тот текст, который будет введен
        historyArea.appendText(text + "\n");  // выводит текст на экран с переносом на след. строку
        historyArea.setWrapText(true);          // переносит длину строк в текстовой области
        userText.clear();                       // очищает поле ввода сообщения после отправки сообщения
        userText.requestFocus();                // возвращает курсор в поле ввода сообщения

    }
}
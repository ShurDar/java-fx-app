module ru.gb.shurupova.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.shurupova.javafxapp to javafx.fxml;
    exports ru.gb.shurupova.javafxapp;
}
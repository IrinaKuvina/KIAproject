package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private Button bnExit;

    @FXML
    private ImageView image1;

    @FXML
    private Label lbB;

    @FXML
    private Label lbA;

    @FXML
    private Label lbX;

    @FXML
    private TextField textAns;

    @FXML
    private TextField texyB;

    @FXML
    private TextField textA;

    @FXML
    private TextField textX;

    @FXML
    private Button bnClear;

    @FXML
    private Button bnCount;

    @FXML
    private Label lbAnswer;

    @FXML
    private Label list1;

    @FXML
    void onClickMethod(ActionEvent event) {
        bnCount.setOnMouseClicked(mouseEvent -> {
            double x, a, b, y;
            y= 0;
            x = Double.valueOf(textX.getText());
            a = Double.valueOf(textA.getText());
            b = Double.valueOf(texyB.getText());
            if (x <= 7) {
                if (a == 0 && b == 0) {
                    textAns.setText("А и В не могут одновременно равняться нулю!");
                } else {
                    y = (x + 4) / (x*(a*a+b*b));
                    textAns.setText(String.valueOf(y));
                }
            } else {
                y = x * (a + b) * (a + b);
                textAns.setText(String.valueOf(y));
            }
        });
        bnClear.setOnMouseClicked(mouseEvent -> {
            textAns.clear();
            textA.clear();
            textX.clear();
            texyB.clear();
        });
        bnExit.setOnMouseClicked(mouseEvent -> {
            Platform.exit();
        });
    }

    @FXML
    void initialize() {
        assert mainForm != null : "fx:id=\"mainForm\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnExit != null : "fx:id=\"bnExit\" was not injected: check your FXML file 'sample.fxml'.";
        assert image1 != null : "fx:id=\"image1\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbB != null : "fx:id=\"lbB\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbA != null : "fx:id=\"lbA\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbX != null : "fx:id=\"lbX\" was not injected: check your FXML file 'sample.fxml'.";
        assert textAns != null : "fx:id=\"textAns\" was not injected: check your FXML file 'sample.fxml'.";
        assert texyB != null : "fx:id=\"texyB\" was not injected: check your FXML file 'sample.fxml'.";
        assert textA != null : "fx:id=\"textA\" was not injected: check your FXML file 'sample.fxml'.";
        assert textX != null : "fx:id=\"textX\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnClear != null : "fx:id=\"bnClear\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnCount != null : "fx:id=\"bnCount\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbAnswer != null : "fx:id=\"lbAnswer\" was not injected: check your FXML file 'sample.fxml'.";
        assert list1 != null : "fx:id=\"list1\" was not injected: check your FXML file 'sample.fxml'.";

    }
}


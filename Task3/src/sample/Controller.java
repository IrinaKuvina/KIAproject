package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private TableView tableMas;

    @FXML
    private TableColumn<TableRow, String> col1;

    @FXML
    private TableColumn<TableRow, String> col2;

    @FXML
    private TableColumn<TableRow, String> col3;

    @FXML
    private TableColumn<TableRow, String> col4;

    @FXML
    private TableColumn<TableRow, String> col5;

    @FXML
    private Button bnCount;

    @FXML
    private Button bnGen;

    @FXML
    private Label lbTask;

    @FXML
    private Label lbMin;

    @FXML
    private Label lnMax;

    @FXML
    private Label lbMaxVal;

    @FXML
    private Label lbMinVal;

    private ObservableList<TableRow> data = FXCollections.observableArrayList();
    private double[][] massive = new double[5][5];
    @FXML
    void OnClickMethod(ActionEvent event) {
        bnGen.setOnMouseClicked(mouseEvent -> {
            data.clear();
            String x1, x2, x3, x4, x5;
            for(int i=0; i<5; i++) {
                for (int j = 0; j < 5; j++) {
                    Random rnd = new Random();
                    massive[i][j] = Math.round(rnd.nextDouble() * 10 - 5);
                }
            }
            for (int i = 0; i < 5; i++) {
                x1 = String.valueOf(massive[i][0]);
                x2 = String.valueOf(massive[i][1]);
                x3 = String.valueOf(massive[i][2]);
                x4 = String.valueOf(massive[i][3]);
                x5 = String.valueOf(massive[i][4]);
                data.add(new TableRow(x1, x2, x3, x4, x5));
                tableMas.setItems(data);
            }
        });
        bnCount.setOnMouseClicked(mouseEvent -> {
            String x1, x2, x3, x4, x5;
            double max = massive[0][0];
            double min = massive[0][0];
            for (int i = 1; i < 5; i++) {
                for (int j = 1; j < 5; j++) {
                    if (massive[i][j] < min) min = massive[i][j];
                    if (massive[i][j] > max) max = massive[i][j];
                }
            }
            lbMaxVal.setText(String.valueOf(max));
            lbMinVal.setText(String.valueOf(min));
            if (max == min * 10) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (massive[i][j] == 0) massive[i][j] = 1;
                        if (massive[i][j] < 0) massive[i][j] = -massive[i][j];
                    }
                }
                data.clear();
                for (int i = 0; i < 5; i++) {
                    x1 = String.valueOf(massive[i][0]);
                    x2 = String.valueOf(massive[i][1]);
                    x3 = String.valueOf(massive[i][2]);
                    x4 = String.valueOf(massive[i][3]);
                    x5 = String.valueOf(massive[i][4]);
                    data.add(new TableRow(x1, x2, x3, x4, x5));
                    tableMas.setItems(data);
                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        assert mainForm != null : "fx:id=\"mainForm\" was not injected: check your FXML file 'sample.fxml'.";
        assert tableMas != null : "fx:id=\"tableMas\" was not injected: check your FXML file 'sample.fxml'.";
        assert col1 != null : "fx:id=\"col1\" was not injected: check your FXML file 'sample.fxml'.";
        assert col2 != null : "fx:id=\"col2\" was not injected: check your FXML file 'sample.fxml'.";
        assert col3 != null : "fx:id=\"col3\" was not injected: check your FXML file 'sample.fxml'.";
        assert col4 != null : "fx:id=\"col4\" was not injected: check your FXML file 'sample.fxml'.";
        assert col5 != null : "fx:id=\"col5\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnCount != null : "fx:id=\"bnCount\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnGen != null : "fx:id=\"bnGen\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbTask != null : "fx:id=\"lbTask\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbMin != null : "fx:id=\"lbMin\" was not injected: check your FXML file 'sample.fxml'.";
        assert lnMax != null : "fx:id=\"lnMax\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbMaxVal != null : "fx:id=\"lbMaxVal\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbMinVal != null : "fx:id=\"lbMinVal\" was not injected: check your FXML file 'sample.fxml'.";

        col1.setCellValueFactory(cellData -> cellData.getValue().col1Property());
        col2.setCellValueFactory(cellData -> cellData.getValue().col2Property());
        col3.setCellValueFactory(cellData -> cellData.getValue().col3Property());
        col4.setCellValueFactory(cellData -> cellData.getValue().col4Property());
        col5.setCellValueFactory(cellData -> cellData.getValue().col5Property());

    }
}
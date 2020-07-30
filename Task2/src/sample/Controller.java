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
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private ImageView image1;

    @FXML
    private TableView table1;

    @FXML
    private TableColumn<TableRow, String> ki;

    @FXML
    private TableColumn<TableRow, String> yi;

    @FXML
    private Label text1;

    @FXML
    private Label lbB;

    @FXML
    private Label lbA;

    @FXML
    private Pane panel1;

    @FXML
    private Label text2;

    @FXML
    private Label text3;

    @FXML
    private Button bnExit;

    @FXML
    private Button bnClear;

    @FXML
    private Button bnGen;

    @FXML
    private Button bnCount;

    @FXML
    private TextField textB;

    @FXML
    private TextField taxtA;

    @FXML
    void OnClickMethod(ActionEvent event) {
        bnGen.setOnMouseClicked(mouseEvent -> {
            Random rnd = new Random();
            taxtA.setText(String.valueOf(rnd.nextDouble() * 100));
            textB.setText(String.valueOf(rnd.nextDouble()*100));
        });
        bnClear.setOnMouseClicked(mouseEvent -> {
            taxtA.clear();
            textB.clear();
            data1.clear();
            data.clear();
            fillTableWithData();
        });
        bnExit.setOnMouseClicked(mouseEvent -> {
            Platform.exit();
        });
        bnCount.setOnMouseClicked(mouseEvent -> {
            double y;
            double s = 0;
            double a = Double.valueOf(taxtA.getText());
            double b = Double.valueOf(textB.getText());
            data.clear();
            data1.clear();
            if (a != 0 && b != 0) {
                for (int i = 0; i < 10; i++) {
                    y = Math.sqrt(Math.cos(massive[i]) * Math.cos(massive[i]) / ((a * a + b * a) - Math.sin(massive[i]))) + s;
                    if (i == 0) {
                        data1.add(new TableRow(String.valueOf(massive[i]), "-"));
                    } else {
                        data1.add(new TableRow(String.valueOf(massive[i]), String.valueOf(y)));
                    }
                    table1.setItems(data1);
                    s = massive[i];
                }
            } else {
                textB.setText("Решения нет!");
            }
        });
    }

    private ObservableList<TableRow> data = FXCollections.observableArrayList();

    private ObservableList<TableRow> data1 = FXCollections.observableArrayList();

    private double[] massive = new double[10];

   @Override
   public void initialize(URL location, ResourceBundle resources) {

        assert mainForm != null : "fx:id=\"mainForm\" was not injected: check your FXML file 'sample.fxml'.";
        assert image1 != null : "fx:id=\"image1\" was not injected: check your FXML file 'sample.fxml'.";
        assert table1 != null : "fx:id=\"table1\" was not injected: check your FXML file 'sample.fxml'.";
        assert ki != null : "fx:id=\"ki\" was not injected: check your FXML file 'sample.fxml'.";
        assert yi != null : "fx:id=\"yi\" was not injected: check your FXML file 'sample.fxml'.";
        assert text1 != null : "fx:id=\"text1\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbB != null : "fx:id=\"lbB\" was not injected: check your FXML file 'sample.fxml'.";
        assert lbA != null : "fx:id=\"lbA\" was not injected: check your FXML file 'sample.fxml'.";
        assert panel1 != null : "fx:id=\"panel1\" was not injected: check your FXML file 'sample.fxml'.";
        assert text2 != null : "fx:id=\"text2\" was not injected: check your FXML file 'sample.fxml'.";
        assert text3 != null : "fx:id=\"text3\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnExit != null : "fx:id=\"bnExit\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnClear != null : "fx:id=\"bnClear\" was not injected: check your FXML file 'sample.fxml'.";
        assert bnGen != null : "fx:id=\"bnGen\" was not injected: check your FXML file 'sample.fxml'.";
        assert textB != null : "fx:id=\"textB\" was not injected: check your FXML file 'sample.fxml'.";
        assert taxtA != null : "fx:id=\"taxtA\" was not injected: check your FXML file 'sample.fxml'.";

        ki.setCellValueFactory(cellData -> cellData.getValue().kiProperty());
        yi.setCellValueFactory(cellData -> cellData.getValue().yiProperty());
        yi.setCellFactory(param -> {
            TableCell<TableRow, String> cell = new TableCell<>();
            Text text = new Text();
            text.setStyle("");
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.textProperty().bind(cell.itemProperty());
            text.wrappingWidthProperty().bind(yi.widthProperty());
            return cell;
        });
    }
    public void fillTableWithData()
    {
        for(int i=0; i<10; i++)
    {
        Random rnd = new Random();
        massive[i] = rnd.nextDouble()*100;
        data.add(new TableRow(String.valueOf(massive[i]),"-"));
        table1.setItems(data);
    }
    }

}

package sample;

import javafx.beans.property.SimpleStringProperty;

public class TableRow {
    SimpleStringProperty ki = new SimpleStringProperty();
    SimpleStringProperty yi = new SimpleStringProperty();

    TableRow(String p1, String p2) {
        this.ki = new SimpleStringProperty(p1);
        this.yi = new SimpleStringProperty(p2);
    }
    public String getKi() {
        return ki.get();
    }

    public SimpleStringProperty kiProperty() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki.set(ki);
    }

    public String getYi() {
        return yi.get();
    }

    public SimpleStringProperty yiProperty() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi.set(yi);
    }

}

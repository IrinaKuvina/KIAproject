package sample;

import javafx.beans.property.SimpleStringProperty;

public class TableRow {
    SimpleStringProperty col1 = new SimpleStringProperty();
    SimpleStringProperty col2 = new SimpleStringProperty();
    SimpleStringProperty col3 = new SimpleStringProperty();
    SimpleStringProperty col4 = new SimpleStringProperty();
    SimpleStringProperty col5 = new SimpleStringProperty();

    TableRow(String p1, String p2, String p3, String p4, String p5) {
        this.col1 = new SimpleStringProperty(p1);
        this.col2 = new SimpleStringProperty(p2);
        this.col3 = new SimpleStringProperty(p3);
        this.col4 = new SimpleStringProperty(p4);
        this.col5 = new SimpleStringProperty(p5);
    }
    public String getCol1() {
        return col1.get();
    }

    public SimpleStringProperty col1Property() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1.set(col1);
    }
    public String getCol2() {
        return col2.get();
    }

    public SimpleStringProperty col2Property() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2.set(col2);
    }

    public String getCol3() {
        return col3.get();
    }

    public SimpleStringProperty col3Property() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3.set(col3);
    }

    public String getCol4() {
        return col4.get();
    }

    public SimpleStringProperty col4Property() {
        return col4;
    }

    public void setCol4(String col4) {
        this.col4.set(col4);
    }

    public String getCol5() {
        return col5.get();
    }

    public SimpleStringProperty col5Property() {
        return col5;
    }

    public void setCol5(String col5) {
        this.col5.set(col5);
    }
}

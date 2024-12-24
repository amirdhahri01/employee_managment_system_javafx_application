module com.mycompany.javafx.database {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    
    opens com.mycompany.javafx.database to javafx.fxml;
    exports com.mycompany.javafx.database;
}

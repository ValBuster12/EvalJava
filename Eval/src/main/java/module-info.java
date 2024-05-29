module com.example.eval {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires java.sql;


    opens com.example.eval to javafx.fxml;
    exports com.example.eval;
}
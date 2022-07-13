module com.Javafx.Javafx {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;

    opens com.Javafx.Javafx to javafx.fxml;
    exports com.Javafx.Javafx;
}
module com.edu.espol.wordee {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.edu.espol.wordee to javafx.fxml;
    exports com.edu.espol.wordee;
}

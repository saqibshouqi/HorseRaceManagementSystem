module com.example.rapidrunprogrammingcw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rapidrunprogrammingcw to javafx.fxml;
    exports com.example.rapidrunprogrammingcw;
}
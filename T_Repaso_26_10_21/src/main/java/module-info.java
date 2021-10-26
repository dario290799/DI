module com.example.t_repaso_26_10_21 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.t_repaso_26_10_21 to javafx.fxml;
    exports com.example.t_repaso_26_10_21;
}
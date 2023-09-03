module com.manageschool.manageschool {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.manageschool.manageschool to javafx.fxml;
    exports com.manageschool.manageschool;
    exports com.manageschool.manageschool.Controllers;
    exports com.manageschool.manageschool.Controllers.Admin;
    exports com.manageschool.manageschool.Controllers.Student;
    exports com.manageschool.manageschool.Models;
    exports com.manageschool.manageschool.Views;
}
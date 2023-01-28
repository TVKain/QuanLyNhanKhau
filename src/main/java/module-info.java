module com.quanlynhankhau.hust.quanlynhankhau {
    requires javafx.controls;
    requires javafx.fxml;


    opens hust.itep.quanlynhankhau to javafx.fxml;
    exports hust.itep.quanlynhankhau;
}
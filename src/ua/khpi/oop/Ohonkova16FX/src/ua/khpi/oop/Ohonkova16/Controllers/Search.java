package ua.khpi.oop.Ohonkova16.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ua.khpi.oop.Ohonkova16.Animation.MyButtonSkin;
import ua.khpi.oop.Ohonkova16.App.Main;

public class Search {


    @FXML
    private Label id;

    @FXML
    private Label name;

    @FXML
    private Label unit;

    @FXML
    private Label count;

    @FXML
    private Label unit_price;

    @FXML
    private Label data_of_receipt;

    @FXML
    private Label attribute;

    @FXML
    private Label value;

    @FXML
    private Label error;

    @FXML
    private Button okButton;


    private void show() {
        if (Show.getSearchId().equals("")) {
            error.setText("No such values!");
        } else {
            for (int i = 0; i < Main.container.size(); i++) {
                if (String.valueOf(Main.container.getElementByIndex(i).getId()).equals(Show.getSearchId())) {
                    id.setText(String.valueOf(Main.container.getElementByIndex(i).getId()));
                    name.setText(String.valueOf(Main.container.getElementByIndex(i).getName()));
                    unit.setText(String.valueOf(Main.container.getElementByIndex(i).getUnit()));
                    count.setText(String.valueOf(Main.container.getElementByIndex(i).getCount()));
                    unit_price.setText(String.valueOf(Main.container.getElementByIndex(i).getUnitPrice()));
                    data_of_receipt.setText(String.valueOf(Main.container.getElementByIndex(i).getDataOfReceipt()));
                    attribute.setText(String.valueOf(Main.container.getElementByIndex(i).getAttribute()));
                    value.setText(String.valueOf(Main.container.getElementByIndex(i).getValue()));
                }
                break;
            }
        }
    }


    @FXML
    void initialize() {
        show();

        okButton.setSkin(new MyButtonSkin(okButton));

        okButton.setOnAction(event -> {
            okButton.getScene().getWindow().hide();
        });
    }
}

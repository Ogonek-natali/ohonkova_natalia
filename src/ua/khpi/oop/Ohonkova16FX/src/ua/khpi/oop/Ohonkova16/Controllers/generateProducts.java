package ua.khpi.oop.Ohonkova16.Controllers;

import java.io.IOException;
import java.util.NoSuchElementException;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import ua.khpi.oop.Ohonkova16.Animation.Shake;
import ua.khpi.oop.Ohonkova16.App.Main;
import ua.khpi.oop.Ohonkova16.Head.Store;
import ua.khpi.oop.Ohonkova16.Util.Util;

public class generateProducts {

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem backMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private ImageView backImage;

    @FXML
    private TextField nameField;

    @FXML
    private TextField unitField;

    @FXML
    private TextField countField;

    @FXML
    private TextField unit_priceField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField data_of_receiptField1;

    @FXML
    private TextField attributeField2;

    @FXML
    private TextField valueField21;



    private void shakesField(){
        Shake shake = new Shake(nameField);
        Shake shake1 = new Shake(unitField);
        Shake shake2 = new Shake(countField);
        Shake shake3 = new Shake(unit_priceField);
        Shake shake4 = new Shake(data_of_receiptField1);
        Shake shake5 = new Shake(attributeField2);
        Shake shake6 = new Shake(valueField21);
        shake.playAnim();
        shake1.playAnim();
        shake2.playAnim();
        shake3.playAnim();
        shake4.playAnim();
        shake5.playAnim();
        shake6.playAnim();
    }

    private void errorMessage() {
        Util.createNewScene("error.fxml", "Error");
    }


    private Store generateProducts() {
        Store recruitment = new Store();
        try {
            recruitment.setName(nameField.getText());
            recruitment.setUnit(unitField.getText());
            recruitment.setCount(Integer.parseInt(countField.getText()));
            recruitment.setUnitPrice(Integer.parseInt(unit_priceField.getText()));
            recruitment.setDataOfReceipt(data_of_receiptField1.getText());
            recruitment.setAttribute(attributeField2.getText());
            recruitment.setValue(valueField21.getText());

        } catch (Exception e) {
            throw new NoSuchElementException();
        }
        return recruitment;
    }

    @FXML
    void initialize() {

        backImage.setOnMouseClicked(event -> {
            Util.createNewScene("home.fxml", "Store");
            backImage.getScene().getWindow().hide();
        });

        backMenuItem.setOnAction(event -> {
            Util.createNewScene("home.fxml", "Store");
            backImage.getScene().getWindow().hide();
        });

        exitMenuItem.setOnAction(event -> {
            backImage.getScene().getWindow().hide();
        });


        saveButton.setOnAction(event -> {
            try {
                Main.container.add(generateProducts());
            } catch (Exception e) {
                System.out.println("Repeat entered:");
                errorMessage();
                shakesField();
                Main.container.add(generateProducts());
            }
            try {
                Util.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Util.createNewScene("home.fxml", "Store");
            saveButton.getScene().getWindow().hide();
        });

        clearMenuItem.setOnAction(event -> {
            nameField.setText("");
            unitField.setText("");
            countField.setText("");
            unit_priceField.setText("");
            data_of_receiptField1.setText("");
            attributeField2.setText("");
            valueField21.setText("");
        });
    }
}

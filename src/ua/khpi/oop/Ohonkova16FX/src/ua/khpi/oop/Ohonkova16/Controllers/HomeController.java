package ua.khpi.oop.Ohonkova16.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import ua.khpi.oop.Ohonkova16.Animation.MyButtonSkin;
import ua.khpi.oop.Ohonkova16.Util.Util;

public class HomeController {
    double x = 10;
    double y = 10;
    double w = 40;
    double h = 180;
    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem showAllMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private MenuItem numberMunuItem;

    @FXML
    private MenuItem AboutMenuItem;

    @FXML
    private Button newProductButton;

    @FXML
    private ImageView homeImageIco;

    @FXML
    private Button showAllProductsButton;

    @FXML
    private Button clearAllButton;

    @FXML
    private Button numberOfProductsButton;

    private void addVacancy() {
        Util.createNewScene("generateProducts.fxml", "Store");
    }

    @FXML
    private ImageView closeImageView;

    @FXML
    void initialize() {
        clearAllButton.setSkin(new MyButtonSkin(clearAllButton));
        newProductButton.setSkin(new MyButtonSkin(newProductButton));
        showAllProductsButton.setSkin(new MyButtonSkin(showAllProductsButton));
        numberOfProductsButton.setSkin(new MyButtonSkin(numberOfProductsButton));

        homeImageIco.setOnMouseClicked(event -> {
            homeImageIco.getScene().getWindow().hide();
            Util.createNewScene("welcome.fxml", "Store");
        });

        AboutMenuItem.setOnAction(event -> Util.createNewScene("aboutMenu.fxml", "About project"));

        newMenuItem.setOnAction(event -> {
            newProductButton.getScene().getWindow().hide();
            addVacancy();
        });

        closeImageView.setOnMouseClicked(event -> closeImageView.getScene().getWindow().hide());

        newProductButton.setOnAction(event -> {
            newProductButton.getScene().getWindow().hide();
            addVacancy();
        });

        exitMenuItem.setOnAction(event -> closeImageView.getScene().getWindow().hide());

        showAllProductsButton.setOnAction(event -> {
            Util.createNewScene("show.fxml", "Show");
            showAllProductsButton.getScene().getWindow().hide();
        });

        clearAllButton.setOnAction(event -> Util.createNewScene("clear.fxml", "Clear"));

        clearMenuItem.setOnAction(event -> Util.createNewScene("clear.fxml", "Clear"));

        numberOfProductsButton.setOnAction(event -> Util.createNewScene("number.fxml", "Number of products"));

        numberMunuItem.setOnAction(event -> Util.createNewScene("number.fxml", "Number of products"));

        showAllMenuItem.setOnAction(event -> {
            Util.createNewScene("show.fxml", "Show");
            showAllProductsButton.getScene().getWindow().hide();
        });

    }
}

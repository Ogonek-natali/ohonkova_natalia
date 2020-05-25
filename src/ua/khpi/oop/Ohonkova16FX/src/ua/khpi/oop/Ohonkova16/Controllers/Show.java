package ua.khpi.oop.Ohonkova16.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import ua.khpi.oop.Ohonkova16.Animation.MyButtonSkin;
import ua.khpi.oop.Ohonkova16.Animation.Shake;
import ua.khpi.oop.Ohonkova16.App.Main;
import ua.khpi.oop.Ohonkova16.Head.Store;
import ua.khpi.oop.Ohonkova16.Util.Util;

import java.io.IOException;

public class Show {

    private ObservableList<Store> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Store> tableViewId;

    @FXML
    private TableColumn<Store, Integer> idProduct;

    @FXML
    private TableColumn<Store, String> nameId;

    @FXML
    private TableColumn<Store, String> unitId;

    @FXML
    private TableColumn<Store, Integer> countId;

    @FXML
    private TableColumn<Store, Integer> unit_priceId;

    @FXML
    private TableColumn<Store, String> data_of_receiptId;

    @FXML
    private TableColumn<Store, String> attributeId;

    @FXML
    private TableColumn<Store, String> valueId;

    @FXML
    private ImageView refresh;

    @FXML
    private Button deleteId;

    @FXML
    private ImageView back;

    @FXML
    private TextField idField;

    @FXML
    private Button searchButton;

    private static String searchId;

    public static String getSearchId() {
        return searchId;
    }

    private void search() {
        searchId = idField.getText();
        if (searchId.equals("")){
            Shake shake = new Shake(idField);
            shake.playAnim();
        }
        Util.createNewScene("search.fxml", "Search");
    }

    @FXML
    void initialize() {
        searchButton.setSkin(new MyButtonSkin(searchButton));
        deleteId.setSkin(new MyButtonSkin(deleteId));

        initData();
        idProduct.setCellValueFactory(new PropertyValueFactory<Store, Integer>("id"));
        nameId.setCellValueFactory(new PropertyValueFactory<Store, String>("name"));
        unitId.setCellValueFactory(new PropertyValueFactory<Store, String>("unit"));
        countId.setCellValueFactory(new PropertyValueFactory<Store, Integer>("count"));
        unit_priceId.setCellValueFactory(new PropertyValueFactory<Store, Integer>("UnitPrice"));
        data_of_receiptId.setCellValueFactory(new PropertyValueFactory<Store, String>("DataOfReceipt"));
        attributeId.setCellValueFactory(new PropertyValueFactory<Store, String>("attribute"));
        valueId.setCellValueFactory(new PropertyValueFactory<Store, String>("value"));


        tableViewId.setItems(list);

        deleteId.setOnAction(event -> {
            Main.container.remove(tableViewId.getSelectionModel().getSelectedItem());
            try {
                Util.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        refresh.setOnMouseClicked(event -> {
            refresh.getScene().getWindow().hide();
            Util.createNewScene("show.fxml", "Show");
        });

        back.setOnMouseClicked(event -> {
            Util.createNewScene("home.fxml", "Store");
            back.getScene().getWindow().hide();
        });

        searchButton.setOnAction(event -> search());

    }

    private void initData() {
        for (int i = 0; i < Main.container.size(); i++) {
            list.add(Main.container.getElementByIndex(i));
        }
    }
}

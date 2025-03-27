import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloView extends Application {

    private HelloController hC = new HelloController();

    private Label lblDistance;
    private Label lblFuel;
    private Label lblResult;

    private TextField txtDistance;
    private TextField txtFuel;

    private Button btnCalculate;
    private Button btnEN;
    private Button btnFR;
    private Button btnJP;
    private Button btnIR;

    private Locale locale = new Locale("en", "US");
    private ResourceBundle rb;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fuel Consumption Calculator");
        VBox vbox = new VBox(10);

        Insets insets = new Insets(10, 10, 10, 10);

        initialize();

        lblDistance = new Label(rb.getString("distance.label"));
        txtDistance = new TextField();

        lblFuel = new Label(rb.getString("fuel.label"));
        txtFuel = new TextField();

        btnCalculate = new Button(rb.getString("calculate.button"));
        lblResult = new Label();

        btnCalculate.setOnAction(e -> {
            try {
                double distance = Double.parseDouble(txtDistance.getText());
                double fuel = Double.parseDouble(txtFuel.getText());
                hC.calculateFuel(distance, fuel, lblResult);

            } catch (Exception ex) {
                lblResult.setText(rb.getString("invalid.input"));
            }
        });

        hC.updateUI(lblDistance, lblFuel, btnCalculate, lblResult);

        HBox hbox = new HBox(10);
        btnEN = new Button("EN");
        btnFR = new Button("FR");
        btnJP = new Button("JP");
        btnIR = new Button("IR");

        btnEN.setOnAction(e -> onENclick());
        btnFR.setOnAction(e -> onFRclick());
        btnJP.setOnAction(e -> onJPclick());
        btnIR.setOnAction(e -> onIRclick());

        Label nametag = new Label("27.3.2025 Tommi Halla");

        hbox.getChildren().addAll(btnEN, btnFR, btnJP, btnIR);
        vbox.getChildren().addAll(lblDistance, txtDistance, lblFuel, txtFuel, btnCalculate, lblResult, hbox, nametag);
        vbox.setPadding(insets);

        Scene scene = new Scene(vbox, 350, 280);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void initialize() {
        hC.setLanguage(locale);
        rb = ResourceBundle.getBundle("messages", locale);
    }

    public void onENclick() {
        locale = new Locale("en", "US");
        hC.setLanguage(locale);
        hC.updateUI(lblDistance, lblFuel, btnCalculate, lblResult);
    }

    public void onFRclick() {
        locale = new Locale("fr", "FR");
        hC.setLanguage(locale);
        hC.updateUI(lblDistance, lblFuel, btnCalculate, lblResult);
    }

    public void onJPclick() {
        locale = new Locale("ja", "JP");
        hC.setLanguage(locale);
        hC.updateUI(lblDistance, lblFuel, btnCalculate, lblResult);
    }

    public void onIRclick() {
        locale = new Locale("fa", "IR");
        hC.setLanguage(locale);
        hC.updateUI(lblDistance, lblFuel, btnCalculate, lblResult);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

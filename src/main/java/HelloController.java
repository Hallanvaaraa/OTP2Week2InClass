import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    private Locale locale;

    public void setLanguage(Locale locale) {
        this.locale = locale;
    }

    public void updateUI(Locale newLocale, Label lblDistance, Label lblFuel, Button btnCalculate, Label lblResult) {
        lblResult.setText("");
        ResourceBundle rb;
        locale = newLocale;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
            lblDistance.setText(rb.getString("distance.label"));
            lblFuel.setText(rb.getString("fuel.label"));
            btnCalculate.setText(rb.getString("calculate.button"));
        } catch (Exception e) {
            e.printStackTrace();
            lblResult.setText("Error loading language");
        }
    }

    // Calculate fuel consumption, result is in liters per 100 kilometer
    public void calculateFuel(double distance, double fuel, Label lblResult) {
        double result = fuel / distance * 100;
        ResourceBundle rb = ResourceBundle.getBundle("messages", locale);
        lblResult.setText(rb.getString("result.label") + " " + result + " " + rb.getString("result.unit"));
    }
}

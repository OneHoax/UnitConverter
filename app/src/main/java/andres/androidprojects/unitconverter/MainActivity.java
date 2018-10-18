package andres.androidprojects.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText millimeterInput;
    private EditText centimeterInput;
    private EditText meterInput;
    private EditText inchInput;
    private EditText footInput;
    static double millimeter;
    static double centimeter;
    static double meter;
    static double inch;
    static double foot;

    Units u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to EditTexts
        millimeterInput = (EditText) findViewById(R.id.millimeterInput);
        centimeterInput = (EditText) findViewById(R.id.centimeterInput);
        meterInput = (EditText) findViewById(R.id.meterInput);
        inchInput = (EditText) findViewById(R.id.inchInput);
        footInput = (EditText) findViewById(R.id.footInput);
    }

    // Helper method for checking if input is not empty; if it is not, parse into int
    public double check(String input) {
        double result = 0;
        if (input.length() > 0) {
            result = Integer.parseInt(input);
        }
        return result;
    }

    // Get input from EditTexts and parse them into ints if not empty and apply convert method
    public void convertButtonClicked(View view) {
        try {
            String millimeterString = millimeterInput.getText().toString();
            millimeter = check(millimeterString);

            String centimeterString = centimeterInput.getText().toString();
            centimeter = check(centimeterString);

            String meterString = meterInput.getText().toString();
            meter = check(meterString);

            String inchString = inchInput.getText().toString();
            inch = check(inchString);

            String footString = footInput.getText().toString();
            foot = check(footString);

            u = new Units();

            if (millimeter > 0) {
                u.convert(millimeter);
            }else if (centimeter > 0) {
                u.convert(centimeter);
            } else if (meter > 0) {
                u.convert(meter);
            } else if (inch > 0) {
                u.convert(inch);
            } else if (foot > 0) {
                u.convert(foot);
            }

            millimeterInput.setText(String.valueOf(u.getMillimeter()));
            centimeterInput.setText(String.valueOf(u.getCentimeter()));
            meterInput.setText(String.valueOf(u.getMeter()));
            inchInput.setText(String.valueOf(u.getInch()));
            footInput.setText(String.valueOf(u.getFoot()));
        } catch (Exception e) {
            System.err.println("Use the Refresh Button");
        }
    }

    // Refresh the EditTexts and double values
    public void refreshButtonClicked(View view) {
        try {
            millimeterInput.setText("");
            centimeterInput.setText("");
            meterInput.setText("");
            inchInput.setText("");
            footInput.setText("");
            millimeter = 0;
            centimeter = 0;
            meter = 0;
            inch = 0;
            foot = 0;
            u.refresh();
        } catch (Exception e) {
            System.err.println("Don't leave the button pressed");
        }
    }
}

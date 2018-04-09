package com.example.android.quizzical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks which radiobutton is correct in Question 1
     */
    public void onQuestion1RadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question1_option1:
                if (checked)
                    break;
            case R.id.question1_option2:
                if (checked)
                    break;
            case R.id.question1_option3:
                if (checked)
                    score = score + 1;
                break;
            case R.id.question1_option4:
                if (checked)
                    break;
        }
    }

    /**
     * Checks which radiobutton is correct in Question 2
     */
    public void onQuestion2RadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question2_option1:
                if (checked)
                    score = score + 1;
                break;
            case R.id.question2_option2:
                if (checked)
                    break;
            case R.id.question2_option3:
                if (checked)
                    break;
            case R.id.question2_option4:
                if (checked)
                    break;
        }
    }

    /**
     * Checks which radiobutton is correct in Question 3
     */
    public void onQuestion3RadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question3_option1:
                if (checked)
                    break;
            case R.id.question3_option2:
                if (checked)
                    score = score + 1;
                break;
            case R.id.question3_option3:
                if (checked)
                    break;
            case R.id.question3_option4:
                if (checked)
                    break;
        }
    }

    /**
     * Checks which radiobutton is correct in Question 4
     */
    public void onQuestion4RadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question4_option1:
                if (checked)
                    break;
            case R.id.question4_option2:
                if (checked)
                    score = score + 1;
                break;
            case R.id.question4_option3:
                if (checked)
                    break;
            case R.id.question4_option4:
                if (checked)
                    break;
        }
    }

    /**
     * Checks which radiobutton is correct in Question 4
     */
    public void onQuestion5RadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question5_option1:
                if (checked)
                    score = score + 1;
                break;
            case R.id.question5_option2:
                if (checked)
                    break;
            case R.id.question5_option3:
                if (checked)
                    break;
            case R.id.question5_option4:
                if (checked)
                    break;
        }
    }

    public void pressSubmit (View view) {
        EditText nameInput = (EditText) findViewById(R.id.enter_name);
        String nameField = nameInput.getText().toString();
        if (score < 4) {
            Toast.makeText(this, "Hoorah! " + nameField + " You scored a " + score + " out of 5. Great effort!",
                    Toast.LENGTH_LONG).show();
        }
        if (score == 4) {
            Toast.makeText(this, "Hoorah! " + nameField +" You scored a " + score + " out of 5. You were so close!",
                    Toast.LENGTH_LONG).show();
        }
        if (score == 5) {
            Toast.makeText(this, "Hoorah! " + nameField +" You scored a " + score + " out of 5. Perfecto!",
                    Toast.LENGTH_LONG).show();
        }

    }

}

package com.example.calculatorapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.lang.*;

public class MainActivity extends AppCompatActivity {

    String lastNumber = ""; // global that keeps track of which number was clicked last
    String lastOperator = ""; // keeps track of which operator has been pressed last
    boolean clearScreen = false; // clears the screen so the user can type a new operand with out appending
    boolean equalsLock = false; // prevents the user from running the equals method multiple times

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // All of the display methods take in a view object as the only parameter. This allows access to
    // what the user is seeing. These methods set the locks discussed above. They also display the appropriate
    // number in the "typingBox" (the grey text box), and clear the screen when necessary.

    public void display0(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "0"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display1(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "1"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display2(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "2"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display3(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "3"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display4(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText()+ "4"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display5(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "5"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display6(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "6"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display7(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText()+ "7"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display8(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "8"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void display9(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(clearScreen)
        {
            typingBox.setText("");
        }
        typingBox.setText(typingBox.getText() + "9"  );
        clearScreen = false;
        equalsLock = false;
    }

    public void clear(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        typingBox.setText("");
        lastOperator = "";
        lastNumber = "";
        equalsLock = false;
    }

    public void backspace(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        String text = "";
        text = typingBox.getText().toString();
        if(typingBox.getText().toString().isEmpty())
        {
            return;
        }
        typingBox.setText(text.substring(0, text.length()-1));
        equalsLock = false;

    }

    // The operatorCheckAndSet method uses a switch statement to determine which operator has been clicked by the user.
    // It also sets the lastOperator variable.

    public void operatorCheckAndSet(View view) {
        switch (view.getId()) {
            case R.id.buttonAdd:
                lastOperator = "+";
                break;
            case R.id.buttonSubtract:
                lastOperator = "-";
                break;
            case R.id.buttonMultiply:
                lastOperator = "*";
                break;
            case R.id.buttonDivide:
                lastOperator = "/";
                break;
        }
    }

    // The operatorClick method functions very similarly to the equals button. It performs the calculations as the user
    // clicks different operators. It also will not set the operator unless the user has actually input an operand.
    // It also converts floats that are whole numbers to decimals so that '5' does not display as "5.000".

    public void operatorClick(View view) {

        TextView typingBox = (TextView) findViewById(R.id.typingBox);

        clearScreen = true;

        equalsLock = false;

        if (lastOperator.isEmpty() && !typingBox.getText().toString().isEmpty()) {
            operatorCheckAndSet(view);
        }
        if (lastNumber.isEmpty() && !typingBox.getText().toString().isEmpty()) {
            if(typingBox.getText().toString().isEmpty())
            {
                lastNumber = "0";
            }
            else
            {
                lastNumber = typingBox.getText().toString();
            }
        }
        else{
            String currentNumber;
            if(typingBox.getText().toString().isEmpty())
            {
                currentNumber = "0";
            }
            else
            {
                currentNumber = typingBox.getText().toString();
            }
            if (lastOperator.equals("+")) {
                float result = Float.parseFloat(lastNumber) + Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
            } else if (lastOperator.equals("-")) {
                float result = Float.parseFloat(lastNumber) - Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
            } else if (lastOperator.equals("*")) {
                float result = Float.parseFloat(lastNumber) * Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
            } else if (lastOperator.equals("/")) {
                float result = Float.parseFloat(lastNumber) / Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
            }
            operatorCheckAndSet(view);
        }

    }

    // The equals method functions very similarly to the operatorClick method. The main difference is that while operatorClick calculates
    // the answer as it goes, and allows the user to continue to add/sub/div/mult their last answer, the equals button does not. It
    // clears all of the global variable, assuming the user is not done with this calculation.

    public void equals(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);

        clearScreen = true;

        if(equalsLock)
        {
            return;
        }
        else {
            String currentNumber;
            if(typingBox.getText().toString().isEmpty())
            {
                currentNumber = "0";
            }
            else
            {
                currentNumber = typingBox.getText().toString();
            }
            if (lastOperator.equals("+")) {
                float result = Float.parseFloat(lastNumber) + Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
                lastOperator = "";
            } else if (lastOperator.equals("-")) {
                float result = Float.parseFloat(lastNumber) - Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
            } else if (lastOperator.equals("*")) {
                float result = Float.parseFloat(lastNumber) * Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
            } else if (lastOperator.equals("/")) {
                float result = Float.parseFloat(lastNumber) / Float.parseFloat(currentNumber);
                if (result % 1 == 0 && result < 2147483647) {
                    lastNumber = Integer.toString((int) result);
                } else {
                    lastNumber = Float.toString(result);
                }
                typingBox.setText(lastNumber);
            }
            lastOperator = "";
            lastNumber = "";
            equalsLock = true;

        }
    }

    // The plusMinus method converts positive numbers to negative, and vice versa, by multiplying whatever is in the typingBox
    // by -1. It checks to be sure the typingBox is not empty.

    public void plusMinus(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);
        if(!typingBox.getText().toString().isEmpty()) {
            float flipSign = Float.parseFloat(typingBox.getText().toString());
            flipSign = flipSign * -1;
            typingBox.setText(Float.toString(flipSign));
        }
    }

    //The decimal method simply appends a decimal to the screen. It will not allow a user to add more than one decimal.

    public void decimal(View view)
    {
        TextView typingBox = (TextView) findViewById(R.id.typingBox);

        if(clearScreen)
        {
            typingBox.setText("");
        }

        if(typingBox.getText().toString().contains("."))
        {
            return;
        }
        else
        {
            typingBox.setText(typingBox.getText() + "."  );
        }

        clearScreen = false;
    }
}

package com.company.buildings.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.company.buildings.R;

import com.company.buildings.logic.Logic;
import com.company.buildings.logic.LogicInterface;

/**
 * Main UI of this app.
 */
public class MainActivity
        extends AppCompatActivity
        implements OutputInterface {
    /**
     * String for LOGGING
     */
    private final static String LOG_TAG =
            MainActivity.class.getCanonicalName();

    /**
     * Logic Instance.
     */
    private LogicInterface mLogic;

    /**
     * EditText that stores the output.
     */
    private EditText mOutput;

    /**
     * EditText that stores the size.
     */
    private EditText mSize;

    /**
     * Button the user presses to perform the computation.
     */
    private Button mProcessButton;

    /**
     * Called when the activity is starting.
     *
     * Similar to 'main' in C/C++/Standalone Java
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // required
        super.onCreate(savedInstanceState);

        // Create a new 'Logic' instance.
        mLogic = new Logic(this);

        // setup the UI.
        initializeUI();
    }

    /**
     * This method sets up/gets reference to the UI components.
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Initialize the views.
        mOutput = (EditText) findViewById(R.id.outputET);
        mSize = (EditText) findViewById(R.id.sizeET);
        mProcessButton = (Button) findViewById(R.id.button);
    }

    /**
     * Called when Button is Pressed.
     *
     * @param buttonPress
     */
    public void buttonPressed(View buttonPress) {
        resetText();
        mLogic.process();
    }

    /**
     * Set the EditText's text.
     */
    private void addToEditText(String string){
        mOutput.setText("" + mOutput.getText() + string);
    }

    /**
     * This prints to the output a string.
     * @param text
     */
    @Override
    public void print(String text) {
        Log.d(LOG_TAG, "print(String)");
        addToEditText(text);
    }

    /**
     * This prints to the output a char.
     * @param _char
     */
    @Override
    public void print(char _char) {
        print("" + _char);
    }

    /**
     * This prints to the screen a string then a new line.
     * @param text
     */
    @Override
    public void println(String text) {
        Log.d(LOG_TAG,"println(String)");
        addToEditText(text + "\n");
    }

    /**
     * This prints to the screen a char then a new line.
     * @param _char
     */
    @Override
    public void println(char _char) {
        println("" + _char);
    }

    /**
     * Reset the on-screen output (EditText box).
     */
    @Override
    public void resetText() {
        mOutput.setText("");
    }

    /**
     * Allow log messages from Logic.
     */
    @Override
    public void log(String logtext) {
        Log.d(Logic.TAG, logtext);
    }
}
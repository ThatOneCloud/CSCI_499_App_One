package com.example.blake.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    /** Number of correct guesses made. Total guesses is heads+tails */
    private int correctGuesses = 0;

    /** Number of times the coin came up heads. */
    private int heads = 0;

    /** Number of times the coin came up tails */
    private int tails = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grab the text labels
        final TextView resultMsg = (TextView) findViewById(R.id.resultMessageText);
        final TextView guessMsg = (TextView) findViewById(R.id.guessRatioText);
        final TextView flipMsg = (TextView) findViewById(R.id.flipRatioText);

        // Grab the buttons
        Button headButton = (Button) findViewById(R.id.headsButton);
        Button tailButton = (Button) findViewById(R.id.tailsButton);

        // Add listeners for the buttons
        headButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Will this work?
                System.out.println("Heads button clicked");

                // Get a random result, will the flip be heads or tails
                boolean headResult = flipCoin();

                // True for heads. Did we guess right, then?
                if(headResult)
                {
                    // We guessed right. Change the statistics
                    correctGuesses++;
                    heads++;

                    resultMsg.setText("You guessed correctly!");
                } else {
                    // Guessed wrong.
                    tails++;

                    resultMsg.setText("You guessed wrong :(");
                }

                // Now to update the other messages
                guessMsg.setText((correctGuesses) + "/" + (heads+tails) + " Guesses Correct");
                flipMsg.setText(heads + ":" + tails + " Heads:Tails");
            }
        });

        tailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Will this work?
                System.out.println("Tails button clicked");

                // Get a random result, will the flip be heads or tails
                boolean headResult = flipCoin();

                // True for heads. Did we guess right, then?
                if(!headResult)
                {
                    // We guessed right. Change the statistics
                    correctGuesses++;
                    tails++;

                    resultMsg.setText("You guessed correctly!");
                } else {
                    // Guessed wrong.
                    heads++;

                    resultMsg.setText("You guessed wrong :(");
                }

                // Now to update the other messages
                guessMsg.setText((correctGuesses) + "/" + (heads+tails) + " Guesses Correct");
                flipMsg.setText(heads + ":" + tails + " Heads:Tails");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Flip a coin to see if it was heads
     * @return True if the flip was heads
     */
    private boolean flipCoin()
    {
        return Math.random() >= 0.50;
    }
}

package edu.mel06002byui.favoritescripture;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ScriptureReader extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "edu.mel06002byui.favoritescripture.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripture_reader);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scripture_reader, menu);
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
     * Will switch to a new activity that displays the compiled string
     * @param view view from the current display
     */
    public void displayFavorite(View view) {
        Intent intent = new Intent(this, DisplayScripture.class);
        EditText bookEditText = (EditText) findViewById(R.id.editBook);
        EditText chapterEditText = (EditText) findViewById(R.id.editChapter);
        EditText verseEditText = (EditText) findViewById(R.id.editVerse);
        String message = bookEditText.getText().toString() + " "
                + chapterEditText.getText().toString() + ":"
                + verseEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

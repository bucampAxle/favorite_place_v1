package toulotte_jardet_bucamp.favorite_place_v1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class add_new_place extends ActionBarActivity {
    private NotesDbAdapter mDbHelper;
    public static Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_place);
        activity = this;
        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final EditText adresse = (EditText) findViewById(R.id.adresse);
        final EditText titre = (EditText) findViewById(R.id.titre);
        final EditText description = (EditText) findViewById(R.id.description);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorie_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        final Button mySendButton = (Button) findViewById(R.id.button);
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);


        mySendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = df.format(c.getTime());
                mDbHelper.createNote( adresse.getText().toString(), description.getText().toString(), spinner.getSelectedItem().toString(), adresse.getText().toString(),formattedDate); //1

                builder1.setMessage("votre lieu à bien était sauvegarder," +
                        "vouler vous vous le retrouver dans la list des lieux");
                builder1.setCancelable(true);


                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent newtaskIntent = new Intent(activity,List_place.class);
                                startActivity(newtaskIntent);
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_place, menu);
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

}

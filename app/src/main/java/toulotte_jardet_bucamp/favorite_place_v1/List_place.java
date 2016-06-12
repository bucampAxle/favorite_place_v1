package toulotte_jardet_bucamp.favorite_place_v1;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;


public class List_place extends ActionBarActivity {

    private NotesDbAdapter mDbHelper;
    private ArrayList<String> placeItems;
    private ListView mavariableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_place);

        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();

        mavariableListView = (ListView) findViewById(R.id.listView);

        placeItems = new ArrayList<String>();

        registerForContextMenu(mavariableListView);

        fillData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_place, menu);
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
     * Rafraichi la liste, à appeler à chaque modification de la liste
     */
    private void fillData() {
        // Get all of the notes from the database and create the item list

        Cursor c = mDbHelper.fetchAllNotes();
        startManagingCursor(c);

        // Now create an array adapter and set it to display using our row
        PlaceCursorAdapter place = new PlaceCursorAdapter(this, c);
        mavariableListView.setAdapter(place);
    }
}

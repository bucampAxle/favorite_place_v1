package toulotte_jardet_bucamp.favorite_place_v1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;


public class Home extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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


    public void goToNewTask(View view){

        Intent newtaskIntent = new Intent(this,add_new_place.class);

        startActivity(newtaskIntent);
    }

    public void goToList_place(View view){

        Intent newtaskIntent = new Intent(this,List_place.class);

        startActivity(newtaskIntent);
    }

    public void goToAdd_new_trip(View view){

        Intent newtaskIntent = new Intent(this,add_new_trip.class);

        startActivity(newtaskIntent);
    }
    public void goToList_trip(View view){

        Intent newtaskIntent = new Intent(this,List_trip.class);

        startActivity(newtaskIntent);
    }

    public void goToAbout_us(View view){

        Intent newtaskIntent = new Intent(this,about_us.class);

        startActivity(newtaskIntent);
    }



}



package toulotte_jardet_bucamp.favorite_place_v1;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Jerome Jardet on 12/06/2016.
 */
public class PlaceCursorAdapter extends CursorAdapter{
    public PlaceCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView title = (TextView) view.findViewById(R.id.place_title);
        TextView type = (TextView) view.findViewById(R.id.place_type);
        TextView address = (TextView) view.findViewById(R.id.place_address);
        TextView description = (TextView) view.findViewById(R.id.place_description);

        // Extract properties from cursor
        String bddTitle = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String bddType = cursor.getString(cursor.getColumnIndexOrThrow("categorie"));
        String bddAddress = cursor.getString(cursor.getColumnIndexOrThrow("adresse"));
        String bddDescription = cursor.getString(cursor.getColumnIndexOrThrow("body"));
        // Populate fields with extracted properties
        title.setText(bddTitle);
        type.setText(bddType);
        address.setText(bddAddress);
        description.setText(bddDescription);
    }
}

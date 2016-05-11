//refer to MainActivity for project details.
//Contributors specific for this page: tausiq.wordpress.com

package trishvaleri.com.foodwine;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * ClientCursorAdapter.java - class used to control the cursor and inflate the listview with
 * db query results.
 * @author Trish Valeri
 */
public class ClientCursorAdapter extends CursorAdapter {
    public ClientCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    /**
     * newView when view is created the first time we tell the adapters how each item will look
     * @param context Context
     * @param cursor Cursor
     * @param parent ViewGroup
     * @return retView
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.display_category_tview, parent, false);
        return retView;
    }

    /**
     * bindView - setting the data, taking the data from the cursor and putting it into views.
     * @param view View
     * @param context Context
     * @param cursor Cursor
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.tView);
        name.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
    }
}


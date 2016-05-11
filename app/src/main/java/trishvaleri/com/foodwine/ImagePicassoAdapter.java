//refer to MainActivity for project details.
//Contributors specific for this page: square.github.io/picasso/,
// futurestud.io/blog/picasso-adapter-use-for-listview-gridview-etc, stackoverflow.com

package trishvaleri.com.foodwine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * ImagePicassoAdapter class used to fill a gridview with images from ArrayList.
 * @author Trish Valeri
 */
public class ImagePicassoAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Image> images;
    private int resource;

    //constructor
    public ImagePicassoAdapter(Context context, int resource, ArrayList<Image> images) {
        super(context, R.layout.activity_main, images);

        this.context = context;
        this.images = images;
        this.resource = resource;

        inflater = LayoutInflater.from(context);
    }

    /**
     * gets/sets the images into the gridview.
     * @param position int
     * @param convertView View
     * @param parent ViewGroup
     * @return convertView to MainActivity.java
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View convertview = convertView;
        final ViewHolder holder;

        if (convertview == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertview = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.imageview = (ImageView) convertview.findViewById(R.id.img);
            convertview.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Image Image = images.get(position);

        Picasso.with(context).load(Image.getPoster()).into(holder.imageview);
        //sets an onclicklistener to the images in the gridview.
        convertview.setOnClickListener(new View.OnClickListener() {
            /**
             * sets an onClickListener to the images in the gridview.
             * starts an intent to DisplayCategory.java when clicked.
             * @param v View
             */
            @Override
            public void onClick(View v) {
                //gets the position of the images in the ArrayList, bundles this int position
                int posOf = images.indexOf(images.get(position));
                Bundle basket = new Bundle();
                basket.putInt("pos", posOf);
                Intent intent = new Intent(context, DisplayCategory.class);
                intent.putExtras(basket);
                context.startActivity(intent);
            }
        });
        return convertview;
    }

    class ViewHolder {
        public ImageView imageview;
    }

}


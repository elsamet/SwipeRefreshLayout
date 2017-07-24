package com.ramadan.swiperefreshlayout.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ramadan.swiperefreshlayout.Movie;
import com.ramadan.swiperefreshlayout.R;

import java.util.List;

/**
 * Created by Mahmoud Ramadan on 7/24/17.
 */

public class SwipeListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Movie>movieList;
    private String[]bgColors;
    private LayoutInflater inflater;
    public SwipeListAdapter(Activity activity, List<Movie> movieList) {
        this.activity = activity;
        this.movieList = movieList;
        bgColors = activity.getApplicationContext().getResources().getStringArray(R.array.movie_serial_bg);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);

        TextView serial = (TextView) convertView.findViewById(R.id.serial);
        TextView title = (TextView) convertView.findViewById(R.id.title);

        serial.setText(String.valueOf(movieList.get(i).id));
        title.setText(movieList.get(i).title);

        String color = bgColors[i % bgColors.length];
        serial.setBackgroundColor(Color.parseColor(color));

        return convertView;
    }
}

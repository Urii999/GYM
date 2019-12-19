package com.example.mygym.scenes.exercises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mygym.R;
import com.example.mygym.entities.ExercicesEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExercicesPresenter  extends BaseAdapter {
    private ArrayList<ExercicesEntity> list;
    private ExercisesActivity view;

    public ExercicesPresenter(ExercisesActivity view) {
        this.view = view;
    }

    public void UpdateList(ArrayList<ExercicesEntity> list) {

        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        * Copy the code from android101 get exercice_item.xml
        *
        *
        * fill the template with the values
        * */

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) this.view.getSystemService( Context.LAYOUT_INFLATER_SERVICE);

            //Dedicated layout for the item itself

            convertView = inflater.inflate( R.layout.exercice_item, parent, false);

        }

        final ExercicesEntity exercice = (ExercicesEntity) getItem(position);

        ((TextView) convertView.findViewById(R.id.textViewN)).setText(exercice.name);
        ((TextView) convertView.findViewById(R.id.textViewH)).setText(exercice.hores);

        //Using Picasso to cache the image
        Picasso.get().load(exercice.iconurl).into((ImageView) convertView.findViewById(R.id.imageView));


        //Listener for the click on the item

        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ExercicesPresenter.this.view.navigateToDetail(exercice);
            }
        });

        return convertView;
    }
}

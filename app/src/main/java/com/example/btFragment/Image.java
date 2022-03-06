package com.example.btFragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Image extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_item);

        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.myImage);

        int posMenu = intent.getIntExtra("PosMenu", 0);
        int posItem = intent.getIntExtra("PosItem", 0);


        TypedArray images = getResources().obtainTypedArray(R.array.images);
        int contentId = images.getResourceId(posMenu, R.array.Cars);
        String imageURL = getResources().getStringArray(contentId)[posItem];
        images.recycle();

        Picasso.get().load(imageURL).resize(900, 600).into(imageView);
    }
}

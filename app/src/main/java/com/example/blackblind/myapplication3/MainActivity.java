package com.example.blackblind.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import javax.security.auth.callback.Callback;

import static com.example.blackblind.myapplication3.imageUrl.IMAGES;


public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //banner

        ImageView imageView = findViewById(R.id.banner);

        //grid view

        gridView = (GridView)findViewById(R.id.grid);
        gridView.setAdapter(new ImageAdapter(this));

        //banner image call

        Picasso.with(getApplicationContext())
                .load("https://blackcblind.000webhostapp.com/banner.JPG")
                .fit()
                .into(imageView);
        Picasso.with(getApplicationContext())
                .invalidate("https://blackcblind.000webhostapp.com/banner.JPG");
        Picasso.with(getApplicationContext()).
                load("https://blackcblind.000webhostapp.com/banner.JPG")
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE);

    }

    //grid view image Adapter

    private static class ImageAdapter extends BaseAdapter {

        private static final String[] IMAGE_URLS = imageUrl.IMAGES;

        private LayoutInflater inflater;

        Context c;

        ImageAdapter(Context context) {
            inflater = LayoutInflater.from(context);
            c = context;

        }

        @Override
        public int getCount() {
            return IMAGE_URLS.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.item_grid_image, parent, false);
                holder = new ViewHolder();
                assert view != null;

                holder.imageView = (ImageView) view.findViewById(R.id.image);

                holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            Picasso.with(c)
                    .load(IMAGE_URLS[position])
                    .placeholder(R.drawable.ic_action_navigation_arrow_back)
                    .error(R.drawable.ic_action_navigation_arrow_back_inverted)
                    .fit()
                    .into(holder.imageView, new com.squareup.picasso.Callback() {

                        @Override
                        public void onSuccess() {
                            holder.imageView.setVisibility(View.VISIBLE);
                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onError() {
                            holder.progressBar.setVisibility(View.VISIBLE);
                            holder.imageView.setVisibility(View.INVISIBLE);
                        }
                    });

            return view;
        }
    }

    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
    }
}



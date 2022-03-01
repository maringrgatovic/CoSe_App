package com.example.cose_project;


import android.content.Context;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.koushikdutta.ion.Ion;

public class ComicListViewAdapter extends BaseAdapter {
    Context myContext;
    LayoutInflater myLayoutInflater;

    public ComicListViewAdapter(Context myContext) {
        this.myContext = myContext;

        this.myLayoutInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return DataStorage.comicsList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = myLayoutInflater.inflate(R.layout.comic_list_view,parent,false);
        }
        ImageView comicThumbImageView = convertView.findViewById(R.id.comicThumbnail);
        TextView comicTitleTextView = convertView.findViewById(R.id.comicTitleItem);
        TextView comicAuthorTextView = convertView.findViewById(R.id.comicAuthorItem);
        Comic currentComic = DataStorage.comicsList.get(position);
        Author author_name = null;

        author_name = DataStorage.getAuthorById(currentComic.getComic_author_ID());
        Ion.with(comicThumbImageView).load(currentComic.getComic_thumbnail());
        comicTitleTextView.setText(currentComic.getComic_title());
        comicAuthorTextView.setText(author_name.getAuthor_name());

        ImageButton subscribeButtonComic = convertView.findViewById(R.id.buttonSubscribeComic);
        subscribeButtonComic.setVisibility(View.INVISIBLE);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*public interface  comicListViewListener{
        void onClick(View v, int position);
    }*/
}

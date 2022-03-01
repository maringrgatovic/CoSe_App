package com.example.cose_project;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        final TextView DescriptionTitle = findViewById(R.id.comicTitleDescription);
        final TextView DescriptionAuthor = findViewById(R.id.comicAuthorDescription);
        final TextView Description = findViewById(R.id.comicDescription);

        Bundle extras = getIntent().getExtras();
        final int sentComicID = extras.getInt("opened_comic");

        DescriptionTitle.setText(DataStorage.getComicById(sentComicID).getComic_title());
        DescriptionAuthor.setText(DataStorage.getAuthorById(DataStorage.getComicById(sentComicID)
                .getComic_author_ID()).getAuthor_name());
        Description.setText(DataStorage.getComicById(sentComicID).getComic_description());

    }
}

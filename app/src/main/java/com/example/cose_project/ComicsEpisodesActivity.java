package com.example.cose_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

import java.lang.reflect.Type;
import java.util.Collection;

public class ComicsEpisodesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);
        DataStorage.imagesEpisodesList.clear();

        final ListView episodesLV = findViewById(R.id.episodesList);
        final EpisodeListViewAdapter episodeListViewAdapter = new EpisodeListViewAdapter(getApplicationContext());
        final TextView comicTitle = findViewById(R.id.comicTitle);
        final TextView authorName = findViewById(R.id.comicAuthor);
        final Button descriptionButton = findViewById(R.id.comicDescription);
        final ImageButton backButton = findViewById(R.id.backButton);

        AsyncHttpClient myClient=new AsyncHttpClient();
        final Gson myGson = new Gson();

        Bundle extras = getIntent().getExtras();
        final int sentComicID=extras.getInt("opened_comic");

        comicTitle.setText(DataStorage.getComicById(sentComicID).getComic_title());
        authorName.setText(DataStorage.getAuthorById(DataStorage.getComicById(sentComicID).getComic_author_ID()).getAuthor_name());

        myClient.get("https://raw.githubusercontent.com/warbossy/CoSe-seminarski/main/episodes.txt", new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getApplicationContext(),"Nesto nevalja s API-em",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Type collectionType = new TypeToken<Collection<Episode>>(){}.getType();
                Collection<Episode> episodes = myGson.fromJson(responseString, collectionType);
                EpisodeDataSource episodeDataSource = new EpisodeDataSource(getApplicationContext());
                for(Episode e : episodes){
                    episodeDataSource.addEpisodeToDb(
                            e.getEpisode_comic_ID(),
                            e.getEpisode_ID(),
                            e.getEpisode_title(),
                            e.getEpisode_tmb(),
                            e.getEpisode_images_path(),
                            e.getEpisode_image_count());
                }
                DataStorage.episodesList = episodeDataSource.getEpisodesByEpisodesComicID(sentComicID);
                episodesLV.setAdapter(episodeListViewAdapter);

                episodesLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Episode clickedEpisode = DataStorage.episodesList.get(position);
                        Intent openEpisodeImagesIntent = new Intent(ComicsEpisodesActivity.this,EpisodeImagesActivity.class);
                        openEpisodeImagesIntent.putExtra("opened_episode",clickedEpisode.getEpisode_ID());
                        startActivity(openEpisodeImagesIntent);
                    }
                });
            }
        });

        descriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {switchActivitiesDescription(sentComicID);}
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainActivity();
            }
        });
    }

    private void switchActivitiesDescription(int sentComicID) {
        Intent switchActivityIntent = new Intent(ComicsEpisodesActivity.this, DescriptionActivity.class);
        switchActivityIntent.putExtra("opened_comic", sentComicID);
        startActivity(switchActivityIntent);
    }

    private void backToMainActivity() {
        Intent switchActivityIntent = new Intent(ComicsEpisodesActivity.this, MainActivity.class);
        startActivity(switchActivityIntent);
    }


}
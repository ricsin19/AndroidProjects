package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MovieSelectorActivity extends SingleFragmentActivity
        implements MovieSelectorFragment.OnMovieViewListener {

    @Override
    protected Fragment createFragment() {
        return MovieSelectorFragment.newInstance();
    }

    public void onMovieView(String url) {
        Intent intent = new Intent(this, MovieWebActivity.class);
        intent.putExtra(MovieWebFragment.EXTRA_URL, url);
        startActivity(intent);
    }

    public void onMovieEdit(Integer CurrentIndex) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        MovieList.get().currentIndex = CurrentIndex;
        intent.putExtra(MovieDetailFragment.EXTRA_INDEX, CurrentIndex);
        startActivity(intent);
    }
}

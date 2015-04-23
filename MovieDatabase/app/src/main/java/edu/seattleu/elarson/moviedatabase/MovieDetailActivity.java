package edu.seattleu.elarson.moviedatabase;

import android.app.Fragment;
import android.content.Intent;


public class MovieDetailActivity extends SingleFragmentActivity{

    //@Override
    //protected Fragment createFragment() {
    //    return MovieDetailFragment.newInstance();
    //}
    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        int currentIndex = intent.getIntExtra(MovieDetailFragment.EXTRA_INDEX, 0);
        return MovieDetailFragment.newInstance(currentIndex);
    }
}

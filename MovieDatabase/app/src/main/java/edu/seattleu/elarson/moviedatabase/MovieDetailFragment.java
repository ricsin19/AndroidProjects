package edu.seattleu.elarson.moviedatabase;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieDetailFragment extends Fragment{
    public static final String EXTRA_INDEX = "edu.seattleu.elarson.moviedatabase.url";
    private int mCurrentIndex;
    private EditText mEditTitle;
    private EditText mEditGenre;
    private EditText mEditURL;
    private RatingBar mRating;
    private CheckBox mCheckBox;
    Movie mMovies;


    public static MovieDetailFragment newInstance(int currentIndex) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRA_INDEX, currentIndex);
        fragment.setArguments(args);
        return fragment;
    }

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCurrentIndex = getArguments().getInt(EXTRA_INDEX);
        }
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        mMovies = MovieList.get().getMovies().get(mCurrentIndex);
        mEditTitle = (EditText) v.findViewById(R.id.editText1);
        mEditGenre = (EditText) v.findViewById(R.id.editText2);
        mEditURL = (EditText) v.findViewById(R.id.editText3);
        mCheckBox = (CheckBox)v.findViewById(R.id.checkBox);
        mRating = (RatingBar)v.findViewById(R.id.ratingBar);

        mMovies = MovieList.get().getMovies().get(mCurrentIndex);

        mEditTitle.setText(mMovies.getTitle());
        mEditGenre.setText(mMovies.getGenre());
        mEditURL.setText(mMovies.getUrl());
        mRating.setRating(mMovies.getRating());
        mCheckBox.setChecked(mMovies.getIsWatched());
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        updateMovieDetails();
    }

    void updateMovieDetails(){
        mMovies.setTitle(mEditTitle.getText().toString());
        mMovies.setGenre(mEditGenre.getText().toString());
        mMovies.setRating(mRating.getRating());
        mMovies.setUrl(mEditURL.getText().toString());
        mMovies.setIsWatched(mCheckBox.isChecked());
    }
}

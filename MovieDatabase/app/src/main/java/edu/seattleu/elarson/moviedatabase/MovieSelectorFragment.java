package edu.seattleu.elarson.moviedatabase;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link edu.seattleu.elarson.moviedatabase.MovieSelectorFragment.OnMovieViewListener} interface
 * to handle interaction events.
 * Use the {@link MovieSelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieSelectorFragment extends Fragment {

    private TextView mTextMovieTitle;
    private TextView mTextMovieGenre;
    private int mCurrentIndex;

    private ArrayList<Movie> mMovies;
    private OnMovieViewListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MovieSelectorFragment.
     */
    public static MovieSelectorFragment newInstance() {
        return new MovieSelectorFragment();
    }

    public MovieSelectorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie_selector, container, false);

        mMovies = MovieList.get().getMovies();
        mCurrentIndex = MovieList.get().currentIndex;

        mTextMovieTitle = (TextView) v.findViewById(R.id.textMovieTitle);
        mTextMovieGenre = (TextView) v.findViewById(R.id.textMovieGenre);

        Button prevButton = (Button) v.findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mCurrentIndex == 0)
                    mCurrentIndex = mMovies.size() - 1;
                else
                    mCurrentIndex = mCurrentIndex - 1;
                updateMovie();
            }
        });

        Button nextButton = (Button) v.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mMovies.size();
                updateMovie();
            }
        });

        Button viewButton = (Button) v.findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onMovieView(mMovies.get(mCurrentIndex).getUrl());
                }
            }
        });

        updateMovie();
        setHasOptionsMenu(true);
        return v;
    }


    private void updateMovie() {
        Movie movie = mMovies.get(mCurrentIndex);
        mTextMovieTitle.setText(movie.getTitle());
        mTextMovieGenre.setText(movie.getGenre());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.action_bar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.menu_item_edit:
                mListener.onMovieEdit(mCurrentIndex);
                return true;
            case R.id.menu_item_web:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnMovieViewListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMovieViewListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateMovie();
    }
    /*
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnMovieViewListener {
        public void onMovieView(String url);
        public void onMovieEdit(Integer CurrentIndex);
    }
}

package com.example.neflii.HomeActivity.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.neflii.HomeActivity.Adapters.Adapter_FilmsMultiSearch_HomeActivity;
import com.example.neflii.HomeActivity.Adapters.Adapter_Films_HomeActivity;
import com.example.neflii.HomeActivity.Entities.ContainerFilms;
import com.example.neflii.HomeActivity.Entities.ContainerGenres;
import com.example.neflii.HomeActivity.Entities.Genres;
import com.example.neflii.R;

import java.util.List;

public class MVP_HomeFragmentSearchFilm extends Fragment {

    private static final String ListMultiSearchFilms = "listMultiSearch";
    private static final String ListMultiSearchGenres = "listGenresMultiSearch";
    private Adapter_FilmsMultiSearch_HomeActivity adapterFilmsMultiSearchHomeActivity;
    private RecyclerView recyclerViewMultiSearch;
    private ContainerFilms containerFilmsMultiSearch;
    private ContainerGenres containerGenresFilmsMultiSearch;

    public static MVP_HomeFragmentSearchFilm buildFragmentPetDetail(ContainerFilms containerFilms, ContainerGenres containerGenres) {
        MVP_HomeFragmentSearchFilm mvpHomeFragmentSearchFilm = new MVP_HomeFragmentSearchFilm();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ListMultiSearchFilms, containerFilms);
        bundle.putParcelable(ListMultiSearchGenres,containerGenres);
        mvpHomeFragmentSearchFilm.setArguments(bundle);
        return mvpHomeFragmentSearchFilm;
    }


    public MVP_HomeFragmentSearchFilm() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mvp_searchfilm_fragment, container, false);

        recyclerViewMultiSearch = view.findViewById(R.id.reciclerView_Fragment);
        initRecycler(view);
        Bundle bundle = getArguments();
        if(bundle != null) {
            containerFilmsMultiSearch = bundle.getParcelable(ListMultiSearchFilms);
            containerGenresFilmsMultiSearch = bundle.getParcelable(ListMultiSearchGenres);
            adapterFilmsMultiSearchHomeActivity.insertFilmsMultiSearch(containerFilmsMultiSearch.getResults());
            adapterFilmsMultiSearchHomeActivity.insertListGenresMultiSearch(containerGenresFilmsMultiSearch.getGenres());
        }
        return view;
    }

    private void initRecycler(View view) {

        //RecyclerView de las peliculas mas populares
        adapterFilmsMultiSearchHomeActivity = new Adapter_FilmsMultiSearch_HomeActivity();
        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewMultiSearch.addItemDecoration(new DividerItemDecoration(recyclerViewMultiSearch.getContext(), DividerItemDecoration.VERTICAL));
        recyclerViewMultiSearch.setLayoutManager(linearLayoutManager);
        recyclerViewMultiSearch.setAdapter(adapterFilmsMultiSearchHomeActivity);

    }
}

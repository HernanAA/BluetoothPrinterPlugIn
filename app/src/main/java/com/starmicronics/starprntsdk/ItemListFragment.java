package com.starmicronics.starprntsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ItemListFragment extends Fragment implements ListView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    private ListView mListView;

    public ItemListFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_list, container, false);

        mListView = (ListView) rootView.findViewById(R.id.commonListView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // do nothing
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // do nothing
    }


    protected void addMenu(String title, boolean isClickable) {

    }

    protected void addMenu(String title, boolean isClickable, int backGroundColor) {

    }
}

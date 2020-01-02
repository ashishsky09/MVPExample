package com.mvpexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mvpexample.adapters.FeedAdapter;
import com.mvpexample.model.Record;
import com.mvpexample.presenter.GetDataContract;
import com.mvpexample.presenter.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetDataContract.View {

    private Presenter presenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    FeedAdapter feedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter=new Presenter(this);
        presenter.getDataFromURL(getApplicationContext(),"");
        recyclerView=findViewById(R.id.recycler_view);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataSuccess(String message, List<Record> list) {
        feedAdapter=new FeedAdapter(getApplicationContext(),list);
        recyclerView.setAdapter(feedAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {

    }
}

package com.example.retrofit_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofit_ex.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding  binding;
   ArrayList<countryModel>  countrylist;
   private countrydataAdapter cadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getCountries();

    }

    private Object getCountries() {
     getcountrydata getcountrydata = RetrofitInstance.getService();
        Call<Result> call = getcountrydata.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
               Result result = response.body();
                if (result!=null && result.getResult() != null){
                  countrylist = (ArrayList<countryModel>) result.getResult();
                  
                  viewData();

                }
            }
            private void viewData() {
              cadapter =new countrydataAdapter(countrylist);
              binding.recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
              binding.recycler.setAdapter(cadapter);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

      return  countrylist;
    }


}
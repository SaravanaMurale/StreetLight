package com.sosaley.streetlight.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.sosaley.streetlight.R;
import com.sosaley.streetlight.databinding.FragmentHomeBinding;
import com.sosaley.streetlight.home.modelview.HomeViewModel;
import com.sosaley.streetlight.map.view.MapActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        /*View root = inflater.inflate(R.layout.fragment_home, container, false);*/

       FragmentHomeBinding fragmentHomeBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        View view=fragmentHomeBinding.getRoot();
        fragmentHomeBinding.setHome(homeViewModel);

        //activityLoginBinding= DataBindingUtil.setContentView(getActivity(),R.layout.fragment_home);
         //TextView textView = root.findViewById(R.id.text_home);
         //textView.setText("Murali");
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        Toast.makeText(getActivity(),"Toast.LENGTH_LONG",Toast.LENGTH_LONG).show();

        fragmentHomeBinding.mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
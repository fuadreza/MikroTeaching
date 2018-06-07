package com.example.shifu.mikroteching.BottomNavigation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shifu.mikroteching.BankMateri.BankMateri;
import com.example.shifu.mikroteching.R;
import com.example.shifu.mikroteching.SoalTes.Tes;
import com.example.shifu.mikroteching.Verbal.Verbal;

/**
 * Created by Shifu on 25/03/2018.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    public static final String TAG = HomeFragment.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COLOR = "color";

    // TODO: Rename and change types of parameters
    private int color;

    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getInt(ARG_COLOR);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        /*recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_square_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setBackgroundColor(getLighterColor(color));

        SimpleAdapter adapter = new SimpleAdapter(getContext());
        recyclerView.setAdapter(adapter);*/

        ImageView menu1 = rootView.findViewById(R.id.menu1);
        ImageView menu2 = rootView.findViewById(R.id.menu2);
        ImageView menu3 = rootView.findViewById(R.id.menu3);
        ImageView menu4 = rootView.findViewById(R.id.menu4);

        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu1:
                startActivity(new Intent(v.getContext(), BankMateri.class));
                break;
            case R.id.menu2:
                startActivity(new Intent(v.getContext(), Tes.class));
                break;
            case R.id.menu3:
                Toast.makeText(this.getContext(), "Fitur masih dalam pengembangan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu4:
                startActivity(new Intent(v.getContext(), Verbal.class));
                break;
        }
    }


    /**
     * Updates {@link RecyclerView} background color upon changing Bottom Navigation item.
     *
     * @param color to apply to {@link RecyclerView} background.
     */
    public void updateColor(int color) {
        recyclerView.setBackgroundColor(getLighterColor(color));
    }

    /**
     * Facade to return colors at 30% opacity.
     *
     * @param color
     * @return
     */
    private int getLighterColor(int color) {
        return Color.argb(30,
                Color.red(color),
                Color.green(color),
                Color.blue(color)
        );
    }
}

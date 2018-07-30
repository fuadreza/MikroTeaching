package com.example.shifu.mikroteching.BottomNavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shifu.mikroteching.PrefManager;
import com.example.shifu.mikroteching.R;

/**
 * Created by Shifu on 25/03/2018.
 */

public class ProgressFragment extends Fragment {
    public static final String TAG = ProgressFragment.class.getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COLOR = "color";
    ImageView ivKDM1, ivKDM2, ivKDM3, ivKDM4, ivKDM5, ivKDM6, ivKDM7, ivKDM8;
    Button btn;
    private PrefManager prefManager;
    private String _myTag;
    // TODO: Rename and change types of parameters
    private int color;
    private RecyclerView recyclerView;

    public ProgressFragment() {
        // Required empty public constructor
    }

    public void setMyTag(String value) {
        if ("".equals(value))
            return;
        _myTag = value;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getInt(ARG_COLOR);
        }
        //Compatibility SVG
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prefManager = new PrefManager(container.getContext());

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_progress, container, false);

        TextView tvSoal = rootView.findViewById(R.id.progSoal);
        TextView tvMateri = rootView.findViewById(R.id.progMateri);

        tvSoal.setText(String.valueOf(prefManager.berapaSkor()));
        tvMateri.setText(String.valueOf(prefManager.berapaMateri()));

        ivKDM1 = rootView.findViewById(R.id.kdm1);
        ivKDM2 = rootView.findViewById(R.id.kdm2);
        ivKDM3 = rootView.findViewById(R.id.kdm3);
        ivKDM4 = rootView.findViewById(R.id.kdm4);
        ivKDM5 = rootView.findViewById(R.id.kdm5);
        ivKDM6 = rootView.findViewById(R.id.kdm6);
        ivKDM7 = rootView.findViewById(R.id.kdm7);
        ivKDM8 = rootView.findViewById(R.id.kdm8);

        if (prefManager.isKDMDone("kdm1")) {
            ivKDM1.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm2")) {
            ivKDM2.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm3")) {
            ivKDM3.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm4")) {
            ivKDM4.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm5")) {
            ivKDM5.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm6")) {
            ivKDM6.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm7")) {
            ivKDM7.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm8")) {
            ivKDM8.setImageResource(R.drawable.ic_dot_success);
        }

//        btn = (Button) rootView.findViewById(R.id.)

//        loadProgress();

        /*recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_square_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setBackgroundColor(getLighterColor(color));

        SimpleAdapter adapter = new SimpleAdapter(getContext());
        recyclerView.setAdapter(adapter);*/

        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    public void changeImage() {
        if (prefManager.isKDMDone("kdm1")) {
            ivKDM1.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm2")) {
            ivKDM2.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm3")) {
            ivKDM3.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm4")) {
            ivKDM4.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm5")) {
            ivKDM5.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm6")) {
            ivKDM6.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm7")) {
            ivKDM7.setImageResource(R.drawable.ic_dot_success);
        }
        if (prefManager.isKDMDone("kdm8")) {
            ivKDM8.setImageResource(R.drawable.ic_dot_success);
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

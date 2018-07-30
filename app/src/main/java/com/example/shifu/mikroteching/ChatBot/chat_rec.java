package com.example.shifu.mikroteching.ChatBot;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.shifu.mikroteching.R;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 10/06/2018.
 */

public class chat_rec extends RecyclerView.ViewHolder {

    TextView leftText, rightText;

    public chat_rec(View itemView) {
        super(itemView);

        leftText = (TextView) itemView.findViewById(R.id.leftText);
        rightText = (TextView) itemView.findViewById(R.id.rightText);


    }

}

package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.TextView;

public class MatchingGameFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_matching_game, container, false);

        TextView cardFront = rootView.findViewById(R.id.card_front);
        TextView cardBack = rootView.findViewById(R.id.card_back);
        LineView connectionLine = rootView.findViewById(R.id.connection_line);

        MatchingGameManager matchingGameManager = new MatchingGameManager(
                requireContext(),
                cardFront,
                cardBack
        );
        matchingGameManager.setLineView(connectionLine);
        matchingGameManager.initCards();

        return rootView;
    }
}

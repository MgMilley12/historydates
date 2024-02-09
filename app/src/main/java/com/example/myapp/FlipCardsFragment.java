package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FlipCardsFragment extends Fragment {

    private CardFlipManager cardFlipManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_flip_cards, container, false);

        // Получение ссылок на TextView из разметки фрагмента
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView cardFront = rootView.findViewById(R.id.card_front);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView cardBack = rootView.findViewById(R.id.card_back);

        // Инициализация CardFlipManager
        cardFlipManager = new CardFlipManager(cardFront, cardBack, requireContext());

        return rootView;
    }
}

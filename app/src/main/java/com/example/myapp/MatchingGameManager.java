package com.example.myapp;

import android.content.Context;
import android.widget.TextView;

public class MatchingGameManager {

    private TextView cardFront;
    private TextView cardBack;
    private LineView lineView;

    public MatchingGameManager(Context context, TextView cardFront, TextView cardBack) {
        this.cardFront = cardFront;
        this.cardBack = cardBack;
    }

    public void setLineView(LineView lineView) {
        this.lineView = lineView;
    }

    public void initCards() {
        cardFront.setOnClickListener(view -> onCardClicked((TextView) view));
        cardBack.setOnClickListener(view -> onCardClicked((TextView) view));
    }

    private void onCardClicked(TextView clickedCard) {
        connectCards(clickedCard);
    }

    private void connectCards(TextView clickedCard) {
        if (lineView != null) {
            float startX = cardFront.getX() + (float) cardFront.getWidth() / 2;
            float startY = cardFront.getY() + (float) cardFront.getHeight() / 2;
            float endX = clickedCard.getX() + (float) clickedCard.getWidth() / 2;
            float endY = clickedCard.getY() + (float) clickedCard.getHeight() / 2;

            lineView.setLineCoordinates(startX, startY, endX, endY);
        }
    }

    public void resetConnectionLine() {
        if (lineView != null) {
            lineView.resetLineCoordinates();
        }
    }
}

package com.example.myapp;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.widget.TextView;

public class CardFlipManager {
    private AnimatorSet frontAnimation;
    private AnimatorSet backAnimation;
    private boolean isFront = true;

    public CardFlipManager(TextView cardFront, TextView cardBack, Context context) {
        float scale = cardFront.getContext().getResources().getDisplayMetrics().density;

        cardFront.setCameraDistance(8000 * scale);
        cardBack.setCameraDistance(8000 * scale);

        frontAnimation = (AnimatorSet) AnimatorInflater.loadAnimator(cardFront.getContext(), R.animator.front_anim);
        backAnimation = (AnimatorSet) AnimatorInflater.loadAnimator(cardBack.getContext(), R.animator.back_anim);

        cardFront.setOnClickListener(v -> flipCard(cardFront, cardBack));
        cardBack.setOnClickListener(v -> flipCard(cardBack, cardFront));
    }

    private void flipCard(TextView visible, TextView invisible) {
        if (!frontAnimation.isRunning() && !backAnimation.isRunning()) {
            if (isFront) {
                frontAnimation.setTarget(visible);
                backAnimation.setTarget(invisible);
                frontAnimation.start();
                backAnimation.start();
                isFront = false;
            } else {
                frontAnimation.setTarget(invisible);
                backAnimation.setTarget(visible);
                backAnimation.start();
                frontAnimation.start();
                isFront = true;
            }
        }
    }
}

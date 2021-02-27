package by.it.academy.animationexample

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.OvershootInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)

//        val animator = ValueAnimator.ofFloat(.0f, 1.0f).apply {
//            duration = 1000
//            addUpdateListener { value -> textView.alpha = value.animatedValue as Float }
//            repeatMode = ValueAnimator.REVERSE
//        }
//
//        val animator2 = ValueAnimator.ofFloat(.10f, 300.0f).apply {
//            duration = 3000
//            interpolator = OvershootInterpolator()
//            addUpdateListener { value -> textView.x = value.animatedValue as Float }
//            repeatMode = ValueAnimator.REVERSE
//        }
//
//        val set = AnimatorSet()
//        set.playTogether(animator2, animator)
//        set.start()

//        val anim = AnimationUtils.loadAnimation(this, R.anim.anim_rotate)
//        textView.startAnimation(anim)

        textView.alpha = .0f
        textView.animate()
            .setDuration(5000)
            .alpha(1f)
            .start()

    }
}
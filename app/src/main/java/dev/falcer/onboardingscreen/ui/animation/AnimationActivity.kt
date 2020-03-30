package dev.falcer.onboardingscreen.ui.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.falcer.onboardingscreen.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {

    private var liked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        init()
    }

    private fun init() {
        text.text = "-_-"
        animation_view.setOnClickListener {
            if(!liked) {
                animation_view.playAnimation()
                text.text = "You Like That Shit"
            } else {
                animation_view.frame = 0
                text.text = "Why you unlike???"
            }
            liked = !liked
        }
    }
}

package dev.falcer.onboardingscreen.ui.onboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import dev.falcer.onboardingscreen.R
import dev.falcer.onboardingscreen.data.entity.OnBoard
import dev.falcer.onboardingscreen.ui.animation.AnimationActivity
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : AppCompatActivity() {

    private val pagers = arrayListOf(
        OnBoard(
            R.drawable.img_relax,
            "Relax your body.",
            "Lorem Ipsum Dolor Sit Amet"
        ), OnBoard(
            R.drawable.img_increase,
            "Increase your salary.",
            "Lorem Ipsum Dolor Sit Amet"
        ), OnBoard(
            R.drawable.img_focus,
            "Focus on your passion.",
            "Lorem Ipsum Dolor Sit Amet"
        )
    )
    private val adapter = OnBoardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        init()
    }

    private fun init() {
        adapter.setData(pagers)
        view_pager.adapter = adapter
        dot_indicator.setViewPager2(view_pager)

        button_ok.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }

        setButton()
    }

    private fun setButton() {

        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    pagers.size - 1 -> {
                        dot_indicator.visibility = View.GONE
                        button_ok.visibility = View.VISIBLE
                    }
                    else -> {
                        dot_indicator.visibility = View.VISIBLE
                        button_ok.visibility = View.GONE
                    }
                }
            }
        })
    }
}

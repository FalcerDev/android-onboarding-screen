package dev.falcer.onboardingscreen.ui.onboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.falcer.onboardingscreen.R
import dev.falcer.onboardingscreen.data.entity.OnBoard
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : AppCompatActivity() {

    private val adapter = OnBoardAdapter()
    private val PAGER = arrayListOf(
        OnBoard(
            R.drawable.img_focus,
            "Focus on your task",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ), OnBoard(
            R.drawable.img_increase,
            "Increase your profit",
            "Duis nulla nibh, suscipit at rutrum sit amet, consequat vel lacus."
        ), OnBoard(
            R.drawable.img_relax,
            "Relax doing your job",
            "Suspendisse id ultrices orci. Mauris consectetur interdum interdum."
        )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        init()
    }

    private fun init() {
        adapter.setData(PAGER)
        viewPager.adapter = adapter
        dots_indicator.setViewPager2(viewPager)
    }
}

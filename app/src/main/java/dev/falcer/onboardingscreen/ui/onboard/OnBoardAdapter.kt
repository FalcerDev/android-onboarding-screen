package dev.falcer.onboardingscreen.ui.onboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.falcer.onboardingscreen.R
import dev.falcer.onboardingscreen.data.entity.OnBoard

class OnBoardAdapter : RecyclerView.Adapter<OnBoardAdapter.ViewHolder>() {

    private lateinit var dataList: List<OnBoard>

    fun setData(data: List<OnBoard>) {
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.card_on_boarding, parent, false)
        )
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.card_image)
        private val title = view.findViewById<TextView>(R.id.card_title)
        private val description = view.findViewById<TextView>(R.id.card_description)

        fun bind(data: OnBoard) {
            Glide.with(itemView).load(data.image).centerInside().into(image)
            title.text = data.title
            description.text = data.description
        }
    }

}
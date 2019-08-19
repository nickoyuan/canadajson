package com.testapp.nick.canadajson.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import android.content.Intent
import com.testapp.nick.canadajson.FullScreenActivity
import com.testapp.nick.canadajson.R


class CanadaRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var canadFactsList: CanadaFactsRowsModel

    fun setCanadaFactsList(canadFactsList: CanadaFactsRowsModel) {
        this.canadFactsList = canadFactsList
        notifyDataSetChanged()
    }

    fun addAllToCanadaFactList(canadFactsList: CanadaFactsRowsModel) {
        this.canadFactsList.rows.addAll(canadFactsList.rows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_canada,
            parent,
            false
        )
        return CanadaViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(::canadFactsList.isInitialized) {
            return canadFactsList.rows.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CanadaViewHolder).title.setText(canadFactsList.rows.get(position).title)
        (holder as CanadaViewHolder).description.setText(canadFactsList.rows.get(position).description)
        loadImgWithGlide(holder.img, position)
        setImgOnClick(holder.img, canadFactsList.rows.get(position).imageHref)
    }

    fun setImgOnClick(img: ImageView, imgUrl: String?) {
        img.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, FullScreenActivity::class.java)
            intent.putExtra("image_url", imgUrl)
            it.context.startActivity(intent)
        })
    }

    fun loadImgWithGlide(holder: ImageView, position: Int) {
        val glideOption = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.mipmap.ic_launcher_foreground)
        Glide.with(holder.context)
            .load(canadFactsList.rows.get(position).imageHref)
            .apply(glideOption)
            .into(holder)
    }


}


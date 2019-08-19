package com.testapp.nick.canadajson.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testapp.nick.canadajson.R
import com.testapp.nick.canadajson.model.CanadaFactsRowsModel

class CanadaRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var canadFactsList: CanadaFactsRowsModel

    fun setCanadaFactsList(canadFactsList: CanadaFactsRowsModel) {
        this.canadFactsList = canadFactsList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_canada, parent, false)
        return CanadaViewHolder(view)
    }

    override fun getItemCount(): Int {
      return canadFactsList.rows.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CanadaViewHolder).title.setText(canadFactsList.rows.get(position).title)
        (holder as CanadaViewHolder).description.setText(canadFactsList.rows.get(position).description)
        (holder as CanadaViewHolder).img.setText(canadFactsList.rows.get(position).imageHref)

    }


}
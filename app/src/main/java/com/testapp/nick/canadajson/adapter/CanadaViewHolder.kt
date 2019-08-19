package com.testapp.nick.canadajson.adapter

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.testapp.nick.canadajson.R

class CanadaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{

    var view : View = itemView
    var title : TextView
    var description : TextView
    var img : TextView

   init {
       title = view.findViewById(R.id.canada_title)
       description = view.findViewById(R.id.canada_description)
       img = view.findViewById(R.id.canada_image)
       view.setOnClickListener(this)
   }

    override fun onClick(v: View?) {
       Log.d("Test", "Clicked")
    }
}
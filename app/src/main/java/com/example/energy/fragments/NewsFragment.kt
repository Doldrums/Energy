package com.example.energy.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.example.energy.R
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.fragment_user.*

class NewsFragment : Fragment() {

    var title : String = "test"
    var description : String = "test"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name = mutableListOf<String>()
        name.add("Christmas Cakes")
        name.add("Christmas Cakes")
        name.add("Christmas Cakes")

        var text = mutableListOf<String>()
        text.add("Such cakes conquer not only with their taste, but also with the decoration process, to which you can attract the whole family, including the youngest children.")
        text.add("Such cakes conquer not only with their taste, but also with the decoration process, to which you can attract the whole family, including the youngest children.")

        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = Adapter(name, 1)


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NewsFragment().apply {

            }
    }


    class Adapter(private val name: List<String>, private val what: Int) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        var i = 0
        lateinit var itemView: View
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            i++
            when (what) {
                2 -> when {
                    i % 2 == 0 -> itemView =
                        LayoutInflater.from(parent.context).inflate(R.layout.list_notification, parent, false)
                    else -> itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
                }
                1 -> itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
                3 -> itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_notification, parent, false)
            }
            return ViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            if (what == 1) holder.name?.text = name[position]
            else if (what == 2) {

                if (i % 2 == 0) {
                    holder.name?.text = "Notification"
                } else {
                    holder.name?.text = name[position]
                }
            } else if (what == 3) holder.name?.text = "Notification"
        }

        override fun getItemCount() = name.size
        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var name: TextView? = null
            var description: TextView? = null

            init {
                name = itemView?.findViewById(R.id.name)
                description = itemView?.findViewById(R.id.discription)
            }
        }


    }
}

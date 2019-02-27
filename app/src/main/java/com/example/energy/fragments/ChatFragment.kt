package com.example.energy.fragments

import android.nfc.tech.NfcA
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.energy.R
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)

    }


    companion object {
        @JvmStatic
        fun newInstance() =
            ChatFragment().apply {

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var messages = mutableListOf<String>()

        btn_send.setOnClickListener {
            val message = txt_message.text.toString()
            when {
                message != "" -> {
                    messages.add(txt_message.text.toString())
                    recycler_messages.layoutManager = LinearLayoutManager(activity!!.applicationContext)
                    recycler_messages.adapter = Adapter(messages)
                }
                message == "" -> Snackbar.make(it,"Введите что-нибудь",Snackbar.LENGTH_LONG).show()
            }
        }


    }

    class Adapter(internal val text: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        lateinit var itemView: View
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
             itemView =
                 LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)

            return ViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text?.text = text[position]
        }

        override fun getItemCount() = text.size
        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var text: TextView? = null

            init {
                text = itemView?.findViewById(R.id.txt_messages)
            }
        }


    }
}

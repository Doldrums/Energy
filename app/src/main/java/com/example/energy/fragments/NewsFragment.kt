package com.example.energy.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.energy.R
import kotlinx.android.synthetic.main.content_scrolling.*

class NewsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name = mutableListOf<String>()
        name.add("«Янтарьэнерго» информирует о завершении испытаний оборудования на Прегольской ТЭС")
        name.add("Трудовой коллектив «Янтарьэнерго» отмечен благодарственным письмом администрации города Калининграда")
        name.add("Кирилл Юткин наградил лучших сотрудников группы компаний «Янтарьэнерго»")
        name.add("«Янтарьэнерго» предупреждает о возможных кратковременных перебоях электроснабжения в Калининграде и области 27 февраля")
        name.add("В «Янтарьэнерго» завершился первый этап всероссийского конкурса рисунка «Россети: рисуют дети!»")
        name.add("Игорь Маковский оценил результаты работы «Янтарьэнерго» в рамках цифровой трансформации")

        my_recycler_view.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        my_recycler_view.adapter = Adapter(name)


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NewsFragment().apply {

            }
    }


    class Adapter(private val name: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        lateinit var itemView: View
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name?.text = name[position]
        }

        override fun getItemCount() = name.size
        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var name: TextView? = null

            init {
                name = itemView?.findViewById(R.id.name)
            }
        }


    }
}

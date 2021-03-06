package com.example.recipiesebook
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class ListeRecyclerAdapter(val yemekListesi: ArrayList<String>,val idListesi: ArrayList<Int>):
    RecyclerView.Adapter<ListeRecyclerAdapter.YemekHolder>() {

    class YemekHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return YemekHolder(view)
    }

    override fun onBindViewHolder(holder: YemekHolder, position: Int) {
        holder.itemView.reccycler_row_text.text = yemekListesi[position]

        holder.itemView.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToRecipieFragment()
            action.bilgi = "recyclerdangeldim"
            action.id = position+1
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }
}
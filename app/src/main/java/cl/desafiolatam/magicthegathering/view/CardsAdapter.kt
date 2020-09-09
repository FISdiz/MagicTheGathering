package cl.desafiolatam.magicthegathering.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.magicthegathering.R
import cl.desafiolatam.magicthegathering.model.pojo.Card
import cl.desafiolatam.magicthegathering.model.pojo.CardsMinimal
import kotlinx.android.synthetic.main.item_card.view.*

class CardsAdapter(private var mtgDataset : MutableList<CardsMinimal>) : RecyclerView.Adapter<CardsAdapter.MTGViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MTGViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return MTGViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mtgDataset.size
    }

    override fun onBindViewHolder(holder: MTGViewHolder, position: Int) {
        holder.cardName.text = mtgDataset.get(position).name
    }

    fun updateItems (it: List<CardsMinimal>) {
        mtgDataset.clear()
        mtgDataset.addAll(it)
        notifyDataSetChanged()
    }

    class MTGViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardName = itemView.card_name
    }
}

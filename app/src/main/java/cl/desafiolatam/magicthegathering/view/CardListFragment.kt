package cl.desafiolatam.magicthegathering.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatam.magicthegathering.R
import cl.desafiolatam.magicthegathering.model.pojo.CardsMinimal
import cl.desafiolatam.magicthegathering.viewmodel.MTGViewModel
import kotlinx.android.synthetic.main.recycle_cards_fragment.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CardListFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var cardList = ArrayList<CardsMinimal>()
    private lateinit var adapter : CardsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycle_cards_fragment, container, false)
    }

    companion object {

        @JvmStatic fun newInstance(param1: String, param2: String) =
            CardListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CardsAdapter(cardList)
        mtg_recycler.adapter = adapter

        val mtgViewModel : MTGViewModel by activityViewModels()
        val page = 1
        mtgViewModel.loadPages(page)

        rec_next.setOnClickListener{

        }

        rec_back.setOnClickListener {

        }

        mtgViewModel.cardList.observe(viewLifecycleOwner, Observer {
            adapter.updateItems(it)
        })
        adapter.cardSelected.observe(viewLifecycleOwner, Observer {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, CardDetailFragment.newInstance("${it.id}", ""), "details")
                .addToBackStack("details")
                .commit()
        })
    }

    

}
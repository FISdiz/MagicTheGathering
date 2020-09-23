package cl.desafiolatam.magicthegathering.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatam.magicthegathering.R
import cl.desafiolatam.magicthegathering.viewmodel.MTGViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_card_detail.*
import kotlinx.android.synthetic.main.fragment_card_image.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CardDetailFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_detail, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mtgViewModel : MTGViewModel by activityViewModels()
        mtgViewModel.getDetailsfrom(param1!!).observe(viewLifecycleOwner, Observer {
            det_title.text = it.name
            det_descr_text.text = it.originalText
            det_manacost_text.text = it.manaCost
            det_type_text.text = it.type
            det_rarity_text.text = it.rarity
            det_power_text.text = it.power.toString()
            det_tough_text.text = it.toughness.toString()
            det_artist_text.text = it.artist
            det_layout_text.text = it.layout
            if (it.imageUrl != null && it.imageUrl != ""){
                Picasso.get().setLoggingEnabled(true)
                Picasso
                    .get()
                    .load("${it.imageUrl}")
                    .into(det_zoom_img)
            } else {
                Picasso
                    .get()
                    .load(R.drawable.magic_dorso)
                    .into(det_zoom_img)
            }
        })
        det_zoom_img.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, CardImageFragment.newInstance(param1!!, ""), "image")
                .addToBackStack("image")
                .commit()
        }
    }
}
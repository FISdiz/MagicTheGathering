package cl.desafiolatam.magicthegathering.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatam.magicthegathering.R
import cl.desafiolatam.magicthegathering.viewmodel.MTGViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.fragment_card_image.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CardImageFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_card_image, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("IMAGE_FRAG", "AAAAA $param1")
        val mtgViewModel : MTGViewModel by activityViewModels()
        mtgViewModel.getDetailsfrom(param1!!).observe(viewLifecycleOwner, Observer {

            if (it.imageUrl != null && it.imageUrl != ""){
            Picasso.get().setLoggingEnabled(true)
            Picasso
                .get()
                .load("${it.imageUrl}")
                .transform(RoundedCornersTransformation(10,10))
                .into(card_image)
            } else {
                Picasso
                    .get()
                    .load(R.drawable.magic_dorso)
                    .transform(RoundedCornersTransformation(150,0))
                    .into(card_image)
            }
        })
    }
}
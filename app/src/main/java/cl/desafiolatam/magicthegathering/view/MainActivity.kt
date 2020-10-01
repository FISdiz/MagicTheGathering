package cl.desafiolatam.magicthegathering.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cl.desafiolatam.magicthegathering.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

/*    private fun setButtonBarVisibility(isVisible: Boolean) {
        val view: BottomNavigationView = getActivity().findViewById(R.id.bottomNav)
        if (view != null) {
            view.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
    }*/
}
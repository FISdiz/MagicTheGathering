package cl.desafiolatam.magicthegathering.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.desafiolatam.magicthegathering.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_send.setOnClickListener {
            val textMail = login_mail.text.toString()
            val textPass = login_password.text.toString()
            login(textMail, textPass)
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI (currentUser : FirebaseUser?) {
        if (currentUser!=null) {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, CardListFragment.newInstance("", ""), "list")
                .addToBackStack("list")
                .commit()
        }
    }

    fun login (user : String, pass: String) {
        auth.signInWithEmailAndPassword(user,pass).addOnCompleteListener {
            task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, CardListFragment.newInstance("", ""), "list")
                    .addToBackStack("list")
                    .commit()
            } else {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validateEmpty (user:String, pass:String) : Boolean {
        if (user.isEmpty()) {
            login_mail.setError("Insert a valid e-mail")
            login_mail.requestFocus()
            return true
        }
        if (pass.isEmpty()) {
            login_password.setError("Insert a valid password")
            login_password.requestFocus()
            return true
        }
        return false
    }
}
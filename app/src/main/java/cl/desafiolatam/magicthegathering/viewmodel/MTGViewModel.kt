package cl.desafiolatam.magicthegathering.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import cl.desafiolatam.magicthegathering.model.Repository

class MTGViewModel(application : Application) : AndroidViewModel(application) {

    var repository : Repository = Repository(application)
    var cardList = repository.cardList

    init {
        repository = Repository(application)
        repository.loadApiData()
    }

}
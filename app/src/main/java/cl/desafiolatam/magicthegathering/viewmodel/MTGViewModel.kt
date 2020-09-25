package cl.desafiolatam.magicthegathering.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.desafiolatam.magicthegathering.model.Repository
import cl.desafiolatam.magicthegathering.model.db.CardsEntity

class MTGViewModel(application : Application) : AndroidViewModel(application) {

    var repository : Repository = Repository(application)
    var cardList = repository.cardList

    init {
        repository = Repository(application)
    }

    fun getDetailsfrom(param1 : String) : LiveData<CardsEntity> {
        return repository.getCardDetails(param1)
    }

    fun loadPages (page : Int) {
        repository.loadApiData(page)
    }
}
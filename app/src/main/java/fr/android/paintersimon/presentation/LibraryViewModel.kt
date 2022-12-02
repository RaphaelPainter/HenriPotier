package fr.android.paintersimon.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.android.paintersimon.data.MyRetrofit
import fr.android.paintersimon.domain.HenriPotierService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LibraryViewModel : ViewModel() { //TODO: move to presentation layer

    val state = MutableLiveData<LibraryState>()
    fun loadBooks() {
        //create service
        val service: HenriPotierService? = MyRetrofit.createHenriPotierService()

        //state at application start
        state.postValue(LibraryState(emptyList(), true))

        //aync request to update state
        viewModelScope.launch(context = Dispatchers.Main) {
            val books = withContext(Dispatchers.IO) {
                service?.listBooks()
            }
            state.postValue(books?.let { LibraryState(it, false) })
        }
    }
}
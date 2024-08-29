package uz.gita.mavericke.ui.presintation.home

import androidx.lifecycle.ViewModel
import uz.gita.mavericke.ui.domain.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    repo: AppRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeContract.UIState(cardList = repo.getCard(), myHistory = repo.myHistory()
    ))
    val state: StateFlow<HomeContract.UIState> = _state

    init {
        _state.value = HomeContract.UIState(
            cardList = repo.getCard(),
            myHistory = repo.myHistory()
        )
    }

    fun onIntent(intent: HomeContract.Intent) {
        // Intentlar bilan ishlash
    }
}
package github.informramiz.asteriodradar.view.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import github.informramiz.asteriodradar.model.database.AsteroidsDatabase
import javax.inject.Inject

class OverviewViewModel @Inject constructor(val database: AsteroidsDatabase): ViewModel() {
    private val _navigateToDetailsEvent = MutableLiveData<Boolean>()
    val navigateToDetailEvent: LiveData<Boolean>
        get() = _navigateToDetailsEvent

    fun onItemClick() {
        _navigateToDetailsEvent.value = true
    }

    fun onNavigationToDetailComplete() {
        _navigateToDetailsEvent.value = false
    }
}

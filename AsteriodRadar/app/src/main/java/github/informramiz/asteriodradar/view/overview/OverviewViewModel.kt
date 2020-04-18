package github.informramiz.asteriodradar.view.overview

import androidx.lifecycle.*
import github.informramiz.asteriodradar.model.respository.AsteroidRepository
import github.informramiz.asteriodradar.model.respository.domain.Asteroid
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OverviewViewModel @Inject constructor(private val asteroidsRepository: AsteroidRepository): ViewModel() {
    private val _navigateToDetailsEvent = MutableLiveData<Asteroid>()
    val navigateToDetailEvent: LiveData<Asteroid>
        get() = _navigateToDetailsEvent

    val asteroids: LiveData<List<Asteroid>> = asteroidsRepository.getAsteroids().asLiveData(context = viewModelScope.coroutineContext)

    init {
        viewModelScope.launch {
            asteroidsRepository.refreshAsteroids()
        }
    }

    fun onItemClick(asteroid: Asteroid) {
        _navigateToDetailsEvent.value = asteroid
    }

    fun onNavigationToDetailComplete() {
        _navigateToDetailsEvent.value = null
    }
}

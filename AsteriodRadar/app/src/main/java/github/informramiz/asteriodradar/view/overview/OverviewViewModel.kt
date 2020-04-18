package github.informramiz.asteriodradar.view.overview

import androidx.lifecycle.*
import github.informramiz.asteriodradar.model.respository.AsteroidRepository
import github.informramiz.asteriodradar.model.respository.domain.Asteroid
import github.informramiz.asteriodradar.model.respository.domain.ImageOfTheDay
import github.informramiz.asteriodradar.model.respository.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OverviewViewModel @Inject constructor(private val asteroidsRepository: AsteroidRepository): ViewModel() {
    private val _navigateToDetailsEvent = MutableLiveData<Asteroid>()
    val navigateToDetailEvent: LiveData<Asteroid>
        get() = _navigateToDetailsEvent

    val asteroids: LiveData<List<Asteroid>> = asteroidsRepository.getAsteroids().asLiveData(context = viewModelScope.coroutineContext)
    val imageOfTheDay: LiveData<Response<ImageOfTheDay>> = liveData {
        emit(Response.LoadingResponse())
        emit(asteroidsRepository.getImageOfTheDay())
    }

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

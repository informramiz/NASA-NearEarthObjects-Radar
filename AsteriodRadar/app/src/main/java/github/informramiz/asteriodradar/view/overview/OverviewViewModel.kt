package github.informramiz.asteriodradar.view.overview

import androidx.lifecycle.*
import github.informramiz.asteriodradar.model.database.dao.AsteroidDao
import github.informramiz.asteriodradar.model.respository.AsteroidRepository
import github.informramiz.asteriodradar.model.respository.domain.Asteroid
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OverviewViewModel @Inject constructor(private val asteroidsRepository: AsteroidRepository,
                                            private val asteroidDoa: AsteroidDao
): ViewModel() {
    private val _navigateToDetailsEvent = MutableLiveData<Boolean>()
    val navigateToDetailEvent: LiveData<Boolean>
        get() = _navigateToDetailsEvent

    val asteroids: LiveData<List<Asteroid>> = asteroidsRepository.getAsteroids().asLiveData(context = viewModelScope.coroutineContext)

    fun onItemClick() {
        _navigateToDetailsEvent.value = true
    }

    fun onNavigationToDetailComplete() {
        _navigateToDetailsEvent.value = false
    }
}

package github.informramiz.asteriodradar.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(): ViewModel() {
    private val _showAstronomicalHelpAlert = MutableLiveData<Boolean>()
    val showAstronomicalHelpAlertEvent: LiveData<Boolean>
        get() = _showAstronomicalHelpAlert

    fun onHelpClick() {
        _showAstronomicalHelpAlert.value = true
    }

    fun showAstronomicalHelpAlertEventComplete() {
        _showAstronomicalHelpAlert.value = false
    }
}

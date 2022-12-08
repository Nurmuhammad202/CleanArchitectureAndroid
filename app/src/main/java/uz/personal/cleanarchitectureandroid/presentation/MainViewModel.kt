package uz.personal.cleanarchitectureandroid.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.personal.cleanarchitectureandroid.domain.modules.SaveUserNameParam
import uz.personal.cleanarchitectureandroid.domain.useCase.GetUserNameUserCase
import uz.personal.cleanarchitectureandroid.domain.useCase.SaveUserNameUserCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var savaUserNameUseCase: SaveUserNameUserCase,
    private var getUserNameUseCase: GetUserNameUserCase,
) : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result


    fun save(text: String) {
        val saveUserNameParam = SaveUserNameParam(text)
        val userCase = savaUserNameUseCase.execute(saveUserNameParam)
        _result.value = "Sava data = $userCase"
    }

    fun load() {
        val useCase = getUserNameUseCase.execute()
        _result.value = useCase.name + useCase.surname
    }
}
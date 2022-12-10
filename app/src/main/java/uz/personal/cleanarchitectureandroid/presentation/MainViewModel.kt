package uz.personal.cleanarchitectureandroid.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.personal.cleanarchitectureandroid.data.remote.models.GetServerModel
import uz.personal.cleanarchitectureandroid.domain.modules.SaveUserNameParam
import uz.personal.cleanarchitectureandroid.domain.modules.SmartPhoneDomain
import uz.personal.cleanarchitectureandroid.domain.useCase.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var savaUserNameUseCase: SaveUserNameUserCase,
    private var getUserNameUseCase: GetUserNameUserCase,
    private var roomUpdateSmartPhoneUseCase: RoomUpdateSmartPhoneUseCase,
    private var roomSaveSmartPhoneUseCase: RoomSaveSmartPhoneUseCase,
    private var roomDeleteSmartPhoneUseCase: RoomDeleteSmartPhoneUseCase,
    private var roomGetSmartPhoneUseCase: RoomGetSmartPhoneUseCase,
    private var apiUseCase: ApiUseCase,
) : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _roomData = MutableLiveData<ArrayList<SmartPhoneDomain>>()
    val roomData: LiveData<ArrayList<SmartPhoneDomain>> = _roomData

    private val _serResponse = MutableLiveData<GetServerModel>()
    val serverResponse: LiveData<GetServerModel> = _serResponse

    fun save(text: String) {
        val saveUserNameParam = SaveUserNameParam(text)
        val userCase = savaUserNameUseCase.execute(saveUserNameParam)
        _result.value = "Sava data = $userCase"
    }

    fun load() {
        val useCase = getUserNameUseCase.execute()
        _result.value = useCase.name + useCase.surname
    }

    fun roomSave(smartPhoneDomain: SmartPhoneDomain) = viewModelScope.launch {
        roomSaveSmartPhoneUseCase.execute(smartPhoneDomain)
    }

    fun roomRemove(smartPhoneDomain: SmartPhoneDomain) = viewModelScope.launch {
        roomDeleteSmartPhoneUseCase.execute(smartPhoneDomain)
    }

    fun roomUpdate(smartPhoneDomain: SmartPhoneDomain) = viewModelScope.launch {
        roomUpdateSmartPhoneUseCase.execute(smartPhoneDomain)
    }

    fun roomGet() = viewModelScope.launch {
        _roomData.value = roomGetSmartPhoneUseCase.execute()
    }

    fun apiUseCase(lat: Double, lon: Double) = viewModelScope.launch {
        apiUseCase.executeGetServerLink(lat = lat, lon = lon).let {
            if (it is GetServerModel) {
                _serResponse.value = it
            }
        }
    }

}


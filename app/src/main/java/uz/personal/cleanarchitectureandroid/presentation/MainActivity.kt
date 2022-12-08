package uz.personal.cleanarchitectureandroid.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import uz.personal.cleanarchitectureandroid.data.repository.UserRepositoryImpl
import uz.personal.cleanarchitectureandroid.data.storage.sharedPref.SharedPrefUseStorage
import uz.personal.cleanarchitectureandroid.databinding.ActivityMainBinding
import uz.personal.cleanarchitectureandroid.domain.modules.SaveUserNameParam
import uz.personal.cleanarchitectureandroid.domain.useCase.GetUserNameUserCase
import uz.personal.cleanarchitectureandroid.domain.useCase.SaveUserNameUserCase

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            viewModel.result.observe(this@MainActivity) { text ->
                txtData.text = text
            }

            btnSaveData.setOnClickListener {
                val text = editSave.text.toString()
                viewModel.save(text)
            }

            btnReadData.setOnClickListener {
                viewModel.load()
            }
        }
    }
}
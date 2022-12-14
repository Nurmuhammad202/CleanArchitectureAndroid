package uz.personal.cleanarchitectureandroid.presentation

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import uz.personal.cleanarchitectureandroid.databinding.ActivityMainBinding
import uz.personal.cleanarchitectureandroid.domain.modules.SmartPhoneDomain

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

            viewModel.roomData.observe(this@MainActivity) {
                Log.d(TAG, "onCreate:dsfdf $it")
            }

            viewModel.serverResponse.observe(this@MainActivity) {
                Log.d(TAG, "onCreate: dsfdsf $it")
            }


            btnSaveData.setOnClickListener {
                val text = editSave.text.toString()
                viewModel.save(text)
            }

            btnReadData.setOnClickListener {
                viewModel.load()
            }

            btnGetRoom.setOnClickListener {
                viewModel.roomGet()
            }

            btnSaveRoom.setOnClickListener {
                val smartPhoneDomain = SmartPhoneDomain()
                smartPhoneDomain.name = "Ipone"
                smartPhoneDomain.price = 500.0
                viewModel.roomSave(smartPhoneDomain = smartPhoneDomain)
            }

            btnGetServer.setOnClickListener {
                viewModel.apiUseCase(-55.0, 69.29289918433346)
            }

        }
    }
}
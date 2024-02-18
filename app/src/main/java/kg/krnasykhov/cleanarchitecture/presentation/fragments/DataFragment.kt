package kg.krnasykhov.cleanarchitecture.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kg.krnasykhov.cleanarchitecture.databinding.FragmentDataBinding

//Передавать лучше всегда applicationContext, чем context activity
//lazy(LazyThreadSafetyMode.NONE) так как здесь многопоточность не требуется можно написать так

class DataFragment : Fragment() {

    private lateinit var binding: FragmentDataBinding
    private lateinit var dataViewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        dataViewModel = ViewModelProvider(
            this,
            DataViewModelFactory(requireActivity().applicationContext)
        )[DataViewModel::class.java]
        dataViewModel.resultLive.observe(viewLifecycleOwner) { text ->
            binding.tvData.text = text
        }
        with(binding) {
            btnSendData.setOnClickListener {
                val text = etPutData.text.toString()
                dataViewModel.save(text)
            }
            btnReceiveData.setOnClickListener {
                dataViewModel.load()
            }
        }
    }
}
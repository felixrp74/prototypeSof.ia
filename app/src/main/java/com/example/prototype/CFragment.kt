package com.example.prototype

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prototype.databinding.FragmentBBinding
import com.example.prototype.databinding.FragmentCBinding

class CFragment : Fragment() {

    private var _binding: FragmentCBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    private lateinit var suma: Suma

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            suma = it.getParcelable<Suma>("suma")!!
            Log.d("DETAIL_FRAGMENT", "gneio $suma")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etNumero1.text = suma.numero1
        binding.etNumero2.text = suma.numero2
        binding.etResult.text = suma.suma

        binding.buttonC.setOnClickListener {
            findNavController().navigate(R.id.action_CFragment_to_DFragment)
        }



    }



}
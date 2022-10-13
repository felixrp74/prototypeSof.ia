package com.example.prototype

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prototype.databinding.FragmentABinding
import com.example.prototype.databinding.FragmentBBinding

class BFragment : Fragment() {

    private var _binding: FragmentBBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        setupRecyclerView()
        setupSearchView()
        setupObservers()
*/
        binding.buttonSum.setOnClickListener {


            val valueA = binding.etNumero1.text.toString()
            val valueB = binding.etNumero2.text.toString()



            val numero1 = Integer.parseInt(valueA)
            val numero2 = Integer.parseInt(valueB)

            val sum : Int = numero1 + numero2

            val sumita = sum.toString()

            val bundle = Bundle()
            val suma = Suma(valueA,valueB,sumita)
            bundle.putParcelable("suma", suma)
            Log.d("TAG", suma.toString())

            findNavController().navigate(R.id.action_BFragment_to_CFragment, bundle)


        }
    }

}
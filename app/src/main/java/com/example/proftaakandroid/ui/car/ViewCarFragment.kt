package com.example.proftaakandroid.ui.car

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.proftaakandroid.R
import com.example.proftaakandroid.databinding.FragmentViewCarBinding
import com.example.proftaakandroid.model.viewmodels.CarViewModel
import com.example.proftaakandroid.navigate

class ViewCarFragment : Fragment() {
    private var _binding: FragmentViewCarBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: CarViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewCarBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel

            viewCarFragment = this@ViewCarFragment
        }
    }

    /**
     * Navigate to the accompaniments menu fragment
     */
    fun goToNextScreen() {
        // TODO: Navigate to the AccompanimentMenuFragment
        navigate(R.id.action_viewCarFragment_to_startCarFragment)
    }

    /**
     *
     */
    fun goBack() {
        navigate(R.id.action_viewCarFragment_to_startApplicationFragment)
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.proftaakandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proftaakandroid.R
import com.example.proftaakandroid.databinding.FragmentStartApplicationBinding
import com.example.proftaakandroid.navigate

class StartApplicationFragment : Fragment() {
    // Binding object instance corresponding to the fragment_start_order.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var _binding: FragmentStartApplicationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartApplicationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.car.setOnClickListener {
            navigate(R.id.action_startApplicationFragment_to_viewCarFragment)
        }

        binding.listing.setOnClickListener {
            navigate(R.id.action_startApplicationFragment_to_viewListingFragment)
        }

        binding.reservation.setOnClickListener {
            navigate(R.id.action_startApplicationFragment_to_viewReservationFragment)
        }

        binding.user.setOnClickListener {
            navigate(R.id.action_startApplicationFragment_to_viewUserFragment)
        }

        return root
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
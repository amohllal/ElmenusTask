package com.example.elmenustask.top_category.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.elmenustask.databinding.FragmentTopCategoryBinding
import com.example.elmenustask.top_category.viewmodel.TopCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopCategoryFragment : Fragment() {
    private var _binding: FragmentTopCategoryBinding? = null
    private val binding get() = _binding!!
    private val topCategoryViewModel: TopCategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
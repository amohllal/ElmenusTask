package com.example.elmenustask.top_category.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.model.Meals
import com.example.domain.model.TopCategoryResponse
import com.example.elmenustask.R
import com.example.elmenustask.core.CATEGORY_ID
import com.example.elmenustask.core.CATEGORY_IMAGE
import com.example.elmenustask.core.CATEGORY_NAME
import com.example.elmenustask.core.showImage
import com.example.elmenustask.core.wrapper.DataStatus
import com.example.elmenustask.databinding.FragmentTopCategoryBinding
import com.example.elmenustask.home.ui.adapters.TopMealsRecyclerAdapter
import com.example.elmenustask.top_category.viewmodel.TopCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopCategoryFragment : Fragment() {
    private var _binding: FragmentTopCategoryBinding? = null
    private val binding get() = _binding!!
    private val topCategoryViewModel: TopCategoryViewModel by viewModels()
    private var topMealsRecyclerAdapter: TopMealsRecyclerAdapter? = null
    private val mealsList = arrayListOf<Meals>()
    private var categoryName: String? = null
    private var categoryImage: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentsFromHome()
        initView()
        initListener()
        getTopCategory()
        observeTopCategoryResponse()
        initTopMealsRecyclerAdapter()

    }

    private fun initListener() {
        binding.topCategoryToolbar.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun initTopMealsRecyclerAdapter() {
        topMealsRecyclerAdapter = TopMealsRecyclerAdapter(mealsList) {
            val bundle = Bundle().apply {
                putString(CATEGORY_ID, it.id)
            }
            findNavController().navigate(
                R.id.action_topCategoryFragment_to_mealsDetailsFragment,
                bundle
            )
        }
        binding.mealsRv.adapter = topMealsRecyclerAdapter
    }

    private fun observeTopCategoryResponse() {
        topCategoryViewModel.topCategoryLiveData.observe(requireActivity()) {
            when (it?.status) {
                DataStatus.Status.SHOW_LOADING -> showLoading()
                DataStatus.Status.HIDE_LOADING -> hideLoading()
                DataStatus.Status.SUCCESS -> handleSuccessData(it.data)
                DataStatus.Status.ERROR -> showError()
                else -> {}
            }
        }
    }

    private fun handleSuccessData(data: TopCategoryResponse?) {
        //hideLoading()
        if (data?.mealList.isNullOrEmpty()) handleNoDataLogic(getString(R.string.no_data_available)) else updateUI(
            data?.mealList
        )
    }

    private fun updateUI(data: ArrayList<Meals>?) {
        data?.let {
            updateTopCategory(it)
        }
    }

    private fun updateTopCategory(it: ArrayList<Meals>) {
        mealsList.addAll(it)
        topMealsRecyclerAdapter?.notifyDataSetChanged()
    }

    private fun showError() {
       // hideLoading()
        handleNoDataLogic(getString(R.string.an_error_occure))
    }

    private fun showLoading() {
        binding.progressBar.isVisible = true
    }

    private fun hideLoading() {
        binding.progressBar.isVisible = false
    }

    private fun handleNoDataLogic(message: String) {
        binding.noDataTv.text = message
        binding.noDataTv.isVisible = true
    }

    private fun getTopCategory() {
        topCategoryViewModel.getTopCategory()
    }

    private fun initView() {
        binding.bannerIv.showImage(categoryImage)
        binding.categoryTitleTv.text = categoryName
        binding.topCategoryToolbar.titleToolbar.text = getString(R.string.top_category)
    }

    private fun getArgumentsFromHome() {
        categoryName = arguments?.getString(CATEGORY_NAME)
        categoryImage = arguments?.getString(CATEGORY_IMAGE)
        topCategoryViewModel.categoryName = categoryName
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
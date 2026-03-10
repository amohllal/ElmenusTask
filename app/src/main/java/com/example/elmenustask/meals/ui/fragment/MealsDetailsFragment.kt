package com.example.elmenustask.meals.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.model.MealResponse
import com.example.elmenustask.R
import com.example.elmenustask.core.CATEGORY_ID
import com.example.elmenustask.core.openYoutubeVideo
import com.example.elmenustask.core.showImage
import com.example.elmenustask.core.wrapper.DataStatus
import com.example.elmenustask.databinding.FragmentMealsDetailsBinding
import com.example.elmenustask.home.ui.adapters.ProductTagsRecyclerAdapter
import com.example.elmenustask.meals.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MealsDetailsFragment : Fragment() {

    private var _binding: FragmentMealsDetailsBinding? = null
    private val binding get() = _binding!!
    private val mealsViewModel: MealsViewModel by viewModels()
    private var productTagsRecyclerAdapter: ProductTagsRecyclerAdapter? = null
    private val tagsList = arrayListOf<String>()
    private var isContentExpanded = false
    private var youtubeLink: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentsData()
        initView()
        initListener()
        getMealDetails()
        observeMealDetailsResponse()

    }

    private fun observeMealDetailsResponse() {
        mealsViewModel.mealDetailLiveData.observe(viewLifecycleOwner) {
            when (it?.status) {
                DataStatus.Status.SHOW_LOADING -> showLoading()
                DataStatus.Status.HIDE_LOADING -> hideLoading()
                DataStatus.Status.SUCCESS -> handleSuccessData(it.data)
                DataStatus.Status.ERROR -> showError()
                else -> {}
            }
        }
    }

    private fun handleSuccessData(data: MealResponse?) {
        //hideLoading()
        if (data == null) handleNoDataLogic(getString(R.string.no_data_available)) else updateUI(
            data
        )
    }

    private fun updateUI(data: MealResponse) {
        binding.apply {
            mealTitleTv.text = data.mealTitle
            mealCategoryTitleTv.text = data.strCategory
            mealOriginTitleTv.text = data.strArea
            recipeDescTv.text = data.strInstructions
            data.strTags?.let { tagsList.addAll(it) }
            data.strYoutube?.let { youtubeLink = it }
            mealIv.showImage(data.strMealThumb)
            productTagsRecyclerAdapter?.notifyDataSetChanged()
        }
    }

    private fun showError() {
        //hideLoading()
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

    private fun getMealDetails() {
        mealsViewModel.getMealDetails()
    }

    private fun initListener() {
        binding.mealsDetailsToolbar.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.showMoreBtn.setOnClickListener {
            if (isContentExpanded) {
                binding.recipeDescTv.maxLines = 3
                binding.showMoreBtn.text = getString(R.string.show_more)
            } else {
                binding.recipeDescTv.maxLines = Int.MAX_VALUE
                binding.showMoreBtn.text = getString(R.string.show_less)
            }
            isContentExpanded = !isContentExpanded
        }

        binding.mealBanner.setOnClickListener {
            youtubeLink?.let { it1 -> requireContext().openYoutubeVideo(it1) }
        }
    }

    private fun initView() {
        binding.mealsDetailsToolbar.titleToolbar.text = getString(R.string.meals_details)
        productTagsRecyclerAdapter = ProductTagsRecyclerAdapter(tagsList)
        binding.tagsRv.adapter = productTagsRecyclerAdapter
    }

    private fun getArgumentsData() {
        mealsViewModel.categoryId = arguments?.getString(CATEGORY_ID)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

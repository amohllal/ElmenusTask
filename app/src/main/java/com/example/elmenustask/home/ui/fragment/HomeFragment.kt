package com.example.elmenustask.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.domain.model.Announcement
import com.example.domain.model.AnnouncementDetails
import com.example.domain.model.Banner
import com.example.domain.model.Category
import com.example.domain.model.CategoryDetails
import com.example.domain.model.HomeResponse
import com.example.domain.model.Ingredient
import com.example.domain.model.IngredientDetails
import com.example.domain.model.Product
import com.example.domain.model.ProductDetails
import com.example.elmenustask.R
import com.example.elmenustask.core.wrapper.DataStatus
import com.example.elmenustask.databinding.FragmentHomeBinding
import com.example.elmenustask.home.ui.adapters.AnnouncementPagerAdapter
import com.example.elmenustask.home.ui.adapters.DotsIndicatorAdapter
import com.example.elmenustask.home.ui.adapters.IngredientsRecyclerAdapter
import com.example.elmenustask.home.ui.adapters.ProductRecyclerAdapter
import com.example.elmenustask.home.ui.adapters.TopCategoryRecyclerAdapter
import com.example.elmenustask.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()
    private var topCategoryRecyclerAdapter: TopCategoryRecyclerAdapter? = null
    private var productRecyclerAdapter: ProductRecyclerAdapter? = null
    private var ingredientsRecyclerAdapter: IngredientsRecyclerAdapter? = null
    private var announcementPagerAdapter: AnnouncementPagerAdapter? = null
    private var dotsIndicatorAdapter: DotsIndicatorAdapter? = null
    private var categoryList = arrayListOf<CategoryDetails>()
    private var mealsList = arrayListOf<ProductDetails>()
    private var ingredientsList = arrayListOf<IngredientDetails>()
    private var announcementList = arrayListOf<AnnouncementDetails>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getHome()
        observeHomeResponse()
        initTopCategoryRecyclerAdapter()
        initProductRecyclerAdapter()
        initIngredientsRecyclerAdapter()
        initAnnouncementPagerAdapter()
    }

    private fun initAnnouncementPagerAdapter() {
        announcementPagerAdapter = AnnouncementPagerAdapter(announcementList)
        binding.announcementVP.adapter = announcementPagerAdapter
        binding.announcementVP.registerOnPageChangeCallback(pageChangeCallback)
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            dotsIndicatorAdapter?.notifyDataSetChanged()
        }
    }

    private fun initTopCategoryRecyclerAdapter() {
        topCategoryRecyclerAdapter = TopCategoryRecyclerAdapter(categoryList) {
            //TODO handle navigation
        }
        binding.topCategoryRv.adapter = topCategoryRecyclerAdapter
    }

    private fun initProductRecyclerAdapter() {
        productRecyclerAdapter = ProductRecyclerAdapter(mealsList) {
            //TODO handle navigation
        }
        binding.mealsRv.adapter = productRecyclerAdapter
    }

    private fun initIngredientsRecyclerAdapter() {
        ingredientsRecyclerAdapter = IngredientsRecyclerAdapter(ingredientsList) {
            //TODO handle navigation
        }
        binding.ingredientsRv.adapter = ingredientsRecyclerAdapter
    }

    private fun observeHomeResponse() {
        homeViewModel.homeLiveData.observe(requireActivity()) {
            when (it?.status) {
                DataStatus.Status.LOADING -> showLoading()
                DataStatus.Status.SUCCESS -> handleSuccessData(it.data)
                DataStatus.Status.ERROR -> showError()
                else -> {}
            }
        }
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

    private fun handleSuccessData(homeResponse: HomeResponse?) {
        hideLoading()
        if (homeResponse == null) handleNoDataLogic(getString(R.string.no_data_available)) else updateUI(
            homeResponse
        )
    }

    private fun updateUI(homeResponse: HomeResponse) {
        homeResponse.banner?.let { updateBanner(it) }
        homeResponse.topCategory?.let { updateTopCategory(it) }
        homeResponse.product?.let { updateMeals(it) }
        homeResponse.ingredient?.let { updateIngredient(it) }
        homeResponse.announcement?.let { updateAnnouncement(it) }
    }

    private fun updateAnnouncement(announcement: Announcement) {
        announcement.announcementList?.let {
            binding.announcementTv.text = announcement.title
            announcementList.addAll(it)
            announcementPagerAdapter?.notifyDataSetChanged()
            initDotsIndicatorAdapter()
        }
    }

    private fun initDotsIndicatorAdapter() {
        dotsIndicatorAdapter = DotsIndicatorAdapter(announcementList.size, binding.announcementVP)
        binding.dotsIndicator.adapter = dotsIndicatorAdapter
        dotsIndicatorAdapter?.notifyDataSetChanged()
    }

    private fun updateIngredient(ingredient: Ingredient) {
        ingredient.ingredientsList?.let {
            binding.ingredientsTv.text = ingredient.title
            ingredientsList.addAll(it)
            ingredientsRecyclerAdapter?.notifyDataSetChanged()
        }
    }

    private fun updateMeals(product: Product) {
        product.productList?.let {
            binding.mealsTv.text = product.title
            mealsList.addAll(it)
            productRecyclerAdapter?.notifyDataSetChanged()
        }
    }

    private fun updateTopCategory(category: Category) {
        category.categoryList?.let {
            binding.topCategoryTv.text = category.title
            categoryList.addAll(it)
            topCategoryRecyclerAdapter?.notifyDataSetChanged()
        }

    }

    private fun updateBanner(banner: Banner) {
        binding.bannerLayout.isVisible = true
        binding.bannerTypeTv.text = banner.title
    }

    private fun showError() {
        hideLoading()
        handleNoDataLogic(getString(R.string.an_error_occure))
    }

    private fun getHome() {
        homeViewModel.getHome()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.announcementVP.unregisterOnPageChangeCallback(pageChangeCallback)
        _binding = null
    }
}
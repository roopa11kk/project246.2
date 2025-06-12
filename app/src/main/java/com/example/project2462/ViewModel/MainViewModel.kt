package com.example.project2462.ViewModel

import androidx.lifecycle.ViewModel
import com.example.project2462.Domain.BannerModel
import com.example.project2462.Repository.MainRepository
import androidx.lifecycle.LiveData
import com.example.project2462.Domain.CategoryModel
import com.example.project2462.Domain.ItemsModel

class MainViewModel:ViewModel() {
private val repository=MainRepository()

    fun loadBanner():LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }

    fun loadItems(categoryId:String):LiveData<MutableList<ItemsModel>>{
        return repository.loadItemCategory(categoryId)
    }
}
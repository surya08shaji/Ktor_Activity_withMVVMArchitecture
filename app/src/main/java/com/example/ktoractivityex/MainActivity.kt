package com.example.ktoractivityex

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktoractivityex.adapter.AdapterArticleList
import com.example.ktoractivityex.adapter.AdapterProduct
import com.example.ktoractivityex.api.ApiService
import com.example.ktoractivityex.databinding.ActivityMainBinding
import com.example.ktoractivityex.modelArticle.ModelListItem
import com.example.ktoractivityex.modelProduct.ResponseModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val mainScope = MainScope()

    private lateinit var adapter: AdapterArticleList
    var value = ArrayList<ModelListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager


        mainScope.launch {
            kotlin.runCatching {
                value = ApiService.create().getArticleList()
            }.onSuccess {
                adapter = AdapterArticleList(value)
                Log.e("value", "$value")
                binding.recyclerView.adapter = adapter

            }.onFailure {
                Log.e("exception", it.localizedMessage)
            }
        }

    }
}
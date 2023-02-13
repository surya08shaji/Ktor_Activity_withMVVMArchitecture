package com.example.ktoractivityex.api

import com.example.ktoractivityex.modelArticle.ModelListItem
import com.example.ktoractivityex.modelProduct.ResponseModel
import io.ktor.client.*
import io.ktor.client.request.*

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {

//    override suspend fun getProducts(): List<ResponseModel> {
//       return client.get { url(ApiRoutes.PRODUCTS) }
//
//    }

    override suspend fun getArticleList(): ArrayList<ModelListItem> {
        return client.get {url(ApiRoutes.ARTICLE_LIST)}
    }
}

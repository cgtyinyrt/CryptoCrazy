package com.example.cryptocrazy.repository

import com.example.cryptocrazy.model.Crypto
import com.example.cryptocrazy.model.CryptoList
import com.example.cryptocrazy.service.CryptoAPI
import com.example.cryptocrazy.util.Constants.API_KEY
import com.example.cryptocrazy.util.Constants.CALL_ATTRIBUTES
import com.example.cryptocrazy.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoAPI
) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY,id,CALL_ATTRIBUTES)
        } catch(e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}
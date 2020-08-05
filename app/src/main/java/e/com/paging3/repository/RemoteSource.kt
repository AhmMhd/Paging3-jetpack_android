package e.com.paging3.repository

import android.util.Log
import com.google.gson.Gson
import e.com.paging3.model.PaginatedResponse
import e.com.paging3.network.NetworkCalls

class RemoteSource(var networkCalls: NetworkCalls) {
    suspend fun requestAPI(position: Int): PaginatedResponse? {
        val queries = HashMap<String, String>().apply {
            put("query", "nodejs")
            put("hitsPerPage", "10")
            put("page", "$position")
        }
        val response = networkCalls.networkService.get("https://hn.algolia.com/api/v1/search_by_date", queries)
                .await()
        if (response.isSuccessful) {
            val json = response.body()?.string() ?: ""
            Log.d("RESPONSE:: ","$json")
            val obj = Gson().fromJson<PaginatedResponse>(json, PaginatedResponse::class.java)
            return obj
        } else {
            Log.d("RESPONSE:: ","Failed")
            return null
        }
    }
}
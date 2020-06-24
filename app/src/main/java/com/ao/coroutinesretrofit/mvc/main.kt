package com.ao.coroutinesretrofit.mvc

import com.chase.kotlincoroutines.adapters.PostAdapter
import com.chase.kotlincoroutines.model.User
import com.chase.kotlincoroutines.network.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun getCororutions(){
    val service = RetrofitFactory.makeRetrofitService()
    CoroutineScope(Dispatchers.IO).launch {
        val response = service.getPosts()
        withContext(Dispatchers.Main){
            if (response.isSuccessful){
                response.body()?.let { initRecyclerView(it) }
            } else{
                toast("Error network operation failed with ${response.code()}")

            }


        }
    }
}



private fun initRecyclerView(list: List<User>) {
    recyclerview.layoutManager = LinearLayoutManager(this)
    recyclerview.adapter = PostAdapter(list, this)
}
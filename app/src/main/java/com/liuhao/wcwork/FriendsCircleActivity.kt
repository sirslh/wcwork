package com.liuhao.wcwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.liuhao.wcwork.adapter.DynamicListAdapter
import com.liuhao.wcwork.common.verticalLinearLayoutManager
import com.liuhao.wcwork.http.HttpManage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FriendsCircleActivity : AppCompatActivity() {

    private val recyclervie: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerview_dynamic_list) }

    private lateinit var dynamicListAdapter: DynamicListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends_circle)
        initView()
        getHttpUser()
    }


    private fun getHttpUser() {
        HttpManage.instance.getHttpService().getUserVO()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("hh", "结果"+it.profileImage)
            }, {
                Log.e("hh", it?.message ?: "错误")
            })
    }

    private fun initView() {

        recyclervie.layoutManager = verticalLinearLayoutManager()
        dynamicListAdapter = DynamicListAdapter()
        recyclervie.adapter = dynamicListAdapter

    }
}

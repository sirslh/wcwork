package com.liuhao.wcwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.liuhao.wcwork.common.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_go_btn).setOnClickListener {
            startActivity<FriendsCircleActivity>()
        }
    }
}

package com.example.intent_kotlin_vazifa5

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.intent_kotlin_vazifa5.user.Member


class DetailActivity: AppCompatActivity() {
    val TAG = DetailActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }
    fun initViews() {
        val tv_exit = findViewById<Button>(R.id.tv_exit)
        tv_exit.setOnClickListener {
            val member = Member("Davlat", 19)
            backToFinish(member)
        }
        val tv_detail = findViewById<TextView>(R.id.tv_detail)
        val user = intent.getParcelableExtra<Parcelable>("user")
        Log.d(TAG, user.toString())
        tv_detail.text = user.toString()
    }

    fun backToFinish(member: Member) {
        val returnIntent = Intent()
        returnIntent.putExtra("member", member)
        setResult(RESULT_OK, returnIntent)
        finish()
    }
}
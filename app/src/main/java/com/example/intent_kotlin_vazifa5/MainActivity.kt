package com.example.intent_kotlin_vazifa5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.intent_kotlin_vazifa5.user.Member
import com.example.intent_kotlin_vazifa5.user.User


class MainActivity : AppCompatActivity() {
    val TAG = DetailActivity::class.java.toString()

    lateinit var tv_home: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { member ->
        if (member.resultCode === RESULT_OK) {
            val data = member.data
            val member1: Member? = data!!.getParcelableExtra("member")
            Log.d(TAG, member1.toString())
            tv_home.text = member1.toString()
        }
    }


        fun initViews() {
            tv_home = findViewById(R.id.tv_home)
            val b_open_detail = findViewById<Button>(R.id.b_open_detail)
            b_open_detail.setOnClickListener {
                val user = User("Azizbek", 20)
                openDetailActivity(user)
            }
        }

        fun openDetailActivity(user: User?) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("user", user)

            detailLauncher.launch(intent)
        }

}
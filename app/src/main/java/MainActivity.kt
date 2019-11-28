package com.example.android.sample.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.sample.savinggold.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          saveButton.setOnClickListener {
            val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = dataStore.edit()
            val savingMoney: String = calculateMoneyEditText.text.toString()
            // 入力された金額を保存
            editor.putString("savedMoney", savingMoney)
            editor.apply()
            // 保存された入力された金額を読み出し
            val savedMoney = Integer.parseInt(dataStore.getString("savedMoney", "Nothing") ?: return@setOnClickListener)
            val firstTotalMoney = 0
            editor.putString("totalMoney", firstTotalMoney.toString())
            editor.apply()
            val lastTotalMoney = Integer.parseInt(dataStore.getString("totalMoney", firstTotalMoney.toString()).toString())
                .plus(savedMoney)
            Toast.makeText(this, "${lastTotalMoney}円貯まりました！", Toast.LENGTH_SHORT).show()
        }
    }
}




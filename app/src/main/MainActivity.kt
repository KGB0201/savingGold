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

        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = dataStore.edit()
        editor.putString("input", "afaklfhaufhae")
        editor.apply()






        saveButton.setOnClickListener {
            Toast.makeText(this, "${calculateMoney.text}円貯まりました！", Toast.LENGTH_SHORT).show()
        }
// メモ
        // EditTextに入力された数値を保存しているtotalFeeに合計してそれをトーストで表示する
        // EditTextに入力された数値 => Integer.parseInt(calculateMoney.text.toString())
        // 保存しているtotalFee => var totalFee = hogehoge 保存している => ??
        // Toastはもうできてる
        // 数値を保存してそれを再利用したい
    }
}




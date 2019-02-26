package com.example.energy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)



        val actionBar = supportActionBar
        actionBar!!.hide()

        btn_login.setOnClickListener {
            val login = txt_login.text.toString()
            val password = txt_password.text.toString()
            when {
                login == "404" && password == "test" -> {
                    intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                login == "" && password == "" -> Snackbar.make(it,"Введите что-нибудь",Snackbar.LENGTH_LONG).show()
                login == "" -> Snackbar.make(it,"Введите логин",Snackbar.LENGTH_LONG).show()
                password == "" -> Snackbar.make(it,"Введите пароль",Snackbar.LENGTH_LONG).show()
                password != "404" || login != "test" -> Snackbar.make(it,"Неверный пароль или логин",Snackbar.LENGTH_LONG).show()
            }
        }

    }
}

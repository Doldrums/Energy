package com.example.energy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_welcome.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val actionBar = supportActionBar
        actionBar!!.hide()

        SignIn.setOnClickListener {
            intent = Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }
        btn_signup.setOnClickListener {
            val name = txt_name.text.toString()
            val surname = txt_surname.text.toString()
            val email = txt_email.text.toString()
            val password = txt_r_password.text.toString()
            when {
                name != "" && password != "" && surname != "" && email != "" -> {
                    intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                name == "" -> Snackbar.make(it,"Введите имя", Snackbar.LENGTH_LONG).show()
                password == "" -> Snackbar.make(it,"Введите пароль", Snackbar.LENGTH_LONG).show()
                surname == "" -> Snackbar.make(it,"Введите фамилию", Snackbar.LENGTH_LONG).show()
                email == "" -> Snackbar.make(it,"Введите почту", Snackbar.LENGTH_LONG).show()
            }
        }

    }
}

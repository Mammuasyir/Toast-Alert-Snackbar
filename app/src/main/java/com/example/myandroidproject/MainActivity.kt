package com.example.myandroidproject

import android.app.Application
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AlertDialog
import com.example.myandroidproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.messages.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "HEloo Toast!", Toast.LENGTH_SHORT)
            toast.show()
        }

        binding.btnAlert.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this@MainActivity)
            alertDialog.setTitle("Judul Alert")
            alertDialog.setMessage("Pesan Alert Dialog")
            alertDialog.setPositiveButton("Ya", DialogInterface.OnClickListener{dialog, which ->
                Toast.makeText(this@MainActivity, "Jika Ya", Toast.LENGTH_SHORT).show()
            })
            alertDialog.setNegativeButton("Tidak", DialogInterface.OnClickListener{dialog, which ->
                Toast.makeText(this@MainActivity, "Jika Tidak", Toast.LENGTH_SHORT).show()
            })
            alertDialog.setNeutralButton("Batal", DialogInterface.OnClickListener{dialog, which ->
                Toast.makeText(this@MainActivity, "Jika Batal", Toast.LENGTH_SHORT).show()
            })
            alertDialog.show()
        }

        binding.btnSnack.setOnClickListener { view ->
            Snackbar.make(view, "Ini adalah Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Oke", null).show()
        }

    }
}
package com.android.parkingpartnerapp.android

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import java.io.File
import java.lang.Exception


class StoreImageActivity : AppCompatActivity() {

    lateinit var viewImage: ImageView
    lateinit var resultLauncher :ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_image)

        var textView: TextView = findViewById(R.id.tvChooseImageFromGallery)
        viewImage = findViewById(R.id.viewImage)
        textView.setOnClickListener {
                 chooseImage()
        }
        registerResult()

    }

    fun chooseImage(){
        val intent : Intent = Intent(MediaStore.ACTION_PICK_IMAGES)
        resultLauncher.launch(intent)

    }

    fun registerResult(){
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){result->
                try {
                    var imageUri :Uri? = result.data?.data
                    viewImage.setImageURI(imageUri)
                }catch (e:Exception)
                {
                    println(e.message)
                }
        }

    }
}
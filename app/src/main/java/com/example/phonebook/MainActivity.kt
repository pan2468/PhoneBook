package com.example.phonebook

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		permissionCheck()
	}

	private fun permissionCheck() {
		if(android.os.Build.VERSION.SDK_INT >= 23){
			var permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
			if(permissionCheck != PackageManager.PERMISSION_GRANTED){
				ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),100)
			}

			permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
			if(permissionCheck != PackageManager.PERMISSION_GRANTED){
				ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
			}

			permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
			if(permissionCheck != PackageManager.PERMISSION_GRANTED){
				ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 100)
			}
		}
	}
}
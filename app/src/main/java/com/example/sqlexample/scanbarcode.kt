package com.example.sqlexample

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler

class scanbarcode : AppCompatActivity() ,ResultHandler{
private val REQUEST_CAMERA=1
var scannerview:ZXingScannerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scannerview= ZXingScannerView(this)
        //setContentView(R.layout.activity_scanbarcode)
        setContentView(scannerview)
    }
    private fun checkPermission():Boolean{
        return ContextCompat.checkSelfPermission(this@scanbarcode , android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED
    }
    private fun   requestPermission(){
        ActivityCompat.requestPermissions(this@scanbarcode , arrayOf(android.Manifest.permission.CAMERA) ,REQUEST_CAMERA)

    }


    override fun handleResult(result: Result?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

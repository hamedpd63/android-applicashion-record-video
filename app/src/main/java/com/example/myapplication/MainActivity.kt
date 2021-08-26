package com.example.myapplication

import android.app.Activity
import android.app.Notification
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        record.setOnClickListener {
            var int = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivityForResult(int,1)
        }
        videoViewre.setOnCompletionListener {
            videoViewre.visibility =View.GONE
            record.visibility=View.VISIBLE
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==1 && resultCode==Activity.RESULT_OK && data != null)
        {
            videoViewre.setVideoURI(data.data)
            videoViewre.visibility =View.VISIBLE
            record.visibility=View.GONE
            videoViewre.start()
        }
    }
}

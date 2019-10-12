package com.andreh.creditcardreader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.text.FirebaseVisionText
import java.io.IOException
import java.lang.StringBuilder
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.io.File


class CardDetectorActivity : AppCompatActivity() {

    var btn_on_device: Button? = null;
    var txt_card: TextView? = null;
    var image_to_analyze: ImageView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_detector)

        btn_on_device = findViewById(R.id.btnStartRecognition) as Button
        txt_card = findViewById(R.id.textCardText) as TextView
        image_to_analyze = findViewById(R.id.image_to_analyze) as ImageView

        val imageFile = File(""+intent.extras!!.getString("image_to_analyze"))
        if(imageFile.exists()){
            val bitmap = BitmapFactory.decodeFile(imageFile.toString())
            image_to_analyze!!.setImageBitmap(bitmap)
        }


        // set on-click listener
        btn_on_device!!.setOnClickListener {
            runTextRecognition()
        }
    }

    private fun runTextRecognition() {


    }

    private fun processTextRecognitionResult(texts: FirebaseVisionText) {

    }
    private fun showToast(no_text_found: String) {
        Toast.makeText(this, no_text_found + "", Toast.LENGTH_SHORT).show()
    }

}

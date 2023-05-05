package com.codewithchang.mlhub.mainPageActivity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.codewithchang.mlhub.Classifier
import com.codewithchang.mlhub.R
import kotlinx.android.synthetic.main.activity_apple.*
import kotlinx.android.synthetic.main.activity_apple.demoTxt
import kotlinx.android.synthetic.main.activity_apple.mCameraButton
import kotlinx.android.synthetic.main.activity_apple.mDetectButton
import kotlinx.android.synthetic.main.activity_apple.mGalleryButton
import kotlinx.android.synthetic.main.activity_apple.mPhotoImageView
import kotlinx.android.synthetic.main.activity_apple.mResultTextView
import kotlinx.android.synthetic.main.activity_apple.mShowPrecaution
import kotlinx.android.synthetic.main.activity_apple_detection.*
import kotlinx.android.synthetic.main.custom_dailog.view.*
import java.io.IOException

class RoseDetection : AppCompatActivity() {

    private lateinit var mClassifier: Classifier
    private lateinit var mBitmap: Bitmap

    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private val mInputSize = 224
    private val mModelPath = "model_rose.tflite"
    private val mLabelPath = "rose_label.txt"
    private val mSamplePath = "diagram.png"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rose_detection)

        mClassifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)

        resources.assets.open(mSamplePath).use {
            mBitmap = BitmapFactory.decodeStream(it)
            mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
            mPhotoImageView.setImageBitmap(mBitmap)
        }


        mGalleryButton.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode)
        }
        mDetectButton.setOnClickListener {
            val results = mClassifier.recognizeImage(mBitmap).firstOrNull()
            mResultTextView.text= results?.title
            //+"\n Confidence:"+results?.confidence

            mShowPrecaution.alpha = 1.0f
            mResultTextView.alpha = 1.0f
            detectAs.alpha = 1.0f
            demoTxt.alpha = 0.0f
        }
        
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Success!!!")
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)
                mDetectButton.alpha = 1.0f
                demoTxt.alpha = 0.0f
                mResultTextView.alpha = 1.0f

            }
        } else {
            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }


    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / orignalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }

    fun precaution(view: View) {
        val results = mClassifier.recognizeImage(mBitmap).firstOrNull()

        when (results?.title) {
            "Rose Black Spot" -> {
                val view = View.inflate(this@RoseDetection, R.layout.rose_black_spot, null)
                val builder = AlertDialog.Builder(this@RoseDetection)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                view.got_it_btn.setOnClickListener {
                    dialog.dismiss()
                }
            }
            "Downy Mildew" -> {
                val view = View.inflate(this@RoseDetection, R.layout.rose_downy_mildew, null)
                val builder = AlertDialog.Builder(this@RoseDetection)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                view.got_it_btn.setOnClickListener {
                    dialog.dismiss()
                }
            }
            "Fresh Leaf" -> {
                val view = View.inflate(this@RoseDetection, R.layout.rose_fresh_leaf, null)
                val builder = AlertDialog.Builder(this@RoseDetection)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                view.got_it_btn.setOnClickListener {
                    dialog.dismiss()
                }
            }

            "Rose Botrytis" -> {
                val view = View.inflate(this@RoseDetection, R.layout.rose_botrytis, null)
                val builder = AlertDialog.Builder(this@RoseDetection)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                view.got_it_btn.setOnClickListener {
                    dialog.dismiss()
                }
            }

            "Rose Crown Gall" -> {
                val view = View.inflate(this@RoseDetection, R.layout.rose_crown_gall, null)
                val builder = AlertDialog.Builder(this@RoseDetection)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                view.got_it_btn.setOnClickListener {
                    dialog.dismiss()
                }
            }

            "Rose Dying" -> {
                val view = View.inflate(this@RoseDetection, R.layout.rose_dying, null)
                val builder = AlertDialog.Builder(this@RoseDetection)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                view.got_it_btn.setOnClickListener {
                    dialog.dismiss()
                }
            }


            else -> {
                //Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show()
                val view = View.inflate(this@RoseDetection, R.layout.custom_dailog, null)
                val builder = AlertDialog.Builder(this@RoseDetection)
                builder.setView(view)

                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                view.got_it_btn.setOnClickListener {
                    dialog.dismiss()
                }
            }
        }
    }

}
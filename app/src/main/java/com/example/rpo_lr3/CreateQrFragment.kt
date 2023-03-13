package com.example.rpo_lr3

//import com.google.zxing.BarcodeFormat
//import com.google.zxing.qrcode.QRCodeWriter

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import kotlinx.android.synthetic.main.fragment_create_qr.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*


class CreateQrFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_qr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val size = 300
        val qrCodeContent = edt_enterMessage.text

        val hintMap: MutableMap<EncodeHintType, Any> = EnumMap<EncodeHintType, Any>(
            EncodeHintType::class.java
        )
        hintMap[EncodeHintType.CHARACTER_SET] = "UTF-8"

        btn_generateCode.setOnClickListener {
            val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
            val codeWriter = MultiFormatWriter()
                val bitMatrix =
                    codeWriter.encode(qrCodeContent.toString(), BarcodeFormat.QR_CODE, size, size,hintMap)
                for (x in 0 until size) {
                    for (y in 0 until size) {
                        val color = if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
                        bitmap.setPixel(x, y, color)
                    }
                }
            iv_Qrcode.setImageBitmap(bitmap)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CreateQrFragment()
    }
}
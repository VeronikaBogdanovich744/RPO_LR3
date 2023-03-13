package com.example.rpo_lr3

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_result.*



private const val ARG_VALUE = "param1"


class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var value: String? = null
    //private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            value = it.getString(ARG_VALUE)
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(URLUtil.isValidUrl(value)){
            btn_open.setVisibility(View.VISIBLE)
            //btn_copy.setVisibility(View.GONE)
        }else{
            btn_open.setVisibility(View.GONE)
            //btn_copy.setVisibility(View.VISIBLE)
        }

        txt_result.setText(value)

        btn_copy.setOnClickListener {
            val clipboard: ClipboardManager = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(value, value)
            clipboard!!.setPrimaryClip(clip)
        }

        btn_open.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(value))
            startActivity(browserIntent)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(value: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_VALUE, value)
                }
            }
    }
}
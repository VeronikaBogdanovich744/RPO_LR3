package com.example.rpo_lr3.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rpo_lr3.CreateQrFragment
import com.example.rpo_lr3.R
import com.example.rpo_lr3.ScanFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_create_qr.setOnClickListener {
            val fragement = CreateQrFragment.newInstance()
            replaceFragment(fragement,true)
        }

        btn_scan.setOnClickListener {
            val fragment = ScanFragment.newInstance()
            replaceFragment(fragment,true)
        }
    }

    fun replaceFragment(fragment:Fragment, istransition:Boolean){

        val act = requireActivity()
        val fragmentTransition= act.supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }

}
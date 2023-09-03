package com.example.vidhi.ui.successPage.view

import android.os.Bundle
import com.example.vidhi.R
import com.example.vidhi.databinding.ActivitySuccessPageBinding
import com.example.vidhi.ui.base.BaseAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Success page after choosing the lucky charm
 *
 * @author Vidhi Dave
 */
@AndroidEntryPoint
class SuccessPageActivity : BaseAppCompatActivity() {

    private lateinit var binding: ActivitySuccessPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySuccessPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initActionBar(getString(R.string.result), true)
        initView()
    }

    override fun initView() {
    }
}
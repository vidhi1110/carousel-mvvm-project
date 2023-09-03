package com.example.vidhi.ui.memeList.view

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.vidhi.R
import com.example.vidhi.network.response.Meme
import com.example.vidhi.ui.memeList.MemeListAdapter
import com.example.vidhi.databinding.ActivityMainBinding
import com.example.vidhi.ui.base.BaseAppCompatActivity
import com.example.vidhi.ui.memeList.viewmodel.MemeListViewModel
import com.example.vidhi.ui.successPage.view.SuccessPageActivity
import com.example.vidhi.utils.carouselrecyclerview.CarouselLayoutManager
import com.example.vidhi.utils.carouselrecyclerview.CarouselRecyclerview
import dagger.hilt.android.AndroidEntryPoint

/**
 * Meme list activity with carousel layouts
 *
 * @author Vidhi Dave
 */
@AndroidEntryPoint
class MemeListActivity : BaseAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MemeListViewModel by viewModels()

    private val adapter by lazy {
        MemeListAdapter(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initActionBar(resources.getString(R.string.pick_your_lucky_charm), false)
        initView()
    }

    override fun initView() {
        setupAllMemes()
        setupObservers()

        binding.recycler.setItemSelectListener(object : CarouselLayoutManager.OnSelected {
            override fun onItemSelected(position: Int) {
                //Center item
                Log.d("position", "" + position)
            }
        })

        Log.d("position", "" + binding.recycler.getSelectedPosition())
        binding.button.setOnClickListener {
            val intent = Intent(this, SuccessPageActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Calling API from viewmodel to get all data
     */
    private fun setupAllMemes() {
        viewModel.getAllMemes()
    }

    /**
     * Observer to setup all data in views
     */
    private fun setupObservers() {
        viewModel.memeList.observe(this) {
            binding.loadingProgressBar.visibility = View.GONE
            if (it.success) {
                setupRecyclerView(it.data.memes)
            } else {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.oops_something_went_wrong_msg))
                    .setNegativeButton(getString(R.string.close), null)
                    .show()
            }
        }
    }

    /**
     * Setting up recyclerview data (carousel layout)
     */
    private fun setupRecyclerView(list: List<Meme>) {
        adapter.addItems(list)
        setProperties(binding.recycler)
        setProperties(binding.recycler1)
        setProperties(binding.recycler2)
    }

    /**
     * Setting some common properties to all views
     */
    private fun setProperties(recycler: CarouselRecyclerview) {
        recycler.adapter = adapter
        recycler.setInfinite(true)
        recycler.setAlpha(true)
        recycler.set3DItem(true)
    }
}
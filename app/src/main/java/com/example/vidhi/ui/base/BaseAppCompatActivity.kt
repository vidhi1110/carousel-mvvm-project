package com.example.vidhi.ui.base

import android.annotation.SuppressLint
import android.content.*
import android.os.*
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.util.*
import com.example.vidhi.R

/**
 * Base class for ActionBarActivity with generalise methods
 *
 * @author Vidhi Dave
 */
@SuppressLint("Registered")
abstract class BaseAppCompatActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var ivHome: ImageView
    private var actionBar: ActionBar? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Locale.setDefault(Locale.US)
    }

    abstract fun initView()

    /**
     * customized actionbar
     *
     * @param title the title
     * @param isBackEnable for back click
     */

    /* SET ACTIONBAR */
    open fun initActionBar(title: String?, isBackEnable: Boolean) {
        try {
            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)
            // initialize actionbar
            actionBar = supportActionBar
            if (actionBar == null) return
            tvTitle = toolbar.findViewById(R.id.tvTitle)
            ivHome = toolbar.findViewById(R.id.ivHome)
            if (isBackEnable) {
                ivHome.setOnClickListener(View.OnClickListener {
                    onBackPressed()
                })
            } else {
                ivHome.visibility = View.GONE
            }
            if (!TextUtils.isEmpty(title)) setTitle(title!!)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun setTitle(title: CharSequence) {
        tvTitle.text = title.toString()
        super.setTitle(title)
    }
}

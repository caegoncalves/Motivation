package com.example.cae.motivation.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cae.motivation.R
import com.example.cae.motivation.mock.Mock
import com.example.cae.motivation.util.AppConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var mFilter: Int = AppConstants.PHRASE_FILTER.ALL
    private val mMock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()

        handleFilter(R.id.imageInfinity)
        refreshPhrase()
    }

    override fun onClick(view: View?) {
        val id = view!!.id

        val listId = listOf(R.id.imageInfinity, R.id.imageSun, R.id.imageHappy)

        if (id in listId) {
            handleFilter(id)
        } else {
            refreshPhrase()
        }
    }

    private fun setListeners() {

        imageInfinity.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        buttonNewPhrase.setOnClickListener(this)

    }

    private fun handleFilter(id: Int) {

        imageInfinity.setImageResource(R.drawable.ic_infinity_unselected)
        imageHappy.setImageResource(R.drawable.ic_happy_unselected)
        imageSun.setImageResource(R.drawable.ic_sun_unselected)

        if (id == R.id.imageInfinity) {
            mFilter = AppConstants.PHRASE_FILTER.ALL
            imageInfinity.setImageResource(R.drawable.ic_infinity_selected)
        } else if (id == R.id.imageSun){
            mFilter = AppConstants.PHRASE_FILTER.SUN
            imageSun.setImageResource(R.drawable.ic_sun_selected)
        } else {
            mFilter = AppConstants.PHRASE_FILTER.HAPPY
            imageHappy.setImageResource(R.drawable.ic_happy_selected)
        }

    }

    private fun refreshPhrase() {
        textPhrase.text = mMock.getPhrase(mFilter)
    }

}

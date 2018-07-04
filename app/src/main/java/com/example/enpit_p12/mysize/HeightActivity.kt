package com.example.enpit_p12.mysize

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.view.WindowId
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_height.*
import java.text.FieldPosition

class HeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)

        spinner.onItemClickListener =
                object  : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override
                    fun onItemSelected(p0: AdapterView<*>?,
                                                view: View?,
                                                position: Int,
                                                id: Long) {
                       val spinner = parent as? Spinner
                        val item = spinner?.selectedItem as? String
                        item?.let{
                            if (it.isNotEmpty())   height.text = it
                    }
                    }

                    override
                    fun onNothingSelected(p0: AdapterView<*>?) {
                    }
                }
        PreferenceManager.getDefaultSharedPreferences(this).apply{
            val heightVal = getInt("HEIGHT",160)
            height.setText(heightVal.toString())
            seekBar.progress = heightVal
        }
        seekBar.setOnSeekBarChangeListener(
                object  : SeekBar.OnSeekBarChangeListener{
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override  fun onProgressChanged(seekBar: SeekBar?,
                                                    progress: Int,
                                                    fromUser: Boolean){
                        height.text = progress.toString()
                    }
                })
        radioGroup.setOnCheckedChangeListener{
            group, checkedId ->
                height.text = findViewById<RadioButton>(checkedId).text
        }
    }
    override fun onPause() {
        super.onPause()
        PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt("HEIGHT",height.text.toString().toInt())
                .apply()
    }
}

package com.example.hw1_5mon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.CounterView
import com.Injector
import com.Presenter
import com.example.hw1_5mon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    val presenter = Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            incBtn.setOnClickListener {
                presenter.increment()
            }
            decBtn.setOnClickListener {
                presenter.decrement()
            }
            changeVisible.setOnClickListener {
                presenter.changeVisible()
            }
            clearBtn.setOnClickListener {
                presenter.clear()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.result.text = count.toString()
    }

    override fun changeVisible(isVisible: Boolean) {
        binding.result.isVisible = isVisible
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.result.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light))
    }
}
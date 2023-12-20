package com

class CounterModel {

    var count = 0
    var isVisible = true

    fun default() {
        count = 0
    }

    fun changeVisibility(isVisible: Boolean) {
        this.isVisible = isVisible
    }

    fun inc() {
        count++
    }

    fun dec() {
        count--
    }
}
package com

class Injector {
    companion object{
        fun getPresenter() = Presenter()
        fun getModel() = CounterModel()
    }
}
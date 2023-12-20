package com

class Presenter {
    private var model = Injector.getModel()
    private lateinit var view: CounterView

    fun increment() {
        model.inc()
        view.showCount(model.count)

        if (model.count == 10) {
            view.showToast("Happens")
        } else if (model.count == 15) {
            view.changeColor()
        }
    }

    fun changeVisible() {
        if (model.isVisible) {
            model.changeVisibility(false)
        } else {
            model.changeVisibility(true)
        }
        view.changeVisible(model.isVisible)
    }

    fun clear() {
        model.default()
        view.showCount(model.count)
    }

    fun decrement() {
        model.dec()
        view.showCount(model.count)
    }

    fun attachView(view: CounterView) {
        this.view = view
    }
}
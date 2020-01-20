package com.itechsofsolutions.tictactoe.ui.base.callback

import androidx.lifecycle.Lifecycle

/**
 * This is a base interface that contains callback methods for presenter
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
interface Presenter<V : MvpView> {

    /**
     * This method is called when [MvpView] object attaches to presenter
     *
     * @param mvpView the view to be attached
     */
    fun attachView(mvpView: V)

    /**
     * This method is called when [MvpView] object detaches from presenter
     */
    fun detachView()

    /**
     * This method is called when [Lifecycle] object attaches to presenter
     *
     * @param lifecycle lifecycle to be attached
     */
    fun attachLifecycle(lifecycle: Lifecycle)

    /**
     * This method is called when [Lifecycle] object detaches from presenter
     */
    fun detachLifecycle(lifecycle: Lifecycle)

    /**
     * This method is called when presenter gets created
     */
    fun onPresenterCreated()

    /**
     * This method is called when presenter gets destroyed
     */
    fun onPresenterDestroy()
}

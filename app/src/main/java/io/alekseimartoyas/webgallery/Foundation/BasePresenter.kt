package io.alekseimartoyas.tradetracker.Foundation

/**
 * Created by optim on 04.02.2018.
 */
abstract class BasePresenter<Activity, Interactor, Router> {
    abstract var interactor: Interactor?
    abstract var activity: Activity?
    abstract var router: Router?

    abstract fun destructor()
}
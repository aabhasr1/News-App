package `in`.learning.aabhasjindal.newsapp.data.rx

import io.reactivex.observers.DisposableSingleObserver

abstract class DatabaseObservable<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {
        onSuccessData(t)
    }

    override fun onError(e: Throwable) {
        onErrorData(e)
    }

    abstract fun onSuccessData(t: T)

    abstract fun onErrorData(t: Throwable)
}
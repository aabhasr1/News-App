package `in`.zipgo.aabhasjindal.newsapp.data.rx

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ObservableUtils {

    /**
     * Apply compute schedulers to observable. You should use it in [Observable.compose]
     *
     * @return Observable that runs in background thread and emits values to UI thread
     * @see .applyIoSchedulers
     * @see Observable.compose
     */
    fun <T> applyComputeSchedulers() = ObservableTransformer<T, T> { observable ->
        observable.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())

    }

    /**
     * Apply IO schedulers to observable. You should use it in [Observable.compose]
     *
     * @return Observable that runs in background thread and emits values to UI thread
     * @see .applyComputeSchedulers
     * @see Observable.compose
     */
    fun <T> applyIoSchedulers() = ObservableTransformer<T, T> { observable ->
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}

package `in`.zipgo.aabhasjindal.newsapp.ui.base

import `in`.zipgo.aabhasjindal.newsapp.data.rx.Variable
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {


    val isLoading = Variable(false)


    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }
}

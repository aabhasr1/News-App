package `in`.zipgo.aabhasjindal.newsapp.ui.base

import `in`.zipgo.aabhasjindal.newsapp.data.model.ErrorDialogData
import `in`.zipgo.aabhasjindal.newsapp.data.rx.Variable
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    var errorDialogData: Variable<ErrorDialogData> = Variable(ErrorDialogData(null, null))
}

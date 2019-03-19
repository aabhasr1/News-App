package `in`.zipgo.aabhasjindal.newsapp.ui.base

import `in`.zipgo.aabhasjindal.newsapp.data.model.ErrorDialogData
import `in`.zipgo.aabhasjindal.newsapp.ui.MainActivity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class BaseFragment : DaggerFragment() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var alertDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(getLayout(), container, false)
        initUI(view)
        attachListeners()
        return view
    }

    abstract fun getLayout(): Int

    abstract fun initUI(view: View?)

    fun setViewModel(viewModel: BaseViewModel) {
        compositeDisposable.add(viewModel.errorDialogData.observable.subscribe { str: ErrorDialogData ->
            if (str.title != null || str.message != null) {
                viewModel.errorDialogData.value = ErrorDialogData(null, null)
                showAlertError(str)
            }
        })
    }

    abstract fun attachListeners()

    fun addDisbosable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (!compositeDisposable.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    protected fun getContentActivity(): MainActivity {
        return activity as MainActivity
    }

    protected fun showAlertError(data: ErrorDialogData) {
        Timber.d("showAlertError: " + data.message + " " + data.title)
        if (alertDialog != null) {
            alertDialog!!.dismiss()
        }
        alertDialog = AlertDialog.Builder(getContentActivity()).create()
        alertDialog!!.setTitle(data.title)
        alertDialog!!.setMessage(data.message)
        alertDialog!!.setButton(
            AlertDialog.BUTTON_POSITIVE, "OK"
        ) { dialog, _ -> dialog.dismiss() }
        alertDialog!!.show()
    }
}
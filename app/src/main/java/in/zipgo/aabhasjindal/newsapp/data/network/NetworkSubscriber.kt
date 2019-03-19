package `in`.zipgo.aabhasjindal.newsapp.data.network

import `in`.zipgo.aabhasjindal.newsapp.data.model.BaseApiResponse
import `in`.zipgo.aabhasjindal.newsapp.data.model.ErrorDialogData
import `in`.zipgo.aabhasjindal.newsapp.data.model.Errors
import `in`.zipgo.aabhasjindal.newsapp.ui.base.BaseViewModel
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import org.json.JSONObject
import timber.log.Timber
import java.lang.ref.WeakReference
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class NetworkSubscriber<T>(viewModel: BaseViewModel) : DisposableObserver<BaseApiResponse>() {

    private val TAG = NetworkSubscriber::class.java.simpleName

    private val weakReference: WeakReference<BaseViewModel> = WeakReference(viewModel)

    private var showDialog = true
    private var unsetProgressBar = false


    override fun onStart() {
        super.onStart()
    }

    fun unsetDialog(): NetworkSubscriber<T> {
        this.showDialog = false
        return this
    }

    @Suppress("UNCHECKED_CAST")
    override fun onNext(apiResponse: BaseApiResponse) {
        Timber.i(apiResponse.toString())
        if (apiResponse.status!!.equals(BaseApiResponse.STATUS_ERROR) && apiResponse.errorCode != null && apiResponse.errorBody != null) {
            onServerError(apiResponse.errorCode!!)
        } else {
            onNextData(apiResponse = apiResponse as T)
        }
    }

    override fun onError(t: Throwable) {
        onErrorData(t)
        handleError(t)
    }

    override fun onComplete() {
        Timber.i("Finished")
        onFinished()
    }

    private fun handleError(e: Throwable) {
        Timber.d("Error: $e")
        val viewModel = weakReference.get()
        if (e is HttpException) {
            if (e.code() == 401) {
                viewModel!!.errorDialogData.value = (
                        ErrorDialogData(
                            "Error",
                            "Invalid Api Key"
                        )
                        )
            } else if (e.code() == 500) {
                viewModel!!.errorDialogData.value = (
                        ErrorDialogData(
                            "Server Error",
                            "Something went wrong, please try later"
                        )
                        )
            } else if (e.code() == 502) {
                viewModel!!.errorDialogData.value = (
                        ErrorDialogData(
                            "Bad Gateway",
                            "Something went wrong, please try later"
                        )
                        )
            } else {
                val responseBody = e.response().errorBody()
                Timber.d("errorBody: %s", responseBody!!.toString())
                val errors = getErrorsData(responseBody)
                if (errors == null) {
                    viewModel!!.errorDialogData.value = (ErrorDialogData("Error " + e.code(), e.response().message()))
                }
            }
        } else if (e is SocketTimeoutException) {
            viewModel!!.errorDialogData.value = (ErrorDialogData("Error", "Request timeout"))
        } else if (e is UnknownHostException) {
            //            return handleUnknownHostException(e, context);
        } else if (e is ErrorCodeReturnedException) {
            //            return handleLibraryHttpClientError((ErrorCodeReturnedException) e, context);
        } else if (e is BaseError) {
            //            return handleBaseError(e, context);
        }
    }

    abstract fun onNextData(apiResponse: T)

    abstract fun onErrorData(t: Throwable)

    abstract fun onServerError(string: String)

    abstract fun onFinished()


    private fun getErrorsData(responseBody: ResponseBody): Errors? {
        try {
            val jsonObject = JSONObject(responseBody.string())
            val errorsString = jsonObject.getString("errors") ?: return null
            val gson = Gson()
            return gson.fromJson<Errors>(errorsString, Errors::class.java)
        } catch (e: Exception) {
            return null//e.getMessage();
        }

    }

}

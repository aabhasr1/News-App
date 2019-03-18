package `in`.zipgo.aabhasjindal.newsapp.ui.base

import `in`.zipgo.aabhasjindal.newsapp.data.model.ErrorDialogData
import `in`.zipgo.aabhasjindal.newsapp.data.model.ErrorMessage
import `in`.zipgo.aabhasjindal.newsapp.ui.base.BaseViewModel
import `in`.zipgo.aabhasjindal.newsapp.data.rx.Variable

open class DaggerViewModel : BaseViewModel() {

    //    var transition: Variable<FragmentData> = Variable(FragmentData(EMPTY_FRAGMENT))
    var clearBackStack: Variable<Boolean> = Variable(false)
    var activeRequest: Variable<Boolean> = Variable(false)
    var errorDialogData: Variable<ErrorDialogData> = Variable(ErrorDialogData(null, null))

    fun onBackClick() {
//        transition.setValue(FragmentData(BACK_FRAGMENT))
    }

    @Suppress("UNUSED_PARAMETER")
    fun highlightErrorFields(messages: List<ErrorMessage>): Boolean {
        return false
    }

    fun parseData() {
//        transition.setValue(FragmentData(EMPTY_FRAGMENT))
//        clearBackStack.setValue(false)
//        errorDialogData.setValue(ErrorDialogData(null, null))
    }

}
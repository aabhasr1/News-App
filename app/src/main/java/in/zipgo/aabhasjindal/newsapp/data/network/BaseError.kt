package `in`.zipgo.aabhasjindal.newsapp.data.network

class BaseError : RuntimeException {

    constructor() {}

    constructor(detailMessage: String) : super(detailMessage) {}

    constructor(detailMessage: String, throwable: Throwable) : super(detailMessage, throwable) {}

    constructor(throwable: Throwable) : super(throwable) {}


}

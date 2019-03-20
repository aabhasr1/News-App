package `in`.learning.aabhasjindal.newsapp.data.rx

import io.reactivex.subjects.BehaviorSubject

class Variable<T>(defaultValue: T) {

    var value: T = defaultValue
        set(newValue) {
            field = newValue
            observable.onNext(value)
            observable.onNext(value)
        }

    var observable: BehaviorSubject<T> = BehaviorSubject.createDefault(value)
}
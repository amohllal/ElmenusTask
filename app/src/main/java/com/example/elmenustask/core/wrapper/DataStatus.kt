package com.example.elmenustask.core.wrapper

import kotlinx.coroutines.delay


class DataStatus<T> {

    var status: Status? = null

    var data: T? = null

    var error: Throwable? = null

    suspend fun postLoading(isLoading: Boolean): DataStatus<T> {
        status = if (isLoading){
            Status.SHOW_LOADING
        } else {
            delay(100)
            Status.HIDE_LOADING
        }
        data = null
        error = null
        return this
    }

    fun success(data: T): DataStatus<T> {
        status = Status.SUCCESS
        this.data = data
        error = null
        return this
    }

    fun error(error: Throwable?): DataStatus<T> {
        status = Status.ERROR
        data = null
        this.error = error
        return this
    }


    enum class Status {
        SUCCESS, ERROR, SHOW_LOADING, HIDE_LOADING
    }


}
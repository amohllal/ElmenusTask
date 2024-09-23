package com.example.elmenustask.core.wrapper

class StateLiveData<T> : SingleLiveEvent<DataStatus<T>?>() {

    suspend fun postLoading(isLoading: Boolean) {
        postValue(DataStatus<T>().postLoading(isLoading))
    }

    fun postSuccess(data: T) {
        postValue(DataStatus<T>().success(data))
    }

    fun postError(throwable: Throwable?) {
        postValue(DataStatus<T>().error(throwable))
    }


}
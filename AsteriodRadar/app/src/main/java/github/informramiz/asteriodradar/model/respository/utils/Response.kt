package github.informramiz.asteriodradar.model.respository.utils

/**
 * Created by Ramiz Raja on 19/04/2020
 */
enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

sealed class Response<T> {
    class LoadingResponse<T> : Response<T>()
    class SuccessResponse<T>(val data: T?): Response<T>()
    class ErrorResponse<T>(val errorMsg: String?): Response<T>()
}


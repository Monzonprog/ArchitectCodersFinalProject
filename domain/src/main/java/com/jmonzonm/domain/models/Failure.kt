package com.jmonzonm.domain.models

sealed interface Failure {
    class ServerFailure(val code: Int) : Failure
    class UnknownFailure(val message: String) : Failure
    object ConnectivityFailure : Failure
}
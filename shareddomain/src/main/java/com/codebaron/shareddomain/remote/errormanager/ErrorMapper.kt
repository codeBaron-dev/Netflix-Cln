package com.codebaron.shareddomain.remote.errormanager

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */

/**
 * this class works like an interpreter, it receives the [ErrorBody] returned from
 * from a network request and maps it to a data class [ErrorModel] which then makes
 * it readable and accessible for both developer and user
 */
class ErrorMapper {

    companion object {
        private var retrofit: Retrofit? = null
    }
    fun parseErrorMessage(response: ResponseBody?): ErrorModel? {
        val converter: Converter<ResponseBody, ErrorModel>? =
            retrofit()
                ?.responseBodyConverter(ErrorModel::class.java, arrayOfNulls<Annotation>(0))
        return response?.let { converter?.convert(it) }
    }

    private fun retrofit(): Retrofit? {
        return retrofit
    }
}
package ir.si.app.oskar.api

import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import java.io.IOException
import java.nio.charset.Charset


class HeaderInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        val requestBuilder = request.newBuilder()

        requestBuilder.addHeader("Connection", "keep-alive")
        requestBuilder.addHeader("application-id", "1")
        requestBuilder.addHeader("Pragma", "no-cache")
        requestBuilder.addHeader("Cache-Control", "no-cache")
        requestBuilder.addHeader("Accept","application/json; version=1.0")
        requestBuilder.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36")
//        requestBuilder.addHeader("Accept-Language", "en-US,en;q=0.9")
//        if (!prefs.accessToken.isNullOrBlank())
            requestBuilder.addHeader("Authorization", "Bearer ${"ory_pat_48x42U07zDYtp4Clb990UZ8WjuuBHMXZ"}")

        request = requestBuilder.build()




        return chain.proceed(request)
    }

    private fun bodyToString(request: RequestBody?): String? {
        return try {
            val buffer = Buffer()
            request?.writeTo(buffer) ?: return ""
            buffer.readUtf8()
        } catch (e: IOException) {
            "did not work"
        }
    }

    private fun responseToString(responseBody: ResponseBody?): String? {
        val source = responseBody?.source()
        source?.request(Long.MAX_VALUE)
        val buffer = source?.buffer()
        return buffer?.clone()?.readString(Charset.forName("UTF-8"))

    }
}

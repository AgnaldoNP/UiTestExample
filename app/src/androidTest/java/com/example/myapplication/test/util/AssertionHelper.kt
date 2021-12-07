package com.example.myapplication.test.util

const val ATTEMPTS = 20
const val WAIT_BEFORE_NEXT_ATTEMPT = 500L

inline fun runAssert(block: () -> Unit) {
    for (i in 0 until ATTEMPTS - 1) {
        try {
            block.invoke()
            return
        } catch (e: Exception) {
            Thread.sleep(WAIT_BEFORE_NEXT_ATTEMPT)
            e.printStackTrace()
        } catch (e: Error) {
            Thread.sleep(WAIT_BEFORE_NEXT_ATTEMPT)
            e.printStackTrace()
        }
    }
    block.invoke()
}

package com.example.myapplication.test

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions
import java.io.File

@CucumberOptions(
    glue = ["com.example.myapplication.test.steps"],
    tags = ["~@skip"],
    features = ["features"]
)
class InstrumentationTest : CucumberAndroidJUnitRunner() {

    override fun onCreate(bundle: Bundle?) {
        bundle?.putString("plugin", getPluginConfigurationString())
        File(getAbsoluteFilesPath()).let {
            it.mkdirs()
            Log.d("ANP", it.absolutePath)
        }
        super.onCreate(bundle)
    }

    private fun getPluginConfigurationString(): String? {
        val cucumber = "cucumber"
        val separator = "--"
        return "pretty" + separator +
            "junit:" + getCucumberXml(cucumber) + separator +
            "html:" + getCucumberHtml(cucumber) + separator +
            "json:" + getCucumberJson(cucumber)
    }

    private fun getCucumberJson(cucumber: String): String {
        return getAbsoluteFilesPath() + "/" + cucumber + ".json"
    }

    private fun getCucumberHtml(cucumber: String): String {
        return getAbsoluteFilesPath() + "/" + cucumber + ".html"
    }

    private fun getCucumberXml(cucumber: String): String {
        return getAbsoluteFilesPath() + "/" + cucumber + ".xml"
    }

    private fun getAbsoluteFilesPath(): String {
        val directory = targetContext.getExternalFilesDir(null)
        return File(directory, "reports").absolutePath
    }

    @Throws(
        ClassNotFoundException::class,
        IllegalAccessException::class,
        InstantiationException::class
    )
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application? {
        return super.newApplication(cl, MyApplicationTest::class.java.name, context)
    }
}

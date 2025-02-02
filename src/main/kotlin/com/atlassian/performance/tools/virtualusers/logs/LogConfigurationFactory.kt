package com.atlassian.performance.tools.virtualusers.logs

import org.apache.logging.log4j.core.LoggerContext
import org.apache.logging.log4j.core.config.AbstractConfiguration
import org.apache.logging.log4j.core.config.Configuration
import org.apache.logging.log4j.core.config.ConfigurationFactory
import org.apache.logging.log4j.core.config.ConfigurationSource
import java.net.URI


internal class LogConfigurationFactory(
    private val logConfig: AbstractConfiguration
) : ConfigurationFactory() {
    override fun getConfiguration(loggerContext: LoggerContext?, name: String, configLocation: URI?): Configuration {
        return createConfiguration()
    }

    override fun getConfiguration(loggerContext: LoggerContext?, name: String, configLocation: URI?, loader: ClassLoader?): Configuration {
        return getConfiguration(loggerContext, name, null);
    }

    override fun getConfiguration(loggerContext: LoggerContext?, source: ConfigurationSource?): Configuration {
        return getConfiguration(loggerContext, source.toString(), null)
    }

    override fun getSupportedTypes(): Array<String> {
        return arrayOf("*")
    }

    private fun createConfiguration(): Configuration = logConfig
}

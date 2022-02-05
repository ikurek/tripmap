package com.tripmap.plugins.database

data class DatabaseEnvironment(
    val url: String,
    val driver: String,
    val username: String,
    val password: String
) {
    companion object {
        private const val DATABASE_URL = "DATABASE_URL"
        private const val DATABASE_DRIVER = "DATABASE_DRIVER"
        private const val DATABASE_USERNAME = "DATABASE_USERNAME"
        private const val DATABASE_PASSWORD = "DATABASE_PASSWORD"

        fun readEnvironment() = DatabaseEnvironment(
            url = System.getenv(DATABASE_URL),
            driver = System.getenv(DATABASE_DRIVER),
            username = System.getenv(DATABASE_USERNAME),
            password = System.getenv(DATABASE_PASSWORD)
        )
    }
}
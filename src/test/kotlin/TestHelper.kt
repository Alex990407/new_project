fun clearTable(name: String) {
    connectToDatabase()?.use { connection ->
        connection.createStatement().execute(
            "DELETE FROM $name"
        )
    }
}

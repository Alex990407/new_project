import connectToDatabase

fun createUsersTable(tableName: String) {
    val connection = connectToDatabase()
    connection?.use {
        val query = """
              CREATE TABLE IF NOT EXISTS $tableName (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100),
                email VARCHAR(100),
                phone_number VARCHAR(15)
            );
        """
        val statement = connection.createStatement()
        statement.executeUpdate(query)
        println("Table ''$tableName' created successfully.")
    }
}


fun insertUser(name: String, email: String, phoneNumber: String) {
    val connection = connectToDatabase()
    connection?.use {
        val query = "INSERT INTO users (name, email, phone_number) VALUES (?, ?, ?)"
        val preparedStatement = connection.prepareStatement(query)
        preparedStatement.setString(1, name)
        preparedStatement.setString(2, email)
        preparedStatement.setString(3, phoneNumber)
        preparedStatement.executeUpdate()
        println("User inserted successfully")
    }
}


fun insertCustomer(name: String, email: String, phoneNumber: String) {
    val connection = connectToDatabase()
    connection?.use {
        val query = "INSERT INTO customers (name, email, phone_number) VALUES (?, ?, ?)"
        val preparedStatement = connection.prepareStatement(query)
        preparedStatement.setString(1, name)
        preparedStatement.setString(2, email)
        preparedStatement.setString(3, phoneNumber)
        preparedStatement.executeUpdate()
        println("User inserted successfully")
    }
}

fun getCustomers(){
    val connection = connectToDatabase()
    val customers = connection?.use {
        val query = "SELECT * FROM customers"
        connection.prepareStatement(query).executeQuery()
        val
    }
}
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

data class Customer(
    val id: Int,
    val name: String,
    val email: String,
    val phoneNumber: String,
)

fun getCustomers(): List<Customer> {
    val customers = mutableListOf<Customer>()

    connectToDatabase()?.use { connection ->
        val query = "SELECT id, name, email, phone_number FROM customers"
        val result = connection.createStatement().executeQuery(query)

        while (result.next()) {
            val customer = Customer(
                id = result.getInt("id"),
                name = result.getString("name"),
                email = result.getString("email"),
                phoneNumber = result.getString("phone_number"),
            )

            customers.add(customer)
        }
    }

    return customers
}

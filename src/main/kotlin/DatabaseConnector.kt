import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun connectToDatabase(): Connection? {
    val url = "jdbc:mysql://localhost:3306/hood_test_db"
    val user = "root"
    val password = "194d06919cc81b6c26418bfcc01805ca"

    return try {
        DriverManager.getConnection(url, user, password)
    } catch (e: SQLException) {
        e.printStackTrace()
        null
    }
}

fun main() {
    val connection = connectToDatabase()
    if (connection != null) {
        println("Connection successful!")

    } else {
        println("Connection failed!")
    }
}

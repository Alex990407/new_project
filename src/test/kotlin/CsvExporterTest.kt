import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import kotlin.test.assertEquals

class CsvExporterTest {

    @BeforeEach
    fun setUp() {

        clearTable("users")
        clearTable("customers")


        insertUser("Test User", "test@example.com", "123456789")
        insertCustomer("Test Customer", "customer@example.com", "987654321")


        exportUsersToCSV("csv_exports/users.csv")
        exportCustomersToCSV("csv_exports/customers.csv")
    }

    @Test
    fun `test users in database match users in CSV`() {
        val usersFromDb = getUsers()
        val usersFromCsv = readUsersFromCSV("csv_exports/users.csv")

        assertEquals(usersFromDb.size, usersFromCsv.size, "The number of records does not match!")

        for (i in usersFromDb.indices) {
            assertEquals(usersFromDb[i].name, usersFromCsv[i].name, "Username does not match")
            assertEquals(usersFromDb[i].email, usersFromCsv[i].email, "Email does not match")
            assertEquals(usersFromDb[i].phoneNumber, usersFromCsv[i].phoneNumber, "Phonenumbers does not match")
        }
    }

    @Test
    fun `test customers in database match customers in CSV`() {
        val customersFromDb = getCustomers()
        val customersFromCsv = readCustomersFromCSV("csv_exports/customers.csv")

        assertEquals(customersFromDb.size, customersFromCsv.size, "The number of records does not match!")

        for (i in customersFromDb.indices) {
            assertEquals(customersFromDb[i].name, customersFromCsv[i].name, "Username does not match")
            assertEquals(customersFromDb[i].email, customersFromCsv[i].email, "Email does not match")
            assertEquals(customersFromDb[i].phoneNumber, customersFromCsv[i].phoneNumber, "Phonenumbers does not match")
        }
    }


    private fun readUsersFromCSV(filePath: String): List<User> {
        val users = mutableListOf<User>()
        val file = File(filePath)

        if (!file.exists()) error("File $filePath not found!")

        file.reader().use { reader ->
            val csvParser = CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())
            for (record in csvParser) {
                users.add(
                    User(
                        id = -1,
                        name = record.get("Name"),
                        email = record.get("Email"),
                        phoneNumber = record.get("Phone")
                    )
                )
            }
        }
        return users
    }

    private fun readCustomersFromCSV(filePath: String): List<Customer> {
        val customers = mutableListOf<Customer>()
        val file = File(filePath)

        if (!file.exists()) error("File $filePath not found!")

        file.reader().use { reader ->
            val csvParser = CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())
            for (record in csvParser) {
                customers.add(
                    Customer(
                        id = -1,
                        name = record.get("Name"),
                        email = record.get("Email"),
                        phoneNumber = record.get("Phone")
                    )
                )
            }
        }
        return customers
    }
}

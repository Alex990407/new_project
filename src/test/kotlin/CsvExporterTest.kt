import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.junit.jupiter.api.AfterEach
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.deleteExisting
import kotlin.test.assertEquals

class CsvExporterTest {
    private val outputDir = "src/test/tmp"

    @BeforeEach
    fun setUp() {
        clearTable("users")
        clearTable("customers")

        insertUser("Test User", "test@example.com", "123456789")
        insertCustomer("Test Customer", "customer@example.com", "987654321")
    }

    @AfterEach
    fun tearDown() {
        Files.deleteIfExists(Path("$outputDir/users.csv"))
        Files.deleteIfExists(Path("$outputDir/customers.csv"))
    }

    @Test
    fun `test users in database match users in CSV`() {
        exportUsersToCSV("$outputDir/users.csv")

        val usersFromCsv = readUsersFromCSV("$outputDir/users.csv")
        assertEquals(1, usersFromCsv.size, "The number of records does not match!")

        assertEquals("Test User", usersFromCsv[0].name, "Username does not match")
        assertEquals("test@example.com", usersFromCsv[0].email, "Email does not match")
        assertEquals("123456789", usersFromCsv[0].phoneNumber, "Phonenumbers does not match")
    }

    @Test
    fun `test customers in database match customers in CSV`() {
        exportCustomersToCSV("$outputDir/customers.csv")

        val customersFromCsv = readCustomersFromCSV("$outputDir/customers.csv")

        assertEquals(1, customersFromCsv.size, "The number of records does not match!")

        assertEquals("Test Customer", customersFromCsv[0].name, "Username does not match")
        assertEquals("customer@example.com", customersFromCsv[0].email, "Email does not match")
        assertEquals("987654321", customersFromCsv[0].phoneNumber, "Phonenumbers does not match")
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

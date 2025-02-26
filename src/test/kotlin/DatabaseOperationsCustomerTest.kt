import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DatabaseOperationsCustomerTest {
    @BeforeEach
    fun setUp() {
        println(">>> setup")
    }

    @AfterEach
    fun tearDown() {
        println(">>> tearDown")
        clearTable("customers")
    }

    @Test
    fun `test insertCustomer inserts customer into the database`() {
        println(">>> test")

        insertCustomer("Testuser 1", "usyk.aleksandr.@example.com", "77710777")
        insertCustomer("Testuser 2", "usyk.aleksandr.@example.com", "77710777")

        val customers = getCustomers()
        assertEquals(2, customers.size)

        val customer1 = getCustomers()[0]
        assertEquals("Testuser 1", customer1.name)

        val customer2 = getCustomers()[1]
        assertEquals("Testuser 2", customer2.name)
    }
}

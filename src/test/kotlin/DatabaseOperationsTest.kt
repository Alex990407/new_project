import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DatabaseOperationsTest {

    @BeforeEach
    fun setUp() {
        println(">>> setup")
        clearTable("users")
    }

    @AfterEach
    fun tearDown() {
        println(">>> tearDown")
        clearTable("users")
    }

    @Test
    fun `test insertUser inserts user into the database`() {

        println(">>> test")

        insertUser("Aleksandr Pistoletov", "pistolet.@example.com", "777999777999")

        val users = getUsers()
        assertEquals(1, users.size)

        val user = users[0]
        assertEquals("Aleksandr Pistoletov", user.name)
        assertEquals("pistolet.@example.com", user.email)
        assertEquals("777999777999", user.phoneNumber)
    }
}

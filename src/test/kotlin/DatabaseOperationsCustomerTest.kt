import io.mockk.*
import org.junit.jupiter.api.Test
import java.sql.Connection
import java.sql.PreparedStatement

class DatabaseOperationsCustomerTest {

    @Test
    fun `test insertCustomer inserts customer into the database`() {

        insertCustomer("Aleksandr Usyk", "usyk.aleksandr.@example.com", "77710777")

        insertCustomer()
    }
}

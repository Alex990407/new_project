import io.mockk.*
import org.junit.jupiter.api.Test
import java.sql.Connection
import java.sql.PreparedStatement

class DatabaseOperationsTest {

    @Test
    fun `test insertUser inserts user into the database`() {


        insertUser("Aleksandr Usyk", "usyk.aleksandr.@example.com", "77710777")



    }
}

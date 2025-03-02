import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import java.io.File
import java.io.FileWriter

fun exportUsersToCSV(filePath: String) {
    val users = getUsers()

    FileWriter(filePath).use { writer ->
        CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("ID", "Name", "Email", "Phone")).use { csvPrinter ->
            for (user in users) {
                csvPrinter.printRecord(user.id, user.name, user.email, user.phoneNumber)
            }
            println("CSV file successfully created: $filePath")
        }
    }
}

fun exportCustomersToCSV(filePath: String) {
    val customers = getCustomers()

    FileWriter(filePath).use { writer ->
        CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("ID", "Name", "Email", "Phone")).use { csvPrinter ->
            for (customer in customers) {
                csvPrinter.printRecord(customer.id, customer.name, customer.email, customer.phoneNumber)
            }
            println("CSV file successfully created: $filePath")
        }
    }
}

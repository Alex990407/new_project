package org.example

import createUsersTable
import insertUser
import insertCustomer
import exportUsersToCSV
import exportCustomersToCSV
import java.io.File

fun main() {
    println("Hello World!")

    val exportDir = File("csv_exports")
    if (!exportDir.exists()) {
        exportDir.mkdir()
        println("Directory 'csv_exports' created.")
    }

    // createUsersTable("users")
    insertUser("Alice Johnson", "alice.johnson@example.com", "55512345")
    insertCustomer("Jane Smith", "jane.smith@example.com", "987654321")

    println("Data added to the database.")

    exportUsersToCSV("csv_exports/users.csv")
    exportCustomersToCSV("csv_exports/customers.csv")

    println("Export completed! Files 'users.csv' and 'customers.csv' created.")
}
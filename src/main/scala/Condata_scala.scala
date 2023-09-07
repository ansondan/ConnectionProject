import java.sql.{Connection, DriverManager}
object Condata_scala {
  def main(args: Array[String]): Unit = {
    // Database connection properties
    val url = "jdbc:mysql://localhost:3306/Personal"
    val username = "Daniel"
    val password = "D#song81"

    // Load the MySQL JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver")

    // Create a connection to the database
    val connection: Connection = DriverManager.getConnection(url, username, password)

    try {
      // Create a statement
      val statement = connection.createStatement()

      // Execute a query
      val query = "SELECT book_id, title, author_id FROM Books;"
      val resultSet = statement.executeQuery(query)

      // Process the query results
      while (resultSet.next()) {
        val column1 = resultSet.getString("book_id")
        val column2 = resultSet.getString("title")
        val column3 = resultSet.getInt("author_id")
        // Add more columns as needed

        // Do something with the retrieved data (e.g., print it)
        println(s"$column1 $column2 $column3")

        // Your database operations here
        // For example, you can execute SQL queries using this connection
      }
    }finally {
      // Close the connection when done
      connection.close()
    }

  }

}

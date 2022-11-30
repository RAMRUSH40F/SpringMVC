package mainPackage.dao;

import mainPackage.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS -Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

/**
 * Data access object.
 * Contains data itself for now.
 */
@Component
public class PersonDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/SpringMvcDb";
    private static final String PASSWORD = "lolaV123";
    private static final String USERNAME = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void save(Person person) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Person VALUES (1,?,?,?)");

            // Защита от инъекции.  PreparedStatmnt быстрее и надежднее.
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT *FROM PERSON";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge((byte) resultSet.getInt("age"));

                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        Person person = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next(); // Указатель на первую строку Бд

            person = new Person();
            // Составляем запросы
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setId(resultSet.getInt("id"));
            person.setAge((byte) resultSet.getInt("age"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");

            preparedStatement.setString(1,updatedPerson.getName());
            preparedStatement.setInt(2,updatedPerson.getAge());
            preparedStatement.setString(3,updatedPerson.getEmail());
            preparedStatement.setInt(4,updatedPerson.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM  Person WHERE id=?");

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

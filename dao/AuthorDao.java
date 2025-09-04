package Patika_8_Week.Library.dao;

import Patika_8_Week.Library.Model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AuthorDao {

    private final Connection connection;

    public AuthorDao(Connection connection) {
        this.connection = connection;
    }

    public void save(Author author) {
        String sql = """
                INSERT INTO authors(name) VALUES (?)
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getName());
            preparedStatement.executeUpdate();
            System.out.println(" Author Tablosuna Kayıt Edildi. ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveAll(List<Author> authors) {
        authors.forEach(this::save);
    }

}

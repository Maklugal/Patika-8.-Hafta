package Patika_8_Week.Library.dao;

import Patika_8_Week.Library.Model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {

    private final Connection connection;

    public MemberDao(Connection connection) {
        this.connection = connection;

    }

    public void save(Member member) {
        String sql = """
                INSERT INTO public.members(name) VALUES (?)
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getName());
            preparedStatement.executeUpdate();
            System.out.println(" Member Tablosuna Kayıt Edildi. ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveAll(List<Member> members) {
        members.forEach(this::save);
    }
}

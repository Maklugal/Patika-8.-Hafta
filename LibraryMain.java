package Patika_8_Week.Library;


import Patika_8_Week.Library.Model.Author;
import Patika_8_Week.Library.Model.Book;
import Patika_8_Week.Library.Model.Borrow;
import Patika_8_Week.Library.Model.Member;
import Patika_8_Week.Library.dao.AuthorDao;
import Patika_8_Week.Library.dao.BookDao;
import Patika_8_Week.Library.dao.BorrowDao;
import Patika_8_Week.Library.dao.MemberDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class LibraryMain {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/library";
        String user = "postgres";
        String password = "123456";


        try (Connection connection = DriverManager.getConnection(url, "postgres", "123456")) {
            System.out.println(" DB bağlantı gerçekleştirildi !");

            Member member = new Member(1, " Mehmet ");
            Member member1 = new Member(2, " Aslan ");
            Member member2 = new Member(3, " Özlem ");

            MemberDao memberDao = new MemberDao(connection);
            memberDao.save(member);
            memberDao.saveAll(List.of(member1, member2));


            Author author = new Author(1, "MAK");
            AuthorDao authorDao = new AuthorDao(connection);
            authorDao.save(author);

            Book book = new Book(1, "Java", author);
            Book book1 = new Book(2, "Öğreniyorum", author);
            Book book2 = new Book(3, "Deneysel", author);

            BookDao bookDao = new BookDao(connection);
            bookDao.saveAll(List.of(book, book1, book2));


            BorrowDao borrowDao = new BorrowDao(connection);
            borrowDao.saveAll(List.of(
                    new Borrow(member, book),
                    new Borrow(member1, book1),
                    new Borrow(member2, book2)
            ));

            borrowDao = new BorrowDao(connection);
            List<Borrow> borrows = borrowDao.getBorrowsByMemberId(member.getId());
            List<Borrow> borrows1 = borrowDao.getBorrowsByMemberId(member1.getId());
            List<Borrow> borrows2 = borrowDao.getBorrowsByMemberId(member2.getId());

            for (Borrow borrow : borrows) {
                System.out.printf("Kitap: %s | Yazar: %s | Ödünç alınma tarihi: %s%n",
                        borrow.getBook().getTitle(),
                        borrow.getBook().getAuthor().getName(),
                        borrow.getBorrowDate()
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

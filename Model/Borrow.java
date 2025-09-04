package Patika_8_Week.Library.Model;

import java.time.LocalDate;

public class Borrow {
    private Integer id;
    private Member member;
    private Book book;
    private LocalDate borrowDate;

    public Borrow(Integer id, Member member, Book book, LocalDate borrowDate) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public Borrow(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.borrowDate = LocalDate.now();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", member=" + member +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                '}';
    }
}

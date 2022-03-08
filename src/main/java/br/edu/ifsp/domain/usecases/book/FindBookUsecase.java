package br.edu.ifsp.domain.usecases.book;

import br.edu.ifsp.domain.entities.book.Book;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.List;
import java.util.Optional;

public class FindBookUsecase {
    private BookDAO bookDAO;

    public FindBookUsecase(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Optional<Book> findOne(Integer id){
        if(id == null){
            throw new IllegalArgumentException("ID can not be null");
        }
        return bookDAO.findOne(id);
    }

    public Optional<Book> findOneByIsbn(String isbn){
        if(Validator.nullOrEmpty(isbn))
            throw new IllegalArgumentException("ISBN can not be null or empty");
        return bookDAO.findByIsbn(isbn);
    }

    public List<Book> findAll(){
        return bookDAO.findAll();
    }

}

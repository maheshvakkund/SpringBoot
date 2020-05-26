package com.mahesh.spring5web.repositories;

import com.mahesh.spring5web.model.Author;
import com.mahesh.spring5web.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepsitory   extends CrudRepository<Book, Long> {
}

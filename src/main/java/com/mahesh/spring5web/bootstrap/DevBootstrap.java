package com.mahesh.spring5web.bootstrap;

import com.mahesh.spring5web.model.Author;
import com.mahesh.spring5web.model.Book;
import com.mahesh.spring5web.model.Publisher;
import com.mahesh.spring5web.repositories.AuthorRepository;
import com.mahesh.spring5web.repositories.BookRepsitory;
import com.mahesh.spring5web.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepsitory bookRepsitory;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,BookRepsitory bookRepsitory,PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepsitory=bookRepsitory;
        this.publisherRepository=publisherRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
        Publisher p =new Publisher();
        p.setName("Mahesh");
        p.setAddress("belgaum");
        publisherRepository.save(p);

        Author mahesh = new Author("mahesh","vakkund");
        Book b=new Book("Domain Driven Design","123",p);
        mahesh.getBooks().add(b);
        b.getAuthors().add(mahesh);

        authorRepository.save(mahesh);
        bookRepsitory.save(b);

        Author shamanth = new Author("shamanth","prabhu");
        Book c=new Book("Domain Driven Design 3","133",p);
        shamanth.getBooks().add(c);
        authorRepository.save(shamanth);
        bookRepsitory.save(c);

    }
}

package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
     Author avi = new Author("Avi","Kaushik");
     Book livingLife = new Book("Living your life", "12121");
     avi.getBooks().add(livingLife);
     livingLife.getAuthor().add(avi);

     authorRepository.save(avi);
     bookRepository.save(livingLife);

     Author sparsh = new Author("Sparsh","Verma");
     Book design = new Book("Design is an art","121212");
     sparsh.getBooks().add(design);
     design.getAuthor().add(sparsh);

     Publisher publisher = new Publisher("Avi Arts","CP Delhi","Delhi","NDLS","1212");
//     publisher.getBooks().add(design);
     publisherRepository.save(publisher);


     authorRepository.save(sparsh);
     bookRepository.save(design);

     System.out.println("Started in springBoot");
     System.out.println("Number of books "+ bookRepository.count());
     System.out.println(publisherRepository.count());






    }
}

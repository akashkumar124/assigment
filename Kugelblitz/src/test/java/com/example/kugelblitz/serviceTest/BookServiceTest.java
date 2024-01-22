//package com.example.kugelblitz.serviceTest;
//
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.example.kugelblitz.Repo.BookRepo;
//import com.example.kugelblitz.entity.Book;
//import com.example.kugelblitz.service.BookService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class BookServiceTest {
//
//    @Mock
//    private BookRepo bookRepository;
//
//    @InjectMocks
//    private BookService bookService;
//
//    private Book testBook;
//
//    @Before
//    public void setUp() {
//        testBook = new Book();
//        testBook.setId(1L);
//        testBook.setTitle("Test Book");
//        testBook.setIsbn("1234567890");
//        testBook.setQuantity(10);
//
//        // Set up mock behavior
//        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));
//        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
//        when(bookRepository.save(any(Book.class))).thenReturn(testBook);
//    }
//
//    @Test
//    public void testGetAllBooks() {
//        List<Book> books = bookService.getAllBooks();
//        verify(bookRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void testGetBookById() {
//        Book result = bookService.getBookById(1L);
//        verify(bookRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    public void testCreateBook() {
//        Book newBook = new Book();
//        newBook.setTitle("New Book");
//        newBook.setIsbn("9876543210");
//        newBook.setQuantity(5);
//
//        Book createdBook = bookService.createBook(newBook);
//        verify(bookRepository, times(1)).save(any(Book.class));
//    }
//
//    @Test
//    public void testUpdateBook() {
//        Book updatedBook = new Book();
//        updatedBook.setTitle("Updated Book");
//        updatedBook.setIsbn("1112223334");
//        updatedBook.setQuantity(15);
//
//        bookService.updateBook(1L, updatedBook);
//        verify(bookRepository, times(1)).findById(1L);
//        verify(bookRepository, times(1)).save(any(Book.class));
//    }
//
//    @Test
//    public void testDeleteBook() {
//        bookService.deleteBook(1L);
//        verify(bookRepository, times(1)).findById(1L);
//        verify(bookRepository, times(1)).delete(any(Book.class));
//    }
//}

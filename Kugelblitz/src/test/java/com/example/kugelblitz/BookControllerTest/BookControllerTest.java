//package com.example.kugelblitz.BookControllerTest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(BookController.class)
//public class BookControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BookService bookService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testGetAllBooks() throws Exception {
//        List<Book> books = new ArrayList<>();
//        when(bookService.getAllBooks()).thenReturn(books);
//
//        ResultActions result = mockMvc.perform(get("/api/books"));
//
//        result.andExpect(status().isOk())
//              .andExpect(content().json("[]"));
//
//        verify(bookService, times(1)).getAllBooks();
//    }
//
//    @Test
//    public void testGetBookById() throws Exception {
//        Book testBook = new Book();
//        testBook.setId(1L);
//        testBook.setTitle("Test Book");
//
//        when(bookService.getBookById(1L)).thenReturn(testBook);
//
//        ResultActions result = mockMvc.perform(get("/api/books/1"));
//
//        result.andExpect(status().isOk())
//              .andExpect(content().json("{\"id\":1,\"title\":\"Test Book\",\"isbn\":null,\"quantity\":0,\"author\":null}"));
//
//        verify(bookService, times(1)).getBookById(1L);
//    }
//
//    @Test
//    public void testCreateBook() throws Exception {
//        Book newBook = new Book();
//        newBook.setTitle("New Book");
//
//        when(bookService.createBook(any(Book.class))).thenReturn(newBook);
//
//        ResultActions result = mockMvc.perform(post("/api/books")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(newBook)));
//
//        result.andExpect(status().isCreated())
//              .andExpect(content().json("{\"id\":null,\"title\":\"New Book\",\"isbn\":null,\"quantity\":0,\"author\":null}"));
//
//        verify(bookService, times(1)).createBook(any(Book.class));
//    }
//
//    @Test
//    public void testUpdateBook() throws Exception {
//        Book updatedBook = new Book();
//        updatedBook.setTitle("Updated Book");
//
//        when(bookService.updateBook(eq(1L), any(Book.class))).thenReturn(updatedBook);
//
//        ResultActions result = mockMvc.perform(put("/api/books/1")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(updatedBook)));
//
//        result.andExpect(status().isOk())
//              .andExpect(content().json("{\"id\":null,\"title\":\"Updated Book\",\"isbn\":null,\"quantity\":0,\"author\":null}"));
//
//        verify(bookService, times(1)).updateBook(eq(1L), any(Book.class));
//    }
//
//    @Test
//    public void testDeleteBook() throws Exception {
//        ResultActions result = mockMvc.perform(delete("/api/books/1"));
//
//        result.andExpect(status().isNoContent());
//
//        verify(bookService, times(1)).deleteBook(1L);
//    }
//}
//

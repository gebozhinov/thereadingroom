package bg.thereadingroom.integration.web;

import bg.thereadingroom.integration.IntegrationTestInit;
import bg.thereadingroom.model.db.BookEntity;
import bg.thereadingroom.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookControllerIntegrationTest extends IntegrationTestInit {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        cleanDatabase();
    }

    @Test
    public void testAddBook() throws Exception {
        insertDatabase("save_book.sql");

        BookEntity book = new BookEntity();
        book.setAuthor("Kent Beck");
        book.setTitle("Test-Driven Development By Example");
        book.setDescription("Clean code that works");
        book.setPrice(BigDecimal.valueOf(10.99));
        book.setStock(10);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated());

        List<BookEntity> all = bookRepository.findAll();

        assertThat(all.size()).isEqualTo(4);
    }
}

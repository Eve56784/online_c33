package project.springproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import project.springproject.controller.ProductController;
import project.springproject.model.Product;
import project.springproject.repository.ProductRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductRepository rep;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ProductController productController = new ProductController(rep);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        product = new Product(1L, "TV", "LG TV", 300.99, 100);
    }

    @Test
    void testGetProductByID() throws Exception {
        when(rep.findById(1L)).thenReturn(Optional.of(product));
        mockMvc.perform(get("/api/shop/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TV"));
    }

    @Test
    void testAddProduct() throws Exception {
        when(rep.save(any(Product.class))).thenReturn(product);
        mockMvc.perform(post("/api/shop/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("TV"));
    }

    @Test
    void testUpdateProduct() throws Exception {
        when(rep.findById(1L)).thenReturn(Optional.of(product));
        when(rep.save(any(Product.class))).thenReturn(product);
        product.setName("Updated TV");
        mockMvc.perform(put("/api/shop/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated TV"));
    }

    @Test
    void testDeleteProduct() throws Exception {
        when(rep.findById(1L)).thenReturn(Optional.of(product));
        mockMvc.perform(delete("/api/shop/1"))
                .andExpect(status().isNoContent());
    }
}

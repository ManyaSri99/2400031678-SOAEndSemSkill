package com.example.msi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Ms1Controller.class)
class Ms1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AdditionService additionService;

    @Test
    void addReturnsOkAndAdditionResult() throws Exception {
        given(additionService.add(5, 10)).willReturn(15);

        mockMvc.perform(get("/ms1/add")
                        .param("a", "5")
                        .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("addition=15"));
    }
}
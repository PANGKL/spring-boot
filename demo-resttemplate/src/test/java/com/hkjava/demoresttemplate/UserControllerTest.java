package com.hkjava.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;
import com.hkjava.demoresttemplate.exception.GlobalExceptionHandler;
import com.hkjava.demoresttemplate.model.User;
import com.hkjava.demoresttemplate.service.UserService;

// This is another Testing Environment
// which may not require a full context
@WebMvcTest // @AutoConfigureMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // replace autowired service, cause not a full springboot
    private UserService userService;




    @Test
    void testGetUser() throws Exception {
        User user1 = new User(1, "John", "johnlau", "johnlau@gmail.com", null,
                null, null, null);
        User user2 = new User(2, "Mary", "marylau", "marylau@gmail.com", null,
                null, null, null);
        Mockito.when(userService.findUsers()).thenReturn(List.of(user1, user2));
        Mockito.when(userService.findUsers());

        // Mockito.verfiy(null,null)

        // ResultActions mvcResult = mockMvc.perform(get("/api/v1/users"));//

        mockMvc.perform(get("/api/v1/users")).andExpect(status().isOk())//
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))//
                .andExpect(jsonPath("$.data[0].id").value(1))//
                .andExpect(jsonPath("$.data[0].name").value("John"))//
                .andExpect(jsonPath("$.data[1].id").value(2))
                .andExpect(jsonPath("$.data[1].name").value("Mary"));
    }

    @Test
    void testEmptyUsers() throws Exception {
        Mockito.when(userService.findUsers()).thenReturn(null); // null cannot .stream()

        mockMvc.perform(get("/api/v1/users"))//
                .andExpect(status().isBadRequest())//
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))//
                .andExpect(jsonPath("$.code").value("40001"))//
                .andExpect(jsonPath("$.message")
                        .value("JsonPlaceHolder Resource NOT FOUND"))//
                .andExpect(jsonPath("$.data").doesNotExist())//
                .andDo(MockMvcResultHandlers.print());


    }
}

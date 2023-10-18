package org.example.controller;

import org.example.model.RebeldeModel;
import org.example.service.BaseCompraService;
import org.example.service.RebeldeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RebeldeController.class)
class RebeldeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RebeldeService rebeldeService;

    @MockBean
    private BaseCompraService baseCompraService;

    @Test
    void deveAdicionarRebeldeComSucesso() throws Exception {
        doReturn(new RebeldeModel()).when(rebeldeService).adicionarRebeldes(any(RebeldeRequest.class));

        this.mockMvc.perform(
                        post("/rebeldes")
                                .content(
                                        "{\n" +
                                                "    \"nome\": \"Nome Teste 2\",\n" +
                                                "    \"idade\": 23,\n" +
                                                "    \"genero\": \"masculino\",\n" +
                                                "    \"localizacao\": \"Sao Paulo\",\n" +
                                                "    \"moedas\": 200.0,\n" +
                                                "    \"inventario\": {\n" +
                                                "        \"item-1\": 10.0,\n" +
                                                "        \"item-2\": 50.0\n" +
                                                "    }\n" +
                                                "}"
                                )
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

}
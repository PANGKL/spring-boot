package com.hkjava.demostockexercise;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.hkjava.demostockexercise.exception.BussinessException;
import com.hkjava.demostockexercise.model.CompanyDTO;
import com.hkjava.demostockexercise.model.Stock;
import com.hkjava.demostockexercise.service.StockService;
import ch.qos.logback.core.encoder.EchoEncoder;

@WebMvcTest
public class StockControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StockService stockService;


  @Test
  void testGetStock() throws Exception {

    CompanyDTO companyDTO =
        new CompanyDTO("Hong Kong", "PKL", "sdsd", "sdsd", 12, "sdsd");
    Stock stock = new Stock(companyDTO, 100, 110, 20, 30, 40);

    String str = "aapl";
    Mockito.when(stockService.findStockState(str)).thenReturn(stock);
    // Mockito.when(stockService.findCompanyQuote(str));

    mockMvc.perform(get("/api/v1/stock").param("symbol", str))
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))// ;
    ;



  }



}

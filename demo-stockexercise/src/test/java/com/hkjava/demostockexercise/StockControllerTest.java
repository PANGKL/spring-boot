package com.hkjava.demostockexercise;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import com.hkjava.demostockexercise.exception.BussinessException;
import com.hkjava.demostockexercise.model.CompanyDTO;
import com.hkjava.demostockexercise.model.Stock;
import com.hkjava.demostockexercise.service.StockService;
import com.jayway.jsonpath.JsonPath;
import ch.qos.logback.core.encoder.EchoEncoder;

@WebMvcTest
public class StockControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StockService stockService;


  @Test
  void testGetStock() throws Exception {

    CompanyDTO companyDTO = new CompanyDTO("US", "Apple Inc", "1980-12-12",
        "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg",
        2782424.363206, "USD");
    Stock stock = new Stock(companyDTO, 177.97, 177.97, 176.17, 176.48, 175.01);

    String str = "aapl";
    Mockito.when(stockService.findStockState(str)).thenReturn(stock);
    // Stock s = stockService.findStockState(str);
    // System.out.println(s);

    mockMvc.perform(get("/api/v1/stock").param("symbol", str))
        .andExpect(status().isOk())//
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))//
        .andExpect(jsonPath("$.companyProfile.country").value("US"))
        .andExpect(jsonPath("$.companyProfile.currency").value("USD"))
        .andExpect(jsonPath("$.currentPrice").value(177.97))
        .andDo(MockMvcResultHandlers.print());



  }



}

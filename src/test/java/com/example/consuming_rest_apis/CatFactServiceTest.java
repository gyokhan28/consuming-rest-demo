package com.example.consuming_rest_apis;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CatFactServiceTest {

    @Mock
    private CatFactRepository catFactRepository;

    @InjectMocks
    private CatFactService catFactService;

    @BeforeEach
    public void setUp() {
        catFactService = new CatFactService(catFactRepository);
    }

    @Test
    public void testSaveFact() {
        String fact = "Cats sleep 16 hours a day";

        // Call the service method
        catFactService.saveFact(fact);

        // Create expected CatFact object
        CatFact expectedCatFact = new CatFact();
        expectedCatFact.setFact(fact);
        expectedCatFact.setLength(fact.length());

    }
}

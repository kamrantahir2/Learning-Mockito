package com.example.LearningMockito;

import com.example.LearningMockito.MathApplication.CalculatorService;
import com.example.LearningMockito.MathApplication.MathApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MathApplicationTester {

//  @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

//  @Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @DisplayName("Testing add functionality")
    @Test
    public void testAdd() {
//      add the behavior of calc service to add two numbers
        when(calcService.add(10.0, 20.0)).thenReturn(30.0);

//      test the add functionality
        assertEquals(mathApplication.add(10, 20), 30);

//      verify the behavior
        verify(calcService, times(1)).add(10, 20);
    }

}
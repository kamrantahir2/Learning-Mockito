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

//    @DisplayName("Testing add functionality")
//    @Test
//    public void testAdd() {
////      add the behavior of calc service to add two numbers
//        when(calcService.add(10.0, 20.0)).thenReturn(30.0);
//
////      add the behavior of calc service to subtract two numbers
//        when(calcService.subtract(20.0,10.0)).thenReturn(10.00);
//
////      test the add functionality
//        assertEquals(mathApplication.add(10, 20), 30);
//        assertEquals(mathApplication.add(10, 20), 30);
//        assertEquals(mathApplication.add(10, 20), 30);
//
////      test the subtract functionality
//        assertEquals(mathApplication.subtract(20, 10), 10);
//
////      check a minimum 1 call count
//        verify(calcService, atLeastOnce()).add(10, 20);
//
////      check if add function is called minimum 2 times
//        verify(calcService, atLeast(2)).add(10, 20);
//
////      check if add function is called maximum 3 times
//        verify(calcService, atMost(3)).add(10.0,20.0);
//    }
//
    @Test(expected = RuntimeException.class)
    public void testAdd() {

//      add the behavior to throw exception
        doThrow(new RuntimeException("Add operation not implement"))
                .when(calcService.add(10,20));

        assertEquals(mathApplication.add(10, 20), 30);
    }


}
package com.example.LearningMockito;

import com.example.LearningMockito.MathApplication.CalculatorService;
import com.example.LearningMockito.MathApplication.MathApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MathApplicationTester {

//     =========================================================================
            //            Original Code
            //              --------

//  @InjectMocks annotation is used to create and inject the mock object
//    @InjectMocks
//    MathApplication mathApplication = new MathApplication();

//  @Mock annotation is used to create the mock object to be injected
//    @Mock

//    private CalculatorService calcService;
//    private MathApplication mathApplication;
//
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

//  ===================================================================================

//          Mockito - Exception Handling
//              -------------------

//    @Test(expected = RuntimeException.class)
//    public void testAdd() {
//
////      add the behavior to throw exception
//        doThrow(new RuntimeException("Add operation not implement"))
//                .when(calcService.add(10,20));
//
//        assertEquals(mathApplication.add(10, 20), 30);
//    }

//  ===================================================================================

//             Mockito - Create Mock
//              -------------------

    private MathApplication mathApplication;
    private CalculatorService calcService;

//    This will run before every test to initialise mathApplication adn calcService
    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

//    @Test
//    public void testAddAndSubtract() {
//
////        add the behavior to add numbers
//        when(calcService.add(20, 10)).thenReturn(30.0);
//
////        subtract the behavior to subtract numbers
//        when(calcService.subtract(20, 10)).thenReturn(10.0);
//
////        test the subtract functionality
//        assertEquals(mathApplication.subtract(20, 10), 10);
//
////        test the subtract functionality
//        assertEquals(mathApplication.add(20, 10), 30);
//
//        InOrder inOrder = inOrder(calcService);
//
////        verify call to calcService is made or not
//        inOrder.verify(calcService).subtract(20, 10);
//        inOrder.verify(calcService).add(20, 10);
//
//
//    }

//    ===================================================

//    @Before
//    public void setUp() {
//        mathApplication = new MathApplication();
//        Calculator calculator = new Calculator();
//        calcService = spy(calculator);
//        mathApplication.setCalculatorService(calcService);
//    }

    class Calculator implements CalculatorService {
        @Override
        public double add(double input1, double input2) {
            return input1 + input2;
        }

        @Override
        public double subtract(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double multiply(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }

        @Override
        public double divide(double input1, double input2) {
            throw new UnsupportedOperationException("Method not implemented yet!");
        }
    }

//   Creating a mock object using Answer
//    @Test
//    public void testAdd() {
//        when(calcService.add(20, 10)).thenAnswer(new Answer<Double>() {
//            @Override
//            public Double answer(InvocationOnMock invocation) throws Throwable {
////                get the arguments passed to mock
//                Object[] args = invocation.getArguments();
//                Object mock = invocation.getMock();
//                return 30.0;
//            }
//        });
//
////        test the add functionality
//        assertEquals(mathApplication.add(20, 10), 30);
//    }

    @Test
    public void testAddAndSubtract() {

//        add the behavior to add numbers
        when(calcService.add(20, 10)).thenReturn(30.0);

//        test the add functionality
        assertEquals(mathApplication.add(20, 10), 30.0);

//        reset the mock
        reset(calcService);

////        test the add functionality after resetting the mock
//        assertEquals(mathApplication.subtract(20, 10), 30.0);

    }

//  ============================================================

//              Mockito - Given, When, Then
//                 --------------------

    @Test
    public void testAdd() {
//        Given
        given(calcService.add(20, 10)).willReturn(30.0);

//        When
        double result = calcService.add(20, 10);

//        Then
        assertEquals(result, 30.0);

    }

}
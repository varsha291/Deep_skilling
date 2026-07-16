package com.cognizant;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    // Exercise 3: Argument Matching
    @Test
    public void testArgumentMatching() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getDataById(anyInt()))
                .thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        service.fetchDataById(10);

        verify(mockApi).getDataById(eq(10));
    }

    // Exercise 4: Handling Void Methods
    @Test
    public void testVoidMethod() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        doNothing()
                .when(mockApi)
                .sendData("Test Data");

        MyService service = new MyService(mockApi);

        service.sendData("Test Data");

        verify(mockApi).sendData("Test Data");
    }

    // Exercise 5: Multiple Returns
    @Test
    public void testMultipleReturns() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First Data")
                .thenReturn("Second Data");

        MyService service = new MyService(mockApi);

        assertEquals("First Data", service.fetchData());
        assertEquals("Second Data", service.fetchData());
    }

    // Exercise 6: Verifying Interaction Order
    @Test
    public void testInteractionOrder() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.performOperations();

        InOrder inOrder = inOrder(mockApi);

        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).disconnect();
    }

    // Exercise 7: Void Method with Exception
    @Test
    public void testVoidMethodException() {

        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        doThrow(new RuntimeException("API Error"))
                .when(mockApi)
                .sendData("Invalid Data");

        MyService service = new MyService(mockApi);

        assertThrows(
                RuntimeException.class,
                () -> service.sendData("Invalid Data")
        );

        verify(mockApi).sendData("Invalid Data");
    }
}
package edu.unisabana.tyvs.service;

import edu.unisabana.tyvs.model.*;

import org.junit.Assert;
import org.junit.Test;


public class RegistryTest {

    @Test
    public void shouldRegisterValidPerson() {
        // Arrange
        Registry registry = new Registry();
        Person p = new Person("Ana", 1, 30, Gender.FEMALE, true);

        // Act
        RegisterResult result = registry.registerVoter(p);

        // Assert
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldRejectDeadPerson() {
        // Arrange
        Registry registry = new Registry();
        Person p = new Person("Carlos", 2, 45, Gender.MALE, false);

        // Act
        RegisterResult result = registry.registerVoter(p);

        // Assert
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    //Escenario: Rechazar persona menor de edad
    //Dado que existe una persona viva de 17 años
    //Cuando intento registrarla
    //Entonces el resultado debe ser UNDERAGE

    @Test
    public void shouldRejectUnderageAt17() {
        // Given
        Registry registry = new Registry();
        Person p = new Person("Luis", 3, 17, Gender.MALE, true);

        // When
        RegisterResult result = registry.registerVoter(p);

        // Then
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

}
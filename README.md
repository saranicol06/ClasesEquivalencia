# Clases de Equivalencia y Pruebas TDD

## Integrantes
- **Axel Daniel Bedoya**
- **Sara Nicol Zuluaga**

---

##  1. Introducción
Este proyecto implementa pruebas unitarias para validar las reglas de registro de votantes usando **TDD (Test-Driven Development)** y **BDD (Behavior-Driven Development)**.  
Se desarrolla en **Java** con **JUnit** y se analiza la **cobertura de código** usando **JaCoCo**.

---

##  2. Estructura del proyecto
El proyecto fue generado con Maven mediante el comando:

```bash
mvn archetype:generate -DgroupId=edu.unisabana.tyvs -DartifactId=clasesequivalencia -Dpackage=edu.unisabana.tyvs.tdd -DarchetypeArtifactId=maven-archetype-quickstart
```

### Estructura principal

clasesequivalencia/
 ├── src/
 │   ├── main/java/edu/unisabana/tyvs/...
 │   └── test/java/edu/unisabana/tyvs/...
 ├── pom.xml
 └── target/

## 3. Enfoque TDD (Test Driven Development)

- Se crean los tests primero (por ejemplo, shouldRejectUnderageAt17()).
- Se implementa la lógica mínima necesaria en la clase Registry.
- Se refactoriza el código hasta que todos los tests pasen correctamente.
- Cada prueba verifica una regla de negocio específica del dominio.

## 4. Clases de equivalencia y escenarios BDD

| Nombre del test (JUnit)             | Escenario BDD (Given–When–Then)                                                                                                                  |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------ |
| shouldReturnInvalidWhenPersonIsNull | **Given** la persona es null<br>**When** intento registrarla<br>**Then** el resultado debe ser `INVALID`                                         |
| shouldRejectWhenIdIsZeroOrNegative  | **Given** la persona tiene id = 0 (o -5), edad 25 y está viva<br>**When** intento registrarla<br>**Then** el resultado debe ser `INVALID`        |
| shouldRejectUnderageAt17            | **Given** la persona tiene 17 años, está viva y su id es válido<br>**When** intento registrarla<br>**Then** el resultado debe ser `UNDERAGE`     |
| shouldAcceptAdultAt18               | **Given** la persona tiene 18 años, está viva y su id es válido<br>**When** intento registrarla<br>**Then** el resultado debe ser `VALID`        |
| shouldAcceptMaxAge120               | **Given** la persona tiene 120 años, está viva y su id es válido<br>**When** intento registrarla<br>**Then** el resultado debe ser `VALID`       |
| shouldRejectInvalidAgeOver120       | **Given** la persona tiene 121 años, está viva y su id es válido<br>**When** intento registrarla<br>**Then** el resultado debe ser `INVALID_AGE` |

## 5. Patrón AAA (Arrange – Act – Assert)

- Cada prueba sigue el patrón AAA:
- Arrange: se preparan los objetos (Person, Registry).
- Act: se ejecuta la acción (registerVoter).
- Assert: se valida el resultado esperado con Assert.assertEquals().
  
Ejemplo:
```java
@Test
public void shouldRejectUnderageAt17() {
    // Arrange
    Registry registry = new Registry();
    Person p = new Person("Luis", 3, 17, Gender.MALE, true);

    // Act
    RegisterResult result = registry.registerVoter(p);

    // Assert
    Assert.assertEquals(RegisterResult.UNDERAGE, result);
}
```

## 6. Cobertura de código (JaCoCo)

Se configuró el plugin JaCoCo en el pom.xml para generar el reporte de cobertura.

Para ejecutarlo: 
```bash
mvn clean test
```

Luego abrir el archivo: 
target/site/jacoco/index.html

<img width="2879" height="565" alt="image" src="https://github.com/user-attachments/assets/01cf60f2-0936-4e87-9d10-5914f7daad93" />


## 7. Conclusiones

- Se aplicaron técnicas de TDD y BDD correctamente.
- Todas las pruebas se ejecutaron con éxito en JUnit.
- El reporte de JaCoCo evidenció una cobertura alta del código del dominio.
- Se validaron todas las reglas de negocio mediante clases de equivalencia.


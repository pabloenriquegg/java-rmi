# Java RMI – Estudio de Caso UD5

Proyecto académico de la asignatura **Programación Concurrente y Distribuida**.  
Implementación de distintos servicios distribuidos en Java mediante **Remote Method Invocation (RMI)**.

## Contenido
- Carpeta `src/`: código fuente dividido en:
  - `client/`: clientes que consumen los servicios remotos.
  - `server/`: implementación de los objetos remotos.
  - `interfaces/`: definición de las interfaces remotas.
- Carpeta `docs/`: memoria explicativa del estudio de caso (PDF).

## Funcionalidades
1. **CountRMI**: contador remoto que puede ser incrementado por un cliente.
2. **WebRMI**: obtiene el código fuente de una página web, guarda el contenido, extrae enlaces y permite borrar los archivos temporales.  
   - Requiere la librería [Jsoup](https://jsoup.org/download).
3. **PrimeRMI**: comprueba si un número es primo o no.

## Requisitos
- **Java 8 o superior**
- Librería externa: **Jsoup**

## Ejecución
1. Compilar las clases:
   ```bash
   javac src/interfaces/*.java src/server/*.java src/client/*.java -cp ".;jsoup-1.15.3.jar"
2. Iniciar el registro RMI:
     ```bash
     rmiregistry
3. Ejecutar el servidor:
    ```bash
    java server.CountRMIImpl
4. Ejecutar los clientes:
    ```bash
    java client.CountRMIClient
    java client.WebRMIClient
    java client.PrimeRMIClient


Objetivos

Comprender el funcionamiento de Java RMI en sistemas distribuidos.

Desarrollar clientes y servidores que interactúan mediante invocación remota de métodos.

Experimentar con persistencia ligera y librerías externas (Jsoup).

Autor

Pablo Enrique Guntín Garrido
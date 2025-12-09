IPS_AUSENTISMOS_VSCODE - Módulo de Colaboradores (Java + JDBC + Servlets + JSP)

Este proyecto está preparado para usarse en VS Code con:

- Extension Pack for Java
- Tomcat for Java
- JDK 17
- Maven

Estructura:
- pom.xml -> configuración Maven (packaging WAR)
- src/main/java -> código Java (entidad, DAO, servlet)
- src/main/webapp -> JSP y WEB-INF/web.xml

Para ejecutar:
1. Abrir la carpeta en VS Code (File > Open Folder).
2. Esperar a que Maven descargue dependencias.
3. Compilar el proyecto (paleta de comandos: "Maven: package").
4. Con la extensión Tomcat for Java, desplegar el WAR o la carpeta en Tomcat 9.

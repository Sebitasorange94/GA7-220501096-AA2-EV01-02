<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ipsausentismos.modelo.entidad.Colaborador" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Colaborador - IPS Ausentismos</title>
</head>
<body>
<%
    Colaborador colaborador = (Colaborador) request.getAttribute("colaborador");
    boolean esEdicion = (colaborador != null && colaborador.getIdColaborador() > 0);
%>

<h1><%= esEdicion ? "Editar Colaborador" : "Nuevo Colaborador" %></h1>

<form action="ColaboradorServlet" method="post">
    <input type="hidden" name="accion" value="<%= esEdicion ? "actualizar" : "insertar" %>" />
    <% if (esEdicion) { %>
        <input type="hidden" name="idColaborador" value="<%= colaborador.getIdColaborador() %>" />
    <% } %>

    <label>Tipo de documento:</label><br/>
    <input type="text" name="tipoDocumento"
           value="<%= esEdicion ? colaborador.getTipoDocumento() : "" %>" required />
    <br/><br/>

    <label>Número de documento:</label><br/>
    <input type="text" name="numeroDocumento"
           value="<%= esEdicion ? colaborador.getNumeroDocumento() : "" %>" required />
    <br/><br/>

    <label>Nombre completo:</label><br/>
    <input type="text" name="nombreCompleto"
           value="<%= esEdicion ? colaborador.getNombreCompleto() : "" %>" required />
    <br/><br/>

    <label>Cargo:</label><br/>
    <input type="text" name="cargo"
           value="<%= esEdicion ? colaborador.getCargo() : "" %>" required />
    <br/><br/>

    <label>Fecha de ingreso:</label><br/>
    <input type="date" name="fechaIngreso"
           value="<%= esEdicion && colaborador.getFechaIngreso() != null
                    ? colaborador.getFechaIngreso().toString()
                    : "" %>" required />
    <br/><br/>

    <label>Días vacaciones acumulados:</label><br/>
    <input type="number" name="diasAcumulados"
           value="<%= esEdicion ? colaborador.getDiasVacacionesAcumulados() : 0 %>" required />
    <br/><br/>

    <label>Días vacaciones disponibles:</label><br/>
    <input type="number" name="diasDisponibles"
           value="<%= esEdicion ? colaborador.getDiasVacacionesDisponibles() : 0 %>" required />
    <br/><br/>

    <label>Estado:</label><br/>
    <select name="estado">
        <option value="ACTIVO"
            <%= esEdicion && "ACTIVO".equals(colaborador.getEstado()) ? "selected" : "" %>>
            ACTIVO
        </option>
        <option value="INACTIVO"
            <%= esEdicion && "INACTIVO".equals(colaborador.getEstado()) ? "selected" : "" %>>
            INACTIVO
        </option>
    </select>
    <br/><br/>

    <input type="submit" value="<%= esEdicion ? "Actualizar" : "Guardar" %>" />
    <a href="ColaboradorServlet?accion=listar">Cancelar</a>
</form>

</body>
</html>

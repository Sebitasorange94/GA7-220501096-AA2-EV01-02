<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ipsausentismos.modelo.entidad.Colaborador" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Colaboradores - IPS Ausentismos</title>
</head>
<body>
    <h1>Lista de Colaboradores</h1>

    <a href="ColaboradorServlet?accion=nuevo">Registrar nuevo colaborador</a>
    <br/><br/>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Tipo Doc</th>
            <th>No. Doc</th>
            <th>Nombre</th>
            <th>Cargo</th>
            <th>Fecha Ingreso</th>
            <th>Días Vac. Acum.</th>
            <th>Días Vac. Disp.</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>

        <%
            List<Colaborador> listaColaboradores =
                    (List<Colaborador>) request.getAttribute("listaColaboradores");
            if (listaColaboradores != null) {
                for (Colaborador c : listaColaboradores) {
        %>
        <tr>
            <td><%= c.getIdColaborador() %></td>
            <td><%= c.getTipoDocumento() %></td>
            <td><%= c.getNumeroDocumento() %></td>
            <td><%= c.getNombreCompleto() %></td>
            <td><%= c.getCargo() %></td>
            <td><%= c.getFechaIngreso() %></td>
            <td><%= c.getDiasVacacionesAcumulados() %></td>
            <td><%= c.getDiasVacacionesDisponibles() %></td>
            <td><%= c.getEstado() %></td>
            <td>
                <a href="ColaboradorServlet?accion=editar&idColaborador=<%= c.getIdColaborador() %>">
                    Editar
                </a>
                |
                <a href="ColaboradorServlet?accion=eliminar&idColaborador=<%= c.getIdColaborador() %>"
                   onclick="return confirm('¿Está seguro de eliminar este colaborador?');">
                    Eliminar
                </a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>

</body>
</html>

package com.ipsausentismos.controlador;

import com.ipsausentismos.modelo.dao.ColaboradorDAO;
import com.ipsausentismos.modelo.entidad.Colaborador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ColaboradorServlet", urlPatterns = {"/ColaboradorServlet"})
public class ColaboradorServlet extends HttpServlet {

    private ColaboradorDAO colaboradorDAO;

    @Override
    public void init() throws ServletException {
        colaboradorDAO = new ColaboradorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar";
        }

        try {
            switch (accion) {
                case "nuevo":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "editar":
                    mostrarFormularioEditar(request, response);
                    break;
                case "eliminar":
                    eliminarColaborador(request, response);
                    break;
                default:
                    listarColaboradores(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "";
        }

        try {
            switch (accion) {
                case "insertar":
                    insertarColaborador(request, response);
                    break;
                case "actualizar":
                    actualizarColaborador(request, response);
                    break;
                default:
                    listarColaboradores(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listarColaboradores(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        List<Colaborador> listaColaboradores = colaboradorDAO.listarColaboradores();
        request.setAttribute("listaColaboradores", listaColaboradores);
        request.getRequestDispatcher("colaboradores-lista.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("colaboradores-form.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int idColaborador = Integer.parseInt(request.getParameter("idColaborador"));
        Colaborador colaborador = colaboradorDAO.buscarColaboradorPorId(idColaborador);
        request.setAttribute("colaborador", colaborador);
        request.getRequestDispatcher("colaboradores-form.jsp").forward(request, response);
    }

    private void insertarColaborador(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String tipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String nombreCompleto = request.getParameter("nombreCompleto");
        String cargo = request.getParameter("cargo");
        LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"));
        int diasAcumulados = Integer.parseInt(request.getParameter("diasAcumulados"));
        int diasDisponibles = Integer.parseInt(request.getParameter("diasDisponibles"));
        String estado = request.getParameter("estado");

        Colaborador colaborador = new Colaborador(
                tipoDocumento, numeroDocumento, nombreCompleto,
                cargo, fechaIngreso,
                diasAcumulados, diasDisponibles,
                estado
        );
        colaboradorDAO.insertarColaborador(colaborador);
        response.sendRedirect("ColaboradorServlet?accion=listar");
    }

    private void actualizarColaborador(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int idColaborador = Integer.parseInt(request.getParameter("idColaborador"));
        String tipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String nombreCompleto = request.getParameter("nombreCompleto");
        String cargo = request.getParameter("cargo");
        LocalDate fechaIngreso = LocalDate.parse(request.getParameter("fechaIngreso"));
        int diasAcumulados = Integer.parseInt(request.getParameter("diasAcumulados"));
        int diasDisponibles = Integer.parseInt(request.getParameter("diasDisponibles"));
        String estado = request.getParameter("estado");

        Colaborador colaborador = new Colaborador(
            idColaborador, tipoDocumento, numeroDocumento, nombreCompleto,
            cargo, fechaIngreso,
            diasAcumulados, diasDisponibles, estado
        );
        colaboradorDAO.actualizarColaborador(colaborador);
        response.sendRedirect("ColaboradorServlet?accion=listar");
    }

    private void eliminarColaborador(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int idColaborador = Integer.parseInt(request.getParameter("idColaborador"));
        colaboradorDAO.eliminarColaborador(idColaborador);
        response.sendRedirect("ColaboradorServlet?accion=listar");
    }
}

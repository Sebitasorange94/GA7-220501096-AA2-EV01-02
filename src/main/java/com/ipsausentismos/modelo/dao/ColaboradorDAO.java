package com.ipsausentismos.modelo.dao;

import com.ipsausentismos.modelo.entidad.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {

    private static final String SQL_INSERTAR =
            "INSERT INTO Colaboradores (TipoDocumento, NumeroDocumento, NombreCompleto, " +
            "Cargo, FechaIngreso, DiasVacacionesAcumulados, DiasVacacionesDisponibles, Estado) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_LISTAR_TODOS =
            "SELECT IdColaborador, TipoDocumento, NumeroDocumento, NombreCompleto, Cargo, " +
            "FechaIngreso, DiasVacacionesAcumulados, DiasVacacionesDisponibles, Estado " +
            "FROM Colaboradores";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT IdColaborador, TipoDocumento, NumeroDocumento, NombreCompleto, Cargo, " +
            "FechaIngreso, DiasVacacionesAcumulados, DiasVacacionesDisponibles, Estado " +
            "FROM Colaboradores WHERE IdColaborador = ?";

    private static final String SQL_ACTUALIZAR =
            "UPDATE Colaboradores SET TipoDocumento = ?, NumeroDocumento = ?, NombreCompleto = ?, " +
            "Cargo = ?, FechaIngreso = ?, DiasVacacionesAcumulados = ?, DiasVacacionesDisponibles = ?, Estado = ? " +
            "WHERE IdColaborador = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM Colaboradores WHERE IdColaborador = ?";

    public void insertarColaborador(Colaborador colaborador) throws SQLException {
        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(SQL_INSERTAR)) {

            ps.setString(1, colaborador.getTipoDocumento());
            ps.setString(2, colaborador.getNumeroDocumento());
            ps.setString(3, colaborador.getNombreCompleto());
            ps.setString(4, colaborador.getCargo());
            ps.setDate(5, Date.valueOf(colaborador.getFechaIngreso()));
            ps.setInt(6, colaborador.getDiasVacacionesAcumulados());
            ps.setInt(7, colaborador.getDiasVacacionesDisponibles());
            ps.setString(8, colaborador.getEstado());
            ps.executeUpdate();
        }
    }

    public List<Colaborador> listarColaboradores() throws SQLException {
        List<Colaborador> listaColaboradores = new ArrayList<>();

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(SQL_LISTAR_TODOS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setIdColaborador(rs.getInt("IdColaborador"));
                colaborador.setTipoDocumento(rs.getString("TipoDocumento"));
                colaborador.setNumeroDocumento(rs.getString("NumeroDocumento"));
                colaborador.setNombreCompleto(rs.getString("NombreCompleto"));
                colaborador.setCargo(rs.getString("Cargo"));

                Date fechaSql = rs.getDate("FechaIngreso");
                LocalDate fechaIngreso = (fechaSql != null) ? fechaSql.toLocalDate() : null;
                colaborador.setFechaIngreso(fechaIngreso);

                colaborador.setDiasVacacionesAcumulados(rs.getInt("DiasVacacionesAcumulados"));
                colaborador.setDiasVacacionesDisponibles(rs.getInt("DiasVacacionesDisponibles"));
                colaborador.setEstado(rs.getString("Estado"));

                listaColaboradores.add(colaborador);
            }
        }

        return listaColaboradores;
    }

    public Colaborador buscarColaboradorPorId(int idColaborador) throws SQLException {
        Colaborador colaborador = null;

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(SQL_BUSCAR_POR_ID)) {

            ps.setInt(1, idColaborador);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    colaborador = new Colaborador();
                    colaborador.setIdColaborador(rs.getInt("IdColaborador"));
                    colaborador.setTipoDocumento(rs.getString("TipoDocumento"));
                    colaborador.setNumeroDocumento(rs.getString("NumeroDocumento"));
                    colaborador.setNombreCompleto(rs.getString("NombreCompleto"));
                    colaborador.setCargo(rs.getString("Cargo"));

                    Date fechaSql = rs.getDate("FechaIngreso");
                    LocalDate fechaIngreso = (fechaSql != null) ? fechaSql.toLocalDate() : null;
                    colaborador.setFechaIngreso(fechaIngreso);

                    colaborador.setDiasVacacionesAcumulados(rs.getInt("DiasVacacionesAcumulados"));
                    colaborador.setDiasVacacionesDisponibles(rs.getInt("DiasVacacionesDisponibles"));
                    colaborador.setEstado(rs.getString("Estado"));
                }
            }
        }

        return colaborador;
    }

    public void actualizarColaborador(Colaborador colaborador) throws SQLException {
        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(SQL_ACTUALIZAR)) {

            ps.setString(1, colaborador.getTipoDocumento());
            ps.setString(2, colaborador.getNumeroDocumento());
            ps.setString(3, colaborador.getNombreCompleto());
            ps.setString(4, colaborador.getCargo());
            ps.setDate(5, Date.valueOf(colaborador.getFechaIngreso()));
            ps.setInt(6, colaborador.getDiasVacacionesAcumulados());
            ps.setInt(7, colaborador.getDiasVacacionesDisponibles());
            ps.setString(8, colaborador.getEstado());
            ps.setInt(9, colaborador.getIdColaborador());

            ps.executeUpdate();
        }
    }

    public void eliminarColaborador(int idColaborador) throws SQLException {
        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement ps = conexion.prepareStatement(SQL_ELIMINAR)) {

            ps.setInt(1, idColaborador);
            ps.executeUpdate();
        }
    }
}

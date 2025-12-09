package com.ipsausentismos.modelo.entidad;

import java.time.LocalDate;

public class Colaborador {

    private int idColaborador;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
    private String cargo;
    private LocalDate fechaIngreso;
    private int diasVacacionesAcumulados;
    private int diasVacacionesDisponibles;
    private String estado;

    public Colaborador() {
    }

    public Colaborador(String tipoDocumento, String numeroDocumento, String nombreCompleto,
                       String cargo, LocalDate fechaIngreso,
                       int diasVacacionesAcumulados, int diasVacacionesDisponibles,
                       String estado) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.diasVacacionesAcumulados = diasVacacionesAcumulados;
        this.diasVacacionesDisponibles = diasVacacionesDisponibles;
        this.estado = estado;
    }

    public Colaborador(int idColaborador, String tipoDocumento, String numeroDocumento, String nombreCompleto,
                       String cargo, LocalDate fechaIngreso,
                       int diasVacacionesAcumulados, int diasVacacionesDisponibles,
                       String estado) {
        this.idColaborador = idColaborador;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.diasVacacionesAcumulados = diasVacacionesAcumulados;
        this.diasVacacionesDisponibles = diasVacacionesDisponibles;
        this.estado = estado;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getDiasVacacionesAcumulados() {
        return diasVacacionesAcumulados;
    }

    public void setDiasVacacionesAcumulados(int diasVacacionesAcumulados) {
        this.diasVacacionesAcumulados = diasVacacionesAcumulados;
    }

    public int getDiasVacacionesDisponibles() {
        return diasVacacionesDisponibles;
    }

    public void setDiasVacacionesDisponibles(int diasVacacionesDisponibles) {
        this.diasVacacionesDisponibles = diasVacacionesDisponibles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

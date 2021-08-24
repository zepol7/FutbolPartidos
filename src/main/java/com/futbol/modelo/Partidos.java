/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbol.modelo;

/**
 *
 * @author USUARIO
 */
public class Partidos {
    
    private int id;
    private int usuario;
    private int local;
    private int visitante;
    private int goles_local;
    private int goles_visitantes;

    public Partidos(int id, int usuario, int local, int visitante, int goles_local, int goles_visitantes) {
        this.id = id;
        this.usuario = usuario;
        this.local = local;
        this.visitante = visitante;
        this.goles_local = goles_local;
        this.goles_visitantes = goles_visitantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_visitantes() {
        return goles_visitantes;
    }

    public void setGoles_visitantes(int goles_visitantes) {
        this.goles_visitantes = goles_visitantes;
    }
    
    
    
    
    
    
    
    
}

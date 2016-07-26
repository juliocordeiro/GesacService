/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Edilson Jr
 */
public class Servico {

    int id;
    int Usuario_cod_usuario;
    Calendar criacao;
    Calendar encerramento;
    int intervalo;
    
    String descricao;
  String perguntas[];

    public String[] getPerguntas() {
        return perguntas;
    }

    public Calendar getCriacao() {
        return criacao;
    }

    public void setCriacao(Calendar criacao) {
        this.criacao = criacao;
    }

    public Calendar getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(Calendar encerramento) {
        this.encerramento = encerramento;
    }

    public void setPerguntas(String[] perguntas) {
        this.perguntas = perguntas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_cod_usuario() {
        return Usuario_cod_usuario;
    }

    public void setUsuario_cod_usuario(int Usuario_cod_usuario) {
        this.Usuario_cod_usuario = Usuario_cod_usuario;
    }

    

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Leo
 */
public class ConsultaDTO {
    
    private String nome_paciente;
    private String cpf_paciente;
    private String medico_consulta;
    private String dia_consulta;
    private String horario_consulta;

    
    public String getNome_paciente() {
        return nome_paciente;
    }

    
    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    
    public String getCpf_paciente() {
        return cpf_paciente;
    }

   
    public void setCpf_paciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

   
    public String getMedico_consulta() {
        return medico_consulta;
    }

   
    public void setMedico_consulta(String medico_consulta) {
        this.medico_consulta = medico_consulta;
    }

    
    public String getDia_consulta() {
        return dia_consulta;
    }

   
    public void setDia_consulta(String dia_consulta) {
        this.dia_consulta = dia_consulta;
    }

    
    public String getHorario_consulta() {
        return horario_consulta;
    }

    
    public void setHorario_consulta(String horario_consulta) {
        this.horario_consulta = horario_consulta;
    }
    
     
}

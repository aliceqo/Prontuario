/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ConsultaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
public class ConsultaDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ConsultaDTO> lista = new ArrayList<>();

    public void marcarConsulta(ConsultaDTO objconsultaDTO) {

        String sql = "insert into consultas (nome_paciente, cpf_paciente, medico_consulta, dia_consulta, horario_consulta) values (?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objconsultaDTO.getNome_paciente());
            pstm.setString(2, objconsultaDTO.getCpf_paciente());
            pstm.setString(3, objconsultaDTO.getMedico_consulta());
            pstm.setString(4, objconsultaDTO.getDia_consulta());
            pstm.setString(5, objconsultaDTO.getHorario_consulta());

            JOptionPane.showMessageDialog(null, "Consulta marcada!");
            
            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "ConsultaDAO " + erro);
        }

    }

    public ArrayList<ConsultaDTO> relatorioConsultas() {

        String sql = "select * from consultas";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ConsultaDTO objconsultaDTO = new ConsultaDTO();
                objconsultaDTO.setNome_paciente(rs.getString("nome_paciente"));
                objconsultaDTO.setCpf_paciente(rs.getString("cpf_paciente"));
                objconsultaDTO.setMedico_consulta(rs.getString("medico_consulta"));
                objconsultaDTO.setDia_consulta(rs.getString("dia_consulta"));
                objconsultaDTO.setHorario_consulta(rs.getString("horario_consulta"));

                lista.add(objconsultaDTO);

            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsultaDAO relatorio " + erro);

        }
        return lista;
    }
    
     public void cancelarConsulta(ConsultaDTO objconsultaDTO) {

        String sql = "delete from consultas where cpf_paciente = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objconsultaDTO.getCpf_paciente());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "ConsultaDAO Cancelar consulta" + erro);
        }
    }
}

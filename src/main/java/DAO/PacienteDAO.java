package DAO;

import DTO.PacienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PacienteDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PacienteDTO> lista = new ArrayList<>();

    public void cadastrarPaciente(PacienteDTO objpacienteDTO) {

        String sql = "insert into pacientes (nome_pacientes, sexo_pacientes, cpf_pacientes) values (?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpacienteDTO.getNome_pacientes());
            pstm.setString(2, objpacienteDTO.getSexo_pacientes());
            pstm.setString(3, objpacienteDTO.getCpf_pacientes());

            JOptionPane.showMessageDialog(null, "Paciente Cadastrado! ");

            pstm.execute();

            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "PacienteDAO Cadastrar" + erro);
        }
    }

    public ArrayList<PacienteDTO> relatorioPacientes() {

        String sql = "select * from pacientes";
        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                PacienteDTO objpacienteDTO = new PacienteDTO();
                objpacienteDTO.setId_pacientes(rs.getInt("id_pacientes"));
                objpacienteDTO.setNome_pacientes(rs.getString("nome_pacientes"));
                objpacienteDTO.setSexo_pacientes(rs.getString("sexo_pacientes"));
                objpacienteDTO.setCpf_pacientes(rs.getString("cpf_pacientes"));

                lista.add(objpacienteDTO);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "PacienteDAO Relatorio: " + erro);
        }
        return lista;
    }
    
    public void alterarPaciente(PacienteDTO objpacienteDTO){
    
        String sql = "update pacientes set nome_pacientes = ?, sexo_pacientes = ?, cpf_pacientes = ? where id_pacientes = ?";
        conn = new ConexaoDAO().conectaBD();
        
         try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpacienteDTO.getNome_pacientes());
            pstm.setString(2, objpacienteDTO.getSexo_pacientes());
            pstm.setString(3, objpacienteDTO.getCpf_pacientes());
            pstm.setInt(4, objpacienteDTO.getId_pacientes());

            

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "PacienteDAO Alterar" + erro);
        }
        
    }
    
    
    public void excluirPaciente(PacienteDTO objpacienteDTO){
    
        String sql = "delete from pacientes where id_pacientes = ?";
        conn = new ConexaoDAO().conectaBD();
        
        
        try {

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objpacienteDTO.getId_pacientes());

            

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "PacienteDAO excluir" + erro);
        }
    
    }
}

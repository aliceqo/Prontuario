package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuarioDTO) {

        conn = new ConexaoDAO().conectaBD();

        try {

            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuarioDTO.getNome_usuario());
            pstm.setString(2, objusuarioDTO.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }

    public void cadastrarUsuario(UsuarioDTO objusuarioDTO) {

        String sql = "insert into usuario (nome_usuario, senha_usuario) values (?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuarioDTO.getNome_usuario());
            pstm.setString(2, objusuarioDTO.getSenha_usuario());

            JOptionPane.showMessageDialog(null, "Usuário Cadastrado! ");

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "UsuarioDAO cadastrar" + erro);
        }

    }

    public ArrayList<UsuarioDTO> relatorioUsuarios() {

        String sql = "select * from usuario";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO objusuarioDTO = new UsuarioDTO();
                objusuarioDTO.setId_usuario(rs.getInt("id_usuario"));
                objusuarioDTO.setNome_usuario(rs.getString("nome_usuario"));

                lista.add(objusuarioDTO);

            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "UsuarioDAO relatorio " + erro);

        }
        return lista;
    }

    public void excluir(UsuarioDTO objusuarioDTO) {

        String sql = "delete from usuario where id_usuario = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, objusuarioDTO.getId_usuario());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "UsuarioDAO Excluir" + erro);
        }
    }

    public ResultSet controledeAcesso(UsuarioDTO objusuarioDTO) {

        conn = new ConexaoDAO().conectaBD();

        try {

            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuarioDTO.getNome_usuario());
            pstm.setString(2, objusuarioDTO.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "ControledeAcessoDAO: " + erro);
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sr. Roosevelt
 */
public class Dao {
    
    
    //Metodo para inserir um aluno no banco de dados
    public void inserirAluno(infoAlunos aluno){
        if(aluno != null){
            String INSERIR_ALUNO = "insert into dados_aluno (nome_aluno, data_nascimento, sexo_aluno, naturalidade_aluno, estado_civil, cpf_aluno, rg_aluno, id_bolsafamilia, bolsa_familia, numero_sus, fardamento, restricao_alimentar, observacao, nome_pai, profissao_pai, nome_mae, profissao_mae, serie, modalidade, turma, email, transporte_publico, localidade) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = null;
            
            try {
                con = conexaoBD.getConexao();
                PreparedStatement inserirAluno;
                inserirAluno = con.prepareStatement(INSERIR_ALUNO);
                //dados do aluno
                inserirAluno.setString(1, aluno.getNome());
                inserirAluno.setDate(2, new Date (aluno.getData_nasci().getTime()));
                inserirAluno.setString(3, aluno.getSexo());
                inserirAluno.setString(4, aluno.getNaturalidade());
                inserirAluno.setString(5, aluno.getEstadoCivil());
                inserirAluno.setString(6, aluno.getCpf());
                inserirAluno.setString(7, aluno.getRg());
                inserirAluno.setInt(8, aluno.getId());
                inserirAluno.setString(9, aluno.getBolsaF());
                inserirAluno.setString(10, aluno.getNumeroSUS());
                inserirAluno.setString(11, aluno.getFardamento());
                inserirAluno.setString(12, aluno.getRestricaoAlimentar());
                inserirAluno.setString(13, aluno.getObservacao());
                inserirAluno.setString(14, aluno.getNomePai());
                inserirAluno.setString(15, aluno.getProfissaoPai());
                inserirAluno.setString(16, aluno.getNomeMae());
                inserirAluno.setString(17, aluno.getProfissaoMae());
                inserirAluno.setString(18, aluno.getSerie());
                inserirAluno.setString(19, aluno.getModalidade());
                inserirAluno.setString(20, aluno.getTurma());
                inserirAluno.setString(21, aluno.getEmail());
                inserirAluno.setString(22, aluno.getTransporteEscolar());
                inserirAluno.setString(23, aluno.getLocalidade());
                
                inserirAluno.execute();
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                conexaoBD.fecharConexao(con, inserirAluno);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }   
        }
    }
    public void inserirDadosComplementares(infoAlunos aluno){
        if(aluno != null){
            String INSERIR_ALUNO = "insert into dados_complementares (nome_responsavel, parentesco, endereco_responsavel, municipio_responsavel, uf_responsavel, cep_responsavel, telefone_responsavel, email_responsavel, nome_escola_anterior, municipio_anterior, uf_anterior, cep_anterior, anoLetivo_anterior, serie_anterior, observacao_escolar, id_aluno) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = null;
            
            try {
                con = conexaoBD.getConexao();
                PreparedStatement inserirAluno;
                inserirAluno = con.prepareStatement(INSERIR_ALUNO);
                
                
                inserirAluno.setString(1, aluno.getNomeResponsavel());
                inserirAluno.setString(2, aluno.getParentesco());
                inserirAluno.setString(3, aluno.getEnderecoResponsavel());
                inserirAluno.setString(4, aluno.getMunicipio());
                inserirAluno.setString(5, aluno.getUf());
                inserirAluno.setString(6, aluno.getCep());
                inserirAluno.setString(7, aluno.getTelefone());
                inserirAluno.setString(8, aluno.getEmailParentesco());
                inserirAluno.setString(9, aluno.getEscolaAnterior());
                inserirAluno.setString(10, aluno.getMunicipioAnterior());
                inserirAluno.setString(11, aluno.getUfAnterior());
                inserirAluno.setString(12, aluno.getCepAnterior());
                inserirAluno.setString(13, aluno.getAnoLetivoAnterior());
                inserirAluno.setString(14, aluno.getSerieAnterior());
                inserirAluno.setString(15, aluno.getObservacaoAnterior());
                inserirAluno.setInt(16, aluno.getIdAluno());
                
                inserirAluno.execute();
                
                conexaoBD.fecharConexao(con, inserirAluno);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }   
        }
    }
    
    public void inserirProfessor(Professor professor){
        if(professor != null){
            String INSERIR_PROFESSOR = "insert into professores (nome_professor, formacao_professor, cpf_professor, rg_professor, endereco_professor, telefone_professor, email_professor, cargaHoraria_professor) values (?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = null;
            
            try {
                con = conexaoBD.getConexao();
                PreparedStatement inserirProfessor;
                inserirProfessor = con.prepareStatement(INSERIR_PROFESSOR);
                //dados do do professor
                inserirProfessor.setString(1, professor.getNomeProfessor());
                inserirProfessor.setString(2, professor.getFormacaoProfessor());
                inserirProfessor.setString(3, professor.getCpfProfessor());
                inserirProfessor.setString(4, professor.getRgProfessor());
                inserirProfessor.setString(5, professor.getEnderecoProfessor());
                inserirProfessor.setString(6, professor.getTelefoneProfessor());
                inserirProfessor.setString(7, professor.getEmailProfessor());
                inserirProfessor.setString(8, professor.getCargaHorariaProfessor());
                
                inserirProfessor.execute();
                JOptionPane.showMessageDialog(null, "Professor Adicionado com sucesso.");
                conexaoBD.fecharConexao(con, inserirProfessor);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }   
        }
    }
    
   
   //Metodo para pesquisar alunos a partir do ID. 
    public List<infoAlunos> pesquisarAluno(int filtro) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String LISTAR = "select *from dados_aluno inner join dados_complementares on dados_aluno.id_bolsafamilia = dados_complementares.id_aluno where dados_aluno.id_bolsafamilia = ?" ;
        ArrayList<infoAlunos> contatos = new ArrayList<infoAlunos>();
        try {
            conn = conexaoBD.getConexao();
            pstm = conn.prepareStatement(LISTAR);
            pstm.setInt(1, filtro);
            rs = pstm.executeQuery();
            while (rs.next()) {
                infoAlunos aluno = new infoAlunos();
              
                
                aluno.setNome(rs.getString("nome_aluno"));
                aluno.setData_nasci(rs.getDate("data_nascimento"));
                aluno.setSexo(rs.getString("sexo_aluno"));
                aluno.setNaturalidade(rs.getString("naturalidade_aluno"));
                aluno.setEstadoCivil(rs.getString("estado_civil"));
                aluno.setCpf(rs.getString("cpf_aluno"));
                aluno.setRg(rs.getString("rg_aluno"));
                aluno.setId(rs.getInt("id_bolsafamilia"));
                aluno.setBolsaF(rs.getString("bolsa_familia"));
                aluno.setNumeroSUS(rs.getString("numero_sus"));
                aluno.setFardamento(rs.getString("fardamento"));
                aluno.setRestricaoAlimentar(rs.getString("restricao_alimentar"));
                aluno.setObservacao(rs.getString("observacao"));
                aluno.setNomePai(rs.getString("nome_pai"));
                aluno.setProfissaoPai(rs.getString("profissao_pai"));
                aluno.setNomeMae(rs.getString("nome_mae"));
                aluno.setProfissaoMae(rs.getString("profissao_mae"));
                aluno.setSerie(rs.getString("serie"));
                aluno.setModalidade(rs.getString("modalidade"));
                aluno.setTurma(rs.getString("turma"));
                aluno.setEmail(rs.getString("email"));
                aluno.setTransporteEscolar(rs.getString("transporte_publico"));
                aluno.setLocalidade(rs.getString("localidade"));
                
                
                aluno.setNomeResponsavel(rs.getString("nome_responsavel"));
                aluno.setParentesco(rs.getString("parentesco"));
                aluno.setEnderecoResponsavel(rs.getString("endereco_responsavel"));
                aluno.setMunicipio(rs.getString("municipio_responsavel"));
                aluno.setUf(rs.getString("uf_responsavel"));
                aluno.setCep(rs.getString("cep_responsavel"));
                aluno.setTelefone(rs.getString("telefone_Responsavel"));
                aluno.setEmailParentesco(rs.getString("email_responsavel"));
                
                aluno.setEscolaAnterior(rs.getString("nome_escola_anterior"));
                aluno.setMunicipioAnterior(rs.getString("municipio_anterior"));
                aluno.setUfAnterior(rs.getString("uf_anterior"));
                aluno.setCepAnterior(rs.getString("cep_anterior"));
                aluno.setAnoLetivoAnterior(rs.getString("anoLetivo_anterior"));
                aluno.setSerieAnterior(rs.getString("serie_anterior"));
                aluno.setObservacaoAnterior(rs.getString("observacao_escolar"));
                
                        
                contatos.add(aluno);
            }
            conexaoBD.fecharConexao(conn, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos: " + e.getMessage());
        }
        return contatos;
    }
    
    //Pesquisar alunos a partir da Série.
    public List<infoAlunos> listarComFiltro(String filtro) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String LISTAR = "select *from dados_aluno where serie ILIKE ?";
        ArrayList<infoAlunos> contatos = new ArrayList<infoAlunos>();
        try {
            conn = conexaoBD.getConexao();
            pstm = conn.prepareStatement(LISTAR);
            pstm.setString(1, "%"+filtro+"%");
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                infoAlunos aluno = new infoAlunos();
              
                aluno.setCodigo_aluno(rs.getInt("codigo_aluno"));
                aluno.setNome(rs.getString("nome_aluno"));
                aluno.setTurma(rs.getString("turma"));
                
                contatos.add(aluno);
            }
            conexaoBD.fecharConexao(conn, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos: " + e.getMessage());
        }
        return contatos;
    }
    
    public List<infoAlunos> gerarRelatorio(int filtro) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String LISTAR = "select *from dados_aluno inner join dados_complementares on dados_aluno.id_bolsafamilia = dados_complementares.id_aluno where dados_aluno.id_bolsafamilia = ?" ;
        ArrayList<infoAlunos> contatos = new ArrayList<infoAlunos>();
        try {
            conn = conexaoBD.getConexao();
            pstm = conn.prepareStatement(LISTAR);
            pstm.setInt(1, filtro);
            rs = pstm.executeQuery();
            while (rs.next()) {
                infoAlunos aluno = new infoAlunos();
              
                
                aluno.setNome(rs.getString("nome_aluno"));
                aluno.setData_nasci(rs.getDate("data_nascimento"));
                aluno.setSexo(rs.getString("sexo_aluno"));
                aluno.setNaturalidade(rs.getString("naturalidade_aluno"));
                aluno.setEstadoCivil(rs.getString("estado_civil"));
                aluno.setCpf(rs.getString("cpf_aluno"));
                aluno.setRg(rs.getString("rg_aluno"));
                aluno.setId(rs.getInt("id_bolsafamilia"));
                aluno.setBolsaF(rs.getString("bolsa_familia"));
                aluno.setNumeroSUS(rs.getString("numero_sus"));
                aluno.setFardamento(rs.getString("fardamento"));
                aluno.setRestricaoAlimentar(rs.getString("restricao_alimentar"));
                aluno.setObservacao(rs.getString("observacao"));
                aluno.setNomePai(rs.getString("nome_pai"));
                aluno.setProfissaoPai(rs.getString("profissao_pai"));
                aluno.setNomeMae(rs.getString("nome_mae"));
                aluno.setProfissaoMae(rs.getString("profissao_mae"));
                aluno.setSerie(rs.getString("serie"));
                aluno.setModalidade(rs.getString("modalidade"));
                aluno.setTurma(rs.getString("turma"));
                aluno.setEmail(rs.getString("email"));
                aluno.setTransporteEscolar(rs.getString("transporte_publico"));
                aluno.setLocalidade(rs.getString("localidade"));
                
                
                aluno.setNomeResponsavel(rs.getString("nome_responsavel"));
                aluno.setParentesco(rs.getString("parentesco"));
                aluno.setMunicipio(rs.getString("municipio_responsavel"));
                aluno.setUf(rs.getString("uf_responsavel"));
                aluno.setCep(rs.getString("cep_responsavel"));
                aluno.setTelefone(rs.getString("telefone_Responsavel"));
                aluno.setEmailParentesco(rs.getString("email_responsavel"));
                
                aluno.setEscolaAnterior(rs.getString("nome_escola_anterior"));
                aluno.setMunicipioAnterior(rs.getString("municipio_anterior"));
                aluno.setUfAnterior(rs.getString("uf_anterior"));
                aluno.setCepAnterior(rs.getString("cep_anterior"));
                aluno.setAnoLetivoAnterior(rs.getString("anoLetivo_anterior"));
                aluno.setSerieAnterior(rs.getString("serie_anterior"));
                aluno.setObservacaoAnterior(rs.getString("observacao_escolar"));
                
                        
                contatos.add(aluno);
            }
            conexaoBD.fecharConexao(conn, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos: " + e.getMessage());
        }
        return contatos;
    }
}

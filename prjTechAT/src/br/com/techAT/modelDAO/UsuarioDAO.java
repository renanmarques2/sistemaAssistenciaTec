package br.com.techAT.modelDAO;

/**
 *
 * @author Renan Marques
 */
public class UsuarioDAO {
    private int idusuario;
    private String usuario;
    private String celusuario;
    private String loginsusuario;
    private String senhausuario;
    private String perfil;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCelusuario() {
        return celusuario;
    }

    public void setCelusuario(String celusuario) {
        this.celusuario = celusuario;
    }

    public String getLoginsusuario() {
        return loginsusuario;
    }

    public void setLoginsusuario(String loginsusuario) {
        this.loginsusuario = loginsusuario;
    }

    public String getSenhausuario() {
        return senhausuario;
    }

    public void setSenhausuario(String senhausuario) {
        this.senhausuario = senhausuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import modelo.Usuario;
import persistencia.UsuarioDAO;

/**
 *
 * @author lucas
 */
public class LUCAO {
    
    public static void main(String[] args) {
   
        Usuario u = new Usuario("Ayrton","universidadeBOLSONARO","ayrton123@hotmail.com","bolsominion");
        UsuarioDAO ur = new UsuarioDAO();
        if(ur.insertUsuario(u)){
            System.out.println("salvou");
        }else{
            System.out.println("nao salvoupa");
        }
        
    }
}

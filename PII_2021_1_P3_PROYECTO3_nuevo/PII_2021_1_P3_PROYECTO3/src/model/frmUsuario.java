package model;

import Usuarios.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import personal.Empleado;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmUsuario {

    public JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JLabel lblTitulo;
    private JPanel jpaDerecho;
    private JTextField txtId;
    private JTextField txtNombreUsuario;
    private JTextField txtContraseña;
    private JTextField txtEdad;
    private JTextField txtEstado;
    private JTextField txtDescripcion;
    private JLabel lblNombreUsuario;
    private JLabel lblContraseña;
    private JLabel lblEdad;
    private JLabel lblEstado;
    private JLabel lblDescripcion;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnDelete;
    private JButton btnPut;
    private JButton btnGetAll;
    private JLabel lblId;
    private JPanel jpaInferior;
    private JTable tblDatos;


    public frmUsuario() {
        btnGetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    java.util.List<Usuario> data = new Gson().fromJson(responseJson,new TypeToken<List<Usuario>>(){}.getType());

                    TablaUsuario datos = new TablaUsuario(data);
                    tblDatos.setModel(datos);

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.get(0).getid());
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });

                btnPost.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Client client= ClientBuilder.newClient();

                            WebTarget target = client.target(URL + "/addUsuario");

                            Invocation.Builder solicitud =target.request();
                            Usuario usuario = new Usuario();
                            usuario.setnombreUsuario(txtNombreUsuario.getText());
                            usuario.setcontraseña(Long.parseLong(txtContraseña.getText()));
                            usuario.setedad(Integer.parseInt(txtEdad.getText()));
                            usuario.setestado(txtEstado.getText());
                            usuario.setdescripcion(txtDescripcion.getText());

                            Gson gson = new Gson();
                            String jsonString = gson.toJson(usuario);

                            Response post = solicitud.post(Entity.json(jsonString));


                            String responseJson = post.readEntity(String.class);
                            Usuario data = new Gson().fromJson(responseJson, Usuario.class);
                            res = data.getnombreUsuario();


                            JOptionPane.showMessageDialog(null,"Mensaje del servidor: " + post.getStatus());

                            switch (post.getStatus()) {
                                case 201:
                                    res = data.getnombreUsuario();
                                    break;
                                default:
                                    res = "Error";
                                    break;
                            }
                        }catch(Exception e1){
                            res = e1.toString();
                            JOptionPane.showMessageDialog(null,"Error después del catch" + res);
                        }
            }
        });


        btnGetId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();
                    String idUsuario = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idUsuario);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                 Usuario data = new Gson().fromJson(responseJson, Usuario.class);

                    res = data.getDataUsuario();

                    JOptionPane.showMessageDialog(null, res);

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.getid());
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
            }
        });


        btnPut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    Invocation.Builder solicitud =target.request();

                    Usuario usuario = new Usuario();
                    usuario.setid(Long.parseLong(txtId.getText()));
                    usuario.setnombreUsuario(txtNombreUsuario.getText());
                    usuario.setcontraseña(Long.parseLong(txtContraseña.getText()));
                    usuario.setedad(Integer.parseInt(txtEdad.getText()));
                    usuario.setestado(txtEstado.getText());
                    usuario.setdescripcion(txtDescripcion.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(usuario);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Usuario data = new Gson().fromJson(responseJson, Usuario.class);

                    res = data.getnombreUsuario();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getnombreUsuario();
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();
                    String idUsuario = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/" + idUsuario);

                    //Invocation.Builder solicitud =target.queryParam("id",4).request();
                    Invocation.Builder solicitud =target.request();

                    Response delete = solicitud.delete();

                    String responseJson = delete.readEntity(String.class);

                    JOptionPane.showMessageDialog(null,delete.getStatus());

                    switch (delete.getStatus()) {
                        case 200:
                            res = "Delete";
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });
    }


    private void createUIComponents() {
             jpaPrincipal = new FondoPanel();
             jpaDerecho = new FondoPanel ();
    }
    class Index extends javax.swing.JFrame
    {
        FondoPanel fondo = new FondoPanel();
        public Index()
        {   this.setContentPane(fondo);
            frameInit();

        }
    }
     class FondoPanel extends JPanel
    {
        private Image imagen;
        public void paint (Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/imagenes/Usuario.jpeg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/usuario";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("USUARIOS" );
        frame1.setContentPane(new frmUsuario().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
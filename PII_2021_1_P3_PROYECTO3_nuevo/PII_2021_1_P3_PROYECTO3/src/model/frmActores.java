package model;


import Actores.actores;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class frmActores{
    public JPanel jpaPrincipal;
    private JLabel lblTitulo;
    private JPanel jpaSuperior;
    private JPanel jpaIzquierdo;
    private JLabel lblId;
    private JPanel jpaDerecho;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtAlias;
    private JTextField txtGenerosInterpretados;
    private JTextField txtNacionalidad;
    private JTextField txtSexo;
    private JTextField txtfechaNacimiento;
    private JTextField txtCantidadPeliculasGrabadas;
    private JLabel lblNombre;
    private JLabel lblGeneros;
    private JLabel lblNacionalidad;
    private JLabel lblSexo;
    private JLabel lblfechaNacimiento;
    private JLabel lblCantidadPeliculasGrabadas;
    private JPanel jpaInferior;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnDelete;
    private JButton btnPut;
    private JButton btnGetAll;
    private JTable tblDatos;
    private JLabel lblAlias;

    public frmActores() {
        btnPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/addActor");

                    Invocation.Builder solicitud =target.request();
                    actores actor = new actores();
                    //actor.setId(Long.parseLong(txtId.getText()));
                    actor.setNombreActor(txtNombre.getText());
                    actor.setAlias(txtAlias.getText());
                    actor.setNacionalidad(txtNacionalidad.getText());
                    //2021-04-16
                    //DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    //LocalDate date = LocalDate.parse(txtfechaNacimiento.getText(), formato);
                    actor.setFechaNacimiento(txtfechaNacimiento.getText());

                    actor.setSexo(txtSexo.getText());
                    actor.setCantidadPeliculasGrabadas(Integer.parseInt(txtCantidadPeliculasGrabadas.getText()));
                    actor.setGenerosInterpretados(txtGenerosInterpretados.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(actor);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    actores data = new Gson().fromJson(responseJson, actores.class);
                    res = data.getNombreActor();


                    JOptionPane.showMessageDialog(null,"Mensaje del servidor: " + post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getNombreActor();
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e1.toString();
                    JOptionPane.showMessageDialog(null,"Error después del catch" + res);
                }
                /*finally {
                    JOptionPane.showMessageDialog(null,"Error después del catch" + res);
                }*/
            }
        });

        btnGetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("sss");
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();
                    System.out.println(get.toString());

                    String responseJson = get.readEntity(String.class);

                    java.util.List<actores> data = new Gson().fromJson(responseJson,new TypeToken<List<actores>>(){}.getType());

                    //res = data.get(0).getNombreActor();
                    // res = data.toString();

                     TablaActores datos = new TablaActores(data);
                     tblDatos.setModel(datos);

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.get(0).getId());
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
                    actores actor = new actores();
                    actor.setId(Long.parseLong(txtId.getText()));
                    actor.setNombreActor(txtNombre.getText());
                    actor.setAlias(txtAlias.getText());
                    actor.setNacionalidad(txtNacionalidad.getText());
                    actor.setFechaNacimiento(txtfechaNacimiento.getText());
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    actor.setSexo(txtSexo.getText());
                    actor.setCantidadPeliculasGrabadas(Integer.parseInt(txtCantidadPeliculasGrabadas.getText()));
                    actor.setGenerosInterpretados(txtGenerosInterpretados.getText());


                    Gson gson = new Gson();
                    String jsonString = gson.toJson(actor);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    actores data = new Gson().fromJson(responseJson, actores.class);

                    res = data.getNombreActor();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getNombreActor();
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

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();
                    String idActores = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/" + idActores);

                    //Invocation.Builder solicitud =target.queryParam("id").request();
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
        btnGetId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();
                    String idActor = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idActor);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    actores data = new Gson().fromJson(responseJson, actores.class);

                    res = data.getDataActores();

                    JOptionPane.showMessageDialog(null, res);

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.getId());
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
    }

    private void createUIComponents() {
        jpaPrincipal = new FondoPanel();
        jpaIzquierdo = new FondoPanel();
        jpaDerecho   = new FondoPanel();
    }
    public class Index extends javax.swing.JFrame
    {     FondoPanel fondo = new FondoPanel();
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
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondA.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/actor";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Actores");
        frame1.setContentPane(new frmActores().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);



    }
}

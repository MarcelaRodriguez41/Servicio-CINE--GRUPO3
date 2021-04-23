package model;


import Actores.actores;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import horario.Horarios;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class frmHorarios {
    public JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JLabel lblTitulo;
    private JTextField txtId;
    private JTextField txtHoraInicio;
    private JTextField txtHoraFinal;
    private JTextField txtNombrePelicula;
    private JTextField txtFecha;
    private JLabel lblId;
    private JLabel lblHoraInicio;
    private JLabel lblHoraFinal;
    private JLabel lblNombrePelicula;
    private JLabel lblFecha;
    private JButton btnDelete;
    private JButton btnPut;
    private JButton btnGetId;
    private JButton btnPost;
    private JButton btnGetAll;
    private JPanel jpaInferior;
    private JTable tblDatos;

    public frmHorarios() {
        btnGetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();
                    System.out.println(get.toString());

                    String responseJson = get.readEntity(String.class);

                    java.util.List<Horarios> data = new Gson().fromJson(responseJson,new TypeToken<List<Horarios>>(){}.getType());



                    TablaHorarios datos = new TablaHorarios(data);
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
                    res = e1.toString();
                }

            }
        });

        btnPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/addHorario");

                    Invocation.Builder solicitud =target.request();
                    Horarios horarios = new Horarios();
                   horarios.setHoraInicio(txtHoraInicio.getText());
                   horarios.setHoraFinal(txtHoraFinal.getText());
                   horarios.setNombrePelicula(txtNombrePelicula.getText());
                   horarios.setFecha(txtFecha.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(horarios);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Horarios data = new Gson().fromJson(responseJson, Horarios.class);
                    res = data.getNombrePelicula();


                    JOptionPane.showMessageDialog(null,"Mensaje del servidor: " + post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getNombrePelicula();
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
                    String idHorario = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idHorario);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                   Horarios data = new Gson().fromJson(responseJson, Horarios.class);

                    res = data.getDataHorario();

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


        btnPut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    Invocation.Builder solicitud =target.request();
                    Horarios horarios = new Horarios();
                    horarios.setId(Long.parseLong(txtId.getText()));
                    horarios.setHoraInicio(txtHoraInicio.getText());
                    horarios.setHoraFinal(txtHoraFinal.getText());
                    horarios.setNombrePelicula(txtNombrePelicula.getText());
                    horarios.setFecha(txtFecha.getText());


                    Gson gson = new Gson();
                    String jsonString = gson.toJson(horarios);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Horarios data = new Gson().fromJson(responseJson, Horarios.class);

                    res = data.getNombrePelicula();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getNombrePelicula();
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
                    String idHorario = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/"+idHorario);

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
            imagen = new ImageIcon(getClass().getResource("/imagenes/Horarios.jpeg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/horario";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Horarios");
        frame1.setContentPane(new frmHorarios().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}

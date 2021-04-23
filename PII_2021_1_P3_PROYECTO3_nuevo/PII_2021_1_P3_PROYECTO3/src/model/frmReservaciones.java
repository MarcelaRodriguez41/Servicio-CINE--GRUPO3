package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import reservas.Reservaciones;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class frmReservaciones {
    public JPanel jpaPrincipal;
    private JLabel lblTitulo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JLabel lblId;
    private JTextField txtId;
    private JTextField txtNombreCliente;
    private JTextField txtNombreEmpleado;
    private JTextField txtFecha;
    private JTextField txtNombrePelicula;
    private JTextField txtHora;
    private JLabel lblNombreCliente;
    private JLabel lblNombreEmpleado;
    private JLabel lblFecha;
    private JLabel lblNombrePelicula;
    private JLabel lblHora;
    private JButton btnGetAll;
    private JTable tblDatos;
    private JPanel jpaInferior;


    public frmReservaciones() {
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

                    java.util.List<Reservaciones> data = new Gson().fromJson(responseJson,new TypeToken<List<Reservaciones>>(){}.getType());

                    TablaReservacion datos = new TablaReservacion(data);
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

                    WebTarget target = client.target(URL + "/addReservacion");

                    Invocation.Builder solicitud =target.request();
                     Reservaciones reservaciones = new Reservaciones();
                     reservaciones.setnombreCliente(txtNombreCliente.getText());
                     reservaciones.setnombreEmpleado(txtNombreEmpleado.getText());
                    reservaciones.setnombrePelicula(txtNombrePelicula.getText());
                    reservaciones.setfecha(txtFecha.getText());
                    reservaciones.sethora(txtHora.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(reservaciones);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Reservaciones data = new Gson().fromJson(responseJson, Reservaciones.class);

                    res = data.getnombreCliente();


                    JOptionPane.showMessageDialog(null,"Mensaje del servidor: " + post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getnombreCliente();
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
                    String idReservacion = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idReservacion);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    Reservaciones data = new Gson().fromJson(responseJson, Reservaciones.class);

                    res = data.getDataReservacion();

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
                    Reservaciones reservaciones = new Reservaciones();
                    reservaciones.setnombreCliente(txtNombreCliente.getText());
                    reservaciones.setnombreEmpleado(txtNombreEmpleado.getText());
                    reservaciones.setnombrePelicula(txtNombrePelicula.getText());
                    reservaciones.setfecha(txtFecha.getText());
                    reservaciones.sethora(txtHora.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(reservaciones);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Reservaciones data = new Gson().fromJson(responseJson, Reservaciones.class);

                    res = data.getnombreCliente();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getnombreCliente();
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
                    String idReservacion = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/" + idReservacion);

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
            imagen = new ImageIcon(getClass().getResource("/imagenes/Reservaciones.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/reservacion";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Reservaciones" );
        frame1.setContentPane(new frmReservaciones().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}

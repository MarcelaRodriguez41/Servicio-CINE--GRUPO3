package model;

import Sucursales.Sucursales;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmSucursales {
    public JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JLabel lblTitulo;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JTextField txtId;
    private JLabel lblTelefono;
    private JTextField txtCorreo;
    private JTextField txtDireccion;
    private JTextField txtCantidadEmpleados;
    private JLabel lblCorreo;
    private JLabel lblDireccion;
    private JTextField txtTelefono;
    private JLabel lblCantidadEmpleados;
    private JTextField txtCantidadSalas;
    private JLabel lblCantidadSalas;
    private JButton btnGetAll;
    private JLabel lblId;
    private JTextField textField1;
    private JTable tblDatos;

    public frmSucursales() {
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

                    java.util.List<Sucursales> data = new Gson().fromJson(responseJson,new TypeToken<List<Sucursales>>(){}.getType());

                    TablaSucursal datos = new TablaSucursal(data);
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

                    WebTarget target = client.target(URL + "/addSucursal");

                    Invocation.Builder solicitud =target.request();
                     Sucursales sucursales = new Sucursales();
                    sucursales.settelefono(Long.parseLong(txtTelefono.getText()));
                    sucursales.setcorreo(txtCorreo.getText());
                    sucursales.setdireccion(txtDireccion.getText());
                    sucursales.setcantidadEmpleados(Integer.parseInt(txtCantidadEmpleados.getText()));
                    sucursales.setcantidadSalas(Integer.parseInt(txtCantidadSalas.getText()));

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(sucursales);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Sucursales data = new Gson().fromJson(responseJson, Sucursales.class);

                    res = data.getdireccion();

                    JOptionPane.showMessageDialog(null,"Mensaje del servidor: " + post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getdireccion();
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
                    String idSucursal = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idSucursal);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    Sucursales data = new Gson().fromJson(responseJson, Sucursales.class);

                    res = data.getDataSucursal();

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
                    Sucursales sucursales = new Sucursales();
                    sucursales.setid(Long.parseLong(txtId.getText()));
                    sucursales.settelefono(Long.parseLong(txtTelefono.getText()));
                    sucursales.setcorreo(txtCorreo.getText());
                    sucursales.setdireccion(txtDireccion.getText());
                    sucursales.setcantidadEmpleados(Integer.parseInt(txtCantidadEmpleados.getText()));
                    sucursales.setcantidadSalas(Integer.parseInt(txtCantidadSalas.getText()));


                    Gson gson = new Gson();
                    String jsonString = gson.toJson(sucursales);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Sucursales data = new Gson().fromJson(responseJson, Sucursales.class);

                    res = data.getdireccion();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getdireccion();
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
                    String idSucursal = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/" + idSucursal);

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
        jpaDerecho =   new FondoPanel();

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
            imagen = new ImageIcon(getClass().getResource("/imagenes/Sucursales.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/sucursal" ;
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Sucursales" );
        frame1.setContentPane(new frmSucursales().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}

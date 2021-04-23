package model;

import Actores.actores;
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

public class frmEmpleado {
    public JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JLabel lblTitulo;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JTextField txtCodigo;
    private JTextField txtCelular;
    private JTextField txtCorreo;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JLabel lblCodigo;
    private JLabel lblCelular;
    private JLabel lblCorreo;
    private JLabel lblNombre;
    private JLabel lblDireccion;
    private JButton btnGetAll;
    private JTextField textField1;
    private JLabel lblId;
    private JTextField txtId;
    private JTable tblDatos;
    private JPanel jpaInferior;


    public frmEmpleado() {
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

                    java.util.List<Empleado> data = new Gson().fromJson(responseJson,new TypeToken<List<Empleado>>(){}.getType());

                    TablaEmpleados datos = new TablaEmpleados(data);
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

                    WebTarget target = client.target(URL + "/addEmpleado");

                    Invocation.Builder solicitud =target.request();
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    empleado.setCelular(Long.parseLong(txtCelular.getText()));
                    empleado.setCorreo(txtCorreo.getText());
                    empleado.setNombreEmpleado(txtNombre.getText());
                    empleado.setDireccion(txtDireccion.getText());


                    Gson gson = new Gson();
                    String jsonString = gson.toJson(empleado);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Empleado data = new Gson().fromJson(responseJson, Empleado.class);
                    res = data.getNombreEmpleado();


                    JOptionPane.showMessageDialog(null,"Mensaje del servidor: " + post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getNombreEmpleado();
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
                    String idEmpleado = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idEmpleado);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    Empleado data = new Gson().fromJson(responseJson, Empleado.class);

                    res = data.getDataEmpleado();

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
                    Empleado empleado = new Empleado();
                    empleado.setId(Long.parseLong(txtId.getText()));
                    empleado.setNombreEmpleado(txtNombre.getText());
                    empleado.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    empleado.setCelular(Long.parseLong(txtCelular.getText()));
                    empleado.setCorreo(txtCorreo.getText());
                    empleado.setDireccion(txtDireccion.getText());


                    Gson gson = new Gson();
                    String jsonString = gson.toJson(empleado);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Empleado data = new Gson().fromJson(responseJson, Empleado.class);

                    res = data.getNombreEmpleado();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getNombreEmpleado();
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
                    String idEmpleado = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/" + idEmpleado);

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
            imagen = new ImageIcon(getClass().getResource("/imagenes/clapeboardEMP.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/empleado";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("EMPLEADOS" );
        frame1.setContentPane(new frmEmpleado().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}

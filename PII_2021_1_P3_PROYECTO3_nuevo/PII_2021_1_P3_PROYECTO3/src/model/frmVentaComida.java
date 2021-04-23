package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import personal.Empleado;
import ventas.VentaComida;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmVentaComida {
    public JPanel jpaPrincipal;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JLabel lblTitulo;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblNombreCliente;
    private JTextField txtNombreCliente;
    private JLabel lblNombreEmpleado;
    private JTextField txtNombreEmpleado;
    private JLabel lblCantidadBoletos;
    private JTextField txtCantidadProducto;
    private JLabel lblNombreProducto;
    private JTextField txtNombreProducto;
    private JLabel lblPrecioProducto;
    private JTextField txtPrecioProducto;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JButton btnGetAll;
    private JTable tblDatos;
    private JPanel jpaInferior;

    public frmVentaComida() {
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

                    java.util.List<VentaComida> data = new Gson().fromJson(responseJson,new TypeToken<List<VentaComida>>(){}.getType());

                    TablaVentaComida datos = new TablaVentaComida(data);
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

                    WebTarget target = client.target(URL + "/addVentaComida");

                    Invocation.Builder solicitud =target.request();
                    VentaComida ventaComida = new VentaComida();
                    ventaComida.setnombreCliente(txtNombreCliente.getText());
                    ventaComida.setnombreEmpleado(txtNombreEmpleado.getText());
                    ventaComida.setnombreProducto(txtNombreProducto.getText());
                    ventaComida.setcantidadProducto(Integer.parseInt(txtCantidadProducto.getText()));
                    ventaComida.setprecioProducto(Integer.parseInt(txtPrecioProducto.getText()));

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(ventaComida);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    VentaComida data = new Gson().fromJson(responseJson, VentaComida.class);
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
                    String idComida = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idComida);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                   VentaComida data = new Gson().fromJson(responseJson, VentaComida.class);

                    res = data.getDataVentaComida();

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
                    VentaComida ventaComida = new VentaComida();
                    ventaComida.setnombreCliente(txtNombreCliente.getText());
                    ventaComida.setnombreEmpleado(txtNombreEmpleado.getText());
                    ventaComida.setnombreProducto(txtNombreProducto.getText());
                    ventaComida.setcantidadProducto(Integer.parseInt(txtCantidadProducto.getText()));
                    ventaComida.setprecioProducto(Integer.parseInt(txtPrecioProducto.getText()));
                    ventaComida.getid();

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(ventaComida);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                   VentaComida data = new Gson().fromJson(responseJson, VentaComida.class);

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
                    String idVentaComida = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/" + idVentaComida);

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
            imagen = new ImageIcon(getClass().getResource("/imagenes/VentaComida.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/ventacomida";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Venta de Comida" );
        frame1.setContentPane(new frmVentaComida().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}

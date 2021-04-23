package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import peliculas.Pelicula;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmPeliculas {
    public JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JLabel lblTitulo;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtSinopsis;
    private JTextField txtGenero;
    private JTextField txtNacionalidad;
    private JTextField txtDuracion;
    private JTextField txtDirector;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblSinposis;
    private JLabel lblGenero;
    private JLabel lblNacionalidad;
    private JLabel lblDuracion;
    private JLabel lblDirector;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JButton btnGetAll;
    private JTable tblDatos;


    public frmPeliculas() {
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

                    java.util.List<Pelicula> data = new Gson().fromJson(responseJson,new TypeToken<List<Pelicula>>(){}.getType());
                     TablaPeliculas datos = new TablaPeliculas(data);
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

        btnPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/addPelicula");

                    Invocation.Builder solicitud =target.request();
                    Pelicula pelicula = new Pelicula();
                    pelicula.setNombrePelicula(txtNombre.getText());
                    pelicula.setSinopsis(txtSinopsis.getText());
                    pelicula.setGenero(txtGenero.getText());
                    pelicula.setNacionalidad(txtNacionalidad.getText());
                    pelicula.setDuracion(txtDuracion.getText());
                    pelicula.setDirector(txtDirector.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(pelicula);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Pelicula data = new Gson().fromJson(responseJson, Pelicula.class);
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
                    String idPelicula = txtId.getText();
                    WebTarget target = client.target(URL + "/id/" + idPelicula);

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    Pelicula data = new Gson().fromJson(responseJson, Pelicula.class);

                    res = data.getDataPeliculas();

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

                    Pelicula pelicula = new Pelicula();
                    pelicula.setNombrePelicula(txtNombre.getText());
                    pelicula.setSinopsis(txtSinopsis.getText());
                    pelicula.setGenero(txtGenero.getText());
                    pelicula.setDuracion(txtDuracion.getText());
                    pelicula.setDirector(txtDirector.getText());
                    pelicula.setNacionalidad(txtNacionalidad.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(pelicula);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Pelicula data = new Gson().fromJson(responseJson, Pelicula.class);

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
                    String idPelicula = txtId.getText();
                    WebTarget target = client.target(URL + "/delete/" + idPelicula);

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
            imagen = new ImageIcon(getClass().getResource("/imagenes/Peliculas.jpeg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://localhost:8080/api/v1/pelicula";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Peliculas");
        frame1.setContentPane(new frmPeliculas().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}

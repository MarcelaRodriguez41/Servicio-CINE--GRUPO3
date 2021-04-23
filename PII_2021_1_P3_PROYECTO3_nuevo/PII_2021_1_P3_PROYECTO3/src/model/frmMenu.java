package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenu {
    private JPanel jpaPrincipal;
    private JButton btnEmpleados;
    private JButton btnActores;
    private JButton btnDirectores;
    private JButton btnSalas;
    private JButton btnGeneros;
    private JButton btnHorario;
    private JButton btnSucursales;
    private JButton btnReservaciones;
    private JButton btnPeliculas;
    private JButton btnUsuarios;
    private JButton btnSnacks;
    private JButton btnBoletos;
    private JLabel lblEmpleados;
    private JPanel jpaMenu;
    private JLabel lblActores;
    private JLabel lblDirectores;
    private JLabel lblSalas;
    private JLabel lblGeneros;
    private JLabel lblReservaciones;
    private JLabel lblSucursal;

    public frmMenu() {

        btnEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("EMPLEADOS" );
                frame2.setContentPane(new frmEmpleado().jpaPrincipal);
                frame2.setResizable(false);
                frame2.pack();
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        btnActores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new JFrame("Actores");
                frame3.setContentPane(new frmActores().jpaPrincipal);
                frame3.setResizable(false);
                frame3.pack();
                frame3.setLocationRelativeTo(null);
                frame3.setVisible(true);

            }
        });
        btnDirectores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new JFrame("Directores");
                frame4.setContentPane(new frmDirectores().jpaPrincipal);
                frame4.setResizable(false);
                frame4.pack();
                frame4.setLocationRelativeTo(null);
                frame4.setVisible(true);
            }
        });
        btnSalas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame5 = new JFrame("Salas");
                frame5.setContentPane(new frmSalas().jpaPrincipal);
                frame5.setResizable(false);
                frame5.pack();
                frame5.setLocationRelativeTo(null);
                frame5.setVisible(true);
            }
        });
        btnGeneros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame6 = new JFrame("Generos");
                frame6.setContentPane(new frmGeneros().jpaPrincipal);
                frame6.setResizable(false);
                frame6.pack();
                frame6.setLocationRelativeTo(null);
                frame6.setVisible(true);
            }
        });
        btnHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame7 = new JFrame("Horarios");
                frame7.setContentPane(new frmHorarios().jpaPrincipal);
                frame7.setResizable(false);
                frame7.pack();
                frame7.setLocationRelativeTo(null);
                frame7.setVisible(true);
            }
        });
        btnPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame8 = new JFrame("Peliculas");
                frame8.setContentPane(new frmPeliculas().jpaPrincipal);
                frame8.setResizable(false);
                frame8.pack();
                frame8.setLocationRelativeTo(null);
                frame8.setVisible(true);
            }
        });
        btnReservaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame9 = new JFrame("Reservaciones" );
                frame9.setContentPane(new frmReservaciones().jpaPrincipal);
                frame9.setResizable(false);
                frame9.pack();
                frame9.setLocationRelativeTo(null);
                frame9.setVisible(true);
            }
        });
        btnSucursales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame10  = new JFrame("Sucursales" );
                frame10.setContentPane(new frmSucursales().jpaPrincipal);
                frame10.setResizable(false);
                frame10.pack();
                frame10.setLocationRelativeTo(null);
                frame10.setVisible(true);
            }
        });
        btnUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame11 = new JFrame("USUARIOS" );
                frame11.setContentPane(new frmUsuario().jpaPrincipal);
                frame11.setResizable(false);
                frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame11.pack();
                frame11.setLocationRelativeTo(null);
                frame11.setVisible(true);
            }
        });
        btnSnacks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame12 = new JFrame("Venta de Comida" );
                frame12.setContentPane(new frmVentaComida().jpaPrincipal);
                frame12.setResizable(false);
                frame12.pack();
                frame12.setLocationRelativeTo(null);
                frame12.setVisible(true);
            }
        });
        btnBoletos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame13 = new JFrame("Venta de Boletos" );
                frame13.setContentPane(new frmVentaBoletos().jpaPrincipal);
                frame13.setResizable(false);
                frame13.pack();
                frame13.setLocationRelativeTo(null);
                frame13.setVisible(true);
            }
        });
    }


    private void createUIComponents() {

        jpaPrincipal = new FondoPanel();
jpaMenu = new FondoPanel();
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
            imagen = new ImageIcon(getClass().getResource("/imagenes/cinema.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Menu principal" );
        frame1.setContentPane(new frmMenu().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}

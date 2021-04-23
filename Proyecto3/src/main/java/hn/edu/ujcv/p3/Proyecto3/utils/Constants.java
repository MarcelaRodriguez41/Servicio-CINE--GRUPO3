package hn.edu.ujcv.p3.Proyecto3.utils;

public final class Constants {
    private static final String URL_API_BASE      = "/api";
    private static final String URL_API_VERSION   = "/v1";
    private static final String URL_BASE          = URL_API_BASE + URL_API_VERSION;
    public static final  String URL_BASE_ACTOR  = String.format("%s/actor",URL_BASE);
    public static final String URL_BASE_DIRECTOR = String.format("%s/director",URL_BASE);
    public static final String URL_BASE_SALA     = String.format("%s/sala",URL_BASE);
    public static final String URL_BASE_GENERO     = String.format("%s/genero",URL_BASE);
    public static final String URL_BASE_HORARIO     = String.format("%s/horario",URL_BASE);
    public static final String URL_BASE_PELICULA     = String.format("%s/pelicula",URL_BASE);
    public static final String URL_BASE_EMPLEADO    = String.format("%s/empleado",URL_BASE);
    public static final String URL_BASE_RESERVACION    = String.format("%s/reservacion",URL_BASE);
    public static final String URL_BASE_SUCURSAL  = String.format("%s/sucursal",URL_BASE);
    public static final String URL_BASE_USUARIO  = String.format("%s/usuario",URL_BASE);
    public static final String URL_BASE_VENTABOLETO  = String.format("%s/ventaboleto",URL_BASE);
    public static final String URL_BASE_VENTACOMIDA  = String.format("%s/ventacomida",URL_BASE);
}

package ldelpino.dateutils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Permite la conversion de objetos representados como fechas.
 * <p>
 * La clase está compuesta por un conjunto de métodos estáticos utiles para la
 * conversión de objetos representados como calendarios, fechas-horas, lineas de
 * tiempo, etc..., en otros objetos relacionados con fechas y horas. También
 * contiene métodos de conversion de objetos relacionados con las fechas y las
 * horas en cadenas de caracteres y viceversa entendibles a los usuarios.</p>
 *
 * <p>
 * Me falta documentacion Aqui.
 * </p>
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since JDK 1.8.281
 * @version 1.5.0
 */
public class DateUtils {

    /**
     * El patron por defecto para la conversion de fechas en cadenas de
     * caracteres.
     */
    public static String DEFAULT_DATE_PATTERN = "dd/MM/yyyy-HH/mm/ss";

    /**
     * El identificador de la zona horaria por defeto.
     */
    public static ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    /**
     * Establece el nuevo patron de fecha por defecto.
     *
     * @param newPattern el nuevo patron a establecer.
     */
    public static void setDefaultPattern(String newPattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(newPattern);
        DateFormat dateFormat = new SimpleDateFormat(newPattern, formatter.getLocale());
        DEFAULT_DATE_PATTERN = newPattern;
    }

    /**
     * Devuelve un objeto de formato de conversion de fechas de tipo
     * {@link java.time.LocalDateTime}
     *
     * @return la instancia del objeto de formato o nulo si el patron por
     * defecto es incorrecto o nulo.
     */
    public static DateTimeFormatter getDateTimeFormatter() {
        try {
            return DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
        }
        catch (IllegalArgumentException ex) {
        }
        return null;
    }

    /**
     * Devuelve un objeto de formato de conversion de fechas de tipo
     * {@link java.util.Date}.
     *
     * @return la instancia del objeto de formato o nulo si el patron por
     * defecto es incorrecto o nulo.
     */
    public static DateFormat getDateFormat() {
        try {
            return new SimpleDateFormat(DEFAULT_DATE_PATTERN, getDateTimeFormatter().getLocale());
        }
        catch (NullPointerException ex) {
        }
        return null;
    }

    /**
     * Convierte un objeto de tipo {@link java.time.LocalDateTime} en una cadena
     * de caracteres a partir de un patron dado.
     *
     * @param date la fecha a convertir en cadena de carcateres.
     * @param datePattern el patron a partir del cual realizar la conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalDateTime date, String datePattern) {
        if (date != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
                return formatter.format(date);
            }
            catch (IllegalArgumentException ex) {
            }
        }
        return null;
    }

    /**
     * Convierte un objeto de tipo {@link java.util.Date} en una cadena de
     * caracteres a partir de un patron dado.
     *
     * @param date la fecha a convertir en cadena de caracteres.
     * @param datePattern el patron a partir del cual realizar la conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Date date, String datePattern) {
        if (date != null) {
            try {
                DateFormat format = getDateFormat();
                return format.format(date);
            }
            catch (IllegalArgumentException ex) {
            }
        }
        return null;
    }

    /**
     * Convierte un objeto de tipo {@link java.util.Calendar} en una cadena de
     * caracteres a partir de un patron dado.
     *
     * @param date la fecha a convertir en cadena de caracteres.
     * @param datePattern el patron a partir del cual realizar la conversion.
     * @return la cadena de caracteres convertida a partir del patron dado, de
     * lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Calendar date, String datePattern) {
        return format(date.getTime(), datePattern);
    }

    /**
     * Convierte un objeto de tipo {@link java.time.LocalDateTime} en una cadena
     * de caracteres a partir del patron por defecto.
     *
     * @param date la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(LocalDateTime date) {
        return format(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte un objeto de tipo {@link java.util.Date} en una cadena de
     * caracteres a partir del patron por defecto.
     *
     * @param date la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Date date) {
        return format(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte un objeto de tipo {@link java.util.Calendar} en una cadena de
     * caracteres a partir del patron por defecto.
     *
     * @param date la fecha a convertir en cadena de caracteres.
     * @return la cadena de caracteres convertida a partir del patron por
     * defecto, de lo contrario devuelve <strong>null</strong>.
     */
    public static String format(Calendar date) {
        return format(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link java.time.LocalDateTime} a partir de un patron dado.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param datePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link java.time.LocalDateTime} si fue
     * convertido, de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalDateTime parseToLocalDateTime(String dateString, String datePattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            return formatter.parse(dateString, LocalDateTime::from);
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link java.util.Date} a partir de un patron dado.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param datePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link java.util.Date} si fue convertido, de lo
     * contrario devuelve <strong>null</strong>.
     */
    public static Date parseToDate(String dateString, String datePattern) {
        try {
            DateFormat format = new SimpleDateFormat(datePattern, getDateTimeFormatter().getLocale());
            return format.parse(dateString);
        }
        catch (ParseException ex) {
            return null;
        }
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link java.util.Calendar} a partir de un patron dado.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param datePattern el patron con el cual realizar la conversion.
     * @return el objeto de tipo {@link java.util.Calendar} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static Calendar parseToCalendar(String dateString, String datePattern) {
        return convertFromDateToCalendar(parseToDate(dateString, datePattern));
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link java.time.LocalDateTime} a partir del patron por defecto.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link java.time.LocalDateTime} si fue
     * convertido, de lo contrario devuelve <strong>null</strong>.
     */
    public static LocalDateTime parseToLocalDateTime(String dateString) {
        return parseToLocalDateTime(dateString, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link java.util.Date} a partir del patron por defecto.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link java.util.Date} si fue convertido, de lo
     * contrario devuelve <strong>null</strong>.
     */
    public static Date parseToDate(String dateString) {
        return parseToDate(dateString, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * de tipo {@link java.util.Calendar} a partir del patron por defecto.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto de tipo {@link java.util.Calendar} si fue convertido,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public static Calendar parseToCalendar(String dateString) {
        return parseToCalendar(dateString, DEFAULT_DATE_PATTERN);
    }

    /**
     * Establece si una cadena de caracteres que representa una fecha, es valida
     * con un patron dado.
     *
     * @param dateString la cadena de caracteres que representa una fecha.
     * @param datePattern el patron a partir del cual esta organizada la cadena
     * de caracteres.
     * @return <strong>true</strong> si la cadena de carcateres es una cadena
     * valida a partir del patron dado, de lo contrario devuelve
     * <strong>false</strong>.
     */
    public static boolean validDate(String dateString, String datePattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        if (formatter != null) {
            return formatter.parse(dateString) != null;
        }
        return false;
    }

    /**
     * Establece si una cadena de caracteres que representa una fecha, es valida
     * a partir del patron por defecto.
     *
     * @param dateString la cadena de caracteres que representa una fecha.
     * @return <strong>true</strong> si la cadena de carcateres es una cadena
     * valida a partir del patron por defecto, de lo contrario devuelve
     * <strong>false</strong>.
     */
    public static boolean validDate(String dateString) {
        return validDate(dateString, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte un objeto de tipo LocalDateTime a un objecto de tipo Calendar.
     *
     * @param localDateTime el objeto de tipo LocalDateTime a convertir.
     * @return la instancia del objeto Calendar convertida desde LocalDateTime.
     */
    public static Calendar convertFromLocalDateTimeToCalendar(LocalDateTime localDateTime) {
        return GregorianCalendar.from(localDateTime.atZone(DEFAULT_ZONE_ID));
    }

    /**
     * Convierte un objeto de tipo Calendar a un objeto de tipo LocalDateTime.
     *
     * @param calendar la instancia del objeto Calendar a convertir.
     * @return la instancia del objeto LocalDateTime convertido desde Calendar.
     */
    public static LocalDateTime convertFromCalendarToLocalDate(Calendar calendar) {
        return calendar.toInstant().atZone(DEFAULT_ZONE_ID).toLocalDateTime();
    }

    /**
     * Convierte un objeto de tipo LocalDateTime en un objeto de tipo Date.
     *
     * @param localDateTime el objeto LocalDateTime a convertir.
     * @return el objeto Date convertido.
     */
    public static Date convertFromLocalDateToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(DEFAULT_ZONE_ID).toInstant());
    }

    /**
     * Convierte un objeto de tipo Date en un objeto de tipo LocalDateTime.
     *
     * @param date el objeto de tipo Date a convertir.
     * @return el objeto de tipo LocalDateTime convertido.
     */
    public static LocalDateTime convertFromDateToLocalDate(Date date) {
        return date.toInstant().atZone(DEFAULT_ZONE_ID).toLocalDateTime();
    }

    /**
     * Convierte un objeto de tipo Date en un objeto de tipo Calendar.
     *
     * @param date el objeto de tipo Date a convertir.
     * @return la instancia del objeto de tipo Calendar convertida.
     */
    public static Calendar convertFromDateToCalendar(Date date) {
        return GregorianCalendar.from(date.toInstant().atZone(DEFAULT_ZONE_ID));
    }
}

package ldelpino.date.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Permite la conversion de objetos representados como fechas.
 * <p>
 * La clase está compuesta por un conjunto de métodos estáticos utiles para la
 * conversión de objetos de fechas. También contiene métodos de validación de
 * cadenas de caracteres como fechas y la conversion hacia objetos fechas de las
 * mismas.</p>
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk 1.8
 * @version 1.0
 */
public class DateUtils {

    /**
     * El patron por defecto para la conversion de fechas en cadenas de
     * caracteres.
     */
    public static String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";

    /**
     * Establece el nuevo patron de fecha por defecto.
     *
     * @param newPattern el nuevo patron a establecer.
     * @throws IllegalArgumentException si el nuevo patron a establecer no es un
     * patron correcto.
     */
    public static void setDefaultPattern(String newPattern) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(newPattern);
        if (formatter != null) {
            DEFAULT_DATE_PATTERN = newPattern;
        }
    }

    /**
     * Devuelve el objeto de formato de conversion de fechas.
     *
     * @return la instancia del objeto de formato.
     * @throws IllegalArgumentException
     */
    public static DateTimeFormatter getDateTimeFormatter() {
        try {
            return DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
        } catch (IllegalArgumentException ex) {
        }
        return null;
    }

    /**
     * Convierte un LocalDate en una cadena de caracteres a partir del patron
     * por defecto.
     *
     * @param date la fecha a convertir en cadena de carcateres.
     * @return la cadena de caracters convertida a partir del patron por
     * defecto, de lo contrario devuelve null.
     */
    public static String format(LocalDate date) {
        return format(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte un Calendar en una cadena de caracteres a partir del patron por
     * defecto.
     *
     * @param calendar la fecha a convertir en cadena de carcateres.
     * @return la cadena de caracters convertida a partir del patron por
     * defecto, de lo contrario devuelve null.
     */
    public static String format(Calendar calendar) {
        return format(calendar, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte un Calendar en una cadena de caracteres a partir de un patron
     * dado.
     *
     * @param date la fecha a convertir en cadena de carcateres.
     * @param datePattern el patron a partir del cual realizar la conversion.
     * @return la cadena de caracters convertida a partir del patron dado, de lo
     * contrario devuelve null.
     */
    public static String format(LocalDate date, String datePattern) {
        if (date == null) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            return formatter.format(date);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    /**
     * Convierte un LocalDate en una cadena de caracteres a partir de un patron
     * dado.
     *
     * @param calendar la fecha a convertir en cadena de carcateres.
     * @param datePattern el patron a partir del cual realizar la conversion.
     * @return la cadena de caracters convertida a partir del patron dado, de lo
     * contrario devuelve null.
     */
    public static String format(Calendar calendar, String datePattern) {
        if (calendar == null) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            return formatter.format(convertFromCalendarToLocalDate(calendar));
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * LocalDate a partir de el patron por defecto.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron por defecto.
     * @return el objeto LocalDate si fue convertido, de lo contrario devuelve
     * null.
     */
    public static LocalDate parse(String dateString) {
        return parse(dateString, DEFAULT_DATE_PATTERN);
    }

    /**
     * Convierte una cadena de caracteres que representa una fecha en un objeto
     * LocalDate a partir de un patron dado.
     *
     * @param dateString la cadena de caracteres que representa una fecha en
     * concreto, con el formato igual al patron dado.
     * @param datePattern el patron con el cual realizar la conversion.
     * @return el objeto LocalDate si fue convertido, de lo contrario devuelve
     * null.
     */
    public static LocalDate parse(String dateString, String datePattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
            return formatter.parse(dateString, LocalDate::from);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    /**
     * Establece si una cadena de caracteres que representa una fecha, es valida
     * con un patron dado.
     *
     * @param dateString la cadena de caracteres que representa una fecha.
     * @param datePattern el patron a partir del cual esta organizada la cadena
     * de caracteres.
     * @return true si la cadena de carcateres es una cadena valida a partir del
     * patron dado, de lo contrrio devuelve false.
     */
    public static boolean validDate(String dateString, String datePattern) {
        return DateUtils.parse(dateString, datePattern) != null;
    }

    /**
     * Establece si una cadena de caracteres que representa una fecha, es valida
     * con el patron por defecto.
     *
     * @param dateString la cadena de caracteres que representa una fecha.
     * @return true si la cadena de carcateres es una cadena valida a partir del
     * patron por defecto, de lo contrrio devuelve false.
     */
    public static boolean validDate(String dateString) {
        return DateUtils.parse(dateString, DEFAULT_DATE_PATTERN) != null;
    }

    /**
     * Convierte un bjeto de tio LocalDate en un objeto de tipo Date.
     *
     * @param localDate el objeto LocalDate a convertir.
     * @return el objeto Date convertido.
     */
    public static Date convertFromLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Convierte un objeto de tipo Date en un objeto de tipo LocalDate.
     *
     * @param date el objeto de tipo Date a convertir.
     * @return el objeto de tipo LocalDate convertido.
     */
    public static LocalDate convertFromDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Convierte un objeto de tipo LocalDate a un object de tipo Calendar.
     *
     * @param localDate el objeto de tipo LocalDate a convertir.
     * @return la instancia del objeto Calendar convertida desde LocalDate.
     */
    public static Calendar convertFromLocalDateToCalendar(LocalDate localDate) {
        return GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    }

    /**
     * Convierte un objeto de tipo Calendar a un objeto de tipo LocalDate.
     *
     * @param calendar la instancia del objeto Calendar a convertir.
     * @return la instancia del object LocalDate convertido desde Calendar.
     */
    public static LocalDate convertFromCalendarToLocalDate(Calendar calendar) {
        return calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

import java.util.Objects;

public class Time {
  private final int hours;
  private final int minutes;
  private final int seconds;

  private String transformada;

  public static final Time MIDNIGHT = new Time(0, 0, 0);
  public static final Time MIDDAY = new Time(12, 0, 0);

  public Time() {
    this.hours = 0;
    this.minutes = 0;
    this.seconds = 0;
  }

  public Time(int hours, int minutes) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = 0;
  }

  public Time(int hours, int minutes, int seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public int hours() {
    return this.hours;
  }

  public int minutes() {
    return this.minutes;
  }

  public int seconds() {
    return this.seconds;
  }

  public Time plus(Time obj) {
    Time segundo= plusSeconds(obj.seconds);
    Time minuto = plusMinutes(obj.minutes);
    Time hora = plusHours(obj.hours);
    int seconds = segundo.seconds;
    int minutes = minuto.minutes + (segundo.minutes-this.minutes);
    int hours = hora.hours + (minuto.hours-this.hours);

    return new Time(hours, minutes, seconds);
  }

  public Time plusHours(int hora) {
    int hours = this.hours;
    if(hora<0){
      return minusHours(hora*-1);
    }
    for (int i = hora; i > 0; i--) {
      if (hours == 24) {
        hours = 0;
      }
      hours++;
    }
    return new Time(hours, this.minutes, this.seconds);
  }

  public Time plusMinutes(int minuto) {
    int minutes = this.minutes;
    int hours = this.hours;
    if(minuto<0){
      return minusMinutes(minuto * -1);
    }
    for (int i = minuto; i > 0; i--) {
      if (minutes == 60) {
        minutes = 0;
        hours++;
      }
      minutes++;
    }
    return new Time(hours, minutes, this.seconds);
  }

  public Time plusSeconds(int segundo) {
    int seconds = this.seconds;
    int minutes = this.minutes;
    if (segundo<0) {
      return minusSeconds(segundo * -1);
    }
    for (int i = segundo; i > 0; i--) {
      if (seconds == 60) {
        seconds = 0;
        minutes++;
      }
      seconds++;
    }
    return new Time(this.hours, minutes, seconds);
  }

  public Time minus(Time obj) {
    Time segundo = minusSeconds(obj.seconds);
    Time minuto = minusMinutes(obj.minutes);
    Time hora = minusHours(obj.hours);
    int seconds = segundo.seconds;
    int minutes = minuto.minutes - (segundo.minutes-this.minutes);
    int hours = hora.hours - (minuto.hours-this.hours);

    return new Time(hours, minutes, seconds);
  }

  public Time minusHours(int hora) {
    int hours = this.hours;
    if (hora < 0) {
      return plusHours(hora * -1);
    }
    

    for (int i = hora; i > 0; i--) {
      if (hours == 0) {
        hours = 24;
      }
      hours--;
    }
    return new Time(hours, minutes, this.seconds);
  }

  public Time minusMinutes(int minuto) {
    int minutes = this.minutes;
    int hora = this.hours;
    if (minuto < 0) {
      return plusMinutes(minuto * -1);
    }
    

    for (int i = minuto; i > 0; i--) {
      if (minutes == 0) {
        minutes = 60;
        hora--;
      }
      minutes--;
    }
    return new Time(hora, minutes, this.seconds);
  }

  public Time minusSeconds(int segundo) {
    int seconds = this.seconds;
    int minuto = this.minutes;
    if (segundo < 0) {
      return plusSeconds(segundo * -1);
    }
    
    for (int i = segundo; i > 0; i--) {
      if (seconds == 0) {
        seconds = 60;
        minuto--;
      }
      seconds--;
    }
    return new Time(this.hours, minuto, seconds);
  }

  public boolean isMidDay() {
    return this.equals(MIDDAY);
  }

  public boolean isMidNight() {
    return this.equals(MIDNIGHT);
  }

  public Time shift() {
    return plusHours(12);
  }

  public Time tick() {
    return plusSeconds(1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Time time = (Time) o;
    return hours == time.hours && minutes == time.minutes && seconds == time.seconds;
  }

  @Override
  public int hashCode() {
    return Objects.hash(hours, minutes, seconds);
  }

  @Override
  public String toString() {
    String formatada;
    String hora = ""+this.hours;
    String minuto = ""+this.minutes;
    String segundo = ""+this.seconds;
    if(hours == 0){
      hora = "00";
    }
    if(hours<10){
      hora = "0"+hours;
    }
    if(minutes<10){
      minuto= "0"+minutes;
    }
    if(seconds<10){
      segundo = "0"+ seconds;
    }
    formatada = hora +":"+minuto+":"+segundo;
    return formatada;
  }

  public String toLongString() {
    String transformada;
    String hora;
    String minuto;
    String segundo;
    if (this.hours > 1) {
      hora = this.hours + " horas";
    } else {
      hora = this.hours + " hora";
    }
    if (this.minutes > 1) {
      minuto = this.minutes + " minutos";
    } else {
      minuto = this.minutes + " minuto";
    }
    if (this.seconds > 1) {
      segundo = this.seconds + " segundos";
    } else {
      segundo = this.seconds + " segundo";
    }
    if (this.seconds == 0 && this.minutes == 0) {
      return hora;
    }
    if (this.seconds == 0) {
      transformada = hora + " e " + minuto;
      return transformada;
    }
    transformada = hora + " " + minuto + " e " + segundo;
    return transformada;
  }

  public static Time fromString(String hora) {
    String[] vetString = hora.split(":");
    int hours = Integer.parseInt(vetString[0]);
    int minutes = Integer.parseInt(vetString[1]);
    int seconds = Integer.parseInt(vetString[2]);
    return new Time(hours, minutes, seconds);
  }

  public static Time fromDouble(Double hora) {
    int hours = (int) (hora * 1);
    int minutes = (int) ((hora - hours) * 60);
    int seconds = (int) ((((hora - hours) * 60) - minutes) * 60);
    hora =((((((hora - hours) * 60) - minutes) * 60) - seconds)*100);
    if(hora>95){
      seconds++;
    }
    return new Time(hours, minutes, seconds);

  }

  public static Time fromSeconds(int segundos) {
    int hours = segundos / (60 * 60);
    int minutes = (segundos - hours * (60 * 60)) / 60;
    int seconds = (segundos - (hours * (60 * 60) + (minutes * 60)));
    return new Time(hours, minutes, seconds);
  }

  public Double toDouble() {
    double hora = this.hours;
    double minuto = (double)this.minutes / 60;
    double segundo = (double)this.seconds / 3600;
    return hora+minuto+segundo;

  }

  public int toInt() {
    int horaI = this.hours * 3600 + this.minutes * 60 + this.seconds;
    return horaI;

  }

  public String toShortString() {
    if (hours == 0) {
      return "00h";
    }
    String hora = "" + this.hours;
    String minuto = "" + this.minutes;
    String segundo = "" + this.seconds;

    if (hours < 10) {
      if (hours == 0) {
        hora = "00";
      }else{
        hora = "0" + hours;
      }
    }
    if (minutes < 10) {
      if(minutes == 0){
        minuto = "00";
      }else{
        minuto = "0" + minutes;
      }
    }
    if (seconds < 10) {
      segundo = "0" + seconds;
    }

    if (this.seconds == 0 && this.minutes == 0) {
      return hora + "h";
    }
    if (this.seconds == 0) {
      transformada = hora + "h" + minuto + "m";
      return transformada;
    }
    transformada = hora + "h" + minuto + "m" + segundo + "s";
    return transformada;

  }

  public static Time from(Time other) {
    int hora =other.hours;
    int minutes = other.minutes;
    int segundo = other.seconds;
    return new Time(hora,minutes,segundo);
  }

}

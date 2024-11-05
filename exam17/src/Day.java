import java.util.GregorianCalendar;

public class Day {
  private int year = 1;
  private int month = 1;
  private int day = 1;

  private static final int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};

  public static boolean isLeap(int year){
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }
  public boolean isLeap(){
    return Day.isLeap(year);
  }

  public Day(){
    GregorianCalendar today = new GregorianCalendar();
    this.year = today.get(GregorianCalendar.YEAR);
    this.month = today.get(GregorianCalendar.MONTH) + 1;
    this.day = today.get(GregorianCalendar.DATE);
  }
  public Day(int year, int month, int day) {
    if(year == 0) year++;
    this.year = year;

    if(month < 1) month = 1;
    if(month > 12) month = 12;
    this.month = month;

    int maxDay = monthDays[month-1];
    if(month == 2 && isLeap(year)) maxDay += 1;
    if(day < 1) day = 1;
    if(day > maxDay) day = maxDay;
    this.day = day;
  }
  public Day(Day day){
    this(day.year, day.month, day.day);
  }

  public int dayOfYear(){
    int acc = 0;
    for(int i = 0; i < month-1; i++) acc += monthDays[i];
    if(month > 2 && this.isLeap()) acc ++;
    return acc + day;
  }
  public int dayLeft(){
    int left = 365 - dayOfYear();
    if(this.isLeap()) left ++;
    return left;
  }

  @Override
  public String toString() {
    return "Day{" +
      "year=" + year +
      ", month=" + month +
      ", day=" + day +
      '}';
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null) return false;
    if(obj.getClass() != this.getClass()) return false;
    return compare((Day)obj) == 0;
  }
  public static int compare(Day day1, Day day2){
    if(day1.year > day2.year) return 1;
    else if(day1.year < day2.year) return -1;

    if(day1.month > day2.month) return 1;
    else if(day1.month < day2.month) return -1;

    if(day1.day > day2.day) return 1;
    else if(day1.day < day2.day) return -1;

    return 0;
  }
  public int compare(Day day){
    // -1, 0, 1
    return compare(this,day);
  }

  public void toNextDay(){
    day += 1;
    int maxDay = monthDays[month];
    if(isLeap() && month == 2) maxDay+=1;
    if(day <= maxDay) return;

    day = 1;
    month += 1;
    if(month <= 12) return;

    month = 1;
    year += 1;
  }
  public void toPrevDay() {
    day -= 1;
    if (day > 0) return;
    month -= 1;
    if (month > 0) {
      day = monthDays[month];
      if (month == 2 && isLeap()) day++;
      return;
    }
    month = 12;
    year--;
  }
  public Day nextDay(int n){
    Day day = new Day(this);
    for(int i = 0; i < n; i++){
      day.toNextDay();
    }
    return day;
  }
  public Day nextDay(){
    return nextDay(1);
  }
  public Day prevDay(int n){
    Day day = new Day(this);
    for(int i = 0; i < n; i++){
      day.toPrevDay();
    }
    return day;
  }
  public Day prevDay(){
    return prevDay(1);
  }


  public static int dayDiff(Day day1, Day day2){
    if(day1.year > day2.year){
      return -dayDiff(day2, day1);
    }
    if(day1.year == day2.year){
      return day2.dayOfYear() - day1.dayOfYear();
    }

    int countLeap = 0;
    int d1 = day1.dayLeft();
    int d2 = day2.dayOfYear();
    int year = day1.year;
    int leapYear = year - year % 4 + 4;
    for(;leapYear < day2.year; leapYear+=4){
      System.out.println(leapYear + " " + (leapYear % 100 != 0 || leapYear % 400 == 0));
      if(leapYear % 100 != 0 || leapYear % 400 == 0) countLeap += 1;
    }
    return d1 + d2 + 365 * (day2.year - day1.year - 1) + countLeap;
  }
  public int dayDiff(Day day){
    return dayDiff(this, day);
  }

}

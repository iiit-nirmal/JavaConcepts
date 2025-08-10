package org.dsa.enums;

enum Week{

    // Enum is fixed set of constant instances
    MONDAY(false), TUESDAY(false),
    WEDNESDAY(false), THURSDAY(false),
    FRIDAY(false), SATURDAY(true),
    SUNDAY(true);

    private final boolean isWeekend;

    // Constructor is private (implicit)
    Week(boolean isWeekend){
        this.isWeekend = isWeekend;
    }

    //Getter
    public boolean isWeekend() {
        return isWeekend;
    }

    // next day
    public Week nextDay(){
        return values()[ (this.ordinal()+1 ) % values().length];
    }
    // next day
    public Week prevDay(){
        return values()[ (this.ordinal()-1 + values().length ) % values().length];
    }

    // Parse from string safely
    public static Week fromString(String day){
        return Week.valueOf(day.toUpperCase());
    }

}
// enum class is final can't be extended
//class EnumExtends extends  Week{ }

public class EnumDemo {
    public static void main(String... args){
        Week today = Week.MONDAY;
        System.out.println(today.ordinal());
        System.out.println(today);
        System.out.println(today.nextDay());
        System.out.println(today.prevDay());
        System.out.println(Week.fromString("friday"));
    }
}

package øving10.oppg1;

public class Arrangement {
    private int id;
    private String name;
    private String place;
    private String arranger;
    private String type;
    private long time; //YEARMMDDHRMN eks 201910031900


    public Arrangement(int id, String name, String place, String arranger, String type, long time) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.arranger = arranger;
        this.type = type;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getArranger() {
        return arranger;
    }

    public String getType() {
        return type;
    }

    public long getTime() {
        return time;
    }

}

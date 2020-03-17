package øving10.oppg1;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangementRegister {
    private Arrangement[] ArrList;


    public ArrangementRegister() {
        this.ArrList = new Arrangement[0];
    }

    public void NyArrangement(int id, String name, String place, String arranger, String type, long time) {
        this.ArrList = Arrays.copyOf(ArrList, ArrList.length + 1);
        ArrList[ArrList.length - 1] = new Arrangement(id, name, place, arranger, type, time);
    }

    public void SortByTime() {
        Arrays.sort(ArrList, new SortByTime());
    }

    public void SortByPlace() {
        Arrays.sort(ArrList, new SortByPlace());
    }

    public void SortByType() {
        Arrays.sort(ArrList, new SortByType());
    }

    public void ListOfPlace(String place) { //en komplisert binarySearch...
        SortByPlace();
        int firstIndex = 0;
        int lastIndex = ArrList.length;
        for (Arrangement o : ArrList) {
            if (o.getPlace().equalsIgnoreCase(place)) {
                break;
            } else firstIndex++;
        }
        int i = ArrList.length-1;
        while(i >= 0) {
            if (ArrList[i].getPlace().equalsIgnoreCase(place)) {
                break;
            } else lastIndex--;
            i--;
        }
        this.ArrList = Arrays.copyOfRange(ArrList, firstIndex, lastIndex);
    }

    public void ListOfDate(int date) {
        SortByTime();
        int firstIndex = 0;
        int lastIndex = ArrList.length;
        for (Arrangement o : ArrList) {
            if (String.valueOf(o.getTime()).substring(0,8).equals(String.valueOf(date))) {
                break;
            } else firstIndex++;
        }
        for (int i = ArrList.length-1; i >= 0; i--) {
            if (String.valueOf(ArrList[i].getTime()).substring(0,8).equals(String.valueOf(date))) {
                break;
            } else lastIndex--;
        }
        this.ArrList = Arrays.copyOfRange(ArrList, firstIndex, lastIndex);
    }

    public void ListOfDates(int fromDate, int toDate) {
        SortByTime();
        int firstIndex = 0;
        int lastIndex = ArrList.length;
        for (Arrangement o : ArrList) {
            if (String.valueOf(o.getTime()).substring(0,8).equals(String.valueOf(fromDate))) {
                break;
            } else firstIndex++;
        }
        for (int i = ArrList.length-1; i >= 0; i--) {
            if (String.valueOf(ArrList[i].getTime()).substring(0,8).equals(String.valueOf(toDate))) {
                break;
            } else lastIndex--;
        }
        this.ArrList = Arrays.copyOfRange(ArrList, firstIndex, lastIndex);
    }

    @Override
    public String toString() {
        String output = "";
        for (Arrangement s : ArrList) {
            output = output + s.getId() + " " + s.getName() + " " + s.getPlace() + " " + s.getType() + " " + s.getArranger() + " " + s.getTime() + "\n";
        }
        return output;
    }

}

class SortByTime implements Comparator<Arrangement> {
    @Override
    public int compare(Arrangement arr1, Arrangement arr2) {
        return (int) arr1.getTime() - (int) arr2.getTime();
    }
}

class SortByPlace implements Comparator<Arrangement> {
    @Override
    public int compare(Arrangement arr1, Arrangement arr2) {
        return arr1.getPlace().compareToIgnoreCase(arr2.getPlace());
    }
}

class SortByType implements Comparator<Arrangement> {
    @Override
    public int compare(Arrangement arr1, Arrangement arr2) {
        return arr1.getType().compareToIgnoreCase(arr2.getType());
    }
}



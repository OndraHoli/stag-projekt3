package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Obor {
    @SerializedName("eprDeadlinePrihlaska")
    public Deadline eprDeadlinePrihlaska;
    @SerializedName("programNazev")
    public String programNazev;

}

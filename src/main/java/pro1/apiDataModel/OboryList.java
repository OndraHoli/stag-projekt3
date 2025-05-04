package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OboryList {

    @SerializedName("prijimaciObor")
    public List<Obor> items;
}

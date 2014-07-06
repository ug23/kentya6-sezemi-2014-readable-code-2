
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        File CookData =
                new File("/Users/Yuji/kentya6-sezemi-2014-readable-code-2/CookData.json");
        FileReader CookDataReader = new FileReader(CookData);
        ArrayList<String> recipeList = new ArrayList<>();
        try {
            Object parseObject = parser.parse(CookDataReader);
            JSONObject jsonObject = (JSONObject) parseObject;
            recipeList = (ArrayList<String>) jsonObject.get("RecipeName");
            
            for (int i = 0; i < recipeList.size(); i++) {
                System.out.println(recipeList.get(i));
            }
        } catch (FileNotFoundException notfound) {
            System.out.println("ファイルが見つかりませんでした");
            notfound.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("入出力エラーです");
            ioe.printStackTrace();
        } catch (ParseException pe) {
            System.out.println("JSONが間違っています");
            pe.printStackTrace();
        }
    }
}

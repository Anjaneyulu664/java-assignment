import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class Q2_BitcoinAPI {

    static String convert(int num) {
        if (num == 0) return "Zero";

        String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};

        if (num < 20) return below20[num];
        if (num < 100) return tens[num / 10] + " " + below20[num % 10];
        if (num < 1000) return below20[num / 100] + " Hundred " + convert(num % 100);
        if (num < 100000) return convert(num / 1000) + " Thousand " + convert(num % 1000);
        if (num < 10000000) return convert(num / 100000) + " Lakh " + convert(num % 100000);

        return convert(num / 10000000) + " Crore " + convert(num % 10000000);
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=inr");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            JSONObject obj = new JSONObject(response.toString());
            int price = obj.getJSONObject("bitcoin").getInt("inr");

            System.out.println(price);
            System.out.println(convert(price));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
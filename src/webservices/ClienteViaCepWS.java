package webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import com.google.gson.Gson;

public class ClienteViaCepWS {

    public static String buscarCep(String cep) throws Exception {
      String json = null;

        try {
           String url = "http://viacep.com.br/ws/"+ cep +"/json";
           String url2 = "http://cep.republicavirtual.com.br/web_cep.php?"+"cep="+cep+"&formato=json";
          //  URLConnection urlConnection = url.openConnection();
         //   InputStream is = urlConnection.getInputStream();
        //    BufferedReader br = new BufferedReader(new InputStreamReader(is));


            
            JSONObject obj = new JSONObject(getHttpGET(url2));
            if (!obj.has("erro")) {
              //  Cep novoCEP = new Cep(obj.getString("cep"),
                //        obj.getString("logradouro"),
                //        obj.getString("complemento"),
                 //       obj.getString("bairro"),
                //        obj.getString("localidade"),
                //        obj.getString("uf"),
                //        obj.getString("ibge"),
                //        obj.getString("gia"));
            	Cep novoCEP = new Cep();
            	novoCEP.Bairro = obj.getString("bairro");

           json = novoCEP.Bairro;
            

        }} catch (Exception e) {
            throw new Exception(e);
        }
   
       
        return json;
    }
    

public static Cep loadUserFromJSONGson(String jsonString) {
    Gson gson = new Gson();
   
    Cep cep = gson.fromJson(jsonString, Cep.class);
    return cep;
}

public final static String getHttpGET(String urlToRead) throws Exception{
    StringBuilder result = new StringBuilder();

    try {
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        
    } catch (Exception ex) {
        // verifica os Eventos
        
        }
        
    
    return result.toString();
}
  
}
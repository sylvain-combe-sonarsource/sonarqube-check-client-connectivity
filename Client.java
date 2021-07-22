import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;

public class Client {


    String run(String url) throws IOException {
        ConnectionSpec tls = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .allEnabledTlsVersions()
                .allEnabledCipherSuites()
                .supportsTlsExtensions(true)
                .build();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectionSpecs(Collections.singletonList(tls))
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        var example = new Client();
        System.out.println(args);
        String response = example.run(args[0]);
        System.out.println(response);
    }
}

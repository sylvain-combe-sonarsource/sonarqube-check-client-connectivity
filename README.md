# Check client connectivity
Reproduces SonarQube's HTTPS client behavior to troubleshoot TLS/certificate issues. Uses the same OkHttp client bundled in SonarQube, with a custom truststore — exactly as SonarQube would connect to an external HTTPS endpoint.

## How to use
Copy `Client.java` to the host where you want to test connectivity. You also need the SonarQube jar on that host — either run directly on the SonarQube host, or copy the jar from your SonarQube instance. Run with the SonarQube JVM and your truststore:

### SonarQube 2024.x and later (new versioning scheme)
```
java -cp "<SonarQubePath>/lib/sonar-application-*.jar" \
-Djavax.net.debug=all \
-Djavax.net.ssl.trustStore=<pathToYourTrustStore> \
-Djavax.net.ssl.trustStorePassword=changeit \
Client.java https://urlAddressToCheck/
```

* https://badssl.com/ offers various sub-domains for additional TLS checks.
* Java 11+ required.

## Not yet available
### sonar-scanner
Does not work for scanner client connectivity — scanner repackages the okhttp client.

### authentication and additional headers
Does not support authentication headers or other custom headers.

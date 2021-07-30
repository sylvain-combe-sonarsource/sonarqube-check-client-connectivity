# Check client connectivity
This small okhttp client for reproduce and troubleshoot SonarQube HTTP/HTTPS client connectivity 

## How to use
Copy the Client.java file to your SonarQube host. And compile && run it as follows:

```
java -cp "<SonarQubePath/lib/*" \
-Djavax.net.debug=all  \
-Djavax.net.ssl.trustStore=<pathToYourTrustStore>  \
-Djavax.net.ssl.trustStorePassword=changeit  \
Client.java https://urlAddressToCheck/
```

* https://badssl.com/ offers various sub-domains for additional checks.
* <SonarQubePath/lib/common/* can be set for earlier (8.8-) of SonarQube

## Not yet available
### sonar-scanner
It does not work for the scanner client connectivity (yet) as it repackages the okhttpclient.

### authentication and additional headers
this small code does not allow you to set any authentication header (or any other specific header)

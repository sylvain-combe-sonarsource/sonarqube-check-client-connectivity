# sonarqube-check-connectivity
Small okhttp client for reproduce and troubleshoot SonarQube HTTP/HTTPS client connectivity 

Copy the Client.java file to your SonarQube host. And compile && run it as follows:

java -cp "<SonarQubePath/lib/common/*" \
-Djavax.net.debug=all  \
-Djavax.net.ssl.trustStore=<pathToYourTrustStore>  \
-Djavax.net.ssl.trustStorePassword=changeit  \
Client.java https://urlAddressToCheck/

https://badssl.com/ offers various sub-domains for additional checks.

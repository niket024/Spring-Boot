Generate keystore from resources folder following below steps:
--------------------
C:\Niket\Learning\Git\Spring-Boot\SAML-App\src\main\resources>keytool -genkey -v -keystore keystore.jks -alias spring -keyalg RSA -keysize 2048 -validity 10000
Enter keystore password: secret
Re-enter new password: secret
What is your first and last name?
  [Unknown]:  Niket
What is the name of your organizational unit?
  [Unknown]:  DEV
What is the name of your organization?
  [Unknown]:  Accolite
What is the name of your City or Locality?
  [Unknown]:  Bangalore
What is the name of your State or Province?
  [Unknown]:  Karnataka
What is the two-letter country code for this unit?
  [Unknown]:  IN
Is CN=Niket, OU=DEV, O=Accolite, L=Bangalore, ST=Karnataka, C=IN correct?
  [no]:  y

Generating 2,048 bit RSA key pair and self-signed certificate (SHA256withRSA) with a validity of 10,000 days
        for: CN=Niket, OU=DEV, O=Accolite, L=Bangalore, ST=Karnataka, C=IN
Enter key password for <spring>
        (RETURN if same as keystore password):
[Storing keystore.jks]

Warning:
The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.jks -deststoretype pkcs12".

Note:
refe: https://www.youtube.com/watch?v=YN2DOJttEaA&t=43s
Git: https://github.com/talk2amareswaran/Spring-Boot-SAML-and-OKTA
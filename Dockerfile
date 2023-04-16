FROM tomcat:9.0.67-jdk11

COPY target/calculator.war /usr/local/tomcat/webapps/


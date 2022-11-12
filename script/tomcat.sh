#!/bin/bash

sudo apt update

sudo apt -y upgrade

sudo apt -y install openjdk-11-jdk

sudo useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat

wget https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.68/bin/apache-tomcat-9.0.68.tar.gz -P /tmp

sudo tar xf /tmp/apache-tomcat-9*.tar.gz -C /opt/tomcat

sudo ln -s /opt/tomcat/apache-tomcat-9.0.68 /opt/tomcat/latest

sudo chown -RH tomcat:tomcat /opt/tomcat/latest

sudo sh -c 'chmod +x /opt/tomcat/latest/bin/*.sh'


sudo sh -c 'cp /opt/tomcat/latest/conf/server.xml /opt/tomcat/latest/conf/server.xml_bak; sed "s/8080/9090/g" /opt/tomcat/latest/conf/server.xml_bak > /opt/tomcat/latest/conf/server.xml'

sudo sh -c 'cat /opt/tomcat/latest/conf/tomcat-users.xml | sed '\''/\/tomcat-users/i  <role rolename="admin-gui"/> \n <role rolename="manager-gui"/> \n <role rolename="manager-script"/> \n <user username="admin" password="admin_password" roles="admin-gui,manager-gui"/> \n <user username="jenkins" password="jenkins" \n roles="manager-script" /> '\'' >  temp && mv temp /opt/tomcat/latest/conf/tomcat-users.xml'

sudo sh -c  'cat /opt/tomcat/latest/webapps/manager/META-INF/context.xml | sed "/CookieProcessor className/,/Manager/d" > temp && mv temp /opt/tomcat/latest/webapps/manager/META-INF/context.xml '


sudo bash -c 'cat <<EOT > /etc/systemd/system/tomcat.service 
[Unit]
Description=Tomcat 9 servlet container
After=network.target
[Service]
Type=forking
User=tomcat
Group=tomcat
Environment="JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64"
Environment="JAVA_OPTS=-Djava.security.egd=file:///dev/urandom -Djava.awt.headless=true"
Environment="CATALINA_BASE=/opt/tomcat/latest"
Environment="CATALINA_HOME=/opt/tomcat/latest"
Environment="CATALINA_PID=/opt/tomcat/latest/temp/tomcat.pid"
Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"
ExecStart=/opt/tomcat/latest/bin/startup.sh
ExecStop=/opt/tomcat/latest/bin/shutdown.sh
[Install]
WantedBy=multi-user.target
EOT
'


sudo systemctl daemon-reload

sudo systemctl start tomcat

sudo systemctl enable tomcat

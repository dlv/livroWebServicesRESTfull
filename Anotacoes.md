# Tomcat

## Instalando Tomcat 8

```
    sudo apt install unzip
```

```
    sudo mkdir /usr/share/tomcat
    cd /usr/share/tomcat
    sudo wget https://mirror.nbtelecom.com.br/apache/tomcat/tomcat-8/v8.5.47/bin/apache-tomcat-8.5.47.zip
    sudo unzip -q apache-tomcat apache-tomcat-8.5.47.zip
    ls
```

```
    sudo ln -s /usr/share/tomcat/apache-tomcat-8.5.47 /tomcat
```

```
    sudo chmod +x /tomcat/bin/*.sh
```

```
    sudo /tomcat/bin/startup.sh
```

```
    tail -f /tomcat/logs/catalina.out
```

```
    sudo /tomcat/bin/shutdown.sh
```

```
    sudo killall java
```

```
    sudo vim /etc/init.d/tomcat8
```

```
#!/bin/bash
PATH=/sbin:/bin:/usr/sbin:/usr/bin
start() {
    sh /usr/share/tomcat/apache-tomcat-8.5.47/bin/startup.sh
}
stop() {
    sh /usr/share/tomcat/apache-tomcat-8.5.47/bin/shutdown.sh
}
case $1 in
    start|stop) $1;;
    restart) stop; start;;
    *) echo "Run as $0 <start|stop|restart>"; exit 1;;
    esac
```

```
    sudo chmod 755 /etc/init.d/tomcat8
```

```
    sudo service tomcat8 start
```
```
    tail -f /tomcat/logs/catalina.out
```

```
    sudo update-rc.d tomcat8 defaults
```

```
    sudo shutdown -r now
```

---

## Configurando memória do Tomcat

```
    sudo vim /tomcat/bin/setenv.h

    export JAVA_OPTS="-Xms256m -Xmx512m -XX:MaxPermSize=256m -server -Djava.security.egd=file:/dev/./urandom"
```

    * Xms256m - Configura a memorial inicial do Tomcat para 256 MB.
    * Xmx512m - Configura a memoria máxima do Tomcat para 512 MB.
    * XX:MaxPermSize=256m - O parâmetro *MaxPermSize*, conhecido como *permanent space*, é um espaço de memória no qual ficam os objetos que nunca são destrídos.
    * server - Configura o Tomcat no modo servidor para otimizar o desempenho.
    * Djava.security.egd=file:/dev/./urandom - Configura o Tomcat para inicializar mais rápido.

```
    sudo service tomcat8 restart
```

```
    sudo killall java
    sudo service tomcat8 start
```
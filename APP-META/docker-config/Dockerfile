FROM URL
MAINTAINER lili<772654204lili@qq.com>

COPY environment/*.sh environment/*.json environment/*.conf /home/admin/

COPY spring-traning-base.tgz /tmp
COPY environment/spring-traning-base.online.properties /opt/spring-traning-base/spring-traning-base.properties
COPY environment/spring-traning-base-common.properties /opt/spring-traning-base/

RUN tar -zvxf /tmp/spring-traning-base.tgz -C /tmp/ && \
mkdir /home/admin/spring-traning-base && mv /tmp/target/spring-traning-base.jar /home/admin/spring-traning-base && \
rm -rf /tmp/spring-traning-base && rm -f /tmp/spring-traning-base.tgz && \
chmod -R 777 /opt/spring-traning-base/ && chmod +x /home/admin/*.sh && \
ln -s /home/admin/start.sh /home/admin/.start

VOLUME /home/admin/spring-traning-base/logs
ENTRYPOINT ["/home/admin/start.sh"]
EXPOSE 9888 22
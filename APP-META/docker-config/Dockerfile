FROM URL
MAINTAINER lili<772654204lili@qq.com>

COPY environment/*.sh environment/*.json environment/*.conf /home/admin/

COPY spring-training-base.tgz /tmp
COPY environment/spring-training-base.online.properties /opt/spring-training-base/spring-training-base.properties
COPY environment/spring-training-base-common.properties /opt/spring-training-base/

RUN tar -zvxf /tmp/spring-training-base.tgz -C /tmp/ && \
mkdir /home/admin/spring-training-base && mv /tmp/target/spring-training-base.jar /home/admin/spring-training-base && \
rm -rf /tmp/spring-training-base && rm -f /tmp/spring-training-base.tgz && \
chmod -R 777 /opt/spring-training-base/ && chmod +x /home/admin/*.sh && \
ln -s /home/admin/start.sh /home/admin/.start

VOLUME /home/admin/spring-training-base/logs
ENTRYPOINT ["/home/admin/start.sh"]
EXPOSE 9888 22
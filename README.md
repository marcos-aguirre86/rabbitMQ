# rabbitMQ

Como installar RabbitMQ en windows 10: https://www.rabbitmq.com/install-windows-manual.html

Como installar RabbitMQ en ubuntu: https://www.rabbitmq.com/install-debian.html

Errores comunes: RabbitMQ – “Failed to create cookie file (drive:)/erlang”

Solución: https://www.rpic.com/knowledgebase/rabbitmq-failed-create-cookie-file-driveerlang/

Issue

When installing RabbitMQ, the process creates a dump file with the error “Failed to create cookie file (drive:)/erlang”.
This typically occurs when your organization has a policy set to direct the home drive to a directory other than the C: drive.
One way to help determine the state of the installed service is to look at the description in windows services. If the description is blank, there is a good chance that there was an issue with the installation.

Resolution

1) Open command prompt as administrator
2) Change directory to the Program FilesRabbitMQ Serverrabbitmq_server-3.5.5sbin directory
3) Run the following commands:
SET HOMEDRIVE=C:
rabbitmq-plugins.bat enable rabbitmq_management
rabbitmq-service.bat stop
rabbitmq-service.bat remove
rabbitmq-service.bat install
rabbitmq-service.bat start
SET HOMEDRIVE=(drive:) (set to home drive letter)



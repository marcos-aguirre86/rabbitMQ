# rabbitMQ

Como installar RabbitMQ en windows 10: https://www.rabbitmq.com/install-windows.html

Installing on Windows Manually 
Overview
This guide describes how RabbitMQ can be installed and configured manually on Windows. In general we recommend using one the more automation-friendly options for Windows when possible.
Install Erlang/OTP
RabbitMQ requires a 64-bit supported version of Erlang for Windows to be installed. Latest binary builds for Windows can be obtained from the Erlang/OTP Version Tree page.
Erlang will appear in the Start Menu, and \erl{version}\bin\erl.exe will be in C:\Program Files for 64-bit Erlang installations
Important: your system should only have one version of Erlang installed. Please consult the Windows-specific Issues page.
Make Sure ERLANG_HOME is Set
In case there's an existing RabbitMQ installation with the broker running as a service and you installed an Erlang VM with a different architecture then the service must be uninstalled before updating ERLANG_HOME.
Set ERLANG_HOME to where you actually put your Erlang installation, e.g. C:\Program Files\erl{version} (full path). The RabbitMQ batch files expect to execute %ERLANG_HOME%\bin\erl.exe.
Go to Start > Settings > Control Panel > System > Advanced > Environment Variables. Create the system environment variable ERLANG_HOME and set it to the full path of the directory which contains bin\erl.exe.
Install RabbitMQ Server
After making sure a supported Erlang version is installed, download rabbitmq-server-windows-3.8.9.zip.
Direct Downloads
Description
Download
Signature
Installer for Windows systems (from GitHub) 
rabbitmq-server-windows-3.8.9.zip 
Signature 
From the zip file, extract the folder named rabbitmq_server-3.8.9 into C:\Program Files\RabbitMQ (or somewhere suitable for application files).
Synchronise the Erlang Cookie
The Erlang cookie is a shared secret used for authentication between RabbitMQ nodes and CLI tools. The value is stored in a file commonly referred to as the Erlang cookie file.
The cookie file used by the service account and the user running rabbitmqctl.bat must be synchronised for CLI tools such as rabbitmqctl.bat to function. All nodes in a cluster must have the same cookie value (cookie file contents).
Please see How CLI Tools Authenticate to Nodes (and Nodes to Each Other): the Erlang Cookie for details.
Locating CLI Tools and App Data
CLI tools
Within the rabbitmq_server-3.8.9\sbin directory are some scripts which run commands to control the RabbitMQ server.
The RabbitMQ server can be run as either an application or service (not both).
rabbitmq-server.bat starts the broker as an application
rabbitmq-service.bat manages the service and starts the broker
rabbitmqctl.bat manages a running broker
Log in as an administrator. To see the output, run these from a Command Prompt in the sbin directory.
Note: On Windows Vista (and later) it is necessary to elevate privilege (e.g. right-click on the icon to select Run as Administrator).
Set up the system path so RabbitMQ server and CLI tools from the sbin directory can be executed without using fully qualified paths.
Create a system environment variable (e.g. RABBITMQ_SERVER) for "C:\Program Files\RabbitMQ\rabbitmq_server-3.8.9". Adjust this if you put rabbitmq_server-3.8.9 elsewhere, or if you upgrade versions.
Append the literal string ";%RABBITMQ_SERVER%\sbin" to your system path (aka %PATH%).
Now it should be possible to run rabbitmq commands from any (administrator) Command Prompt.
Navigate to rabbitmq_server-3.8.9\sbin to run commands if the system path does not contain the RabbitMQ sbin directory.

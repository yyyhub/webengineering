#工程说明
因工程仅完成部分基础功能，暂时只支持本地运行


源码测试步骤：
1.下载project文件夹下说有文件
2.自行安装MySQL5.7数据库（要求用户名密码皆为root，如果不是，请修改webengineering-demo-manager/webengineering-manager-web/src/main/conf/db.properties文件种相关配置），并在MySQL底下创建数据库名为webengineering，然后导入project文件夹底下的.sql文件，生产相应的数据库
3.安装eclipse，并自行配置maven相关内容，需要配置maven远程仓库，以便jar包下载
4.利用eclipse导入project工程，并update整个工程，再使用maven命令，依次install webengineering-demo、webengineering-demo-common、webengineering-demo-manager三个项目文件，然后利用tomcat7:run命令即可开启本地服务器进行调试

发布部署war包使用步骤：
1.下载project文件夹下的war包
2.自行配置tomcat服务器，将war包放入tomcat服务器底下（1.要求版本必须高于tomcat7，2.将server.xml文件底下的网站路径改为war包所在路径，3.修改tomcat服务器的字符编码：打开server.xml文件找到并修改为<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
3.开启tomcat服务器即可通过网上访问（如果需要配置成外网服务器，只需自行配置tomcat服务器，使其能够被外网访问到即可）

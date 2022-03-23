# MaduleIoT
Service manager running on the server.   
### This software runs in Windows environment. 
### Using git clone instruction to download code, and using mvn instruction to create executable jar files.
### The software supports HTTP communication and opens a variety of restful APIs for other software calls.
### Users can control IoT devices by sending HTTP information to remote IoT instances in the way of function call in the main function function.

## 编译环境
1. Ubuntu 18.04
2. JAVA 1.8
3. maven 3.6.0
## 下载及编译源码
git clone https://github.com/JCThompson1/MaduleIoT.git
mvn package clean -Dmaven.test.skip=true
mvn package -Dmaven.test.skip=true
## 参与贡献
1. Fork本仓库
2. 新建Feat_xxx分支
3. 提交代码
4. 新建Pull Request

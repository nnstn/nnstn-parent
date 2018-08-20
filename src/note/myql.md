mysql 源码安装
依赖包：
yum install gcc gcc-c++
yum install -y ncurses-devel
yum install -y cmake
yum install -y libaio
yum install -y bison
创建用户：
groupadd mysql
useradd -r -g mysql mysql
mkdir /mysql
chown -R mysql:mysql  /mysql

wget https://cdn.mysql.com//Downloads/MySQL-5.6/mysql-5.6.41.tar.gz

tar zxvf mysql-5.6.26.tar.gz
cd mysql-5.5.15
cmake -DCMAKE_INSTALL_PREFIX=/mysql .
make
make install

数据库初始化
scripts/mysql_install_db --defaults-file=/mysql/my.cnf --user=mysql
/bin/sh /mysql/bin/mysqld_safe  --defaults-file=/mysql/my.cnf --user=mysql &
update user set Password=PASSWORD('wangjingnan0115');
update user set host='%';
flush privileges;

本地登陆：
mysql -uroot -p -h 127.0.0.1
# db-core1
整合Spring、Hibernate、Ibatis，提供对数据库操作的通用工具。在这里共用两个ORM框架，其实并不矛盾，各有各的妙用。
<br><br>
Ibatis是比较旧的框架了，不过，他的核心部分还在MyBatis中被延用。
<br><br>
Spring3对Ibatis提供了直接支持，Spring4就不再支持了。于是MyBatis社区，就自己开发了一个扩展框架Spring-MyBatis。<br>
这个项目用的还是Spring3的方式。Spring4与Spring-MyBatis的方式将在下一个项目db-core2中开源。
<br><br>
应用说明：<br>
db_core1模块是数据操作的核心模块，可以直接使用。对关系数据库适用。<br>
db-core-demo-module模块是数据表的封装类。<br>
db-core-demo-service是针对数据表的操作类，并且有Test例子。<br>
要实现自己的数据表操作，请参数db-core-demo-module与db-core-demo-service的实现方式。<br>

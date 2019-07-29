使用git创建工程步骤：
1.现在git网站创建一个仓库，得到仓库的url
2.创建一个本地的仓库
3.创建一个工程
4.分享工程
5.path指向git的url

使用easyUI的datagrid的分页工具的注意事项：
1.分页的后台接收数据时的当前页使用page，每页的条数rows
2.后台返回的数据是一个对象，其属性有int total，和List rows

提交表单中文乱码：
1.修改tomcat的配置文件
或者
1.
<plugin>
	<groupId>org.apache.tomcat.maven</groupId>
	<artifactId>tomcat7-maven-plugin</artifactId>
	<version>${tomcat7-maven-plugin-version}</version>
	<configuration>
		<port>80</port>
		<path>/</path>
		<uriEncoding>utf8</uriEncoding><-- Maven配置 -->
	</configuration>
</plugin>
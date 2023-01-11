# 百惠wms1.0(SpringBoot版本)

#### 介绍
```$xslt
百惠WMS仓库管理系统,用于日常练习,毕业设计.
```
---
#### 软件架构

##### 后端   
* SpringBoot (基础框架)
* MyBatis (ORM框架)
* MYSQL (数据库)
* Druid (数据库连接池)
* PageHelper (分页插件)
* kaptcha (验证码)
* Shiro (权限认证框架)
* knife4j/swagger (API生成工具)

##### 前端

* LayUI (前端框架)
* echarts (图标显示)
* md5 (数据加密)
* treeTable (树形表格)
* xm-select (多功能下拉框)


---
#### 软件介绍

<img src="https://note.youdao.com/yws/api/personal/file/WEB4cd99b32c012362d71bd64c786c17c48?method=download&shareKey=b9c754f54c9c5c6fd2722b3876536142">

<img src="https://note.youdao.com/yws/api/personal/file/WEB6685d8daa685a06e4c7ec5e12a890573?method=download&shareKey=66ecbf57a6a256d311e99cdbe2a99e4a">

<img src="https://note.youdao.com/yws/api/personal/file/WEB73220491726be27661ee427a06560ca7?method=download&shareKey=37e27dae0a7c1ecbb30b5d07bc84bb4b">

<img src="https://note.youdao.com/yws/api/personal/file/WEBf0dad51de3258e142448a90594889831?method=download&shareKey=159d37ee45ecf8a55a5d4023231243f8">

<img src="https://note.youdao.com/yws/api/personal/file/WEBb0b00a8cf0b60d18b16874582d3bd7d7?method=download&shareKey=e5db4fdd17ec061e626bbc2bf5ca8f59">

<img src="https://note.youdao.com/yws/api/personal/file/WEB593472dc088e63959a92d9038dacf87e?method=download&shareKey=b1b91ab3ce50e7aec1f59a5e7b5f96da">

<img src="https://note.youdao.com/yws/api/personal/file/WEBbae8d18797fb5b2c722a82e1f172b217?method=download&shareKey=3d7b68d82a21c893a9eec81692e91c12">

<img src="https://note.youdao.com/yws/api/personal/file/WEBc47265583278314a39a126a50f16c74d?method=download&shareKey=0ac474e0a91a3c28cb2de43846e26139">

<img src="https://note.youdao.com/yws/api/personal/file/WEBf7f7e38dda892dcfc5f8a83076ce7025?method=download&shareKey=2ec192eb9a24937dfd4852711ad91634">

<img src="https://note.youdao.com/yws/api/personal/file/WEBbb5842e5d7d74b46e1532f16ddcb5dcf?method=download&shareKey=e6a7d69382f403fca09725acaac6e543">

---

#### 启动方式

```$xslt
1. 下载源码
2. 导入到IDEA开发工具中
3. 创建数据库 bh_wms （数据库为MYSQL数据库,版本为MYSQL5.7或者5.7以上版本）
4. 导入数据库文件 bh-wms.sql
5. 修改 application.properties 配置文件中的数据库用户名和密码
6. 启动springboot项目
7. 项目访问地址 http://localhost:8080
8. API在线文档地址 http://localhost:8080/doc.html
9. 用户名和密码如下: 
```

#### 测试账户

```
用户名: 18288888888
密码  : 1
```


#### 作者联系方式

```$xslt
企鹅: 1611756908
鹅群: 948233848
邮箱: hd1611756908@163.com
博客: https://ukoko.gitee.io
B站: https://space.bilibili.com/514155929/
```

#### 未完成

* 用户更新［角色,部门未更新］
* 产品更新 [分类未更新]
* 仓库负责人有缺陷(需要设计仓库和用户关联表,多对多)[关联表设计完成,添加仓库还未修改]
* 添加仓库［仓库管理管理员字段未添加］
* 菜单未完成
---


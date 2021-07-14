# 钉钉开放平台 Java SDK

本SDK基于钉钉开放平台开发，功能逐渐开发中。
开发文档详见：
1. [企业内部应用开发](https://ding-doc.dingtalk.com/document#/org-dev-guide)

## 使用

### Java / Spring 使用

参见各某块下 TestXXXService：


### Spring Boot starter

#### 1. 添加依赖

最新版本：0.0.2

```xml
<dependencies>
    <dependency>
        <groupId>top.todev.ding</groupId>
        <artifactId>ding-talk-org-boot-starter</artifactId>
        <version>${ding-talk-4j.version}</version>
    </dependency>
    <dependency>
        <groupId>top.todev.ding</groupId>
        <artifactId>ding-talk-workflow-boot-starter</artifactId>
        <version>${ding-talk-4j.version}</version>
    </dependency>
    <dependency>
        <groupId>top.todev.ding</groupId>
        <artifactId>ding-talk-callback-boot-starter</artifactId>
        <version>${ding-talk-4j.version}</version>
    </dependency>
</dependencies>
```

#### 2. 配置密钥
> host 配置已有默认值，可忽略。

```yaml
ding:
  talk:
    org:
      app-key: 请完善key
      app-secret: 请完善密钥
    workflow:
      app-key: ${ding.talk.org.app-key}
      app-secret: ${ding.talk.org.app-secret}
    callback:
      app-key: ${ding.talk.org.app-key}
      event-aes-key: 请完善回调事件AesKey
      event-token: 请完善回调事件Token
```

#### 3. 使用

```java
/** 钉钉开发平台企业应用接口 */
@Autowired
private IDingOrgService service;

/** 工作流实例接口 */
@Autowired
private IDingWorkflowService service;

/** 事件回调接口 */
@Autowired
private IDingCallbackCryptoManager manager;
```

#### 4. 注意
1. 暂无

## 完成情况
部分内容未更新，请看接口说明。
### 通讯录管理
- [x] 用户管理2.0
- [x] 部门管理2.0

### 智能工作流
#### 官方工作流
- [x] 发起审批实例
- [x] 获取审批实例详情
- [x] 获取凭证


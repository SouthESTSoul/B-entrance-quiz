### 完成度：



__Details:__

- \- 应该在点击分组的时候才生成组

### 测试：
* 有Controller层测试，覆盖了部分功能的Happy Path

__Details:__



### 知识点：
* 使用了lombok
* 需要了解下三层架构

__Details:__

- \- 构造器注入时可以省略@Autowired
- \- 没有使用泛型
- \- 违反Restful实践, url不合理
- \- 没有使用钻石操作符
- \- 不符合三层架构，缺少用于保存数据的Repository层
- \- 以下代码可以使用Java8 Stream简化
- \- 打乱顺序可以了解下Collections.shuffle()
- \- 了解下Comparator的静态方法

### 工程实践：
* 注意单一职责，group和student应该有单独的Controller和Service

__Details:__

- \- import中不要使用通配符
- \- Magic Number
- \- 列表遍历推荐使用for循环
- \- 计算id的方式不够健壮，可以使用字段保存最大id

### 综合：


__Details:__




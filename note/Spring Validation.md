# Spring Validation

## 1. JSR-303 简介

JSR-303 是 JavaEE 6 中的一项子规范，叫做 Bean Validation，官方参考实现是 Hibernate Validator。

此实现与 Hibernate ORM 没有任何关系。JSR-303 用于对 Java Bean 中的字段的值进行验证。 Spring MVC 3.x 之中也大力支持 JSR-303，可以在控制器中使用注解的方式对表单提交的数据方便地验证。

Spring 4.0 开始支持 Bean Validation 功能。

## 2. JSR-303 基本的校验规则

### 空检查

- `@Null` 验证对象是否为 `null`
- `@NotNull` 验证对象是否不为 `null`, 无法查检长度为 0 的字符串
- `@NotBlank` 检查约束字符串是不是 `Null` 还有被 `Trim` 的长度是否大于 0,只对字符串,且会去掉前后空格
- `@NotEmpty` 检查约束元素是否为 `NULL` 或者是 `EMPTY`

### 布尔检查

- `@AssertTrue` 验证 `Boolean` 对象是否为 `true`
- `@AssertFalse` 验证 `Boolean` 对象是否为 `false`

### 长度检查

- `@Size(min=, max=)` 验证对象（`Array`, `Collection` , `Map`, `String`）长度是否在给定的范围之内
- `@Length(min=, max=)` 验证字符串长度介于 `min` 和 `max` 之间

### 日期检查

- `@Past` 验证 `Date` 和 `Calendar` 对象是否在当前时间之前，验证成立的话被注释的元素一定是一个过去的日期
- `@Future` 验证 `Date` 和 `Calendar` 对象是否在当前时间之后 ，验证成立的话被注释的元素一定是一个将来的日期

### 正则检查

- `@Pattern`验证`String`

  对象是否符合正则表达式的规则，被注释的元素符合制定的正则表达式

  - `regexp`：正则表达式
  - `flags`：指定 `Pattern.Flag` 的数组，表示正则表达式的相关选项

### 数值检查

**注意：** 建议使用在 `String` ,`Integer` 类型，不建议使用在 `int` 类型上，因为表单值为 `“”` 时无法转换为 `int`，但可以转换为 `String` 为 `“”`，`Integer` 为 `null`

- `@Min` 验证 Number 和 String 对象是否大等于指定的值
- `@Max` 验证 Number 和 String 对象是否小等于指定的值
- `@DecimalMax` 被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过 `BigDecimal`定义的最大值的字符串表示 `.小数` 存在精度
- `@DecimalMin` 被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过 `BigDecimal`定义的最小值的字符串表示 `.小数` 存在精度
- `@Digits` 验证 Number 和 String 的构成是否合法
- `@Digits(integer=,fraction=)` 验证字符串是否是符合指定格式的数字，`integer` 指定整数精度，`fraction` 指定小数精度
- `@Range(min=, max=)` 被指定的元素必须在合适的范围内
- `@Range(min=10000,max=50000,message=”range.bean.wage”)`
- `@Valid` 递归的对关联对象进行校验, 如果关联对象是个集合或者数组，那么对其中的元素进行递归校验，如果是一个 `map`，则对其中的值部分进行校验.(是否进行递归验证)
- `@CreditCardNumber` 信用卡验证
- `@Email` 验证是否是邮件地址，**如果为 null，不进行验证，算通过验证**
- `@ScriptAssert(lang= ,script=, alias=)`
- `@URL(protocol=,host=, port=,regexp=, flags=)`

## 3. 使用 Spring Validation 验证

### POM

这里我们使用 Hibernate Validator 5.x 来实现 Spring Validation 接口，`pom.xml` 文件如下：

```text
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.3.4.Final</version>
</dependency>
```

主要是增加了 `org.hibernate:hibernate-validator` 依赖

### 定义验证工具类

```java
package com.illusory.i.shop.commons.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * JSR303 Validator(Hibernate Validator)工具类.
 * <p>
 * ConstraintViolation 中包含 propertyPath, message 和 invalidValue 等信息.
 * 提供了各种 convert 方法，适合不同的 i18n 需求:
 * 1. List<String>, String 内容为 message
 * 2. List<String>, String 内容为 propertyPath + separator + message
 * 3. Map<propertyPath, message>
 * <p>
 * 详情见wiki: https://github.com/springside/springside4/wiki/HibernateValidator
 *
 * @author illusoryCloud
 * @version 1.0.0
 * @date 2019/3/26 21:09
 */
public class BeanValidator {
    /**
     * 静态变量 属性由自己手动注入
     * Spring-context.xml
     */
    private static Validator validator;

    public static void setValidator(Validator validator) {
        BeanValidator.validator = validator;
    }

    /**
     * 服务端参数有效性验证
     * 错误消息封装为字符串 用于显示到页面上
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回 null；验证失败：返回错误信息
     */
    public static String validator(Object object, Class<?>... groups) {
        try {
            validateWithException(validator, object, groups);
        } catch (ConstraintViolationException ex) {
            List<String> list = extractMessage(ex);
            list.add(0, "数据验证失败：");

            // 封装错误消息为字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                String exMsg = list.get(i);
                if (i != 0) {
                    sb.append(String.format("%s. %s", i, exMsg)).append(list.size() > 1 ? "<br/>" : "");
                } else {
                    sb.append(exMsg).append(list.size() > 1 ? "<br/>" : "");
                }
            }

            return sb.toString();
        }

        return null;
    }

    /**
     * 调用 JSR303 的 validate 方法, 验证失败时抛出 ConstraintViolationException.
     */
    private static void validateWithException(Validator validator, Object object, Class<?>... groups) throws ConstraintViolationException {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    /**
     * 辅助方法, 转换 ConstraintViolationException 中的 Set<ConstraintViolations> 中为 List<message>.
     */
    private static List<String> extractMessage(ConstraintViolationException e) {
        return extractMessage(e.getConstraintViolations());
    }

    /**
     * 辅助方法, 转换 Set<ConstraintViolation> 为 List<message>
     */
    private static List<String> extractMessage(Set<? extends ConstraintViolation> constraintViolations) {
        List<String> errorMessages = new ArrayList<>();
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.add(violation.getMessage());
        }
        return errorMessages;
    }

    /**
     * 辅助方法, 转换 ConstraintViolationException 中的 Set<ConstraintViolations> 为 Map<property, message>.
     */
    private static Map<String, String> extractPropertyAndMessage(ConstraintViolationException e) {
        return extractPropertyAndMessage(e.getConstraintViolations());
    }

    /**
     * 辅助方法, 转换 Set<ConstraintViolation> 为 Map<property, message>.
     */
    private static Map<String, String> extractPropertyAndMessage(Set<? extends ConstraintViolation> constraintViolations) {
        Map<String, String> errorMessages = new HashMap<>();
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return errorMessages;
    }

    /**
     * 辅助方法, 转换 ConstraintViolationException 中的 Set<ConstraintViolations> 为 List<propertyPath message>.
     */
    private static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e) {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), " ");
    }

    /**
     * 辅助方法, 转换 Set<ConstraintViolations> 为 List<propertyPath message>.
     */
    private static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations) {
        return extractPropertyAndMessageAsList(constraintViolations, " ");
    }

    /**
     * 辅助方法, 转换 ConstraintViolationException 中的 Set<ConstraintViolations> 为 List<propertyPath + separator + message>.
     */
    private static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e, String separator) {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), separator);
    }

    /**
     * 辅助方法, 转换 Set<ConstraintViolation> 为 List<propertyPath + separator + message>.
     */
    private static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations, String separator) {
        List<String> errorMessages = new ArrayList<>();
        for (ConstraintViolation violation : constraintViolations) {
            errorMessages.add(violation.getPropertyPath() + separator + violation.getMessage());
        }
        return errorMessages;
    }

}
```

## 4. Reference

`[lusifer]:http://www.funtl.com/zh/supplement1/#jsr-303-%E7%AE%80%E4%BB%8B`


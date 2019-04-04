# jQuery zTree

zTree 是一个依靠 jQuery 实现的多功能 “树插件”。优异的性能、灵活的配置、多种功能的组合是 zTree 最大优点。

## 页面引用

CSS 部分

```html
<link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" />
```

JS 部分

```html
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
```

## 使用方法

开启 zTree 异步加载数据的功能，案例代码如下：

```javascript
var setting = {
    view: {
        // 禁止多选
        selectedMulti: false
    },
    async: {
        // 开启异步加载功能
        enable: true,
        // 远程访问地址
        url: "/content/category/tree/data",
        // 选择父节点时会自动将节点中的参数传回服务器再重新取结果
        autoParam: ["id"]
    }
};

// 初始化 zTree 控件
$.fn.zTree.init($("#myTree"), setting);
// 绑定事件
$("#btnModalOk").bind("click", function () {
    // 获取 zTree 控件
    var zTree = $.fn.zTree.getZTreeObj("myTree");
    // 获取已选中的节点
    var nodes = zTree.getSelectedNodes();
    if (nodes.length == 0) {
        alert("请先选择一个父节点");
    }

    else {
        var node = nodes[0];
        alert(node.id);
    }
});
```

### HTML 结构代码

```html
<ul id="myTree" class="ztree"></ul>
```

### 服务器关键代码

此为 `Controller` 关键代码

```java
@ResponseBody
@RequestMapping(value = "tree/data", method = RequestMethod.POST)
public List<TbContentCategory> treeData(String id) {
    if (id == null) {
        id = "0";
    }
    List<TbContentCategory> tbContentCategories = tbContentCategoryService.selectByPid(Long.parseLong(id));
    return tbContentCategories;
}
```



# TW 酒店管理系 #
练手项目

**开发流程建议**
* 拆分tasking
* 梳理happy path和sad path
* 编写测试，从 controller->service-repository 完成全流程。

---

**用户注册登录**

As a 用户

I want 进入酒店系统

So that 我可以注册用户并登录

**AC1 用户注册**

**Given** 当用户在注册页面输入用户名密码

**When** 点击注册按钮

**Then** 返回注册结果

```json
//POST http://localhost:8080/users/register
//requst:
{
  "username": "user1",
  "password": "123456"
}
//response:
{
  "code": 200,
  "message": "注册成功",
  "data": null
}
```

**AC2 用户登录**

**Given** 当用户在登录输入用户名密码

**When** 点击登录按钮

**Then** 返回登录结果

```json
//POST http://localhost:8080/users/login
//requst:
{
  "username": "user1",
  "password": "123456"
}
//response:
{
  "code": 200,
  "message": "登录成功",
  "data": {
    "token": "ox123abcde1237d"
  }
}
```

**用户退出登录**

As a 用户

I want 退出酒店系统

So that 我可以点击退出登录，下次需要重新登录

**AC1 用户退出登录**

**Given** 用户在登录状态

**When** 点击退出登录按钮

**Then** 返回登录页面并注销登录状态

```json
//POST http://localhost:8080/users/logout
//response:
{
  "code": 200,
  "message": "退出登录成功",
  "data": null
}
```

**用户上传和修改个人信息**

As a 用户

I want 更新个人信息

So that 我可以提交新的用户信息

**AC1 更新昵称，性别，联系方式**

**Given** 用户在登录状态

**When** 填写昵称，性别，联系方式

**Then** 返回更新后的用户信息

```json
//POST http://localhost:8080/users/update-profile
//requst:
{
  "nickname": "张三",
  "gender": "男",
  "phone": "13888888888"
}
//response:
{
  "code": 200,
  "message": "更新用户信息成功",
  "data": {
    nickname: "张三",
    gender: "男",
    phone: "13888888888",
    avatar: "https://avatar.png"
  }
}
```

**AC2 更新头像信息**

**Given** 用户在登录状态

**When** 选择头像

**Then** 返回更新后的用户信息

```json
//POST http://localhost:8080/users/update-avatar
//requst:
file: avatar.png
//response:
{
"code": 200,
"message": "更新用户头像成功",
"data": {nickname: "张三", gender: "男", phone: "13888888888", avatar: "https://avatar.png"
}
}
```

**用户搜索房间**

As a 用户

I want 搜索匹配的房间

So that 我可以输入关键词搜索并获取匹配列表

**AC1 更新昵称，性别，联系方式**

**Given** 当前系统中存在上架房间

**When** 输入关键词搜索

**Then** 返回匹配的房间列表，并分页展示

```json
//GET http://localhost:8080/rooms/search/{keyword}
//response:
{
  "code": 200,
  "message": "查询成功",
  "data": {
    "page": 1,
    "totalPage": 10,
    "items": []
  }
}
```

**用户预定房间**

As a 用户

I want 预定一个房间

So that 我可以查看房间信息并进行预定

**AC1 展示房间详情**

**Given** 当前系统中存在上架房间

**When** 点击其中一个房间，打开详情页面

**Then** 可以展示房间名，单日价格，地址，评分，评价，图片，可预定时间等信息

```json
//GET http://localhost:8080/rooms/{id}
//response:
{
  "code": 200,
  "message": "查询成功",
  "data": {
    "roomName": "xxx大酒店",
    "price": 100,
    "address": "湖北省武汉市xxx",
    "star": 3.5,
    "comments": [],
    "picture": [],
    "reservableStartTime": "20223-01-01",
    "reservableEndTime": "20223-01-02"
  }
}
```

**AC2 房间预定**

**Given** 在可以预定时间范围内

**When** 点击预定按钮

**Then** 提示预定结果

```json
//POST http://localhost:8080/rooms/{id}/reserve
//requst:
{
  "checkinTime": "20223-01-01",
  "checkoutTime": "20223-01-02",
  "remark": "备注信息"
}
//response:
{
  "code": 200,
  "message": "预定成功",
  "data": null
}
```

**用户取消订单**

As a 用户

I want 取消一个已经预定的订单

So that 我可以打开订单详情，通过取消按钮来取消预定

**AC1：展示订单详情**

**Given：** 当前用户已经预定过房间

**When：** 打开订单详情页面

**Then：** 可以看到订单号，总金额，订单状态，酒店信息，下单日期等信息

```json
//GET http://localhost:8080/orders/{id}
//response:
{
  "code": 200,
  "message": "查询成功",
  "data": {
    "orderNo": "1234",
    "totalPrice": 200,
    "status": "IN_PROGRESS",
    "hotel": {
      "roomName": "xxx大酒店",
      "price": 100,
      "address": "湖北省武汉市xxx",
      "star": 3.5,
      "comments": [],
      "picture": [],
      "reservableStartTime": "20223-01-01",
      "reservableEndTime": "20223-01-02"
    },
    "orderTime": "2023-01-01"
  }
}
```

**AC2：取消预约订单**

**Given：** 当前用户已经预定过房间

**When：** 在订单详情页面，点击取消按钮

**Then：** 可以在页面上看到取消结果

```json
//POST http://localhost:8080/orders/{id}/cancel
//response:
{
  "code": 200,
  "message": "取消成功",
  "data": null
}
```

**对订单进行评价和留言**

As a 用户

I want 对完成了的订单进行评价和评分

So that 在已经完成的订单中进行评论和打分

**AC2：评价和评分**

**Given：** 存在已经完成的订单

**When：** 打开完成的订单，输入评价和评分

**Then：** 可以看到最新的酒店评价和评分信息

```json
//POST http://localhost:8080/orders/{id}/evaluate
//requst:
{
  "star": 3.5,
  "comment": "评论信息"
}
//response:
{
  "code": 200,
  "message": "评价成功",
  "data": {
    "roomName": "xxx大酒店",
    "price": 100,
    "address": "湖北省武汉市xxx",
    "star": 3.5,
    "comments": [],
    "picture": [],
    "reservableStartTime": "20223-01-01",
    "reservableEndTime": "20223-01-02"
  }
}
```
---

**管理员注册登录**

As a 用户

I want 进入酒店系统

So that 我可以注册管理员并登录

**AC1 管理员注册**

**Given** 当用户在注册页面输入用户名密码

**When** 点击注册按钮

**Then** 返回注册结果

```json
//POST http://localhost:8080/administrators/register
//requst:
{
  "username": "user1",
  "password": "123456"
}
//response:
{
  "code": 200,
  "message": "注册成功",
  "data": null
}
```

**AC2 管理员登录**

**Given** 当用户在登录输入用户名密码

**When** 点击登录按钮

**Then** 返回登录结果

```json
//POST http://localhost:8080/administrators/login
//requst:
{
  "username": "user1",
  "password": "123456"
}
//response:
{
  "code": 200,
  "message": "登录成功",
  "data": {
    "token": "ox123abcde1237d"
  }
}
```

**管理房间信息**

As a 管理员

I want 上架或下架一个房间

So that 我可以创建一个新的房间，并上架到系统当中，或者将已经上架的房间进行下架操作

**AC1 创建房间**

**Given** 管理员账户

**When** 填写房间名，单日价格，地址，评分，评价，图片，可预定时间等信息

**Then** 返回创建结果，打开房间详情页面。

```json
//POST http://localhost:8080/admin/rooms/create
//requst:
{
  "roomName": "xxx大酒店",
  "price": 100,
  "address": "湖北省武汉市xxx",
  "comments": [],
  "picture": [],
  "reservableStartTime": "20223-01-01",
  "reservableEndTime": "20223-01-02"
}
//response:
{
  "code": 200,
  "message": "创建成功",
  "data": {
    "roomName": "xxx大酒店",
    "price": 100,
    "address": "湖北省武汉市xxx",
    "star": 3.5,
    "comments": [],
    "picture": [],
    "reservableStartTime": "20223-01-01",
    "reservableEndTime": "20223-01-02"
  }
}
```

**AC2 上架房间**

**Given** 存在已经创建好的房间

**When** 打开创建好的房间详情页面，点击上架按钮

**Then** 返回上架结果。

```json
//POST http://localhost:8080/admin/rooms/{id}/shelf

//response:
{
  "code": 200,
  "message": "上架成功",
  "data": null
}
```

**AC3 下架房间**

**Given** 存在已经上架的放假

**When** 打开上架的房间详情页面，点击下架按钮

**Then** 返回下架结果。

```json
//POST http://localhost:8080/admin/rooms/{id}/drop

//response:
{
  "code": 200,
  "message": "下架成功",
  "data": null
}
```





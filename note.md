## MVC设计模式

model-view-controller\
servlet-作用-处理请求和响应\
业务逻辑-使用接口和类单独抽取出去-模型（业务逻辑+需要处理的数据）\
一个servlet专门处理请求-控制\
一个servlet处理响应-视图
## 请求转发和重定向
跳转资源的方式

请求转发-内部跳转-一次请求一次响应\
内部有数据更新，不能使用请求转发\
使用RequestDispatcher接口的forward（）方法，可把请求发给另外一个资源\
使用request的getRequestDispatcher(String path)方法来获取需要转发的页面的requestdiapatcher\
path-指定转发的URL，只能是相对路径

重定向-两次请求，两次响应\
原请求地址重新定位到某个新地址，原有的请求失效，
客户端看到的是新的请求返回的响应结果\
使用HttpServletResponse的sendRedirect()方法

查询可用请求转发，有数据更新应该使用重定向

## servlet重要的接口
ServletConfig-获取初始化参数和ServletContext对象

ServletContext-通过该对象访问Servlet的各种资源\
Servlet上下文，一个容器只有一个该对象，所有servlet对象共享

HttpServeltRequest-Http请求对象

HttpServletResponse-Http响应对象\
响应状态码：1、服务器收到请求，需要请求者继续操作；2、请求已被服务器收到、理解、并接收；3、客户端需要进一步操作才能完成请求
4、客户端错误；5、服务器处理过程中有错误发生\
相应行由报文协议和版本以及状态码和状态描述构成\
PrintWriter对象所使用的字符集编码。 response.setCharacterEncoding("UTF-8"); 只能用来设置PrintWriter输出流中字符的编码方式，它的优先权最高。 response.setContentType("text/html;charset=UTF-8"); 既可以设置PrintWriter输出流中字符的编码方式，也可以设置浏览器接收到 这些字符后以什么编码方式来解码，它的优先权低于第一种方法。 response.setLocale(new java.util.Locale("zh","CN")); 只能用来设置PrintWriter输出流中字符的编码方式，它的优先权最低，在已 经使用前两种方法中的一个设置了编码方式以后，它将被覆盖而不再起作用


## Http协议
请求行、请求头、可选的请求正文

## ServletConfig接口
getInitParameter() 给定初始化参数名称，返回匹配的初始化参数值\
getInitParameterNames() 返回一个枚举，包含所有的初始化参数名\
getServletContext()获取当前ServletContext对象\
getServletName()获取当前Servlet名字



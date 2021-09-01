<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/31
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="/res/layui-v2.5.6/layui/css/layui.css">
    <script src="/res/layui-v2.5.6/layui/layui.js"></script>
</head>
<body>
    <%--<button class="layui-btn layui-btn-danger">测试静态资源是否能够访问</button>--%>
    <div>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>注册</legend>
        </fieldset>
        <form class="layui-form" action="" onsubmit="return false">
            <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="adminName" class="layui-input">
                </div>
            </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="adminPwd" class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">重复密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="adminPwdR" class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">入职时间</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" name="adminTime" id="adminTime" placeholder="yyyy-MM-dd HH:mm:ss">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="adminSex" value="男" title="男" checked="">
                    <input type="radio" name="adminSex" value="女" title="女">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">爱好</label>
                <div class="layui-input-block">
                    <input type="checkbox" name="hobby" value="抽烟" title="抽烟">
                    <input type="checkbox" name="hobby" value="喝酒" title="喝酒" checked="">
                    <input type="checkbox" name="hobby" value="烫头" title="烫头">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">就业城市</label>
                <div class="layui-input-inline">
                    <select name="adminCity">
                        <option value="">请选择</option>
                        <option value="深圳">深圳</option>
                        <option value="上海">上海</option>
                        <option value="杭州">杭州</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">是否专升本</label>
                <div class="layui-input-block">
                    <input type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchTest" lay-text="是|否">
                </div>
            </div>
            <%--使用layui的属性接收和bean接收
            后台显示打印效果即可
                性别    单选框
                爱好    多选框  抽烟、喝酒、烫头
                就业城市    下拉框---深圳、上海、杭州
                是否专升本    开关

            --%>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="regBtn">立即注册</button>
                    <%--<button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
                </div>
            </div>
        </form>
    </div>

    <script>
        layui.use(['form','layer','jquery','laydate'], function() {
                var form = layui.form;
                var layer = layui.layer;
                var $ = layui.jquery;
                var laydate = layui.laydate;

            //日期时间选择器
            laydate.render({
                elem: '#adminTime'
                ,type: 'datetime'
            });

            //监听指定开关
            form.on('switch(switchTest)', function(data){
                console.log(data)
                console.log(data.othis.text())
                layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                    offset: '6px'
                });
                /*layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)*/
            });
                form.on('submit(regBtn)',function (data) {
                    //layer.msg(JSON.stringify(data.field));
                    $.ajax({
                        url:'/api/admin/regByBean',
                        type:'POST',
                        data:data.field,
                        dataType:'JSON',
                        success:function (res) {
                            console.log(res)
                            if(res.code==0){
                                window.location.href="/pages/login"
                            }else if(res.code==4401){
                                layer.msg("你输入的密码和重复密码不一致")
                            }else{
                                layer.msg("填写完整表单")
                            }
                        }

                    });
                });
            });
    </script>
</body>
</html>

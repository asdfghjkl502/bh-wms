/* 慧学习JS代码 */ 
/* 初始化首页的侧边栏和内容区的高度 */ 
var $;
var element;
var dropdown;
var layer;

layui.use(['jquery','dropdown','element','layer'],function(){
	//加载jquery模块
	$ = layui.jquery;
	dropdown = layui.dropdown;
	element = layui.element;
	layer = layui.layer;
	//获取浏览器总宽度
	var $ww = $(window).width();
	//获取浏览器的总高度
	var $wh = $(window).height();
	//设置右侧内容区宽度
	var $hcr = $(".hxx-container-right");
	$hcr.css({
		"width":$ww-200,
		"margin":"0 5px"
	});
	//设置内容区高度
	var $hcri = $(".hxx-iframe");
	$hcri.css({
		"height":$wh-148
	});
	//设置登录页面的内容高度
	let $login = $(".login");
	$login.css({
		"height":$wh
	});
	//刷新验证码
	$("#vc").click(function () {
		//获取验证码地址
		this.src=this.src+"?"+Math.random();
	});
	//展示用户昵称
	//获取用户昵称
	let cookies = document.cookie;
	let split = cookies.split(";");
	let c = {};
	for (let i = 0; i < split.length; i++) {
		let ss = split[i].split("=");
		c[ss[0].trim()]=ss[1]; //key值需要去空格
	}
	//将昵称展示到前端用户展示位置(页面右上角)
	$("#userNick").html(c.userNick);

	//修改信息事件处理
	$("#muid").click(function () {
		layer.open({
			type: 2,
			title: '修改用户信息',
			shadeClose: true,
			shade: false,
			area: ['500px', '500px'],
			content: 'pages/user_info.html',
			end:function () {
				location.reload();//刷新
			}
		});
	});
	/**
	 *  获取用户头像
	 *  1. 判断是否登录,cookie是否有值
	 *  2. 如果不存在值,说明没有登录,不需要查询
	 */
	if(c!=null && c.userId!=null && c.userId!="" && c.userId!="undefined"){
		$.getJSON("/getUserDetail",{userId:c.userId},function (d) {
			console.log(d);
			if(d.code===0){
				//获取头像的DOM节点
				$("#avatarId")[0].src=d.obj.avatar;
			}else{
				layer.msg(d.msg);
			}
		});
	}


});

/**
 * 添加选项卡
 */
function add_tab(title,url){
	//根据地址生成md5值,方便进行切换选项卡以及选项卡重复点击问题
	var tabId = md5(url);
	/**
	 * 判断重复点击,如果重复点击直接切换到已经存在的选项卡,如果不存在,那么重新生成
	 * 根据内容区自动判断选项卡是否存在
	 */
	for(var i=0;i<$(".hxx-iframe").length;i++){
		if($(".hxx-iframe").eq(i).attr("tab-id")==tabId){
			element.tabChange("nav_filter",tabId);
			return;
		}
	}
	//添加
	element.tabAdd("nav_filter",{
		title:title,
		id:tabId,
		content:'<iframe style="border: none;" tab-id="'+tabId+'" frameborder=0 scrolling="yes" class="hxx-iframe" src="'+url+'"></iframe>'
	});
	//切换
	element.tabChange("nav_filter", tabId);
	//设置高度
	var $wh = $(window).height();
	var $hcri = $(".hxx-iframe");
	$hcri.css({
		"height":$wh-148
	});
}
//初始化首页
$(function(){
	//记载欢迎页
	loadPage("pages/welcome.html");
	//菜单初始化
	clickMenu();
});

//加载页面函数
function loadPage(url){
	$(".showContent").load(url);
}

// 菜单操作函数
function clickMenu(){
	//获取所有的子菜单项
	var menus = $("#accordion>.panel-default .panel-collapse>.list-group>.list-group-item>a");
	//给菜单绑定单击响应事件
	for(let i=0;i<menus.length;i++){
		$(menus[i]).click(function(){
			//调用加载页面函数进行页面加载
			loadPage(this.href);
			//取消默认提交
			return false;
		});
	}
}

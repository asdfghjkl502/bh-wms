/* 慧学习JS代码 */ 
/* 初始化首页的侧边栏和内容区的高度 */ 
var $;
var element;
var dropdown;

layui.use(['jquery','dropdown','element'],function(){
	//加载jquery模块
	$ = layui.jquery;
	dropdown = layui.dropdown;
	element = layui.element;
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
		"height":$wh-130
	});
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
		"height":$wh-130
	});
}
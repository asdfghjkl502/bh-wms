//初始化默认时间
let s = getCurrentTime();
$(".currentTime").html(s);

setInterval(function(){
	let s = getCurrentTime();
	$(".currentTime").html(s);
},500);


/**
 * 获取当前时间
 */
function getCurrentTime(){
	//创建当前时间
	let c = new Date();
	let s = "";

	//年
	s+=c.getFullYear()+"-";
	//月
	var month = c.getMonth()+1+"-";
	s+= month.length==2?"0"+month:month;
	//日
	var d = c.getDate()+" ";
	s+= d.length==2?"0"+d:d;
	//时
	var h = c.getHours()+":";
	s+= h.length==2?"0"+h:h;
	//分
	var m = c.getMinutes()+":";
	s+=m.length==2?"0"+m:m;
	//秒
	var str=c.getSeconds()+"";
	s+=str.length==1? "0"+c.getSeconds():c.getSeconds();
	return s;	
}
$.get("./api/vgsites", function(data){
	$("#vglist").html(data.listHtml)
	$("#Label2").html(data.date)
});
function downUrlFmt(value, row, index){
	if(value.indexOf("pan.baidu.com") > 0){
		return "<span class='button-wrap'><button class='button button-circle button-tiny' onclick=' window.location.href=\""+value+"\"'><i class='fa fa-cloud'></i></button></span>";
	}else if(value.indexOf("ed2k") != -1){
		return "<a href='" + value +"' target='_blank'>ed2k</a>";
	}else{
		return "<span class='button-wrap'><button class='button button-circle button-raised button-primary button-tiny' onclick=' window.location.href=\""+value+"\"'><i class='fa fa-download'></i></button></span>";
	}
}
function indexFormatter(value, row, index){
	return index + 1;
}
function nameFmt(value, row, index){
	//return "<a href='"+row.downUrl+"' target='_blank'>"+value+"</a>"
	return value;
}
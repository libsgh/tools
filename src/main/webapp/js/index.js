$.get("./api/vgsites", function(data){
	$("#vglist").html(data.listHtml)
	$("#Label2").html(data.date)
});
function activeToolFmt(value, row, index){
	if(value.indexOf("-")>0){
		return value;
	}
	var as = value.split("&&");
	var html = "";
	$.each(as, function(i,item){
		var ss = item.split("/");
		html+= "<a href='" + value +"' target='_blank'>"+ss[ss.length-1]+"</a>";
		if(i != as.length-1){
			html+="&nbsp;&&nbsp;"
		}
	});
	return html;
}
function indexFormatter(value, row, index){
	var option = $("table").bootstrapTable('getOptions');
	var pageSize = option.pageSize;
	var pageNumber = option.pageNumber;
	return pageSize * (pageNumber - 1) + index + 1;
}
function vnameFmt(value, row, index){
	return "<a href='"+row.downUrl+"' target='_blank'>"+value+"</a>"
}
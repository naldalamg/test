function getList(url){

    $.ajax({
        type:'post'
        ,url:url
        ,data: $('#testForm').serialize()
        ,dataType: 'json'
        ,success:function(obj){
			
        	let html = '';
        	
            if(obj != null){
				
				$(obj.hrList).each(function(idx, data){
					html += '<tr class="HRList_content">';
					html += '<td>'+idx+'</td>';
					html += '<td>'+data.employee_id+'</td>';
					html += '<td>'+data.full_name+'</td>';
					html += '<td>'+data.department_id+'</td>';
					html += '<td>'+data.department_name+'</td>';
					html += '</tr>';
				});
				
				$("#boardList").append(html);
				//html = '<tr class="HRList_content">'
            }else{
                alert('no data');
            }

        }
        ,error:function(e){
            console.log(e);
        }

    });
}

function getList2(){
	
	$.getJSON('${contextPath}/mainHRListAjax.html', function (data) {
		console.log(data);
    });
	
}
<%@page import="front.notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="front.notice.service.NoticeService"%>
<%@page import="front.notice.service.NoticeServiceImpl"%>      
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�������� ��ü��ȸ</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
	}
				

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	
	function checkOnly(chk){
		
		var chkObj = document.getElementsByName("nnumCheck");
		console.log("chkObj >>> : " + chkObj);
		for (var i=0; i < chkObj.length; i++){
			if (chkObj[i] != chk){
				chkObj[i].checked = false;
			}
		}
	}
	
	$(document).ready(function(){	

		
		$("#I").click(function(){			
			location.href='/Hoppies/front/notice/notice.html';			
		});
		
	
		$("#SALL").click(function(){			
			var isudType = document.noticeSelectAllForm.ISUD_TYPE.value = "SALL";			
			send(isudType);		
		});
		
		
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{					
				var v1 = $("#ISUD_TYPE").val('U');
				
				send(v1);				
			}			
		});
		
	
	
		$("#DOK").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{				
			
				var v2 = $("#ISUD_TYPE").val('DOK');
				
				send(v2);
			}					
		});
		
		
		function chkInfo(){			
			var obj = document.getElementsByName("nnumCheck");
			var nCnt = 0;			
			for(var i=0; i < obj.length; i++){ 
	          	if (obj[i].checked == true){ 
	          		nCnt++;
	          	}		          			            
	        }			
				
			return nCnt;
		}
		
		
		function send(isudType){
			
			
			$("#noticeSelectAllForm").attr({
				"action":"/testKosmo/notice?ISUD_TYPE="+isudType,
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
	});

</script>	
</head>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<%
	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<NoticeVO> aList = (ArrayList<NoticeVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ��ü ��ȸ �Ǽ�  " + nCnt + " ��");	
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	
</font>
</td>
</tr>
</table>
<hr>
<hr>
<form name="noticeSelectAllForm" id="noticeSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">����</td>
	<td class="tt">��ȣ</td>
	<td class="tt">������</td>
	<td class="tt">����</td>
	<td class="tt">����</td>
	<td class="tt">��������</td>
	<td class="tt">�����</td>
	<td class="tt">������</td>
</tr>
</thead>
<%
	for(int i=0; i<nCnt; i++){
		
		NoticeVO nvo = aList.get(i);

%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="nnumCheck" name="nnumCheck" value=<%= nvo.getNnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= nvo.getNnum() %> </td>
	<td class="tt"><%= nvo.getNsubject() %> </td>
	<td class="tt"><%= nvo.getNmemo() %> </td>
	<td class="tt"></td>
	<td class="tt"><%= nvo.getDeleteyn() %> </td>		
	<td class="tt"><%= nvo.getnInsertdate() %> </td>
	<td class="tt"><%= nvo.getnUpdatedate() %> </td>		
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="9" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
		<input type="button" value="���" id="I">
		<input type="button" value="��ȸ" id="SALL">
		<input type="button" value="����" id="U">
		<input type="button" value="����" id="DOK">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>


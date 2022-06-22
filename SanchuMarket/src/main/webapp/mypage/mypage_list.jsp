<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style type="text/css">
	#box{
		width: 1200px;
		margin: auto;
		margin-top: 20px;
		padding-right: 20px;
	}
	#collapse{
		text-align: center;
		width: 600px;
		margin: auto;
	}
	th{
		margin:auto;
		text-align: center;
	}
	td{
		text-indent: 10px;
	}

</style>
</head>
<body>
	<jsp:include page="index.jsp"/>
	<div id="box" align="center" width="600px" >
		<table id="collapse"  border="1" style="border-collapse:collapse; font-size:8pt"
				 bordercolor="navy" cellpadding="4" cellspacing="0" >
		
		<hr>
			<tr >
				<th>����</th>
				<th>��ǰ��</th>
				<th>����</th>
				<th>�ǸŻ���</th>
				<th>�ø���¥</th>
				<th>���</th>
			</tr>
			<br>
			
			<!-- data���� ��� -->
			<c:if test="${empty list}">
				<td colspan="6" align="center">
					<font color="red">��ϵ� ��ǰ�� �����ϴ�</font>
				</td>
			</c:if>
			<!-- data �ִ� ���-->
			<c:forEach var="vo" items="${list }">
				<tr>
					<th><img src="../images/${vo.img}" width="100" height="90"></th>
					<th>${vo.p_name }</th>
					<th>${vo.price }</th>
					<th>${vo.p_status }</th>
					<th>${vo.p_date }</th>
					<th>
						<input type="button" value="����������" onclick=""><br>
						<input type="button" value="�����ϱ�" onclick="">
					</th>
				</tr>
			</c:forEach>
			<br><hr><br>
			<table>
				<tr>
					<td>
						<input class="btn btn-info" type="button" value="ȸ����������" onclick="">
						<input class="btn btn-danger" type="button" value="ȸ��Ż��" onclick="">
						<input class="btn"  type="button" value="���ư���" onclick="">
					</td>
				</tr>
			</table>
		</table>
	</div>
</body>
</html>












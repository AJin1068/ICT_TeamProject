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
	}
	#title{
		text-align: center;
		color: cccccc;
	}
	th{
		text-align: center;
	}
	td{
		text-indent: 10px;
	}

</style>
</head>
<body>
	<div id="box">
		<h1 id="title">���� ������</h1>
		<table>
		<hr>
		
		<table>
			<tr>
				<td>
					<input class="btn"  type="button" value="�� �ǸŸ��" onclick="">
					<input class="btn"  type="button" value="�� ����" onclick="">
				</td>
			</tr>
		</table>
		
		<hr>
			<tr>
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
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
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
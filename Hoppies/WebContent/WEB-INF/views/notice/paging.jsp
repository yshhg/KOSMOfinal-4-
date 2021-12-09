<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>

<%
	/**********************************
	�����ؾ� �� ����
	***********************************/
	String	url = null;
	String	str = null;
	
	url = request.getParameter("url");
	System.out.println("url >>> : " + url);
	
	str = request.getParameter("str");
	System.out.println("str >>> : " + str);
	
	if(str != null)
	{
		str = str + "&";
		System.out.println("str + & >>> : " + str);
	}
%>

<%
	/**********************************
	������ �׺���̼� ���� ����
	***********************************/
	// ���������� ������ �Խù��� ��
	int pageSize = 0;
	
	// �׷��� ũ��
	int groupSize = 0;
	
	// ��ü �Խù��� ����
	int totalCount = 0;
	
	//���� ������
	int curPage = 0;
	
	// ��ü �������� ����
	int pageCount = 0;
	
	if(request.getParameter("pageSize") != null)
	{
		pageSize = Integer.parseInt(request.getParameter("pageSize"));//10
		System.out.println("pageSize>>>"+pageSize);
	}
	
	if(request.getParameter("groupSize") != null)
	{
		groupSize = Integer.parseInt(request.getParameter("groupSize"));//5
		System.out.println("groupSize>>>"+groupSize);
	}
	
	if(request.getParameter("curPage") != null)
	{
		curPage = Integer.parseInt(request.getParameter("curPage"));//1
		System.out.println("curPage>>>"+curPage);
	}
	
	if(request.getParameter("totalCount") != null)
	{
		totalCount = Integer.parseInt(request.getParameter("totalCount"));//400
		System.out.println("totalCount>>>"+totalCount);
	}
	
	// ��ü�Խù����� ������ũ�⸦ ������ ��ü ������ ������ �����.
	// �Ҽ����� ���� ������ ������ ������ �Ѱ���.
	pageCount = (int)Math.ceil(totalCount / (pageSize+0.0));
	System.out.println("pageCount>>>>"+pageCount);
	//(0/page)
	
	// ����׷� ����
	//1-1/5
	int curGroup = (curPage-1) / groupSize;
	System.out.println("curGroup>>>>"+curGroup);
	
	//0*0
	int linkPage = curGroup * groupSize;
	System.out.println("linkPage>>>>"+linkPage);
%>
<p align="right">
<%
	// ù��° �׷��� �ƴѰ��
	if(curGroup > 0) {
		
	//boardSelectList.jsp?&curPage=1	
	//boardSelectList.jsp?&curPage=0
%>
	<a href="<%=url%>?<%=str%>curPage=1">����</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>">��</a>&nbsp;&nbsp;&nbsp;
<%
	}
	else
	{
%>
		����&nbsp;&nbsp;&nbsp��&nbsp;&nbsp;&nbsp;
<%
	}
	
	// ���� ��ũ�� ���� ������Ŵ
	linkPage++;
	System.out.println("linkPage++>>>>"+linkPage);
	//1
	
	int loopCount = groupSize;
	System.out.println("loopCount>>>"+loopCount);
	//5
	
	// �׷���������� ������ ��ũ����.
	//5>0 && 1<=40
	while((loopCount > 0) && (linkPage <= pageCount))
	{
		//1==1
		if(linkPage == curPage)
		{
			System.out.println("�׷���������� ������ ��ũif");
		//linkPage :1
%>
	<%=linkPage%>
<%
		}
		else
		{
			System.out.println("�׷���������� ������ ��ũelse");
			//[2][3][4][5]
%>
	[<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>"><%=linkPage%></a>]&nbsp;
<%
		}
		
		linkPage++;
		loopCount--;
	}
	
	// �����׷��� �ִ� ���
	//		6			40
	if(linkPage <= pageCount)
	{
		System.out.println("�����׷��� �ִ� ��� linkPage>>>"+linkPage);
		System.out.println("�����׷��� �ִ� ���pageCount>>>"+pageCount);
		
	//	boardSelectList.jsp?&curPage=6
	//	boardSelectList.jsp?&curPage=40	
%>
	<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>">��</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=url%>?<%=str%>curPage=<%=pageCount%>">����</a>&nbsp;&nbsp;&nbsp;
<%
	}
	else
	{
		System.out.println("�����׷��� �ִ� ��� linkPage>>>"+linkPage);
		System.out.println("�����׷��� �ִ� ���pageCount>>>"+pageCount);
		System.out.println("�����׷��� �ִ� ���_else");
%>
	��&nbsp;&nbsp;&nbsp;����&nbsp;&nbsp;&nbsp;
<%
	}
%>
</p>
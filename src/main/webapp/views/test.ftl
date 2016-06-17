<html>
<body>
<p>当前页：${page.currentPage}</p>
<p>总记录数：${page.totalRecords}</p>
<p>总页数：${page.totalPages}</p>
<p>是否有前页：${page.hasPreviousPage?string}</p>
<p>是否有下页：${page.hasNextPage?string}</p>
<p>每页记录数：${page.pageRecords}</p>
<p><#list page.slider as slider>
	${slider}
</#list>
</p>
<#list page.records as operator>
	<p>${operator.id},${operator.operatorId},${operator.name},${operator.password},${operator.roleId}</p>

</#list>
</body>
</html>
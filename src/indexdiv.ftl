<div>
	<table class = "custom">
		<colgroup><col class = "tbF1"><col class = "tbF2"><col></colgroup>
		<tr>
			<th colspan="3">${description}</th>
		</tr>
		<#if readlist?size!=0>
			<#list readlist as read>
				<#if read_index==0>
					<tr>
						<td rowspan="${readlist?size}">读取接口</td>
						<td><a href="${read.auri}">${read.uri}</a></td>
						<td>${read.methodpath!""}</td>
					</tr>
				<#else>
					<tr>
						<td><a href="${read.auri}">${read.uri}</a></td>
						<td>${read.methodpath!""}</td>
					</tr>
				</#if>
			</#list>
		</#if>
		
		<#if writelist?size!=0>
			<#list writelist as write>
				<#if write_index==0>
					<tr>
						<td rowspan="${writelist?size}">写入接口</td>
						<td><a href="${write.auri}">${write.uri}</a></td>
						<td>${write.methodpath!""}</td>
					</tr>
				<#else>
					<tr>
						<td><a href="${write.auri}">${write.uri}</a></td>
						<td>${write.methodpath!""}</td>
					</tr>
				</#if>
			</#list>
		</#if>
	</table>
</div>
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>MENU DE PIZZAS</title>
			</head>
			<body>
				<h1>LIST OF ANIMALS</h1>
				<table border="1">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Species</th>
						<th>Breed</th>
						<th>Age</th>
						<th>Sterilised</th>
					</tr>
					<xsl:for-each select="animals/animal">
						<tr>
							<td><xsl:value-of select="id"/></td>
	          				<td><xsl:value-of select="name"/></td>
	          				<td><xsl:value-of select="species"/></td>
	          				<td><xsl:value-of select="breed"/></td>
	          				<td><xsl:value-of select="age"/></td>
	          				<td><xsl:value-of select="sterilised"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>

<?xml version="1.0" encoding="euc-kr" ?>

<xsl:stylesheet 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method = "html" indent="yes" encoding="euc-kr" />
    <xsl:template match="list">
<html>
<head><title>å ���</title></head>
<body>
���� ��ϵǾ� �ִ� å�� ����� ������ �����ϴ�.
<ul>
    <xsl:for-each select="book">
    <li><b><xsl:value-of select="title" /></b>
    (<xsl:value-of select="price" /> ��)
    <br />
    <i><xsl:value-of select="author" /></i>
    </li>
    </xsl:for-each>
</ul>
</body>
</html>
    </xsl:template>
</xsl:stylesheet>

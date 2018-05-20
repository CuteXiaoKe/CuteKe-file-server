<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/resume">
        <html>
            <head>
                <title>个人简历</title>
                <meta name="author" content="CuteKe小站"/>
                <meta name="description" content="个人简历"/>
                <link rel="stylesheet" type="text/css" href="css/resume.css"/>
                <meta charset="UTF-8"/>
            </head>
            <body>
                <div style="width: 620px;">
                    <div>
                        <img class="leftImage" src="img/resume/person.png"/>
                        <xsl:element name="img">
                            <xsl:attribute name="src">img/avator/<xsl:value-of select="person/imgName"/>
                            </xsl:attribute>
                            <xsl:attribute name="class">rightImage</xsl:attribute>
                        </xsl:element>
                        <p class="fontStyle">个人信息</p>
                        <hr class="hrStyle1"/>
                    </div>
                </div>
                <div class="alignDiv">
                    <table>
                        <tbody>
                            <tr>
                                <td>姓&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;名：</td>
                                <td>
                                    <xsl:value-of select="person/name"/>
                                </td>
                                <td class="rightTd">出生年月：</td>
                                <td>
                                    <xsl:value-of select="person/birth"/>
                                </td>
                            </tr>
                            <tr>
                                <td>电&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;话:</td>
                                <td>
                                    <xsl:value-of select="person/telephone"/>
                                </td>
                                <td class="rightTd">政治面貌：</td>
                                <td>
                                    <xsl:value-of select="person/politics"/>
                                </td>
                            </tr>
                            <tr>
                                <td>邮&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;箱：</td>
                                <td>
                                    <xsl:value-of select="person/email"/>
                                </td>
                                <td class="rightTd">意向岗位：</td>
                                <td>
                                    <xsl:value-of select="person/target"/>
                                </td>
                            </tr>
                            <tr>
                                <td>籍&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;贯：</td>
                                <td>
                                    <xsl:value-of select="person/location"/>
                                </td>
                                <td class="rightTd"></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div style="width: 700px;margin-top:20px;">
                    <div>
                        <img class="leftImage" src="img/resume/education.png"/>
                        <p class="fontStyle">教育背景</p>
                        <hr class="hrStyle2"/>
                    </div>
                    <div class="alignDiv">
                        <table style="font-weight:bold">
                            <tbody>
                                <xsl:for-each select="education/educationOne">
                                    <tr>
                                        <td>
                                            <xsl:value-of select="date"/>
                                        </td>
                                        <td class="rightTd2">
                                            <xsl:value-of select="school"/>
                                        </td>
                                        <td class="rightTd3">
                                            <xsl:value-of select="major"/>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div style="width: 700px;margin-top:20px;">
                    <div>
                        <img class="leftImage" src="img/resume/skill.png"/>
                        <p class="fontStyle">专业技能</p>
                        <hr class="hrStyle2"/>
                    </div>
                    <div class="alignDiv">
                        <ul>
                            <xsl:for-each select="skill/skillOne">
                                <li>
                                    <xsl:value-of select="."/>
                                </li>
                            </xsl:for-each>
                        </ul>
                    </div>
                </div>
                <xsl:if test="practice/practiceOne">
                    <div style="width: 700px;margin-top:20px;">
                        <div>
                            <img class="leftImage" src="img/resume/practice.png"/>
                            <p class="fontStyle">实习经历</p>
                            <hr class="hrStyle2"/>
                        </div>
                        <xsl:for-each select="practice/practiceOne">
                            <div class="alignDiv">
                                <table style="color:#1B9CDF;font-weight:bold;margin-top:20px">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <xsl:value-of select="company"/>
                                            </td>
                                            <td class="rightTd2">
                                                <xsl:value-of select="department"/>
                                            </td>
                                            <td class="rightTd3">
                                                <xsl:value-of select="date"/>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <p class="content" style="margin-top:10px;">
                                    <xsl:value-of select="description"/>
                                </p>
                            </div>
                        </xsl:for-each>
                    </div>
                </xsl:if>
                <div style="width: 700px;margin-top:20px;">
                    <div>
                        <img class="leftImage" src="img/resume/project.png"/>
                        <p class="fontStyle">项目经验</p>
                        <hr class="hrStyle2"/>
                    </div>
                    <xsl:for-each select="project/projectOne">
                        <div class="alignDiv">
                            <table style="color:#1B9CDF;font-weight:bold;margin-top:20px">
                                <tbody>
                                    <tr>
                                        <td>
                                            <xsl:value-of select="name"/>
                                        </td>
                                        <td class="rightTd2">
                                            <xsl:value-of select="duty"/>
                                        </td>
                                        <td class="rightTd3">
                                            <xsl:value-of select="date"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <p style="margin-top:10px;font-weight:bold">
                                项目简介：
                            </p>
                            <p class="content" style="margin-top:0px;">
                                <xsl:value-of select="introduction"/>
                            </p>
                            <p style="margin-top:10px;font-weight:bold">
                                负责工作：
                            </p>
                            <ol>
                                <xsl:for-each select="job/jobOne">
                                    <li>
                                        <xsl:value-of select="."/>
                                    </li>
                                </xsl:for-each>
                            </ol>
                        </div>
                    </xsl:for-each>
                </div>
                <xsl:if test="honor/honorOne">
                    <div style="width: 700px;margin-top:20px;">
                        <div>
                            <img class="leftImage" src="img/resume/honor.png"/>
                            <p class="fontStyle">获得荣誉</p>
                            <hr class="hrStyle2"/>
                        </div>
                        <div class="alignDiv">
                            <table>
                                <tbody>
                                    <xsl:for-each select="honor/honorOne">
                                        <tr>
                                            <td>
                                                <xsl:value-of select="date"/>
                                            </td>
                                            <td class="rightTd3">
                                                <xsl:value-of select="info"/>
                                            </td>
                                        </tr>
                                    </xsl:for-each>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </xsl:if>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
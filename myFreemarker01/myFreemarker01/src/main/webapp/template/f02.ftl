<#--数据类型-->

<#--布尔类型-->
<#--${flag}不能直接输出，需转换为字符串-->
${flag?c} <br>
${flag?string} <br>
${flag?string("iii","ooo")} <br>
<hr>
<#--${flag?then} <br>-->
${flag?then("what", "the")} <br>
<hr>
<#--日期类型-->
<#--不能直接输出-->
<#--${date}-->
${date?time}<br>
${date?date}<br>
${date?datetime}<br>
<#--${date?string}-->
${date?string("yyyy/MM/dd HH:mm:ss")}<br>
<hr>
<#--数值类型-->
${age}<br>
${avg}<br>
<#--多余3位数的数字默认会加上逗号分隔-->
${salary}<br>
<#-- 将数值转换成字符串类型 -->
${salary?c}<br>
<#-- 将数值转换成字符串类型要用c，用string的话后面需跟要转换成的类型，单独的string在转换时无效 -->
<#--${salary?string}<br>-->
${salary?string.currency}<br>
${salary?string.percent}<br>
${avg?string.percent}<br>
<#--保留#个数个小数位，按照四舍五入的规则-->
${avg?string["0.#"]}<br>
${avg?string["0.##"]}<br>
<hr>
<#--字符串类型数据-->
${msg}<br>
${msg2}<br>
${msg?string}<br>
${msg?substring(2)}
${msg?substring(1,3)}
${msg?uncap_first}
${msg2?cap_first}
${msg?lower_case}
${msg?upper_case}
${msg?length}
${msg?starts_with("He")?c}
${msg2?ends_with("er")?c}
${msg?index_of("l")}

${msg2?trim}<br>
${msg2?replace("free", "freedom")}
<hr>
<#--空值处理-->
<#-- 不存在的值，报错 -->
<#--${aa}-->
<#-- 值为null的数据，报错 -->
<#--${emp}-->
${emp2}<br>
${aa!}<br>
${emp!}<br>
${aa!"aa不存在或者为null"}<br>
${emp!"emp不存在或者为null"}<br>

${(aa??)?c}
${(emp??)?c}
${(emp2??)?c}<br>
<br>
<#--序列类型（数组、List、Set）-->
<#list stars as star>
    index1: ${star_index} - name: ${star}<br>
    <#--    "." 不适用-->
<#--    index2: ${star.index} - name: ${star}<br>-->
</#list>
获取序列的长度：${stars?size}<br>
获取第一个元素：${stars?first}<br>
获取最后一个元素： ${stars?last}<br>
<hr>
<#list  cityList as city>
    index:${city_index} - name: ${city}<br>
</#list>

<#list  cityList?reverse as city>
    ${city} -
</#list>
<br>
<#list  cityList?sort as city>
    ${city} -
</#list>
<br>
<#list  cityList?sort?reverse as city>
    ${city} -
</#list>
<br>
<#list userList as user>
    num: ${user.userId} &nbsp; name: ${user.uname} &nbsp; ${user.uage}<br>
</#list>
<#list userList?sort_by("uage") as user>
    num: ${user.userId} &nbsp; name: ${user.uname} &nbsp; ${user.uage}<br>
</#list>

<#--hash类型-->
<#list cityMap?keys as key>
    ${key_index} -- ${key} - ${cityMap[key]}<br>
</#list>
<br>
<#list cityMap?values as value>
    ${value_index} -- ${value} <br>
</#list>

<hr>
cityMap["sh"]: ${cityMap["sh"]}

<html>
<head>
    <title>게시판 리스트</title>
</head>
<body>
<a href="/article/create"><button >새글</button></a>
<table border="1">
    <thead>
    <tr>
        <td>no.</td>
        <td width="150">제목</td>
        <td>글쓴이</td>
    </tr>
    </thead>
    <tbody>
        <#list articles as item>
        <tr>
            <td>${item.id}</td>
            <td><a href="/article/${item.id}"> ${item.title}</a></td>
            <td>${item.author}</td>
        </tr>
        </#list>
        <tr>
            <td colspan="3">
                <ul class="pager">
                <#if paging.pageNo != paging.startPageNo>
                    <li class="previous">
                        <a href="/articles/${paging.prevPageNo}">&larr; 이전페이지</a>
                    </li>
                </#if>

                <#if paging.pageNo != paging.finalPageNo>
                    <li class="next">
                        <a href="/articles/${paging.nextPageNo}">다음페이지 &rarr;</a>
                    </li>
                </#if>
                </ul>
            </td>
        </tr>
    </tbody>
</table>


<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
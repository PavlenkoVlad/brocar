<#macro navbar selected="main">
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="utf-8">

        <title>BroCar</title>

        <script src="/js/jquery.min.js"></script>

        <link href="/css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

        <script src="/js/bootstrap.min.js"></script>
    </head>
    <body>
    <nav class="navbar navbar-inverse" style="border-radius: 0px; border-width: 0px">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#navbar" aria-expanded="false">
                    <span class="sr-only">Навигация</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">BroCar</a>
            </div>

            <div class="collapse navbar-collapse" id="navbar" aria-expanded="false">
                <ul class="nav navbar-nav navbar-right">

                    <#if selected == "main">
                        <li class="active"><a href="/">Главная</a></li>
                    <#else>
                        <li><a href="/">Главная</a></li>
                    </#if>

                    <#if selected == "search">
                        <li class="active"><a href="/search">Поиск</a></li>
                    <#else>
                        <li><a href="/search">Поиск</a></li>
                    </#if>

                    <#if selected == "about">
                        <li class="active"><a href="/about">О нас</a></li>
                    <#else>
                        <li><a href="/about">О нас</a></li>
                    </#if>

                    <#if selected == "contacts">
                        <li class="active"><a href="/contacts">Контакты</a></li>
                    <#else>
                        <li><a href="/contacts">Контакты</a></li>
                    </#if>

                    <#if user??>
                        <#if role == "ADMIN">
                            <#if selected == "admin">
                                <li class="active"><a href="/admin">Админ. панель</a></li>
                            <#else>
                                <li><a href="/admin">Админ. панель</a></li>
                            </#if>
                        </#if>
                    </#if>

                    <#if user??>
                        <li><a href="/logout">Выйти</a></li>
                    <#else>
                        <#if selected == "login">
                            <li class="active"><a href="/login">Войти</a></li>
                        <#else>
                            <li><a href="/login">Войти</a></li>
                        </#if>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>

    <#nested>

    </body>
</html>
</#macro>
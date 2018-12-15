<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">

    <title>BroCar</title>

    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/index-cover.css" rel="stylesheet">
</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">BroCar</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li class="active"><a href="/">Главная</a></li>
                            <li><a href="/search">Поиск</a></li>
                            <li><a href="/about">О нас</a></li>
                            <li><a href="/contacts">Контакты</a></li>

                            <#if user??>
                                <#if role == "ADMIN">
                                    <li><a href="/admin">Админ. панель</a></li>
                                </#if>
                            </#if>

                            <#if user??>
                                <li><a href="/logout">Выйти</a></li>
                            <#else>
                                <li><a href="/login">Войти</a></li>
                            </#if>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">Начните прямо сейчас!</h1>
                <p class="lead">BroCar - это удобное средство для поиска СТО в вашем городе. Больше вам не нужно звонить знакомым в поисках проверенного и подходящего СТО. Именно с BroCar, Вы, сможете быстро подобрать лучшее СТО, по приемлимой цене.</p>
                <p class="lead">
                    <a href="/search" class="btn btn-lg btn-default">Начать поиск</a>
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>BroCar. Курсовая работа 2018.</p>
                </div>
            </div>

        </div>

    </div>

</div>
</body>
</html>

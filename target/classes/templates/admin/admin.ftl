<#import "../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Добро пожаловать!</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h3>Это панель админисратора. Здесь можно добавлять, редактировать и удалять записи. Будь внимателен и остарожен!</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <a href="/admin/markCar"><button type="button" class="btn btn-default">Перейти к таблицам</button></a>
            </div>
        </div>
    </div>
</@n.navbar>


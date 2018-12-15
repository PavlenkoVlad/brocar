<#import "common/navbar.ftl" as n>

<@n.navbar selected="login">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Авторизация</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <form class="form-horizontal" action="/login" method="post">
                <div class="form-group">
                    <label for="username" class="col-md-2 col-md-offset-3 control-label">Логин</label>
                    <div class="col-md-2">
                        <input type="text" class="form-control" id="username" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-md-2 col-md-offset-3 control-label">Пароль</label>
                    <div class="col-md-2">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 col-md-offset-5" style="text-align: center">
                        <button type="submit" class="btn btn-default">Войти</button>
                        <h3>или</h3>
                        <a href="/registration">
                            <button type="button" class="btn btn-default">Зарегистрироваться</button>
                        </a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</@n.navbar>
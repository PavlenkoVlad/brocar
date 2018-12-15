<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/admin/markCar">Марки</a></li>
        <li role="presentation"><a href="/admin/modelCar">Модели</a></li>
        <li role="presentation"><a href="/admin/service">Услуги</a></li>
        <li role="presentation"><a href="/admin/ars">СТО</a></li>
        <li role="presentation"><a href="/admin/timetable">Расписание</a></li>
        <li role="presentation"><a href="/admin/provService">Предоставляемые услуги</a></li>
        <li role="presentation" class="active"><a href="/admin/user">Пользователи</a></li>
    </ul>

    <div class="container">
        <br/>
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <td><b>№</b></td>
                        <td><b>Имя пользователя</b></td>
                        <td><b>Статус пользователя</b></td>
                    </tr>
                    </thead>
                    <tbody>
                        <#list users as usr>
                        <tr>
                            <td>${usr_index + 1}</td>
                            <td>${usr.username}</td>
                            <#if usr.role == "ADMIN">
                                <td>Администратор</td>
                            <#elseif usr.role == "USER">
                                <td>Пользователь</td>
                            </#if>
                            <td style="text-align: right">
                                <a href="/admin/user/edit?bcuId=${usr.bcuId}"><i class="fas fa-edit"></i></a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="/admin/user/delete?bcuId=${usr.bcuId}"><i class="fas fa-trash-alt"></i></a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@n.navbar>
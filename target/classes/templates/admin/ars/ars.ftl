<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/admin/markCar">Марки</a></li>
        <li role="presentation"><a href="/admin/modelCar">Модели</a></li>
        <li role="presentation"><a href="/admin/service">Услуги</a></li>
        <li role="presentation" class="active"><a href="/admin/ars">СТО</a></li>
        <li role="presentation"><a href="/admin/timetable">Расписание</a></li>
        <li role="presentation"><a href="/admin/provService">Предоставляемые услуги</a></li>
        <li role="presentation"><a href="/admin/user">Пользователи</a></li>
    </ul>

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <br/>
                <a href="/admin/ars/add"><button type="button" class="btn btn-default">Добавить СТО</button></a>
                <br/>
                <br/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <td><b>№</b></td>
                        <td><b>Название</b></td>
                        <td><b>Моб. тел. 1</b></td>
                        <td><b>Моб. тел. 2</b></td>
                        <td><b>Адрес</b></td>
                        <td><b>Почта</b></td>
                        <td><b>Описание</b></td>
                    </tr>
                    </thead>
                    <tbody>
                        <#list autoRepairShops as ars>
                        <tr>
                            <td>${ars_index + 1}</td>
                            <td>${ars.name}</td>
                            <td>${ars.phone1}</td>
                            <#if ars.phone2??>
                                <td>${ars.phone2}</td>
                            <#else>
                                <td></td>
                            </#if>
                            <td>${ars.address}</td>
                            <td>${ars.email}</td>
                            <#if ars.description??>
                                <td>${ars.description}</td>
                            <#else>
                                <td></td>
                            </#if>
                            <td style="text-align: right">
                                <a href="/admin/ars/edit?bcaId=${ars.bcaId}"><i class="fas fa-edit"></i></a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="/admin/ars/delete?bcaId=${ars.bcaId}"><i class="fas fa-trash-alt"></i></a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@n.navbar>
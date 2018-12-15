<#import "common/navbar.ftl" as n>

<@n.navbar selected="search">
    <div class="container" align="center">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <h1><b>${ars.name}</b></h1>
            </div>
        </div>
        <#if ars.description??>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h3>${ars.description}</h3>
                </div>
            </div>
        </#if>
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Марка авто</th>
                            <th>Модель авто</th>
                            <th>Услуга</th>
                            <th>Цена</th>
                            <th>Описание</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list services as markSize, modelService>
                            <tr>
                                <#list markSize as mark, size>
                                    <td rowspan="${size + modelService?size + 1}">${mark}</td>
                                </#list>
                            </tr>
                            <#list modelService as model, service>
                                <tr>
                                    <td rowspan="${service?size + 1}">${model}</td>
                                </tr>
                                <#list service as s>
                                    <tr>
                                        <td>${s.getBcpId().service.name}</td>
                                        <td>${s.price}</td>
                                        <#if s.description??>
                                            <td>${s.description}</td>
                                        <#else>
                                            <td></td>
                                        </#if>
                                    </tr>
                                </#list>
                            </#list>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>

        <#if ars.timetable??>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h3><b>Расписание</b></h3>
                </div>
            </div>

            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Понедельник</th>
                                <th>Вторник</th>
                                <th>Среда</th>
                                <th>Четверг</th>
                                <th>Пятница</th>
                                <th>Суббота</th>
                                <th>Воскресенье</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${ars.timetable.monday}</td>
                                <td>${ars.timetable.tuesday }</td>
                                <td>${ars.timetable.wednesday }</td>
                                <td>${ars.timetable.thursday }</td>
                                <td>${ars.timetable.friday }</td>
                                <td>${ars.timetable.saturday }</td>
                                <td>${ars.timetable.sunday }</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </#if>

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <h3><b>Контакты</b></h3>
            </div>
        </div>

        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <p><b>Моб. тел.: </b>${ars.phone1}</p>
                <#if ars.phone2??>
                    <p><b>Моб. тел.: </b>${ars.phone1}</p>
                </#if>
                <p><b>Адрес: </b>${ars.address}</p>
                <p><b>Почта: </b>${ars.email}</p>
            </div>
        </div>

    </div>
</@n.navbar>
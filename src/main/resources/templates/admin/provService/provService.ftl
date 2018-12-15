<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/admin/markCar">Марки</a></li>
        <li role="presentation"><a href="/admin/modelCar">Модели</a></li>
        <li role="presentation"><a href="/admin/service">Услуги</a></li>
        <li role="presentation"><a href="/admin/ars">СТО</a></li>
        <li role="presentation"><a href="/admin/timetable">Расписание</a></li>
        <li role="presentation" class="active"><a href="/admin/provService">Предоставляемые услуги</a></li>
        <li role="presentation"><a href="/admin/user">Пользователи</a></li>
    </ul>

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <br/>
                <a href="/admin/provService/add"><button type="button" class="btn btn-default">Добавить услугу</button></a>
                <br/>
                <br/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <td><b>№</b></td>
                        <td><b>Название СТО</b></td>
                        <td><b>Название модели</b></td>
                        <td><b>Название услуги</b></td>
                        <td><b>Цена</b></td>
                        <td><b>Описание</b></td>
                    </tr>
                    </thead>
                    <tbody>
                        <#list provServices as provService>
                        <tr>
                            <td>${provService_index + 1}</td>
                            <td>${provService.bcpId.ars.name}</td>
                            <td>${provService.bcpId.modelCar.markCar.name}&nbsp;${provService.bcpId.modelCar.name}</td>
                            <td>${provService.bcpId.service.name}</td>
                            <td>${provService.price}</td>
                            <#if provService.description??>
                                <td>${provService.description}</td>
                            <#else>
                                <td></td>
                            </#if>
                            <td style="text-align: right">
                                <a href="/admin/provService/edit?bcaId=${provService.bcpId.ars.bcaId}&bcmdId=${provService.bcpId.modelCar.bcmdId}&bcsId=${provService.bcpId.service.bcsId}">
                                    <i class="fas fa-edit"></i>
                                </a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="/admin/provService/delete?bcaId=${provService.bcpId.ars.bcaId}&bcmdId=${provService.bcpId.modelCar.bcmdId}&bcsId=${provService.bcpId.service.bcsId}">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@n.navbar>
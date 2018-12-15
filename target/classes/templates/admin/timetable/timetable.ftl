<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/admin/markCar">Марки</a></li>
        <li role="presentation"><a href="/admin/modelCar">Модели</a></li>
        <li role="presentation"><a href="/admin/service">Услуги</a></li>
        <li role="presentation"><a href="/admin/ars">СТО</a></li>
        <li role="presentation" class="active"><a href="/admin/timetable">Расписание</a></li>
        <li role="presentation"><a href="/admin/provService">Предоставляемые услуги</a></li>
        <li role="presentation"><a href="/admin/user">Пользователи</a></li>
    </ul>

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <br/>
                <a href="/admin/timetable/add"><button type="button" class="btn btn-default">Добавить расписание</button></a>
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
                        <td><b>Название СТО</b></td>
                        <td><b>Понедельник</b></td>
                        <td><b>Вторник</b></td>
                        <td><b>Среда</b></td>
                        <td><b>Четверг</b></td>
                        <td><b>Пятница</b></td>
                        <td><b>Суббота</b></td>
                        <td><b>Воскресенье</b></td>
                    </tr>
                    </thead>
                    <tbody>
                        <#list timetables as timetable>
                        <tr>
                            <td>${timetable_index + 1}</td>
                            <td>${timetable.ars.name}</td>
                            <td>${timetable.monday}</td>
                            <td>${timetable.tuesday}</td>
                            <td>${timetable.wednesday}</td>
                            <td>${timetable.thursday}</td>
                            <td>${timetable.friday}</td>
                            <td>${timetable.saturday}</td>
                            <td>${timetable.sunday}</td>
                            <td style="text-align: right">
                                <a href="/admin/timetable/edit?bcaId=${timetable.bcaId}"><i class="fas fa-edit"></i></a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="/admin/timetable/delete?bcaId=${timetable.bcaId}"><i class="fas fa-trash-alt"></i></a>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@n.navbar>
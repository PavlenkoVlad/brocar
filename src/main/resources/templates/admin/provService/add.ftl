<#import "../../common/navbar.ftl" as n>

<@n.navbar selected="admin">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center">
                <h1>Добавление новой услуги</h1>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <form id="provService-add-form">
                    <div class="form-group">
                        <label for="bcaId">Название СТО</label>
                        <select class="form-control" id="bcaId" name="bcaId" required>
                            <option value="-1">Выберите СТО</option>
                            <#list autoRepairShops as ars>
                                <option value="${ars.bcaId}">${ars.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="bcmdId">Название модели</label>
                        <select class="form-control" id="bcmdId" name="bcmdId" required>
                            <option value="-1">Выберите модель</option>
                            <#list modelCars as modelCar>
                                <option value="${modelCar.bcmdId}">${modelCar.markCar.name}&nbsp;${modelCar.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="bcsId">Название услуги</label>
                        <select class="form-control" id="bcsId" name="bcsId" required>
                            <option value="-1">Выберите услугу</option>
                            <#list services as service>
                                <option value="${service.bcsId}">${service.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="price">Цена</label>
                        <input type="text" class="form-control" id="price" name="price" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Описание</label>
                        <input type="text" class="form-control" id="description" name="description">
                    </div>
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-default">Добавить</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/admin/provService">
                            <button type="button" class="btn btn-default">Отменить</button>
                        </a>
                    </div>
                </form>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="text-align: center; color: red">
                <div id="error-message">

                </div>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $.ajaxSetup({async:false});
            $("#provService-add-form").submit(function (event) {
                event.preventDefault();
                addProvService();
            })
        });

        function addProvService() {
            var bcaId = $("#bcaId").val();
            var bcmdId = $("#bcmdId").val();
            var bcsId = $("#bcsId").val();
            var price = $("#price").val();
            var description = $("#description").val();
            $.post("/admin/provService/add",
                    {bcaId:bcaId, bcmdId:bcmdId, bcsId: bcsId, price:price, description:description},
                    function (data) {
                if(data == -1) {
                    $("#error-message").empty();
                    $("#error-message").append("<p>Такая услуга уже существует</p>");
                }
                else {
                    if(data == -2) {
                        $("#error-message").empty();
                        $("#error-message").append("<p>Обязательно нужно выбрать СТО</p>");
                    }
                    else {
                        if(data == -3) {
                            $("#error-message").empty();
                            $("#error-message").append("<p>Обязательно нужно выбрать модель</p>");
                        }
                        else {
                            if(data == -4) {
                                $("#error-message").empty();
                                $("#error-message").append("<p>Обязательно нужно выбрать услугу</p>");
                            }
                            else {
                                $(location).attr('href', '/admin/provService');
                            }
                        }
                    }
                }
            });
        }
    </script>
</@n.navbar>
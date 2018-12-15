<#import "../common/navbar.ftl" as n>

<@n.navbar selected="search">
    <div class="container">
        <div class="row" style="text-align: center">
            <div class="col-md-10 col-md-offset-1">
                <form class="form-inline" id="search-form">
                    <div class="form-group">
                        <label for="markCar-select">Марка</label>
                        <select class="form-control" id="markCar-select" name="bcmId" onchange="setOptionsForModelCarsSelect()">
                            <option value="-1">Выберите марку</option>
                                <#list markCars as markCar>
                                    <option value="${markCar.bcmId}">${markCar.name}</option>
                                </#list>
                        </select>
                    </div>
                    &nbsp
                    <div class="form-group">
                        <label for="modelCar-select">Модель</label>
                        <select class="form-control" id="modelCar-select" name="bcmdId">
                            <option value="-1">Выберите модель</option>

                        </select>
                        <#if modelCarSelectedValue??>
                            <input type="hidden" value="${modelCarSelectedValue}" id="modelCarSelectedValue">
                        <#else>
                            <input type="hidden" value="-1" id="modelCarSelectedValue">
                        </#if>
                    </div>
                    &nbsp
                    <div class="form-group">
                        <label for="service-select">Услуга</label>
                        <select class="form-control" id="service-select" name="bcsId">
                            <option value="-1">Выберите услугу</option>
                                <#list services as service>
                                    <option value="${service.bcsId}">${service.name}</option>
                                </#list>
                        </select>
                    </div>
                    &nbsp
                    <button type="submit" class="btn btn-default">Поиск</button>
                </form>
            </div>
        </div>
        <br/>
        <br/>
        <br/>
        <div class="row" id="search-result">

        </div>
    </div>

    <script>

        $(document).ready(function () {
            $.ajaxSetup({async:false});
            setSelectedOptionForModelCarsSelect();
            getSearchResult();
            $("#search-form").submit(function (event) {
                event.preventDefault();
                getSearchResult();
            })
        });

        function setOptionsForModelCarsSelect() {
            var bcmId = $('#markCar-select').find(':selected').val();
            var url = '/modelCar/getModelsByMarkId?bcmId=' + bcmId;
            $.get(url, function (data) {
                if(data == null) {
                    return;
                }
                $('#modelCar-select').find('option').remove();
                $('#modelCar-select').append('<option value="-1">Выберите модель</option>');
                for(i = 0; i < data.length; i++) {
                    $('#modelCar-select')
                            .append('<option value="' + data[i]['bcmdId'] + '">' + data[i]['name'] + '</option>');
                }
            });
        }

        function setSelectedOptionForModelCarsSelect() {
            var bcmId = $('#markCar-select').find(':selected').val();
            var url = '/modelCar/getModelsByMarkId?bcmId=' + bcmId;
            $.get(url, function (data) {
                if(data == null) {
                    return;
                }
                $('#modelCar-select').find('option').remove();
                $('#modelCar-select').append('<option value="-1">Выберите модель</option>');
                var modelCarSelectedValue = $('#modelCarSelectedValue').val();
                for(i = 0; i < data.length; i++) {
                    if(data[i]['bcmdId'] == modelCarSelectedValue) {
                        $('#modelCar-select')
                                .append('<option selected value="' + data[i]['bcmdId'] + '">' + data[i]['name'] + '</option>');
                    } else {
                        $('#modelCar-select')
                                .append('<option value="' + data[i]['bcmdId'] + '">' + data[i]['name'] + '</option>');
                    }
                }
            });
        }
        
        function getSearchResult() {
            var bcmId = $('#markCar-select').find(':selected').val();
            var bcmdId = $('#modelCar-select').find(':selected').val();
            var bcsId = $('#service-select').find(':selected').val();

            $.post("/search", {bcmId:bcmId, bcmdId:bcmdId, bcsId:bcsId}, function (data) {
                $("#search-result").empty();
                $("#search-result").append(data);
            });
        }
    </script>
</@n.navbar>
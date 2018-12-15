<div class="col-md-10 col-md-offset-1">
    <#list autoRepairShopMap as key, value>
        <div class="panel panel-default">
            <div class="panel-heading" style="text-align: center">
                <h2><b>${key.name}</b></h2>
            </div>
            <div class="panel-body">
                <#if key.description??>
                    <p>${key.description}</p>
                </#if>
                    <p><b>Марки: </b>${value[0]}</p>
                    <p><b>Услуги: </b>${value[1]}</p>
                    <p><b>Моб. тел.: </b>${key.phone1}</p>
                <#if key.phone2??>
                    <p><b>Моб. тел.: </b>${key.phone2}</p>
                </#if>
                <p><b>Адрес: </b>${key.address}</p>
                <p><b>Почта: </b>${key.email}</p>
            </div>
            <div class="panel-footer" style="text-align: center">
                <#if user??>
                    <a href="/ars?bcaId=${key.bcaId}" style="color: #333333">
                        <button type="button" class="btn">Подробнее</button>
                    </a>
                </#if>
            </div>
        </div>
    </#list>
</div>
<div class="card-columns">
<#list messages as message >
<div  class="card my-3" style="width: 18rem;">
<div>
<#if message.filename??>
<img src="/img/${message.filename}" class="card-img-top">
</#if>
</div>


    <div class="m-2">
    <span>${message.text}</span>
  
</div>

<div class="card-footer text-muted">


<a href="/user-messages">${message.authorName}</a>


</div>

</div>

<#else>
No message
</#list>
</div>
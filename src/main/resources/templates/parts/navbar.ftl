<#include "security.ftl">

<#import "login1.ftl" as l>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/">Contentik</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/">Главная</a>
      </li>

<#if !user??>
<li class="nav-item">
        <a class="nav-link" href="/main">Авторизация</a>
      </li>
</#if>

<#if user??>
<li class="nav-item">
        <a class="nav-link" href="/main">Сообщения</a>
      </li>
</#if>

<#if user??>
<li class="nav-item">
        <a class="nav-link" href="/user-messages">Мои сообщения</a>
      </li>
</#if>






</ul>
<div class="navbar-text mr-3" >${name!}</div>

<#if user??>
  <@l.logout/>
</#if>
</div>
</nav>